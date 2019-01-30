package Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class boj_11559 {

	static final int vertical = 12;
	static final int horizontal = 6;
	static boolean[][] visited;
	static char[][] map;
	static Queue<Point> q = new LinkedList<>();

//	static int[] dx = { 0, 0, -1, 1, -1, 1, 1, -1 };
//	static int[] dy = { -1, 1, 0, 0, -1, 1, -1, 1 };

	static int[] dx = { 0, -1, 0, 1 };
	static int[] dy = { -1, 0, 1, 0 };

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		map = new char[vertical][horizontal];
		visited = new boolean[vertical][horizontal];
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < vertical; i++) {
			String temp = br.readLine();
			for (int j = 0; j < horizontal; j++) {
				map[i][j] = temp.charAt(j);
				if (map[i][j] != '.') {
					q.add(new Point(j, i, map[i][j]));
				}
			}
		}

		System.out.println("처음 시작!");
		for (int i = 0; i < vertical; i++) {

			System.out.println(Arrays.toString(map[i]));

		}
		System.out.println("=========");
		bfs();
	}

	static void bfs() {

		int cnt = 0;

		while (!q.isEmpty()) {

			int size = q.size();
//			System.out.println("사이즈" + size);
			boolean flag = false;
			for (int i = 0; i < size; i++) {

				Point p = q.poll();
				char curColor = p.color;
				
//				System.out.println("========");
//				System.out.println("x"+p.x);
//				System.out.println("y"+p.y);
//				System.out.println("color"+p.color);
//				System.out.println("========");
				
				ArrayList<Point> sameList = new ArrayList<>();
				Queue<Point> sameList2 = new LinkedList<>();
//				int[] dir = new int[4];

				
				sameList2.add(new Point(p.x, p.y, p.color));
				sameList.add(new Point(p.x, p.y, map[p.y][p.x]));

				visited = new boolean[vertical][horizontal];

				while(!sameList2.isEmpty()) {
					
					Point sameStart = sameList2.poll();
					
					visited[sameStart.y][sameStart.x] = true;
					
					for (int j = 0; j < 4; j++) {

						int nextX = sameStart.x + dx[j];
						int nextY = sameStart.y + dy[j];

						if (nextX < 0 || nextY < 0 || nextX >= horizontal || nextY >= vertical)
							continue;

						if (map[nextY][nextX] == curColor && !visited[nextY][nextX]) {

							sameList.add(new Point(nextX, nextY, map[nextY][nextX]));
							sameList2.add(new Point(nextX, nextY, map[nextY][nextX]));
						}

					}
				}

				System.out.println("같은거 사이즈"+sameList.size());
				
				if (sameList.size() >= 4) {
					flag = true;
					map[p.y][p.x] = '.';

					for (int j = 0; j < sameList.size(); j++) {
						map[sameList.get(j).y][sameList.get(j).x] = '.';
					}

				}

			}

			System.out.println("한번 바꾸기전 상태");
			for (int i = 0; i < vertical; i++) {

				System.out.println(Arrays.toString(map[i]));

			}
			System.out.println("=========");

			if (flag) {

				cnt += 1;

				for (int i = 0; i < horizontal; i++) {
					LinkedList<Point> moveList = new LinkedList<>();

					for (int j = (vertical - 1); j >= 0; j--) {
						if (map[j][i] != '.') {
							moveList.add(new Point(i, j, map[j][i]));
							map[j][i] = '.';
						}
					}

					int cur = vertical - 1;
					int moveSize = moveList.size();

					for (int j = 0; j < moveSize; j++) {
						Point moveP = moveList.poll();
						map[cur][i] = moveP.color;
						cur -= 1;
					}
				}

				for (int i = 0; i < vertical; i++) {

					for (int j = 0; j < horizontal; j++) {
						if (map[i][j] != '.') {
							q.add(new Point(j, i, map[i][j]));
						}
					}
				}

				System.out.println("위치  바꾼 후");
				for (int i = 0; i < vertical; i++) {

					System.out.println(Arrays.toString(map[i]));

				}
				System.out.println("=========");

			}
		}

		System.out.println(cnt);
	}

	static class Point {
		int x, y;
		char color;

		Point(int x, int y, char color) {
			this.x = x;
			this.y = y;
			this.color = color;
		}

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return super.toString();
		}

	}
}
