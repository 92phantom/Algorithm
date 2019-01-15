package BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1987 {

	static int R, C;
	static int cnt = 1, ans = 1;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, -1, 0, 1 };

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		int[][] map = new int[R][C];
		boolean[] visited = new boolean[26];

		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine(), "");
			String temp = st.nextToken();
			for (int j = 0; j < C; j++) {
				map[i][j] = (char) (temp.charAt(j) - 'A');
			}
		}

		dfs(map, visited, 0, 0);

		System.out.println(ans);
	}

	static void dfs(int[][] map, boolean[] visited, int x, int y) {

		int idx = map[y][x];

		visited[idx] = true;

		for (int i = 0; i < 4; i++) {

			int nextX = x + dx[i];
			int nextY = y + dy[i];

			if (nextX < 0 || nextX >= C || nextY < 0 || nextY >= R)
				continue;

			if (!visited[map[nextY][nextX]]) {
				ans = Math.max(++cnt, ans);
				dfs(map, visited, nextX, nextY);
			}

		}

		
		//√ ±‚»≠ «ÿ¡‡æﬂµ  ¡ﬂø‰«‘ ! 
		--cnt;
		visited[idx] = false;

	}
}
