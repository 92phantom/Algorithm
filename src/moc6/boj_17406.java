package moc6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_17406 {

	static int N;
	static int[][] map;
	static boolean[][] v;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static int maxH = Integer.MIN_VALUE;
	static int ans = Integer.MIN_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());

		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				int temp = Integer.parseInt(st.nextToken());
				map[i][j] = temp;
				maxH = Math.max(maxH, temp);
			}
		}

		for (int i = 0; i <= maxH; i++) {
			v = new boolean[N][N];
			func(i);
		}

		System.out.println(ans);
	}

	static void func(int h) {

		Queue<Node> q = new LinkedList<>();

		// 잠김
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!(map[i][j] > h)) {
					v[i][j] = true;
				} else {
					q.add(new Node(j, i));
				}
			}
		}

		int count = 0;
		// 영역 체크
		while (!q.isEmpty()) {

			Node cur = q.poll();

			if (!v[cur.y][cur.x]) {
				count += 1;
				Queue<Node> sub = new LinkedList<>();
				sub.add(cur);
				v[cur.y][cur.x] = true;

				while (!sub.isEmpty()) {

					Node cur2 = sub.poll();

					for (int k = 0; k < 4; k++) {
						int nextX = cur2.x + dx[k];
						int nextY = cur2.y + dy[k];

						if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= N || v[nextY][nextX])
							continue;

						else {
							v[nextY][nextX] = true;
							sub.add(new Node(nextX, nextY));
						}

					}

				}
			}

		}

		
		ans = Math.max(ans, count);

	}

	static class Node {
		int x, y;

		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

}
