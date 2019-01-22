package BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_14501 {

	static int N;
	static long ans = 0;
	static int[][] map;
	static boolean[] visited;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		// map[N][0] = T
		// map[N][1] = p

		map = new int[N + 1][2];
		visited = new boolean[N+1];
		
		StringTokenizer st;

		for (int i = 1; i <= N; i++) {

			st = new StringTokenizer(br.readLine(), " ");

			int T, P;

			T = Integer.parseInt(st.nextToken());
			P = Integer.parseInt(st.nextToken());

			map[i][0] = T;
			map[i][1] = P;

		}
		
		for(int i=1; i<= N; i++) {
			
			if(!visited[i]) {
				
				visited[i] = true;
				dfs(i, 0);
				visited[i] = false;
			}
			
		}
		
		System.out.println(ans);
	}

	static void dfs(int index, int value) {
		
		int tempVal = index + (map[index][0]);
		
		// 전체 시간
		if(tempVal > N+1)
			return;
		
		value += map[index][1];
		
		ans = Math.max(ans, value);
		visited[index] = true;
		
		for(int i= tempVal; i<= N; i++) {
			
			if(i<= N+1 && !visited[i])
				dfs(i, value);
			
		}
		
		visited[index] = false;
	}
}
