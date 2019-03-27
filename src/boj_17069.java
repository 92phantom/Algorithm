import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_17069 {

	static int N;
	static int[][] map;
	static boolean[][] visited;

	static int[] dx = { 1, 0, 1 };
	static int[] dy = { 0, 1, 1 };

	static int ans = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		map = new int[N][N];
		visited = new boolean[N][N];

		for (int i = 0; i < N; i++) {

			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {

				int temp = Integer.parseInt(st.nextToken());

				map[i][j] = temp;

			}

		}

		dfs(1, 0, 0);

		System.out.println(ans);
		
	}

	static void dfs(int x, int y, int move) {

		if (x == (N - 1) && y == (N - 1)) {
			ans += 1;
			return;
		} else {
			visited[y][x] = true;

			if (move == 2) {

				for (int i = 0; i < 3; i++) {
					int nextX = x + dx[i];
					int nextY = y + dy[i];

					if (nextY < 0 || nextX < 0 || nextX >= N || nextY >= N)
						continue;

					if (i == 2) {
						if (map[y + 1][x] == 1 || map[y + 1][x + 1] == 1 || map[y][x + 1] == 1) {
							continue;
						}
					}

					if (visited[nextY][nextX] || map[nextY][nextX] == 1)
						continue;

					else {
						dfs(nextX, nextY, i);
					}
				}

			}

			else {

				for (int i = 0; i < 3; i++) {
					int nextX = x + dx[i];
					int nextY = y + dy[i];

					if (nextY < 0 || nextX < 0 || nextX >= N || nextY >= N)
						continue;

					if (i == 2) {
						if (map[y + 1][x] == 1 || map[y + 1][x + 1] == 1 || map[y][x + 1] == 1) {
							continue;
						}
					}

					else if (i != move) {
						continue;
					}

					if (visited[nextY][nextX] || map[nextY][nextX] == 1)
						continue;

					else {
						dfs(nextX, nextY, i);
					}
				}

			}

			visited[y][x] = false;
		}
	}

}
