import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_2167 {

	static int N, M, K;
	static int[][] map;

	static boolean[][] visited;

	static int[][] dp;

	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	static int ans = 0;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		dp = new int[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
//				visited[i][j] = -1;
			}
		}

		K = Integer.parseInt(br.readLine());

		for (int z = 0; z < K; z++) {

			st = new StringTokenizer(br.readLine(), " ");

			ans = 0;
			int a = Integer.parseInt(st.nextToken()) - 1; // 행
			int b = Integer.parseInt(st.nextToken()) - 1; // 열
			int x = Integer.parseInt(st.nextToken()) - 1; // 행
			int y = Integer.parseInt(st.nextToken()) - 1; // 열

			for(int i=a; i<=x; i++) {
				for(int j=b; j<=y; j++) {
					ans += map[i][j];
				}
			}
		
			System.out.println(ans);
			
		}

	}

//	static void dfs(int x, int y, int result) {
//
//		
////		dp[y][x] = dp[y][x]
//		for (int i = 0; i < 4; i++) {
//			int nextX = x + dx[i];
//			int nextY = y + dy[i];
//
//			if (nextX < 0 || nextY < 0 || nextX >= M || nextY >= N)
//				continue;
//
//			if (visited[nextY][nextX])
//				continue;
//
//			else if (!visited[nextY][nextX]) {
//
//				visited[nextY][nextX] = true;
//				dp[nextY][nextX] = result + map[nextY][nextX];
//				dfs(nextY, nextX, dp[nextY][nextX]);
//
//			}
//
//		}
//
//	}
//
//	static void bfs(int startY, int startX, int endY, int endX) {
//
//		Queue<Node> q = new LinkedList<>();
//
//		q.add(new Node(startX, startY, map[startY][startX]));
//
//		visited[startY][startX] = true;
//
//		while (!q.isEmpty()) {
//
//			Node cur = q.poll();
//
//			if (cur.y == endY && cur.x == endX) {
//				for (int i = 0; i < N; i++) {
//					System.out.println(Arrays.toString(visited[i]));
//				}
//				System.out.println(cur.value);
//				return;
//			}
//
//			for (int i = 0; i < 4; i++) {
//				int nextX = cur.x + dx[i];
//				int nextY = cur.y + dy[i];
//
//				if (nextX < 0 || nextY < 0 || nextX >= M || nextY >= N)
//					continue;
//
//				if (visited[nextY][nextX]) {
//					continue;
//				}
//
//				else {
//					visited[nextY][nextX] = true;
//					q.add(new Node(nextX, nextY, cur.value + map[nextY][nextX]));
//				}
//			}
//
//		}
//
//	}
//
//	static class Node {
//		int x;
//		int y;
//		int value;
//
//		Node(int x, int y, int value) {
//			this.x = x;
//			this.y = y;
//			this.value = value;
//		}
//	}
}
