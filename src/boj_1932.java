import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_1932 {

	static int n;
	static int[][] map;

	static int[] dx = { 0, 1 };

	static int ans = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		map = new int[1000][1000];

		map[0][0] = Integer.parseInt(br.readLine());

		for (int i = 1; i < n; i++) {

			st = new StringTokenizer(br.readLine(), " ");

			int size = st.countTokens();

			for (int j = 0; j < size; j++) {

				int before;

				if (j >= 1) {
					before = Math.max(map[i - 1][j - 1], map[i - 1][j]);
				} else {
					before = map[i - 1][j];
				}
				map[i][j] = Integer.parseInt(st.nextToken()) + before;

				ans = Math.max(map[i][j], ans);
			}

		}

		System.out.println(ans);
//		
//		for(int i=0; i<=n; i++) {
//			ans = Math.max(map[n-1][i], ans);
//		}
//		
//		System.out.println(ans);
	}

	static void dfs(int x, int y, int depth, int result) {

		if (depth == n) {
			ans = Math.max(ans, result);
			return;
		}

		int nextY = y + 1;

		dfs(x, nextY, depth + 1, result + map[nextY][x]);
		dfs(x + 1, nextY, depth + 1, result + map[nextY][x + 1]);

	}

}
