package BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_1707 {

	static int K;
	static int V, E;
//	static boolean[] visited;
	static int[][] map;
	static int[] colorMap;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), "");

		K = Integer.parseInt(st.nextToken());

		for (int i = 0; i < K; i++) {

			st = new StringTokenizer(br.readLine(), " ");

			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			map = new int[V + 1][V + 1];
			colorMap = new int[V + 1];
//			visited = new boolean[V + 1];

			for (int j = 0; j < E; j++) {

				st = new StringTokenizer(br.readLine(), " ");

				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());

				map[x][y] = map[y][x] = 1;

			}

			bfs(new Pivot4(1, 1));
			
			System.out.println(check());
		}
	}
//
//	static void dfs(Pivot4 v) {
//
//		visited[v.x] = true;
//		colorMap[v.x] = v.color;
//		for (int i = 1; i <= V; i++) {
//
//			if (map[v.x][i] == 1 && ! visited[i] && colorMap[i] != v.color) {
//				int color;
//				color = v.color == 1 ? 2 : 1;
//				
//				dfs(new Pivot4(i, color));
//			}
//
//		}
//
//	}

	static void bfs(Pivot4 v){
		
		Queue<Pivot4> q = new LinkedList<>();
		
		q.add(v);
		
		colorMap[v.x] = v.color;
		
		while(!q.isEmpty()){
			
			Pivot4 pivot = q.poll();
			int x = pivot.x;
			int color = pivot.color;
			
			for (int i = 1; i <= V; i++) {

				if (map[x][i] == 1 && colorMap[i] == 0) {
					
					int nextColor;
					nextColor = color == 1 ? 2 : 1;
					
					colorMap[i] = nextColor;

					q.add(new Pivot4(i, nextColor));
					
				}else if(colorMap[x] == colorMap[i]){
					System.out.println("¤±aa");
					
				}
			}
			
		}
		
	}
	
	static String check() {

		for (int i = 1; i <= V; i++) {

			for (int j = 1; j <= V; j++) {

				if (map[i][j] == 1) {

					if (colorMap[i] == colorMap[j]) {

						return "NO";
					}

				}

			}

		}

		return "YES";

	}

}

class Pivot4 {
	int x, color;

	Pivot4(int x, int color) {
		this.x = x;
		this.color = color;
	}

}
