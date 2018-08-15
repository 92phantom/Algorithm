package BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

/*
 * 
 * author	: HYUNJIN PARK
 * date		: 2018.08.16
 * result	: 12636KB, 144ms
 * 
 */

public class Mazes_2178 {

	static int N, M;
	static int map[][];
	static boolean visisted[][];
	static int x[] = { 1, 0, -1, 0 };
	static int y[] = { 0, 1, 0, -1 };

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);		
		String word;
		StringTokenizer st= new StringTokenizer(input.nextLine(), " " );

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		visisted = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			word = input.nextLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = (word.charAt(j) - '0');
			}
		}
		
		bfs(new Point(0, 0, 1)); 						
		input.close();

	}

	public static void bfs(Point P) {
		Queue<Point> q = new LinkedList<>();

		q.add(P);
		visisted[P.y][P.x] = true;

		while (!q.isEmpty()) {

			Point p = q.poll();
			if (p.x == M - 1 && p.y == N - 1) {
				System.out.println(p.depth);
				return;
			}
			for (int i = 0; i < 4; i++) {
				int nextX = x[i] + p.x;
				int nextY = y[i] + p.y;

				if (nextX < 0 || nextX >= M || nextY < 0 || nextY >= N)
					continue;

				if (visisted[nextY][nextX] == false && map[nextY][nextX] == 1) {

					visisted[nextY][nextX] = true;
					q.add(new Point(nextX, nextY, p.depth + 1));
				}
			}
		}
	}
}

class Point {
	int x, y, depth;

	Point(int x, int y, int depth) {
		this.x = x;
		this.y = y;
		this.depth = depth;
	}

}