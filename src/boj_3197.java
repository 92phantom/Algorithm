import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_3197 {

	static int R, C;

	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };

	static char[][] map;

	static int[][] water;

	static int bakjo_1_X = -1;
	static int bakjo_1_Y = -1;
	static int bakjo_2_X = -1;
	static int bakjo_2_Y = -1;

//	static ArrayList<Node> list = new ArrayList<>();

	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][C];
		water = new int[R][C];

		for (int i = 0; i < R; i++) {
			String temp = br.readLine();
			for (int j = 0; j < C; j++) {
				char input = temp.charAt(j);
				map[i][j] = input;

				if (input == 'L') {
					if (bakjo_1_X == -1) {
						bakjo_1_X = j;
						bakjo_1_Y = i;
					}else {
						bakjo_2_X = j;
						bakjo_2_Y = i;
					}
				}

			}
		}

		bfs();
		/*
		 * 
		 * È£¼ö´Â Â÷·Ê·Î ³ì´Âµ¥, ¸ÅÀÏ ¹° °ø°£°ú Á¢ÃËÇÑ ¸ðµç ºùÆÇ °ø°£Àº ³ì´Â´Ù.
		 * 
		 * 
		 */

	}

	static void bfs() {

		int count = 0;
		Queue<Node> q = new LinkedList<>();
		visited = new boolean[R][C];
		
		for (int i = 0; i < R; i++) {

			for (int j = 0; j < C; j++) {
				if (map[i][j] == '.') {
					visited[i][j] = true;
					q.add(new Node(j, i, 0));
				}

			}

		}

		while (!q.isEmpty()) {

			int size = q.size();

			for (int i = 0; i < size; i++) {

				Node cur = q.poll();

				int x = cur.x;
				int y = cur.y;

				water[y][x] = count;

				for (int k = 0; k < 4; k++) {

					int nextX = x + dx[k];
					int nextY = y + dy[k];
					if (nextX < 0 || nextY < 0 || nextX >= C || nextY >= R)
						continue;

					if (visited[nextY][nextX])
						continue;

					visited[nextY][nextX] = true;
					q.add(new Node(nextX, nextY, 0));
				}
			}

			count += 1;

		}

		PriorityQueue<Node> bakjoMove = new PriorityQueue<>();
		bakjoMove.add(new Node(bakjo_1_X, bakjo_1_Y, 0));
		visited = new boolean[R][C];
		visited[bakjo_1_Y][bakjo_1_X] = true;

		while (!bakjoMove.isEmpty()) {

			Node cur = bakjoMove.poll();
			int x = cur.x;
			int y = cur.y;

			if(bakjo_2_X == x && bakjo_2_Y == y) {
				System.out.println(cur.day);
				return;
			}
			
			for (int i = 0; i < 4; i++) {

				int nextX = x + dx[i];
				int nextY = y + dy[i];

				if (nextX < 0 || nextY < 0 || nextX >= C || nextY >= R)
					continue;

				if (visited[nextY][nextX])
					continue;

				visited[nextY][nextX] = true;
				bakjoMove.add(new Node(nextX, nextY, Math.max(cur.day, water[nextY][nextX])));

			}

		}

		
//			printDebug();

	}

	static void printDebug() {

		System.out.println("============");

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}

	}

	static class Node implements Comparable<Node> {
		int x;
		int y;
		int day;

		Node(int x, int y, int day) {
			this.x = x;
			this.y = y;
			this.day = day;
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
//			System.out.println("¹¹¿©"+(this.day-o.day));
			return this.day - o.day;
		}
	}

}
