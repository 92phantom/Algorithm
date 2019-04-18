package BOJ20190401;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_14500 {
	static int N, M;
	static int[][] map;
	static boolean[][] v;
	static int ans = 0;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		v = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				int temp = Integer.parseInt(st.nextToken());
				map[i][j] = temp;
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				dfs(j, i, 1, map[i][j]);
			}
		}

		exceptionShape();

		System.out.println(ans);
	}

	static void dfs(int x, int y, int count, int total) {

		if (count == 4) {
			ans = Math.max(total, ans);

			return;
		} else {

			v[y][x] = true;

			for (int i = 0; i < 4; i++) {
				int nextX = x + dx[i];
				int nextY = y + dy[i];

				if (nextX < 0 || nextY < 0 || nextX >= M || nextY >= N)
					continue;

				if (v[nextY][nextX])
					continue;

				dfs(nextX, nextY, count + 1, total + map[nextY][nextX]);
			}

			v[y][x] = false;
		}

	}

	static void exceptionShape() {

		// で
		for (int i = 1; i < N; i++) {
			for (int j = 1; j < M - 1; j++) {
				int temp = 0;

				temp += map[i][j];
				temp += map[i - 1][j];
				temp += map[i][j - 1];
				temp += map[i][j + 1];

				ans = Math.max(temp, ans);
			}
		}

		// ぬ
		for (int i = 0; i < N - 1; i++) {
			for (int j = 1; j < M - 1; j++) {
				int temp = 0;
				temp += map[i][j];
				temp += map[i + 1][j];
				temp += map[i][j - 1];
				temp += map[i][j + 1];

				ans = Math.max(temp, ans);
			}
		}
		// た
		for (int i = 1; i < N - 1; i++) {
			for (int j = 0; j < M - 1; j++) {
				int temp = 0;
				temp += map[i][j];
				temp += map[i + 1][j];
				temp += map[i - 1][j];
				temp += map[i][j + 1];

				ans = Math.max(temp, ans);
			}
		}

		// っ
		for (int i = 1; i < N - 1; i++) {
			for (int j = 1; j < M; j++) {
				int temp = 0;
				temp += map[i][j];
				temp += map[i + 1][j];
				temp += map[i - 1][j];
				temp += map[i][j - 1];

				ans = Math.max(temp, ans);
			}
		}
	}
}
