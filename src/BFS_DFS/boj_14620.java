package BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_14620 {

	static int N, ans=Integer.MAX_VALUE;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];

		for (int i = 0; i < N; i++) {

			st = new StringTokenizer(br.readLine(), " ");

			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}

		}

		solve(0, 0, 1);
		System.out.println(ans);

	}

	static void solve(int flowerCnt, int priceTmp, int y) {

		if (flowerCnt == 3) {
			ans = Math.min(ans, priceTmp);
			return;
		}

		for (int i = y; i < N - 1; i++) {

			for (int j = 1; j < N - 1; j++) {

				if (visited[i][j])
					continue;

				if (!dfs(i, j))
					continue;

				int price = map[i][j];

				visited[i][j] = true;
				
				for (int k = 0; k < 4; k++) {
					int nextX = j + dx[k];
					int nextY = i + dy[k];
					visited[nextY][nextX] = true;

					price += map[nextY][nextX];
				}
				
				solve(flowerCnt + 1, priceTmp + price, i);

				// BackTracking
				visited[i][j] = false;
				for (int k = 0; k < 4; k++) {
					visited[i + dy[k]][j + dx[k]] = false;
				}

			}

		}

	}

	static boolean dfs(int y, int x) {

		for (int i = 0; i < 4; i++) {

			int nextX = x + dx[i];
			int nextY = y + dy[i];

			if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= N || visited[nextY][nextX])
				return false;

		}

		return true;

	}
}
