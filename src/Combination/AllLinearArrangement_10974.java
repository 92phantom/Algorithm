package Combination;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * 
 * @ author 	: HYUNJIN PARK
 * @ date		: 2018.08.15
 * @ result		: 51272KB, 944ms
 * 
 */

public class AllLinearArrangement_10974 {

	static int[] output;

	public static void main(String... args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), "");
		int N = Integer.parseInt(st.nextToken());

		boolean[] visited = new boolean[N];
		output = new int[N];

		for (int i = 0; i < N; i++) {

			visited[i] = true;

			dfs(visited, N, i, 0);

			visited[i] = false;
		}
	}

	static void dfs(boolean[] visited, int N, int start, int depth) {

		output[depth] = start + 1;

		if (depth == N - 1) {

			for (int i = 0; i < N; i++)
				System.out.print(output[i] + " ");
			System.out.println();
			return;

		}

		for (int i = 0; i < N; i++) {

			if (visited[i])
				continue;
			visited[i] = true;
			dfs(visited, N, i, depth + 1);
			visited[i] = false;

		}

	}
}
