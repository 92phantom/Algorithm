package BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_4179 {

	static int R, C, ans = -1;
	static boolean[][] visited;
	static char[][] map;
	static Queue<Pivot> list = new LinkedList<>();
	static Queue<Pivot> man = new LinkedList<>();
	static int x, y;
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][C];
		visited = new boolean[R][C];

		for (int i = 0; i < R; i++) {
			String temp = br.readLine();

			for (int j = 0; j < C; j++) {

				char input = temp.charAt(j);
				map[i][j] = input;
				if (input == 'J') {
//					x = j;
//					y = i;
					map[i][j] = '.';
					man.add(new Pivot(j, i, 0));
				} else if (input == 'F') {

					list.add(new Pivot(j, i, 0));
					visited[i][j] = true;

				}
			}
		}

		bfs(x, y, 0);
	}

	static void bfs(int x, int y, int move) {
//
//		Queue<Pivot> q = new LinkedList<>();
//
//		visited[y][x] = true;
//		q.add(new Pivot(x, y, move));

		int cnt = 0;

		while (!man.isEmpty()) {

			cnt++;
			// ∫“¿Ã ≥µ¥Ÿ.

			if (!list.isEmpty()) {
				int size = list.size();

				for (int i = 0; i < size; i++) {

					Pivot temp = list.poll();

					for (int j = 0; j < 4; j++) {

						int nextX = temp.x + dx[j];
						int nextY = temp.y + dy[j];

						if (nextX < 0 || nextY < 0 || nextX >= C || nextY >= R)
							continue;

						if (map[nextY][nextX] != '.')
							continue;

						list.add(new Pivot(nextX, nextY, 0));
						map[nextY][nextX] = 'F';

					}
				}
			}
			
			// ¡ˆ»∆æ∆ ∞°¿⁄!

			int ms = man.size();

			for (int s = 0; s < ms; s++) {

				Pivot p = man.poll();

				if (p.x == 0 || p.y == 0 || p.x == (C - 1) || p.y == (R - 1)) {
					System.out.println(cnt + 1);
					return;
				}

				for (int i = 0; i < 4; i++) {

					int nextX = p.x + dx[i];
					int nextY = p.y + dy[i];

					if (nextX < 0 || nextY < 0 || nextX >= C || nextY >= R)
						continue;

					if (visited[nextY][nextX] || map[nextY][nextX] != '.')
						continue;

					visited[nextY][nextX] = true;
					man.add(new Pivot(nextX, nextY, p.move + 1));

				}
			}

		}

		System.out.println("IMPOSSIBLE");

	}

	static class Pivot {
		int x, y, move;

		Pivot(int x, int y, int move) {
			this.x = x;
			this.y = y;
			this.move = move;
		}

	}

}
