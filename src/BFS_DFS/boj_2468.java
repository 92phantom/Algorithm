package BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 
 * result : 45532 KB, 300 ms
 * 
 */

public class boj_2468 {

	static int N;
	static int[][] map;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, -1, 0, 1 };
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {

		int minV = Integer.MAX_VALUE;
		int maxV = 0;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), "");

		N = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		visited = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				minV = minV > map[i][j] ? map[i][j] : minV;
				maxV = maxV < map[i][j] ? map[i][j] : maxV;
			}
		}

		ArrayList<Integer> memoization = new ArrayList<Integer>();

		memoization.add(0, 1);
		
		for (int k = 1; k <= maxV; k++) {

			int cnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {

					if (!visited[i][j] && map[i][j] > k) {
						cnt += 1;
						bfs(new Pivot(i, j, k));
					}
				}
			}
			visited = new boolean[N][N];
			
			memoization.add(k, cnt);
			
		}

		System.out.println(Collections.max(memoization));

	}

	static void bfs(Pivot p) {

		Queue<Pivot> q = new LinkedList<>();

		q.add(p);

		visited[p.getX()][p.getY()] = true;

		while (!q.isEmpty()) {

			Pivot pivot = q.poll();

			for (int i = 0; i < 4; i++) {

				int nextX = pivot.getX() + dx[i];
				int nextY = pivot.getY() + dy[i];
				int depth = pivot.getDepth();
				if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= N)
					continue;

				if (!visited[nextX][nextY] && map[nextX][nextY] > depth) {
					q.add(new Pivot(nextX, nextY, depth));
					visited[nextX][nextY] = true;
				}

			}

		}

	}

}

class Pivot {

	private int x, y, depth;

	Pivot(int x, int y, int depth) {
		setX(x);
		setY(y);
		setDepth(depth);
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

}
