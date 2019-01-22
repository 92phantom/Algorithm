package BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj_15649 {

	static int N, M;
	static boolean[] visited;
	static ArrayList<Integer> map;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new ArrayList<>();
		visited = new boolean[N + 1];

		dfs(0);

	}

	static void dfs(int cnt) {

		if (cnt == M) {

			for (int i = 0; i < M; i++)
				System.out.print(map.get(i) + " ");
			System.out.println();

			return;

		}

		else {
			for (int i = 1; i <= N; i++) {

				if (!visited[i]) {

					visited[i] = true;
					map.add(i);
					dfs(cnt + 1);
					visited[i] = false;
					map.remove(cnt);

				}

			}
		}
	}

}
