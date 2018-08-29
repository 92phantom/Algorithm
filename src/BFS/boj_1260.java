package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_1260 {

	static int N, M, V;
	static int[][] map;
	static boolean[] visited;

	public static void main(String... a) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());

		map = new int[N + 1][N + 1];
		visited = new boolean[N + 1];

		for (int i = 0; i < M; i++) {

			st = new StringTokenizer(br.readLine(), " ");

			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			map[x][y] = 1;
			map[y][x] = 1;

		}

		bfs(1);
		visited = new boolean[N + 1];
		dfs(1);

	}

	static void bfs(int v) {

		Queue<Integer> q = new LinkedList<>();
		q.add(v);
		visited[v] = true;
		while (!q.isEmpty()) {
			v = q.poll();
			System.out.print(v + " ");
			for (int i = 1; i <= N; i++) {
				if (map[v][i] == 1 && !visited[i]) {
					visited[i] = true;
					q.add(i);
				}
			}
		}
	}

	static void dfs(int v) {

		visited[v] = true;
		System.out.print(v + " ");
		for (int i = 1; i <= N; i++) {
			if (map[v][i] == 1 && !visited[i]) {
				visited[i] = true;
				dfs(i);
			}
		}
	}
}
