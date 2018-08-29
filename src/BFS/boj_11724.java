package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
 * 
 * result: 56448KB, 460ms
 * 
 */
public class boj_11724 {

	static int N, M, cnt = 0;
	static int[][] map;
	static boolean[] visited;

	public static void main(String... a) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N + 1][N + 1];
		visited = new boolean[N + 1];

		for (int i = 1; i <= M; i++) {

			st = new StringTokenizer(br.readLine(), " ");

			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			map[x][y] = 1;
			map[y][x] = 1;

		}

		for (int i = 1; i <= N; i++) {
			if (!visited[i]) {
				cnt += 1;
				bfs(i);
			}
		}

		System.out.println(cnt);
		visited = new boolean[N+1];
		
		cnt = 0;
		for (int i = 1; i <= N; i++) {
			if (!visited[i]) {
				cnt += 1;
				dfs(i);
			}
		}

		System.out.println(cnt);

	}

	
	static void dfs(int v){
		
		for(int i=1; i<=N; i++){
			
			if(map[v][i] == 1 && !visited[i]){
				visited[i] = true;
				dfs(i);
			}
			
		}
		
	}
	
	static void bfs(int v) {
		Queue<Integer> q = new LinkedList<>();

		q.add(v);

		visited[v] = true;

		while (!q.isEmpty()) {

			v = q.poll();

			for (int i = 1; i <= N; i++) {

				if (map[v][i] == 1 && !visited[i]) {
					q.add(i);
					visited[i] = true;

				}

			}

		}

	}
}
