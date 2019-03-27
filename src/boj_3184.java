import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_3184 {

	static int R, C;
	static char[][] map;
	static boolean[][] visited;
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { -1, 1, 0, 0 };

	static int totalO = 0;
	static int totalV = 0;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][C];
		visited = new boolean[R][C];

		for (int i = 0; i < R; i++) {
			String temp = br.readLine();
			for (int j = 0; j < C; j++) {
				char c = temp.charAt(j);
				map[i][j] = c;
				if (c == 'o') {
					totalO += 1;
				}
				if (c == 'v') {
					totalV += 1;
				}
			}

		}

		// . -> ºó ÇÊµå
		// # -> ¿ïÅ¸¸®
		// o -> ¾ç
		// v -> ´Á´ë

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (!visited[i][j] && map[i][j] == 'o') {
					bfs(j, i);
				}
			}

		}
		
		System.out.println(totalO+ " " + totalV);

	}

	static void bfs(int x, int y) {

		Queue<Node> q = new LinkedList<>();
		q.add(new Node(x, y));

		visited[y][x] = true;

		int o = 1;
		int v = 0;

//		System.out.println("=====");
		while (!q.isEmpty()) {

			Node cur = q.poll();
			
//			System.out.println("Node X:"+ cur.x + "\tY: "+cur.y);

			
			for (int i = 0; i < 4; i++) {

				int nextX = cur.x + dx[i];
				int nextY = cur.y + dy[i];

				if (nextX < 0 || nextY < 0 || nextX >= C || nextY >= R || visited[nextY][nextX])
					continue;

				if (map[nextY][nextX] == '#')
					continue;

				if (map[nextY][nextX] == 'o') {
					o += 1;
					visited[nextY][nextX] = true;
					q.add(new Node(nextX, nextY));

				}
				else if (map[nextY][nextX] == 'v') {
					v += 1;
					visited[nextY][nextX] = true;
					q.add(new Node(nextX, nextY));

				} else if (map[nextY][nextX] == '.') {
					visited[nextY][nextX] = true;
					q.add(new Node(nextX, nextY));
				}

			}

		}
		
//		System.out.println("¾çÀÇ ¼ö "+ o);
//		System.out.println("´Á´ëÀÇ ¼ö"+ v);
		
		if (o > v) {
			totalV -= v;
		}

		else if (o <= v) {
			totalO -= o;
		}
	}

	static class Node {
		int x, y;
//		char val;

		Node(int x, int y) {
			this.x = x;
			this.y = y;
//			this.val = val;
		}
	}

}
