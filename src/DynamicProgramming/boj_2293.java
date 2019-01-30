package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2293 {

	static int n, k;
	static int[] map;
	static int[] dp;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		map = new int[n];
		dp = new int[k + 1];

		for (int i = 0; i < n; i++) {
			map[i] = Integer.parseInt(br.readLine());
		}

		dp[0] = 1;

		
		for (int i = 0; i < n; i++) {
		
			for (int j = 1; j <= k; j++) {
				if(j-map[i] >= 0) {
					dp[j] = dp[j] + dp[j-map[i]];
				}
			}

		}
		
		System.out.println(dp[k]);

	}

}
