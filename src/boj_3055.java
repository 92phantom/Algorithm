import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_3055 {

	static int R, C;
	static char[][] map;
	static int endX, endY;

	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { -1, 1, 0, 0 };

	static Queue<Node> pq = new LinkedList<>();
	static Queue<Node> q = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][C];

		for (int i = 0; i < R; i++) {
			String temp = br.readLine();
			for (int j = 0; j < C; j++) {
				char input = temp.charAt(j);
				if (input == 'D') {
					endX = j;
					endY = i;
				} else if (input == 'S') {
					pq.add(new Node(j, i));
				}
				map[i][j] = input;

			}
		}

		bfs();

	}

	static void bfs() {


		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == '*') {
					q.add(new Node(j, i));
				}
			}
		}

		int ans = 0;
		
		while (true) {

			if (pq.size() == 0) {
				System.out.println("KAKTUS");
				break;
			}
			
			int size = q.size();

			for (int loop = 0; loop < size; loop++) {
				Node cur = q.poll();

				for (int i = 0; i < 4; i++) {

					int nextX = cur.x + dx[i];
					int nextY = cur.y + dy[i];

					if (nextX < 0 || nextY < 0 || nextX >= C || nextY >= R)
						continue;

					if (map[nextY][nextX] == 'D' || map[nextY][nextX] == 'X')
						continue;

					map[nextY][nextX] = '*';
					q.add(new Node(nextX, nextY));

				}
			}

			int pqSize = pq.size();


			
			for (int loop = 0; loop < pqSize; loop++) {
				Node cur = pq.poll();

				if (cur.x == endX && cur.y == endY) {
					System.out.println(ans);
					return;
				}

				for (int i = 0; i < 4; i++) {

					int nextY = cur.y + dy[i];
					int nextX = cur.x + dx[i];

					if (nextX < 0 || nextY < 0 || nextX >= C || nextY >= R)
						continue;

					if (map[nextY][nextX] == 'X' || map[nextY][nextX] == '*')
						continue;

					pq.add(new Node(nextX, nextY));

				}

			}

			ans +=1;


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
