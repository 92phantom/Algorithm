package Combination;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 
 * result : 10624KB, 88ms
 * 
 */

public class boj_1149 {

	static int N;
	static int[][] map;
	static int[][] dp;
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), "");
		
		N = Integer.parseInt(st.nextToken());
		
		map = new int[N+1][3];
		dp = new int[N+1][3];
		
		for(int i=1; i<=N; i++){	
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<3; j++){
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dp[0][0] = dp[0][1] = dp[0][2] = 0;
		
		
		for(int i=1; i<=N; i++){
			
			dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + map[i][0];
			dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + map[i][1];
			dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + map[i][2];
			
		}
		
		System.out.println(getMinValue(N));
		
	}
	
	static int getMinValue(int size){
		
		int minValue = Integer.MAX_VALUE;
		
		for(int i=0; i<3; i++){
	
			if(minValue>dp[size][i])	
				minValue = dp[size][i];
		}
		
		return minValue;
	}
	
}
