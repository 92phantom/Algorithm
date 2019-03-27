import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_1261 {

	static int N, M;
	static int[][] map;

	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	static boolean[][] visited;
	static int ans = 0;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		ans = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for (int j = 0; j < M; j++) {

				map[i][j] = Integer.parseInt(input.charAt(j) + "");

			}
		}
		bfs();
		System.out.println(ans);

	}

	static void bfs() {

		PriorityQueue<Node> q = new PriorityQueue<>();
		q.add(new Node(0, 0, 0));
		visited[0][0] = true;

		while (!q.isEmpty()) {

			int size = q.size();

			for (int k = 0; k < size; k++) {

				Node cur = q.poll();

				int x = cur.x;
				int y = cur.y;
				int count = cur.count;


				if (x == (M - 1) && y == (N - 1)) {
					ans = Math.min(ans, count);
				}

				for (int i = 0; i < 4; i++) {
					int nextX = x + dx[i];
					int nextY = y + dy[i];
					int curCount = count;
					if (nextX < 0 || nextY < 0 || nextX >= M || nextY >= N) {
						continue;
					}

					if (visited[nextY][nextX])
						continue;

					if (map[nextY][nextX] == 1) {
						curCount += 1;
					}
					
					q.add(new Node(nextX, nextY, curCount));
					visited[nextY][nextX] = true;
				}

			}
		}

	}

	static class Node implements Comparable<Node> {
		int x, y, count;

		Node(int x, int y, int count) {
			this.x = x;
			this.y = y;
			this.count = count;
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub

			if (this.count > o.count) {
				return 1;
			}

			else if (this.count == o.count) {
				return 0;
			}

			else {
				return -1;
			}
		}
	}
}
