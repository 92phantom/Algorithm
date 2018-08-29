package Exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_2468 {

	static int N;
	static int[][] map;
	static boolean[][] visited;

	static int tmpCount = 0;

	static int minVal = Integer.MAX_VALUE, maxVal;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, -1, 0, 1 };

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), "");

		N = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		visited = new boolean[N][N];

		for (int i = 0; i < N; i++) {

			st = new StringTokenizer(br.readLine(), " ");

			for (int j = 0; j < N; j++) {

				int tmp = Integer.parseInt(st.nextToken());

				map[i][j] = tmp;
				maxVal = maxVal < tmp ? tmp : maxVal;
				minVal = minVal > tmp ? tmp : minVal;

			}

		}

		bfs();

		for (int i = 0; i < N; i++) {

			for (int j = 0; j < N; j++) {

				System.out.print(" " + visited[i][j]);
			}
			System.out.println();
		}


	}

	
	
	static void bfs() {

		int ans = 1;

		while (minVal <= maxVal) {
			Queue<Points> q = new LinkedList<>();

			for (int i = 0; i < N; i++) {

				for (int j = 0; j < N; j++) {

					if (visited[i][j] == false && map[i][j] > minVal) {
						
						System.out.println("¿©±â"+ tmpCount);
						
						q.add(new Points(i, j, 0));

						visited[i][j] = true;
						tmpCount++;

						while (!q.isEmpty()) {

							Points p = q.poll();

							for (int k = 0; k < 4; k++) {

								int nextX = p.x + dx[k];
								int nextY = p.y + dy[k];

								if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= N)
									continue;

								if (map[nextY][nextX] <= minVal || visited[nextY][nextX]) {
									continue;
								}		

								q.add(new Points(nextX, nextY, 0));
								visited[nextY][nextX] = true;

							}

						}

					}
				}

				System.out.println(minVal);
			}

			ans = ans < tmpCount ? tmpCount : ans;
			minVal++;
		}
		System.out.println("@@");
		System.out.println(ans);
	}

}

class Points {
	int x, y, depth;

	Points(int x, int y, int depth) {
		this.x = x;
		this.y = y;
		this.depth = depth;
	}
}