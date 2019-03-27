import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// DFS�� �ִ� ���� ���ѵ�
// �� �ִ밪 ���� ���� ��Ʈ�ι̳� ���� ��ġ�ϴ��� Ǯ�����

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

		// �� ����� DFS Ž�� �Ұ�
		exceptionShape();

		System.out.println(ans);
	}

	static void exceptionShape() {

		// ��
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

		// ��
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
		// ��
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

		// ��
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
