package BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_16236 {

	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };
	static int N;
	static int[][] map;
	static ArrayList<Items> fish = new ArrayList<Items>();
	static int x, y;
	static boolean[][] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];

		for (int i = 0; i < N; i++) {

			st = new StringTokenizer(br.readLine(), " ");

			for (int j = 0; j < N; j++) {

				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 9) {
					y = i;
					x = j;
				}
			}

		}
		solve();
	}

	static void solve() {
		Queue<Items> q = new LinkedList<>();
		q.add(new Items(x, y, 2, 0, 0));
		visited[y][x] = true;

		int result = 0;

		while (!q.isEmpty()) {

			int eatX = 99;
			int eatY = 99;
			int eat = 0, big = 0, cnt = 0;

			int size = q.size();

			for (int j = 0; j < size; j++) {

				Items item = q.poll();

				for (int i = 0; i < 4; i++) {

					int nextX = dx[i] + item.x;
					int nextY = dy[i] + item.y;

					if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= N)
						continue;

					if (visited[nextY][nextX])
						continue;

					if (map[nextY][nextX] > item.big) continue;
					
					visited[nextY][nextX] = true;
					q.add(new Items(nextX, nextY, item.big, item.eat, item.cnt + 1));

					if (map[nextY][nextX] != 0 && map[nextY][nextX] != item.big) {
						
						if (nextY < eatY) {

							eatY = nextY;
							eatX = nextX;
							eat = item.eat;
							big = item.big;
							cnt = item.cnt + 1;
							
						} else if (nextY == eatY) {

							if (nextX < eatX) {
								eatY = nextY;
								eatX = nextX;
								eat = item.eat;
								big = item.big;
								cnt = item.cnt + 1;
							}
						} 

					}
				}

			}
			if (eatX != 99) {
				eat++;

				if (eat == big) {
					big++;
					eat = 0;

				}

				map[y][x] = 0;
				map[eatY][eatX] = 9;
				result += cnt;
				x = eatX;
				y = eatY;
//				visited = new boolean[N][N];
				init();
				q.clear();
				visited[eatY][eatX] = true;

				q.add(new Items(eatX, eatY, big, eat, 0));
			}
		}

		System.out.println(result);
	}
	private static void init() {
	        for(int i=0;i<N;i++) {
	            for(int j=0;j<N;j++)
	                visited[i][j] = false;
	        }
	    }
	static class Items {

		int x, y, big, eat, cnt;

		Items(int x, int y, int big, int eat, int cnt) {
			this.x = x;
			this.y = y;
			this.big = big;
			this.eat = eat;
			this.cnt = cnt;
		}

	}

}
