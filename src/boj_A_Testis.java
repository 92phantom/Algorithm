import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// DFS로 최대 값을 구한뒤
// 그 최대값 구한 것이 테트로미노 모양과 일치하는지 풀어야함

public class boj_A_Testis {

	static int N, M;
	static int[][] map;
	static boolean[][] visited;
	static int ans;
	static int max;

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	static int[] height;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int C = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());

		map = new int[100][C];
		visited = new boolean[100][C];
		height = new int[C];

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < C; i++) {
			int temp = Integer.parseInt(st.nextToken());
			height[i] = temp;
			for (int j = 0; j < temp; j++) {
				map[j][i] = 1;
				visited[j][i] = true;
			}
		}
		ans = 0;

		for (int i = 0; i < C; i++) {

			if (!visited[height[i] + 1][i]) {
				visited[height[i]][i] = true;
				dfs(i, height[i] + 1, 1, 0);
				visited[height[i]][i] = false;
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
				dfs(nextX, nextY, count + 1, result + 1);
				visited[nextY][nextX] = false;
			}
		}
	}
}
