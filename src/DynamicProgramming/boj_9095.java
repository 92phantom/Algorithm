package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_9095 {

	static int T, n;
	static int[] dp;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), "");

		T = Integer.parseInt(st.nextToken());
		dp = new int[12];
//		int[] temp = new int[T];
		
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		dp[4] = 7;
		dp[7] = 44;
		dp[10] = 274;

		
		for (int j = 4; j < 12; j++) {
			dp[j] = dp[j - 1] + dp[j - 2] + dp[j - 3];
		}
		
		for (int i = 0; i < T; i++) {

			st = new StringTokenizer(br.readLine(), "");
			n = Integer.parseInt(st.nextToken());
			System.out.println(dp[i]);

//			temp[i] = dp[n];
		}
		
//		for(int i=0; i<T; i++){
//			
//			System.out.println(temp[i]);
//			
//		}

	}
}
