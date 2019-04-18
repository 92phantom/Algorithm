package SAMSUNG_LASTDAY;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import SAMSUNG_LASTDAY.boj_16235_Namu.Sorting;

public class boj_16236_Shark {

	static int N;
	static int[][] map = new int[21][21];
	static int sharkX, sharkY;
	static int sharkSIZE = 2;
	static int eat = 0;

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		StringTokenizer st;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			for (int j = 0; j < N; j++) {
				int temp = Integer.parseInt(st.nextToken());
				map[i][j] = temp;
				if (temp == 9) {
					sharkX = j;
					sharkY = i;
				}
			}
		}

		bfs();
	}

	static void bfs() {

		int ans = 0;
		while (true) {

			boolean[][] v = new boolean[N][N];

			Queue<Node> q = new LinkedList<>();
			q.add(new Node(sharkX, sharkY, sharkSIZE, 0));
			v[sharkY][sharkX] = true;

			int found = -1;

			ArrayList<Node> avail = new ArrayList<>();

			while (!q.isEmpty()) {
				Node cur = q.poll();

				if (found == cur.move) {
					break;
				}

				for (int i = 0; i < 4; i++) {
					int nextX = cur.x + dx[i];
					int nextY = cur.y + dy[i];

					if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= N)
						continue;
					if (v[nextY][nextX])
						continue;

					v[nextY][nextX] = true;

					if (map[nextY][nextX] <= sharkSIZE) {

						if (map[nextY][nextX] > 0 && sharkSIZE > map[nextY][nextX]) {
							found = cur.move + 1;
							avail.add(new Node(nextX, nextY, map[nextY][nextX], cur.move + 1));
						}

						q.add(new Node(nextX, nextY, cur.size, cur.move + 1));
					}

				}
			}

			if (found == -1) {
				break;
			}

			else {

				if (avail.size() > 0) {
					Collections.sort(avail, new Sorting());

					int eatX = avail.get(0).x;
					int eatY = avail.get(0).y;

					eat += 1;
					map[sharkY][sharkX] = 0;

					sharkX = eatX;
					sharkY = eatY;

					ans += found;

					if (eat == sharkSIZE) {
						eat = 0;
						sharkSIZE += 1;
					}

				}

			}

		}

		System.out.println(ans);

	}

	static class Sorting implements Comparator<Node> {
		@Override
		public int compare(Node o1, Node o2) {
			// TODO Auto-generated method stub
			if (o1.y < o2.y) {
				return -1;
			} else if (o1.y == o2.y) {
				if (o1.x < o2.x) {
					return -1;
				}
			}
			return 0;
		}
	}

	static class Node {
		int x, y, size, move;

		Node(int x, int y, int size, int move) {
			this.x = x;
			this.y = y;
			this.size = size;
			this.move = move;
		}
	}

}
