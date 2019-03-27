package SamsungExpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_4014 {

	static int T;
	static int N;
	static int LENGTH;
	static int[][] map;
	static int ans = 0;

	static boolean[][] visited;

	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {

			st = new StringTokenizer(br.readLine(), " ");

			N = Integer.parseInt(st.nextToken());
			LENGTH = Integer.parseInt(st.nextToken());

			map = new int[21][21];
			visited = new boolean[21][21];
			ans = 0;

			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine(), " ");

				for (int k = 0; k < N; k++) {
					map[j][k] = Integer.parseInt(st.nextToken());
				}

			}

			for (int j = 0; j < N; j++) {

				horizon(0, j);

			}
			visited = new boolean[21][21];

			for (int j = 0; j < N; j++) {

				vertical(j, 0);

			}

			System.out.println("#" + (i + 1) + " " + ans);
		}

	}	

	// 技肺 贸府
	static void vertical(int x, int y) {

		if (y == N - 1) {
			ans += 1;
			return;
		}

		if (map[y][x] == map[y + 1][x]) {
			vertical(x, y + 1);
		}

		else if (map[y][x] == (map[y + 1][x] + 1)) {

			if (y + LENGTH >= N)
				return;

			for (int i = 1; i <= LENGTH; i++) {

				visited[y + i][x] = true;

				if (map[y][x] != (map[y + i][x] + 1))
					return;

			}

			vertical(x, y + LENGTH);
		}

		else if (map[y][x] == map[y + 1][x] - 1) {

			if (y - LENGTH + 1 < 0)
				return;

			for (int i = 0; i < LENGTH; i++) {

				if (visited[y - i][x])
					return;

				if (map[y][x] != map[y - i][x])
					return;

				visited[y - i][x] = true;
			}

			vertical(x, y + 1);
		}

	}

	// 啊肺 贸府
	static void horizon(int x, int y) {

		if (x == N - 1) {
			ans += 1;
			return;
		}

		if (map[y][x] == map[y][x + 1]) {
			
			horizon(x + 1, y);
			
		} else if (map[y][x] == map[y][x + 1] + 1) {

			if (x + LENGTH >= N)
				return;

			for (int i = 1; i <= LENGTH; i++) {

				visited[y][x + i] = true;

				if (map[y][x] != map[y][x + i] + 1)
					return;

			}
			horizon(x + LENGTH, y);

		} else if (map[y][x] == map[y][x + 1] - 1) {

			if (x - LENGTH + 1 < 0)
				return;

			for (int i = 0; i < LENGTH; i++) {

				if (visited[y][x - i])
					return;

				if (map[y][x] != map[y][x - i])
					return;

				visited[y][x - i] = true;
			}

			horizon(x + 1, y);

		}

	}

	static class Node {
		int x, y;

		Node(int x, int y) {

		}
	}

}
