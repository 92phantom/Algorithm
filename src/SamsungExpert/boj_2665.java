package SamsungExpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_2665 {

	static int INF = 10000000;
	static int n;
	static int[][] map;
	static int[][] visited;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, -1, 0, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());

		map = new int[51][51];
		visited = new int[51][51];

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine(), "");
			String temp = st.nextToken();

			for (int j = 1; j <= n; j++) {
				map[i][j] = Integer.parseInt(temp.charAt(j-1) + "");
				visited[i][j] = INF;
			}
		}

		visited[1][1] = 0;
		bfs(new Point2665(1, 1));

		
		System.out.println(visited[n][n]);

	}

	static void bfs(Point2665 p) {

		Queue<Point2665> q = new LinkedList<>();

		q.add(p);

		while (!q.isEmpty()) {
			Point2665 current = q.poll();

			for (int i = 0; i < 4; i++) {

				int nextX = current.x + dx[i];
				int nextY = current.y + dy[i];

				if (nextX < 1 || nextX > n || nextY < 1 || nextY > n)
					continue;

				if (visited[nextY][nextX] <= visited[current.y][current.x])
					continue;

				if (map[nextY][nextX] == 1) {
					visited[nextY][nextX] = visited[current.y][current.x];
					q.add(new Point2665(nextX, nextY));
				} else {
					visited[nextY][nextX] = visited[current.y][current.x] + 1;
					q.add(new Point2665(nextX, nextY));
				}
			}

		}

	}

}

class Point2665 {
	int x, y;

	Point2665(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
