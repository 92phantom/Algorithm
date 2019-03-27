package SamsungExpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_4012 {

	static int T, N;
	static int ans = Integer.MAX_VALUE;
	static int[][] map;
	static boolean[] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {

			N = Integer.parseInt(br.readLine());
			ans = Integer.MAX_VALUE;
			visited = new boolean[N];
			map = new int[N][N];

			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int k = 0; k < N; k++) {
					map[j][k] = Integer.parseInt(st.nextToken());
				}
			}

			dfs(0, 0);

			System.out.println("#" + (i + 1) + " " + ans);
		}

	}

	static void dfs(int count, int idx) {

		if (count == N / 2) {

			int A = 0, B = 0;

			for (int i = 0; i < N; i++) {

				for (int j = 0; j < N; j++) {

					if (visited[i] && visited[j]) {
						A+= map[i][j];
					}

					else if (!visited[i] && !visited[j]) {
						B+= map[i][j];
					}

				}
			}

			int result = Math.abs(A-B);
			
			ans = Math.min(result, ans);
			
			return;
		}

		for (int i = idx; i < N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				dfs(count + 1, i);
				visited[i] = false;
			}
		}

	}

}
