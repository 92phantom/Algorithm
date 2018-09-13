package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 마지막 전 계단을 밟은 경우
// 마지막 전 계단을 밟지 않은경우
public class boj_2579 {

	static int N;
	static int[] stairs, dp;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), "");
	
			N = Integer.parseInt(st.nextToken());

		stairs = new int[N+1];
		dp = new int[N+1];
		
		for(int i=1; i<=N; i++){
			
			st = new StringTokenizer(br.readLine(), "");

			stairs[i] = Integer.parseInt(st.nextToken());
			
		}
		
		dp[1] = stairs[1];
		dp[2] = dp[1] + stairs[2];
	
		for(int i=3; i<=N; i++){
			
			dp[i] = Math.max(dp[i-2]+stairs[i], dp[i-3]+stairs[i-1]+stairs[i]);
			
		}
		
		System.out.println(dp[N]);
		
	}


}

