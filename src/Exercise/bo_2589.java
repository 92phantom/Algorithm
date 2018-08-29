package Exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bo_2589 {

	static int n, m, x, y;
	static int map[][] = new int[50][50];
	static int max = 0;
	static int dx[] = { 1, -1, 0, 0 };
	static int dy[] = { 0, 0, 1, -1 };
	static int tmp[][];

	public static void main(String args[]) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = s.charAt(j);
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 'L') {
					tmp = new int[n][m];
					bfs(i, j);
				}
			}
		}

		System.out.println(max);
	}

	public static void bfs(int a, int b) {
		Queue<Point> q = new LinkedList<Point>();
		q.add(new Point(a, b));
		
		while (!q.isEmpty()) {
			
			Point point = q.poll();
			
			x = point.x;
			y = point.y;
	
			for (int i = 0; i < 4; i++) {
				int nextX = x + dx[i];
				int nextY = y + dy[i];

				if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= m)
					continue;

				if (map[nextX][nextY] == 'L') {
					
					if (tmp[nextX][nextY] == 0 || tmp[nextX][nextY] > tmp[x][y] + 1) {
						
						tmp[nextX][nextY] = tmp[x][y] + 1;
						
						if (tmp[nextX][nextY] > max) {
							
							max = tmp[nextX][nextY];
							
						}
						
						q.add(new Point(nextX, nextY));
					}
				}

			}
		}
	}
}

class Point {
	int x;
	int y;

	Point(int _x, int _y) {
		x = _x;
		y = _y;
	}
}