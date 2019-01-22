package BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_9372 {

	static String ansStr = "";
	static int ans = Integer.MAX_VALUE;
	static int T, nationCNT = 0;
	static int N, M;
	static ArrayList<Integer>[] map = new ArrayList[1001];
	static boolean[] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());

		// Main Loop
		for (int i = 0; i < T; i++) {

			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			visited = new boolean[N + 1];
			ans = Integer.MAX_VALUE;
			nationCNT = 0;
			// Map(ArrayList) Initialize
			for (int j = 1; j < 1001; j++)
				map[j] = new ArrayList<>();

			// Input : N= 국가의 수, M = 비행기의 종류
			for (int j = 0; j < M; j++) {

				st = new StringTokenizer(br.readLine(), " ");

				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());

				map[start].add(end);
				map[end].add(start);
			}

			for (int j = 1; j <= N; j++) {

				if (!visited[j]) {
					visited[j] = true;
					nationCNT += 1;
					dfs(j, 0);
				}

			}
			ansStr += ans + "\n";

//			ansStr += (N-1) + "\n";
		}
//		System.out.println(Arrays.toString(visited));
		System.out.println(ansStr);
	}

	static void dfs(int node, int cnt) {

		if (nationCNT == N) {
			ans = Math.min(ans, cnt);
		}

		for (int i = 0; i < map[node].size(); i++) {

			int nextNode = map[node].get(i);
			if (!visited[nextNode]) {
//				System.out.println("nextNode"+ nextNode);
				nationCNT += 1;
				visited[node] = true;
				dfs(nextNode, cnt+1);

			}
		}

	}

}
