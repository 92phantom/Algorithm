package BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
 * 
 * @result : 10616KB 80ms
 * 
 */
public class boj_2583 {
	static int M;
	static int N;
	static int K;
	static int map[][];
	static boolean visited[][];
	static int result[];
	static int dx[] = { -1, 0, 1, 0 };
	static int dy[] = { 0, -1, 0, 1 };

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		result = new int[3000];

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new int[M][N];

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			int startX = Integer.parseInt(st.nextToken());
			int startY = Integer.parseInt(st.nextToken());
			int endX = Integer.parseInt(st.nextToken());
			int endY = Integer.parseInt(st.nextToken());

			for (int j = startX; j < endX; j++) {

				for (int h = startY; h < endY; h++) {
					map[h][j] = -1;
				}
			}
		}

		int count = 1;

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 0) {
					dfs(i, j, count);
					count++;
				}
			}
		}

		System.out.println(count - 1);
		Arrays.sort(result, 1, count);

		for (int i = 1; i < count; i++) {
			System.out.print(result[i] + " ");
		}

	}

	static void dfs(int x, int y, int count) {

		map[x][y] = -1;
		result[count]++;

		for (int i = 0; i < 4; i++) {

			int nextX = x + dx[i];
			int nextY = y + dy[i];

			if (nextX < 0 || nextY < 0 || nextX >= M || nextY >= N)
				continue;

			if (map[nextX][nextY] == 0) {
				dfs(nextX, nextY, count);
			}

		}

	}
}
