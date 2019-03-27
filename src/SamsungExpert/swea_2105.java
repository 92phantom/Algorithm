package SamsungExpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.concurrent.ConcurrentHashMap;

public class swea_2105 {

	static int T, N;
	static int[][] map;
	static int ans;
	static boolean[] visited;
	static int startX, startY;
	static int[] dx = { -1, 1, -1, 1 };
	static int[] dy = { -1, -1, 1, 1 };
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {

			ans = -1;
			map = new int[21][21];
			visited = new boolean[101];
			
			N = Integer.parseInt(br.readLine());

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");

				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			// Y축 범위 0부터 N-3까지
			for (int i = 0; i < N-2; i++) {

				// X축 범위 1부터 N-2까지
				for (int j = 1; j < N-1; j++) {

					startX = j;
					startY = i;

					dfs(j, i, -1, 0, 1);
				}
			}

			System.out.println("#" + tc + " " + ans);
		}
	}

	static void dfs(int x, int y, int dir, int dirChange, int count) {

		if (dirChange >= 5)
			return;
		
		visited[map[y][x]] = true;

		for (int i = 0; i < 4; i++) {

			int nextX = x + dx[i];
			int nextY = y + dy[i];

			if (count >= 4 && nextX == startX && nextY == startY && dirChange >= 3) {
				ans = Math.max(ans, count);
				visited[map[y][x]] = false;
				return;
			}

			if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= N || visited[map[nextY][nextX]])
				continue;

			dfs(nextX, nextY, i, i == dir ? dirChange : dirChange + 1, count+1);
			
		}

		// BackTracking
		visited[map[y][x]] = false;
	}

}
