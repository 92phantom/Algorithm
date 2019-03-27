package BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;


public class boj_16235 {

	static final int SIZE = 12;
	static int[][] map = new int[SIZE][SIZE];
	static int[][] add = new int[SIZE][SIZE];
	static int[][] summer = new int[12][12];
	static int[][] winter = new int[12][12];
	static ArrayList<Integer>[][] NAMU = new ArrayList[SIZE][SIZE];

	static int dy[] = { -1,-1,-1,0,0,1,1,1 };
	static int dx[] = { -1,0,1,-1,1,-1,0,1 };

	
	public static void main(String[] args) throws IOException {

		int N, M, K;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = 5;
				add[i][j] = Integer.parseInt(st.nextToken());
			}

		}

		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				NAMU[i][j] = new ArrayList<Integer>();
			}
		}
		
		for (int i = 0; i < M; i++) {

			int y = 0, x = 0, age = 0;
			st = new StringTokenizer(br.readLine(), " ");
			y = Integer.parseInt(st.nextToken());
			x = Integer.parseInt(st.nextToken());
			age = Integer.parseInt(st.nextToken());

			y -= 1;
			x -= 1;

			NAMU[y][x].add(age);

		}

		while (true) {

			if(K==0) {
				break;
			}			
			K--;
			for (int i = 0; i < N; i++) {
				for(int j=0; j<N; j++) {
					
					if(!NAMU[i][j].isEmpty()) {
						
						Collections.sort(NAMU[i][j]);
						
						for(int k =0; k<NAMU[i][j].size(); k++) {
							
							int cur = NAMU[i][j].get(k);
							
							if(cur <= map[i][j]) {
								map[i][j] -=cur;
								NAMU[i][j].set(k, NAMU[i][j].get(k)+1);
							}
							else {
								NAMU[i][j].remove(k);
								summer[i][j] += (cur/2);
								k--;
							}
						}	
					}
				}
			}
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					
					
					map[i][j] += summer[i][j];
					
				}
			}

			summer = new int[SIZE][SIZE];
			
			ArrayList<Integer>[][] temp_NAMU = new ArrayList[SIZE][SIZE];

			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					temp_NAMU[i][j] = new ArrayList<Integer>();
				}
			}
			
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					for(int k=0; k<NAMU[i][j].size(); k++) {
						temp_NAMU[i][j].add(NAMU[i][j].get(k));
					}
				}
			}
			
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					
					for(int k=0; k<NAMU[i][j].size(); k++) {
						
						if(NAMU[i][j].get(k)%5 != 0) continue;
						
						for(int dir = 0; dir<8; dir++) {
							int nextY = dy[dir] +i;
							int nextX = dx[dir] + j;
							
							if((0 <= nextY && nextY < N) && (0 <= nextX && nextX < N)) {
								temp_NAMU[nextY][nextX].add(1);
							}
							
						}
						
					}
					
				}
			}
			
			for(int i=0; i<N; i++) {
				
				for(int j=0; j<N; j++) {
					NAMU[i][j].clear();
					
					for(int k=0; k< temp_NAMU[i][j].size(); k++) {
						NAMU[i][j].add(temp_NAMU[i][j].get(k));
					}
				}
				
			}
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					map[i][j] += add[i][j];
				}
			}
			
		}

		int ans =0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				ans+= NAMU[i][j].size();
			}
		}
		System.out.println(ans);
		
		
	}
}
