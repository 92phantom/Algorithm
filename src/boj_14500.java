import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// DFS로 최대 값을 구한뒤
// 그 최대값 구한 것이 테트로미노 모양과 일치하는지 풀어야함

public class boj_14500 {

	static int N, M;
	static int[][] map;
	static boolean[][] visited;
	static int ans;

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		ans = 0;

		map = new int[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < N; i++) {

			for (int j = 0; j < M; j++) {
				visited[i][j] = true;
				dfs(j, i, 1, map[i][j]);
				visited[i][j] = false;
			}

		}

		// ㅗ 모양은 DFS 탐색 불가
		exceptionShape();

		System.out.println(ans);
	}

	static void exceptionShape() {

		// ㅗ
		for (int i = 1; i < N; i++) {
			for (int j = 1; j < M - 1; j++) {
				int temp = 0;

				temp += map[i][j];
				temp += map[i - 1][j];
				temp += map[i][j - 1];
				temp += map[i][j + 1];

				ans = Math.max(temp, ans);
			}
		}

		// ㅜ
		for (int i = 0; i < N - 1; i++) {
			for (int j = 1; j < M - 1; j++) {
				int temp = 0;
				temp += map[i][j];
				temp += map[i + 1][j];
				temp += map[i][j - 1];
				temp += map[i][j + 1];

				ans = Math.max(temp, ans);
			}
		}
		// ㅏ
		for (int i = 1; i < N - 1; i++) {
			for (int j = 0; j < M - 1; j++) {
				int temp = 0;
				temp += map[i][j];
				temp += map[i + 1][j];
				temp += map[i - 1][j];
				temp += map[i][j + 1];

				ans = Math.max(temp, ans);
			}
		}

		// ㅓ
		for (int i = 1; i < N - 1; i++) {
			for (int j = 1; j < M; j++) {
				int temp = 0;
				temp += map[i][j];
				temp += map[i + 1][j];
				temp += map[i - 1][j];
				temp += map[i][j - 1];

				ans = Math.max(temp, ans);
			}
		}
	}

	static void dfs(int x, int y, int count, int result) {

		if (count == 4) {
			ans = Math.max(result, ans);
			return;
		}

		for (int i = 0; i < 4; i++) {
			int nextX = x + dx[i];
			int nextY = y + dy[i];

			if (nextX < M && nextX >= 0 && nextY >= 0 && nextY < N && !visited[nextY][nextX]) {
				visited[nextY][nextX] = true;
				dfs(nextX, nextY, count + 1, result + map[nextY][nextX]);
				visited[nextY][nextX] = false;
			}
		}
	}
}
