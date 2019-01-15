package BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_1389 {

	static int N, M;
	static int[][] map = new int[101][101];
	static boolean[] visited;
	static int[] memoization;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		memoization = new int[101];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			map[x][y] = 1;
			map[y][x] = 1;
		}

		for(int startPoint=1; startPoint<=N; startPoint++){
			visited = new boolean[N + 1];
			bfs(new Pivot1389(startPoint, 0), startPoint);
		}
		
		System.out.println(minIndex());

	}

	static int minIndex(){
		
		int idx=0, min= Integer.MAX_VALUE;
		for(int i=1; i<=N; i++){
			
			if(min>memoization[i]){
				min = memoization[i];	
				idx = i;
			}	
		}
		return idx;
	}
	
	static void bfs(Pivot1389 p, int startPoint) {

		Queue<Pivot1389> q = new LinkedList<>();
		q.add(p);
	
		visited[p.v] = true;

		while (!q.isEmpty()) {

			Pivot1389 pivot = q.poll();
			
			memoization[startPoint]+=pivot.depth;
				
			for (int i = 1; i <= N; i++) {
				if (!visited[i] && map[pivot.v][i] == 1) {
					visited[i] = true;
					q.add(new Pivot1389(i, (pivot.depth+1)));
				}
			}
		}
		
	}
}

class Pivot1389 {

	int v, depth;

	Pivot1389(int v, int depth) {
		this.v = v;
		this.depth = depth;
	}

}