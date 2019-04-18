package BOJ20190401;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_14503 {
	static int N, M, r, c, d;
	static int[][] map = new int[51][51];
	static int[] dy = { -1, 0, 1, 0 };
	static int[] dx = { 0, 1, 0, -1 };
	static int ans = 0;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken()); // 세로
		M = Integer.parseInt(st.nextToken()); // 가로

		st = new StringTokenizer(br.readLine(), " ");

		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				int temp = Integer.parseInt(st.nextToken());
				map[i][j] = temp;
			}
		}

		ans += 1;

		map[r][c] = 9;

		while (true) {

			int n = d;

			boolean f = false;

			for (int i = 0; i < 4; i++) {

				f = false;
				n = dir(n);

			}

		}

	}

	static int dir(int cur) {
		switch (cur) {

		case 0:
			return 3;
		case 1:
			return 0;
		case 2:
			return 1;
		case 3:
			return 2;

		default:
			return 0;
		}
	}

	static boolean isRange(int x, int y) {

		if (x >= M || y >= N || x < 0 || y < 0) {
			return false;
		}
		return true;

	}

}
