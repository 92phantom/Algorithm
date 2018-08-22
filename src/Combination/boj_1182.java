package Combination;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 
 * @result : 10020KB, 92ms
 * 
 */
public class boj_1182 {

	static int N, S, count;
	static int[] map;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());

		map = new int[N];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < N; i++) {
			map[i] = Integer.parseInt(st.nextToken());
		}

		dfs(0, 0);

		if (S == 0) {
			System.out.println(count - 1);
		} else {
			System.out.println(count);
		}
	}

	static void dfs(int sum, int step) {
		if (step == N) {

			if (sum == S)
				count++;
			return;

		}

		dfs(sum + map[step], step + 1);
		dfs(sum, step + 1);

	}
}
