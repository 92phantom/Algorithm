package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_1912 {

	static int n;
	static int[] map;
	static int[] dp;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine(), " ");

		map = new int[n];
		dp = new int[n];
		
		for (int i = 0; i < n; i++) {
			map[i] = Integer.parseInt(st.nextToken());
		}

		dp[0] = map[0];
		
		for(int i=1; i<n; i++) {
			int temp = Math.max(dp[i-1]+map[i], map[i]);
			dp[i] = temp;
		}
		
		Arrays.sort(dp);

		System.out.println(dp[n-1]);

	}

}
