package BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_14503 {

	static int count = 0;
	static int N, M;
	static Node robot;
	static int[][] map;
//	static int ans = 0;
	static int[] dy = { -1, 0, 1, 0 };
	static int[] dx = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];

		st = new StringTokenizer(br.readLine(), " ");
		int y = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());

		robot = new Node(x, y, d);

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		count += 1;

		map[y][x] = 9;

		while (true) {

			int nextD = d;

			boolean flag = false;

			for (int i = 0; i < 4; i++) {

				flag = false;
				nextD = dir(nextD);
				int nextY = y + dy[nextD];
				int nextX = x + dx[nextD];

				if (nextY >= 0 && nextY < N && nextX >= 0 && nextX < M && map[nextY][nextX] == 0) {
					count += 1;

					d = nextD;
					y = nextY;
					x = nextX;

					map[y][x] = 9;

					flag = true;

					break;

				}

			}

			if (!flag) {

				if (d == 0) {
					y++;
				} else if (d == 1) {
					x--;
				} else if (d == 2) {
					y--;
				} else if (d == 3) {
					x++;
				}
				if (map[y][x] == 1)
					break;
			}

		}

		System.out.println(count);

	}

	static int dir(int cur) {

		if (cur == 0) {
			return 3;
		} else if (cur == 1) {
			return 0;
		} else if (cur == 2) {
			return 1;
		} else {
			return 2;
		}

	}

	static class Node {

		int x, y, d;

		Node(int x, int y, int d) {
			this.x = x;
			this.y = y;
			this.d = d;
		}

	}

}
