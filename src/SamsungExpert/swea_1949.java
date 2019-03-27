package SamsungExpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_1949 {

	static int N, K;

	static int[][] map = new int[9][9];

	static boolean[][] visited = new boolean[9][9];

	static int maxHeight = 0;
	static int ans = 0;

	static int[] dx = { 0, -1, 0, 1 };
	static int[] dy = { -1, 0, 1, 0 };

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {

			maxHeight = 0;
//			maxLength = 0;
			ans = 0;

			visited = new boolean[9][9];
//			initArr();

			// Input

			StringTokenizer st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());

			K = Integer.parseInt(st.nextToken());

			for (int i = 0; i < N; i++) {

				st = new StringTokenizer(br.readLine());

				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					maxHeight = maxHeight < map[i][j] ? map[i][j] : maxHeight;
				}

			}

			// Solve

			for (int row = 0; row < N; row++) {

				for (int col = 0; col < N; col++) {

					if (map[row][col] == maxHeight) {

						dfs(row, col, 1, 1);

					}

				}

			}

			System.out.println("#" + t + " " + ans);

		}
	}

	static void dfs(int y, int x, int k, int depth) {

		visited[y][x] = true;

		// 탐색

		ans = Math.max(depth, ans);

		for (int i = 0; i < 4; i++) {

			int nextY = y + dy[i];

			int nextX = x + dx[i];

			if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= N)
				continue;

			if (visited[nextY][nextX])
				continue;

			// 공사를 해야 하고,

			if (map[nextY][nextX] >= map[y][x]) {

				int diff = map[nextY][nextX] - map[y][x] + 1;

				// 공사를 할 수 있는 경우

				if (k == 1 && K >= diff) {
					map[nextY][nextX] -= diff;
					dfs(nextY, nextX, 0, depth + 1);
					map[nextY][nextX] += diff;
				}
				
			} else {
				
				dfs(nextY, nextX, k, depth + 1);
				
			}

		}

		visited[y][x] = false;

	}

	static void printMap() {

		for (int i = 0; i < N; i++) {

			for (int j = 0; j < N; j++) {

				System.out.printf("%4d", map[i][j]);

			}

			System.out.println();

		}

		System.out.println();

	}

	static class Node {

		int y, x;

		Node(int y, int x) {

			this.y = y;

			this.x = x;

		}

	}
}
