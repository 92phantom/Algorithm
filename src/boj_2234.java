import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_2234 {

	static int N, M;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = { 0, -1, 0, 1 };
	static int[] dy = { -1, 0, 1, 0 };

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		map = new int[50][50];
		visited = new boolean[50][50];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				int temp = Integer.parseInt(st.nextToken());

				map[i][j] = temp;

			}
		}

		func();

	}

	static void func() {

		int room = 0;
		int big_room = 0;

		for (int i = 0; i < N; i++) {

			for (int j = 0; j < M; j++) {

				if (!visited[i][j]) {

					big_room = bigCheck(big_room, bfs(i, j));
					room ++;
//					System.out.println("--");
//					for(int z=0; z<N; z++) {
//						System.out.println(Arrays.toString(visited[z]));
//					}
				}

			}

		}

		System.out.println(room);
		System.out.println(big_room);

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {

				for (int w = 1; w <= 8; w *= 2) {

					if ((map[i][j] & w) == w) {

						visited = new boolean[50][50];
						map[i][j] = map[i][j] - w;
						big_room = bigCheck(big_room, bfs(i, j));
						map[i][j] = map[i][j] + w;

					}

				}

			}
		}

		System.out.println(big_room);

	}

	static int bfs(int x, int y) {

		int roomSize = 0;
		
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(x, y));
		
		visited[x][y] = true;
		roomSize++;

		while (!q.isEmpty()) {

			Node cur = q.poll();
			int curX = cur.x;
			int curY = cur.y;

			int wall = 1;

			for (int i = 0; i < 4; i++) {

				if ((map[curX][curY] & wall) != wall) {

					int nextX = curX + dx[i];
					int nextY = curY + dy[i];

					if (nextX >= 0 && nextY >= 0 && nextX < N && nextY < M) {

						if (!visited[nextX][nextY]) {
							roomSize++;
							visited[nextX][nextY] = true;
							q.add(new Node(nextX, nextY));

						}

					}

				}
				wall = wall * 2;

			}

		}
		return roomSize;
	}

	static int bigCheck(int a, int b) {

		if (a > b) {
			return a;
		} else {
			return b;
		}

	}

	static class Node {
		int x, y;

		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

}
