package Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_2933_new {

	static int R, C;
	static int N_SIZE;
	static char[][] map;
	static boolean[][] visited;

	// DIRECTION
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][C];

		for (int i = 0; i < R; i++) {

			String temp = br.readLine();

			for (int j = 0; j < C; j++) {

				char input = temp.charAt(j);

				map[i][j] = input;

			}

		}

		N_SIZE = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < N_SIZE; i++) {

			int input = Integer.parseInt(st.nextToken());
			int cutRow = R - input;

			breakMineral(cutRow, i);
			clusterCheck();
		}

		for (int i = 0; i < R; i++) {

			for (int j = 0; j < C; j++) {

				System.out.print(map[i][j]);
			}
			System.out.println();
		}

	}

	static void breakMineral(int row, int dir) {

		// 처음 좌측
		if (dir % 2 == 0) {

			for (int i = 0; i < C; i++) {
				if (map[row][i] == 'x') {
					map[row][i] = '.';
					return;
				}
			}

		} else {
			for (int i = (C - 1); i >= 0; i--) {
				if (map[row][i] == 'x') {
					map[row][i] = '.';
					return;
				}
			}
		}

	}

	static void clusterCheck() {
		visited = new boolean[R][C];

		Queue<Point> q = new LinkedList<>();

		for (int i = 0; i < C; i++) {

			if (map[R - 1][i] == 'x' || !visited[R - 1][i]) {
				q.add(new Point(i, R - 1));
			}

			while (!q.isEmpty()) {

				Point p = q.poll();

				visited[p.y][p.x] = true;

				// 주변 노드 탐색
				for (int j = 0; j < 4; j++) {

					int nextX = p.x + dx[j];
					int nextY = p.y + dy[j];

					if (nextX < 0 || nextY < 0 || nextX >= C || nextY >= R)
						continue;

					if (!visited[nextY][nextX] && map[nextY][nextX] == 'x') {

						visited[nextY][nextX] = true;
						q.add(new Point(nextX, nextY));

					}

				}

			}

		}

		ArrayList<Point> clusterList = new ArrayList<>();
		// 공중에 떠있는 클러스터가 있는지 확인
		for (int i = 0; i < R; i++) {

			for (int j = 0; j < C; j++) {

				if (!visited[i][j] && map[i][j] == 'x') {

					map[i][j] = '.';
					clusterList.add(new Point(j, i));
				}
			}

		}

		// 공중에 떠있는 클러스터가 없을 경우
		if (clusterList.size() == 0) {
			return;
		}

		boolean flag = true;

		// 이 부분 다시 풀어봐야함

		while (flag) {

			for (Point point : clusterList) {
				int nextY = point.y + 1;
				int nextX = point.x;

				if (nextX < 0 || nextY < 0 || nextX >= C || nextY >= R || map[nextY][nextX] == 'x') {
					flag = false;
					break;
				}
			}
			if (flag) {
				for (Point point : clusterList) {
					point.y++;
				}
			}

		}

		for (int i = 0; i < clusterList.size(); i++) {

			map[clusterList.get(i).y][clusterList.get(i).x] = 'x';

		}

	}

	static class Point {
		int x, y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}
}
