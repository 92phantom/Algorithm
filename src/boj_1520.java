import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1520 {

	static int N, M;
	static int[][] map;
	static int[][] visited;

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
		visited = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				visited[i][j] = -1;
			}
		}

		int x = 0;
		int y = 0;

//		visited[y][x] = 0;
		ans = Math.max(ans, dfs(y, x));

		System.out.println(ans);

	}

	static int dfs(int x, int y) {

		if (x == M - 1 && y == N - 1) {
			return 1;
		}

		if (visited[y][x] != -1) {
			return visited[y][x];
		}
		
		visited[y][x] = 0;
		
		for (int i = 0; i < 4; i++) {
			int nextX = x + dx[i];
			int nextY = y + dy[i];

			if (nextX < 0 || nextY < 0 || nextX >= M || nextY >= N)
				continue;

			else if (map[nextY][nextX] < map[y][x]) {
				
				visited[y][x] += dfs(nextX, nextY);
				
			}

		}

		return visited[y][x];

	}

}
