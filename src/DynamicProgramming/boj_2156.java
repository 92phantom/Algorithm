package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2156 {

	static int n;
	static int[] map;
	static int[] dp = new int[10002];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), "");
		
		n = Integer.parseInt(st.nextToken());
		
		map = new int[10002];
		
		for(int i=1; i<=n; i++){
			
			st = new StringTokenizer(br.readLine(), "");
			map[i] = Integer.parseInt(st.nextToken());
			
		}
		
		dp[1] = map[1];
		dp[2] = dp[1] + map[2];
		dp[3] = Math.max(Math.max(dp[0]+map[2]+map[3], dp[1]+map[3]), dp[1]+map[2]);

		
		for(int i=4; i<=n; i++){

			dp[i] = Math.max(Math.max(dp[i-3]+map[i-1]+map[i], dp[i-2]+map[i]), dp[i-4]+map[i-1]+map[i-2]);
	
		}
		
		System.out.println(dp[n]);
	}

}
