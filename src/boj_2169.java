import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj_2169 {

	static int N, M;
	static int[][] map;
	static int[][] dupMap;
	static int[] dx = { -1, 1, 0 };
	static int[] dy = { 0, 0, 1 };

	static long ans = 0;

	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		dupMap = new int[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				int temp = Integer.parseInt(st.nextToken());
				map[i][j] = temp;
			}
		}

		dupMap[0][0] = map[0][0];

//		// 첫번째 행
		for (int i = 1; i < M; i++) {
			dupMap[0][i] = dupMap[0][i - 1] + map[0][i];
		}

//		// 두번째 행

		int[][] store = new int[2][1005];

		for (int i = 1; i < N; i++) {

			// 위에서
			for (int j = 0; j < M; j++) {
				store[0][j] = store[1][j] = dupMap[i - 1][j] + map[i][j];
			}
			// 왼쪽에서 왔을때
			for (int j = 1; j < M; j++) {
				store[0][j] = Math.max(store[0][j], store[0][j - 1] + map[i][j]);
			}
			// 오른쪽에서 왔을 때
			for (int j = (M - 2); j >= 0; j--) {
				store[1][j] = Math.max(store[1][j], store[1][j + 1] + map[i][j]);
			}

			for (int j = 0; j < M; j++) {
				dupMap[i][j] = Math.max(store[0][j], store[1][j]);
			}

		}

		System.out.println(dupMap[N - 1][M - 1]);

	}

}
