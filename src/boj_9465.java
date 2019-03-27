import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_9465 {

	static int T;
	static int n;
	static int[][] map;
	static int[][] dp;

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static boolean[][] visited;

	static int ans;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			n = Integer.parseInt(br.readLine());
			ans = 0;
			map = new int[2][n+2];
			dp = new int[2][n+2];

			for (int j = 0; j < 2; j++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int k = 1; k <= n; k++) {
					map[j][k] = Integer.parseInt(st.nextToken());
				}
			}

			dp[0][0] = dp[1][0] = 0;
			dp[0][1] = map[0][1];
			dp[1][1] = map[1][1];

			for (int j = 2; j <= n; j++) {
				dp[0][j] = Math.max(dp[1][j - 1], dp[1][j - 2]) + map[0][j];
				dp[1][j] = Math.max(dp[0][j - 1], dp[0][j - 2]) + map[1][j];

			}

			ans = Math.max(dp[0][n], dp[1][n]);

			System.out.println(ans);
		}

	}

}
