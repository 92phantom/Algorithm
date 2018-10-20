package SamsungExpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class swea_1953 {

	static int T, N, M, R, C, L, ans;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		T = Integer.parseInt(br.readLine());

		for (int i = 1; i <= T; i++) {

			st = new StringTokenizer(br.readLine(), " ");

			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());

			map = new int[N][M];
			visited = new boolean[N][M];

			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int k = 0; k < M; k++) {

					map[j][k] = Integer.parseInt(st.nextToken());

				}

			}

			// dfs(C, R, L);

			bfs(new Point1953(C, R, L));

			for (int j = 0; j < N; j++) {
				System.out.println(Arrays.toString(visited[j]));
			}

			int cnt = 0;
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < M; k++) {
					if (visited[j][k])
						cnt += 1;
				}
			}
			//
			System.out.println(cnt);
		}

	}

	static void bfs(Point1953 p) {

		Queue<Point1953> q = new LinkedList<>();

		visited[p.y][p.x] = true;

		q.add(p);

		while (!q.isEmpty()) {

			Point1953 point = q.poll();

			int x = point.x;
			int y = point.y;
			int timer = point.timer;

			if (timer == 0)
				return;

//			int currentVal = map[y][x];

			// System.out.println(currentVal);

			for (int i = 0; i < 4; i++) {

				int nextX = x + dx[i];
				int nextY = y + dy[i];

				if (nextX < 0 || nextY < 0 || nextX >= M || nextY >= N || map[nextY][nextX] == 0)
					continue;

				if (!visited[nextY][nextX]) {

					if (map[x][y] == 2) {
                        if (i == 2 || i == 3) continue;
                    }
                    else if (map[x][y] == 3) {
                        if (i == 0 || i == 1) continue;
                    }
                    else if (map[x][y] == 4) {
                        if (i == 0 || i == 3) continue;
                    }
                    else if (map[x][y] == 5) {
                        if (i == 1 || i == 3) continue;
                    }
                    else if (map[x][y] == 6) {
                        if (i == 1 || i == 2) continue;
                    }
                    else if (map[x][y] == 7) {
                        if (i == 0 || i == 2) continue;
                    }
 

                    if (i == 0) {
                        if (map[nextY][nextX] == 1 || map[nextY][nextX] == 2 || map[nextY][nextX] == 4 || map[nextY][nextX] == 7) {
                            q.add(new Point1953(nextX, nextY, timer - 1));
                            visited[nextY][nextX] = true;
                        }
                    }
                    else if (i == 1) {
                        if (map[nextY][nextX] == 1 || map[nextY][nextX] == 2 || map[nextY][nextX] == 5 || map[nextY][nextX] == 6) {
                            q.add(new Point1953(nextX, nextY, timer - 1));
                            visited[nextY][nextX] = true;
                        }
                    }
                    else if (i == 2) {
                        if (map[nextY][nextX] == 1 || map[nextY][nextX] == 3 || map[nextY][nextX] == 6 || map[nextY][nextX] == 7) {
                            q.add(new Point1953(nextX, nextY, timer-1));
                            visited[nextY][nextX] = true;
                        }
                    }
                    else {
                        if (map[nextY][nextX] == 1 || map[nextY][nextX] == 3 || map[nextY][nextX] == 4 || map[nextY][nextX] == 5) {
                            q.add(new Point1953(nextX, nextY, timer -1));
                            visited[nextY][nextX] = true;
                        }
                    }
					
					

				}
			}

		}

	}

	static boolean up(String next) {

		if (next.matches("1|2|5|6")) {
			return true;
		}

		return false;
	}

	static boolean down(String next) {

		if (next.matches("1|2|4|7")) {
			return true;
		}

		return false;
	}

	static boolean left(String next) {

		if (next.matches("1|3|4|5")) {
			return true;
		}

		return false;
	}

	static boolean right(String next) {

		if (next.matches("1|3|6|7")) {
			return true;
		}

		return false;
	}

	static void dfs(int x, int y, int timer) {

		if (timer == 0) {
			return;
		}

		visited[y][x] = true;

		for (int i = 0; i < 4; i++) {

			int nextX = x + dx[i];
			int nextY = y + dy[i];

			if (nextX < 0 || nextY < 0 || nextX >= M || nextY >= N || map[nextY][nextX] == 0)
				continue;

			// 1ÀÏ¶§

			boolean check = false;
			if (map[y][x] == 1) {
				check = true;
			} else if (map[y][x] == 2) {

				// »ó
				if (dy[i] < 0 && (map[nextY][nextX] == 1 || map[nextY][nextX] == 2 || map[nextY][nextX] == 5
						|| map[nextY][nextX] == 6)) {
					check = true;
				}
				// ÇÏ
				else if (dy[i] > 0 && (map[nextY][nextX] == 1 || map[nextY][nextX] == 2 || map[nextY][nextX] == 4
						|| map[nextY][nextX] == 7)) {
					check = true;
				}

			} else if (map[y][x] == 3) {

				// ¿ì
				if (dx[i] > 0 && (map[nextY][nextX] == 1 || map[nextY][nextX] == 3 || map[nextY][nextX] == 6
						|| map[nextY][nextX] == 7)) {
					check = true;
				}
				// ÁÂ
				else if (dx[i] < 0 && (map[nextY][nextX] == 1 || map[nextY][nextX] == 3 || map[nextY][nextX] == 4
						|| map[nextY][nextX] == 5)) {
					check = true;
				}

			} else if (map[y][x] == 4) {

				// »ó
				if (dy[i] < 0 && (map[nextY][nextX] == 1 || map[nextY][nextX] == 2 || map[nextY][nextX] == 5
						|| map[nextY][nextX] == 6)) {
					check = true;
				}
				// ¿ì
				else if (dx[i] > 0 && (map[nextY][nextX] == 1 || map[nextY][nextX] == 3 || map[nextY][nextX] == 6
						|| map[nextY][nextX] == 7)) {
					check = true;
				}

			} else if (map[y][x] == 5) {

				// ÇÏ
				if (dy[i] > 0 && (map[nextY][nextX] == 2 || map[nextY][nextX] == 4 || map[nextY][nextX] == 7
						|| map[nextY][nextX] == 1)) {
					check = true;
				}
				// ¿ì
				else if (dx[i] > 0 && (map[nextY][nextX] == 1 || map[nextY][nextX] == 3 || map[nextY][nextX] == 6
						|| map[nextY][nextX] == 7)) {
					check = true;
				}

			} else if (map[y][x] == 6) {

				// ÇÏ
				if (dy[i] > 0 && (map[nextY][nextX] == 1 || map[nextY][nextX] == 2 || map[nextY][nextX] == 4
						|| map[nextY][nextX] == 7)) {
					check = true;
				}
				// ÁÂ
				else if (dx[i] < 0 && (map[nextY][nextX] == 1 || map[nextY][nextX] == 3 || map[nextY][nextX] == 4
						|| map[nextY][nextX] == 5)) {
					check = true;
				}

			} else if (map[y][x] == 7) {

				// »ó
				if (dy[i] < 0 && (map[nextY][nextX] == 1 || map[nextY][nextX] == 2 || map[nextY][nextX] == 5
						|| map[nextY][nextX] == 6)) {
					check = true;
				}
				// ÁÂ
				else if (dx[i] < 0 && (map[nextY][nextX] == 1 || map[nextY][nextX] == 3 || map[nextY][nextX] == 4
						|| map[nextY][nextX] == 5)) {
					check = true;
				}

			}

			if (check) {
				dfs(nextX, nextY, timer - 1);
			}
		}
		// return ans;
	}

}

class Point1953 {

	int x, y, timer;

	public Point1953(int x, int y, int timer) {
		this.x = x;
		this.y = y;
		this.timer = timer;
	}
}