import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_B_shark {

	static int N;
	static int[][] map;

	static int sharkX = 0;
	static int sharkY = 0;

	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static boolean[][] visited;

	static int sharkSIZE = 2;
	static int curEAT = 0;

	static int ans = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		map = new int[N][N];
		visited = new boolean[N][N];
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

		while (true) {

			visited = new boolean[N][N];

			Queue<Node> q = new LinkedList<>();

			ArrayList<Node> avail = new ArrayList<>();

			q.add(new Node(sharkX, sharkY, 0));
			visited[sharkY][sharkX] = true;

			int found = -1;

			while (!q.isEmpty()) {

				Node cur = q.poll();
				
				if (found == cur.move) {
					break;
				}

				for (int i = 0; i < 4; i++) {
					int nextX = cur.x + dx[i];
					int nextY = cur.y + dy[i];

					if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= N || visited[nextY][nextX])
						continue;

					visited[nextY][nextX] = true;

					if (sharkSIZE >= map[nextY][nextX]) {

						if (map[nextY][nextX] > 0 && sharkSIZE > map[nextY][nextX]) {

							found = cur.move + 1;
							avail.add(new Node(nextX, nextY, cur.move + 1));
						}
						
						q.add(new Node(nextX, nextY, cur.move + 1));

					}
				}

			}

//			System.out.println("여기는가지");

			if (found == -1) {
//				System.out.println("안걸리나");
				break;
			} else {
				if (avail.size() > 0) {
					Collections.sort(avail, new Sorting());

					int eatX = avail.get(0).x;
					int eatY = avail.get(0).y;

					curEAT += 1;
					map[sharkY][sharkX] = 0;

					sharkX = eatX;
					sharkY = eatY;
					ans += found;
					if (curEAT == sharkSIZE) {
						curEAT = 0;
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

			// 가장 위에 있는 물고기,
			// 그러한 물고기가 여러마리라면,
			// 가장 왼쪽에 있는 물고기를 먹는다.
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

		int x, y, move;

		Node(int x, int y, int move) {
			this.x = x;
			this.y = y;
			this.move = move;
		}

	}

}
