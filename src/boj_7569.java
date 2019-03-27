import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_7569 {

	static int M, N, H;
	static int[][][] map;

	static int[] dx = { -1, 1, 0, 0, 0, 0 };
	static int[] dy = { -0, 0, -1, 1, 0, 0 };
	static int[] dz = { 0, 0, 0, 0, -1, 1 };
	static boolean[][][] visited;
	static ArrayList<Node> list;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		map = new int[H][N][M];
		visited = new boolean[H][N][M];
		/*
		 * 
		 * 정수 1은 익은 토마토, 정수 0 은 익지 않은 토마토, 정수 -1 토마토 x
		 * 
		 */
		list = new ArrayList<>();
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int k = 0; k < M; k++) {
					int temp = Integer.parseInt(st.nextToken());
					map[i][j][k] = temp;
					if (temp == 1) {
						list.add(new Node(k, j, i, 0));
					}
				}
			}
		}

		bfs();

	}

	static void bfs() {
		Queue<Node> q = new LinkedList<>();
		for (int i = 0; i < list.size(); i++) {
			Node cur = list.get(i);
//			visited[cur.z][cur.y][cur.z] = true;
			q.add(list.get(i));
		}

		int count = 0;

		while (!q.isEmpty()) {

			Node cur = q.poll();
			int x = cur.x;
			int y = cur.y;
			int z = cur.z;

			count = cur.move;

			for (int i = 0; i < 6; i++) {
				int nextX = x + dx[i];
				int nextY = y + dy[i];
				int nextZ = z + dz[i];

				if (nextX < 0 || nextY < 0 || nextZ < 0 || nextX >= M || nextY >= N || nextZ >= H)
					continue;

				if (visited[nextZ][nextY][nextX]) {
					continue;
				}

				if (map[nextZ][nextY][nextX] == 1 || map[nextZ][nextY][nextX] == -1) {
					continue;
				}

				visited[nextZ][nextY][nextX] = true;
				map[nextZ][nextY][nextX] = 1;
				q.add(new Node(nextX, nextY, nextZ, cur.move + 1));
			}

		}

		boolean flag = true;
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < M; k++) {
					if (map[i][j][k] == 0) {
						flag = false;
					}
				}
			}
		}

		if (flag) {
			System.out.println(count);
		} else {
			System.out.println(-1);
		}
	}

	static class Node {
		int x, y, z, move;

		Node(int x, int y, int z, int move) {
			this.x = x;
			this.y = y;
			this.z = z;
			this.move = move;
		}
	}

}
