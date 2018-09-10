package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_10026 {

	static int N, cnt=0, discnt =0;
	static char map[][];
	static char disableMap[][];
	static boolean visited[][];
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, -1, 0, 1 };

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), "");

		N = Integer.parseInt(st.nextToken());

		map = new char[N][N];
		disableMap = new char[N][N];
		
		visited = new boolean[N][N];

		for (int i = 0; i < N; i++) {

			st = new StringTokenizer(br.readLine(), "");
			String temp = st.nextToken();

			for (int j = 0; j < N; j++) {
				map[i][j] = temp.charAt(j);
				disableMap[i][j] = temp.charAt(j) == 'G' ? 'R' : temp.charAt(j);
			}
		}

		for(int i=0; i<N; i++){
			for(int j=0; j<N; j++){
				if(!visited[i][j]){
					dfs(map, new Pivot5(i, j));
					cnt++;
				}	
			}
		}
		visited = new boolean[N][N];
		for(int i=0; i<N; i++){
			
			for(int j=0; j<N; j++){
				if(!visited[i][j]){
					dfs(disableMap, new Pivot5(i, j));
					discnt++;
				}	
			}	
		}
		
		System.out.println(cnt +" "+ discnt);
	}

	
	static void dfs(char[][] map, Pivot5 p) {

		visited[p.x][p.y] = true;
		
		for(int i=0; i<4; i++){
			
			int nextX = dx[i] + p.x;
			int nextY = dy[i] + p.y;
			
			if(nextX<0 || nextY<0 || nextX>=N || nextY>=N)
				continue;
			
			if(!visited[nextX][nextY] && map[p.x][p.y]==map[nextX][nextY]){
				
				dfs(map, new Pivot5(nextX, nextY));
				
			}
			
		}
		
		
		
	}

}

class Pivot5 {

	int x, y;

	Pivot5(int x, int y) {

		this.x = x;
		this.y = y;
	}

}