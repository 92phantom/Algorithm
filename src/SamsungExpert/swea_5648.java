package SamsungExpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class swea_5648 {
	static int T, N;
	static ArrayList<Node> oneJA;
	static int[][] map;
//	static boolean[] visited;
	static boolean[][] crush;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { 1, -1, 0, 0 };

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {

			N = Integer.parseInt(br.readLine());
			oneJA = new ArrayList<>();
			map = new int[4001][4001];
			crush = new boolean[4001][4001];

			for (int i = 0; i < N; i++) {
				int x, y, dir, k;
				st = new StringTokenizer(br.readLine(), " ");
				x = Integer.parseInt(st.nextToken()) + 1000;
				y = Integer.parseInt(st.nextToken()) + 1000;
				x *= 2;
				y *= 2;
				dir = Integer.parseInt(st.nextToken());
				k = Integer.parseInt(st.nextToken());

				oneJA.add(new Node(x, y, dir, k));

			}

			System.out.println("#" + tc + " " + bfs());
		}

	}

	static int bfs() {
		int total = 0;

		for (int j = 0; j <= 4000; j++) {
			int size = oneJA.size();
//			visited = new boolean[4001][4001];

			for (int i = 0; i < size; i++) {

				int dir = oneJA.get(i).dir;
				int nextX = oneJA.get(i).x + dx[dir];
				int nextY = oneJA.get(i).y + dy[dir];

				// 값 0

				// 범위 넘어가도 0
				if (nextX < 0 || nextY < 0 || nextX > 4000 || nextY > 4000) {
					oneJA.get(i).k = 0;
					continue;
				}

				// 원자 값 갱신
				oneJA.get(i).x = nextX;
				oneJA.get(i).y = nextY;
				map[nextY][nextX]++;

				if (map[nextY][nextX] > 1)
					crush[nextY][nextX] = true;

			}

			// 충돌함?
			for (int i = 0; i < size; i++) {
				if (oneJA.get(i).k == 0)
					continue;

				int curX = oneJA.get(i).x;
				int curY = oneJA.get(i).y;
				int curK = oneJA.get(i).k;
				// 충돌 했네

				if (crush[curY][curX]) {
					map[curY][curX]--;
					total += curK;
					oneJA.get(i).k = 0;
					if (map[curY][curX] == 0) {
						crush[curY][curX] = false;
					}
				} else {
					map[curY][curX] = 0;
				}

			}
//
//			int fin = 0;
//			for (int i = 0; i < oneJA.size(); i++) {
//				if (oneJA.get(i).k == 0) {
//					fin++;
//				}
//			}
//
//			if (fin == N) {
//				break;
//			}

			ArrayList<Node> copy = new ArrayList<>(oneJA);

			oneJA.clear();

			for (int i = 0; i < copy.size(); i++) {
				if (copy.get(i).k != 0) {
					oneJA.add(copy.get(i));
				}
			}

			if(oneJA.size() == 0) {
				break;
			}

		}

		return total;
	}

	static class Node {
		int x, y, dir, k;

		Node(int x, int y, int dir, int k) {
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.k = k;
		}

	}
}
