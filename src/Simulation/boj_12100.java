package Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class boj_12100 {

	static int N;
	static int[][] map;
	static int ans = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];

		for (int i = 0; i < N; i++) {

			st = new StringTokenizer(br.readLine(), " ");

			for (int j = 0; j < N; j++) {

				map[i][j] = Integer.parseInt(st.nextToken());

			}

		}
		
		func();
		System.out.println(ans);
		
	}

	static void func() {

		/*
		 * 0 : аб 1 : ©Л 2 : ╩С 3 : го
		 */

		for (int i = 0; i < 4; i++) {

			blockMove(i, 1, map);

		}

	}

	static void blockMove(int direction, int count, int[][] map) {

		int[][] dupMap = new int[N][N];

		if (direction == 0) {

			for (int i = 0; i < N; i++) {

				LinkedList<Integer> q = new LinkedList<>();

				for (int j = 0; j < N; j++) {

					int temp = map[j][i];
					if (temp > 0)
						q.add(temp);

				}
				
				int cur = 0;
				
				while(!q.isEmpty()) {
					
					int tempVal = q.pollFirst();
					if(q.size()>0) {
						
						if(tempVal == q.getFirst()) {	
							tempVal *= 2;
							q.removeFirst();
						}
						
					}
					
					ans = Math.max(ans, tempVal);
					dupMap[cur][i] = tempVal;
					cur+=1;
					
				}

			}

		}
		
		if (direction == 1) {

			for (int i = 0; i < N; i++) {

				LinkedList<Integer> q = new LinkedList<>();

				for (int j = N-1; j >= 0; j--) {

					int temp = map[j][i];
					if (temp > 0)
						q.add(temp);

				}
				
				int cur = N-1;
				
				while(!q.isEmpty()) {
					
					int tempVal = q.pollFirst();
					if(q.size()>0) {
						
						if(tempVal == q.getFirst()) {	
							tempVal *= 2;
							q.removeFirst();
						}
						
					}
					ans = Math.max(ans, tempVal);
					dupMap[cur][i] = tempVal;
					cur-=1;
					
				}

			}

		}
		if (direction == 2) {

			for (int i = 0; i < N; i++) {

				LinkedList<Integer> q = new LinkedList<>();

				for (int j = 0; j < N; j++) {

					int temp = map[i][j];
					if (temp > 0)
						q.add(temp);

				}
				
				int cur = 0;
				
				while(!q.isEmpty()) {
					
					int tempVal = q.pollFirst();
					
					if(q.size()>0) {
						
						if(tempVal == q.getFirst()) {	
							tempVal *= 2;
							q.removeFirst();
						}
						
					}
					ans = Math.max(ans, tempVal);
					dupMap[i][cur] = tempVal;
					cur+=1;
					
				}

			}

		}
		
		if (direction == 3) {

			for (int i = 0; i < N; i++) {

				LinkedList<Integer> q = new LinkedList<>();

				for (int j = N-1; j >= 0; j--) {

					int temp = map[i][j];
					if (temp > 0)
						q.add(temp);

				}
				
				int cur = N-1;
				
				while(!q.isEmpty()) {
					
					int tempVal = q.pollFirst();
					
					if(q.size()>0) {
						
						if(tempVal == q.getFirst()) {	
							tempVal *= 2;
							q.removeFirst();
						}
						
					}
					ans = Math.max(ans, tempVal);

					dupMap[i][cur] = tempVal;
					cur-=1;
					
				}

			}

		}
		
		if(count == 5) {
			
			return;
			
		}else {
			
			for(int i=0; i<4; i++) {
				
				
				blockMove(i, count+1, dupMap);
				
			}
			
			
		}

	}
}
