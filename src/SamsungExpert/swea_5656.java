package SamsungExpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class swea_5656 {

	static int N, T, W, H;
	static int map[][];
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, -1, 0, 1 };
	static int ans;
	static boolean[] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {

			ans = Integer.MAX_VALUE;

			st = new StringTokenizer(br.readLine(), " ");

			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());

			visited = new boolean[W];
			map = new int[H][W];

			for (int j = 0; j < H; j++) {

				st = new StringTokenizer(br.readLine(), " ");
				for (int k = 0; k < W; k++) {
					int val = Integer.parseInt(st.nextToken());
					map[j][k] = val;
				}

			}

			for (int j = 0; j < W; j++) {

//				if (!visited[j]) {
//					visited[j] = true;
				dfs(j, 0, map);
//					visited[j] = false;
//				}
			}

			System.out.println("#"+(i+1)+" "+ans);

		}

	}

	static void dfs(int idx, int count, int[][] input) {

		if (count == N) {
			int result = 0;
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					if (input[i][j] != 0) {
						result += 1;
					}
				}
			}

			ans = Math.min(ans, result);

			return;
		}

		int[][] dupMap = new int[H][W];

		for (int i = 0; i < H; i++) {
			System.arraycopy(input[i], 0, dupMap[i], 0, W);
		}

		Queue<Node> q = new LinkedList<>();

		int aaa = 0;

		for (int i = 0; i < H; i++) {
			if (dupMap[i][idx] != 0) {
				aaa = i;
				q.add(new Node(idx, i, dupMap[i][idx]));
				break;
			}
		}

//		System.out.println("IDX" + idx);
//		System.out.println("VALUE" + dupMap[aaa][idx]);
//		System.out.println("좌표 Y좌표" + aaa + "\t X좌표" + idx);
		while (!q.isEmpty()) {

			Node cur = q.poll();

			dupMap[cur.y][cur.x] = 0;

			if (cur.value != 1) {

				for (int k = 0; k < cur.value; k++) {

					for (int i = 0; i < 4; i++) {

						int nextX = cur.x + dx[i] * k;
						int nextY = cur.y + dy[i] * k;

						if (nextX < 0 || nextY < 0 || nextX >= W || nextY >= H)
							continue;

						if (dupMap[nextY][nextX] != 0) {
							q.add(new Node(nextX, nextY, dupMap[nextY][nextX]));
							dupMap[nextY][nextX] = 0;
						}
					}
				}
			}
		}

//		System.out.println("=================");
//		for (int i = 0; i < H; i++) {
//			System.out.println(Arrays.toString(dupMap[i]));
//		}
		
		// 이동한거 옮기기
		LinkedList<Integer> list = new LinkedList<>();
		// H는 Y축
		// W는 X축
		for (int i = 0; i < W; i++) {

			for (int j = 0; j < H; j++) {

				if (dupMap[j][i] != 0) {
					list.add(dupMap[j][i]);
					dupMap[j][i] = 0;
				}

			}
			int size = list.size();
			int moveIDX = H - 1;

			for (int j = 0; j < size; j++) {
				int tempVal = list.pollLast();
				dupMap[moveIDX--][i] = tempVal;
			}

		}

		for (int i = 0; i < W; i++) {
//			visited[i] = true;
			dfs(i, count + 1, dupMap);
//			visited[i] = false;
		}

	}

	static class Node {
		int x, y, value;

		Node(int x, int y, int value) {
			this.x = x;
			this.y = y;
			this.value = value;
		}

	}

}
