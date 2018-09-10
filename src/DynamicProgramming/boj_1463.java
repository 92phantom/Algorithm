package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_1463 {

	
	static int N;
	static int[] dp;
	public static void main(String[] args) throws NumberFormatException, IOException{
		
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		dp = new int[1000001];
		
		dp[0] = 0;
		dp[1] = 0;
		dp[2] = 1;
		dp[3] = 1;
		
		for(int i=4; i<N+1; i++){
			
			dp[i] = dp[i-1] +1;
			
			if(i%2 ==0 && dp[i/2]+1 < dp[i]){
				dp[i] = dp[i/2]+1;
			}
			if(i%3 ==0 && dp[i/3]+1 < dp[i]){
				dp[i] = dp[i/3]+1;
			}
			
		}
		
		System.out.println(dp[N]);
		
	}
}
