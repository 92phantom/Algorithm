
// 1194 달이 차오른다, 가자.
// 시작 시간 14:02
// 종료 시간 15:51
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_1194 {

	static int N, M;
	static int minseekX = 0;
	static int minseekY = 0;

	static int exitX = 0;
	static int exitY = 0;

	static char[][] map;
	static boolean[][][] visited;

	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };


	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new char[N][M];
		visited = new boolean[N][M][1 << 6];

		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for (int j = 0; j < M; j++) {
				char temp = input.charAt(j);
				map[i][j] = temp;
				if (temp == '0') {
					minseekX = j;
					minseekY = i;
				}
			}
		}

		System.out.println(bfs());

	}

	static int bfs() {

		visited = new boolean[N][M][1 << 6];
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(minseekX, minseekY, 0));
		map[minseekY][minseekX] = '.';

		visited[minseekY][minseekX][0] = true;
		int count = 0;

		while (!q.isEmpty()) {

			int size = q.size();

			for (int i = 0; i < size; i++) {	

				Node cur = q.poll();
				int currentKey = cur.key;
				if (map[cur.y][cur.x] == '1') {
					return count;
				}

				for (int j = 0; j < 4; j++) {
					int nextX = cur.x + dx[j];
					int nextY = cur.y + dy[j];
					int key = currentKey;
					if (nextX < 0 || nextX >= M || nextY < 0 || nextY >= N || map[nextY][nextX] == '#') {
						continue;
					}

					// 키 모음
					if (map[nextY][nextX] >= 'a' && map[nextY][nextX] <= 'f') {

						key |= (1 << map[nextY][nextX] - 'a');
					}

					// 키 확인 이동
					else if (map[nextY][nextX] >= 'A' && map[nextY][nextX] <= 'F') {

						if ((key & (1 << (map[nextY][nextX] - 'A'))) == 0) {
							continue;
						}

					}

					if (visited[nextY][nextX][key])
						continue;

					visited[nextY][nextX][key] = true;
					q.add(new Node(nextX, nextY, key));

				}

			}
			count += 1;

		}

		return -1;
//		}

	}

	static class Node {
		int x, y;
		int key;

		Node(int x, int y, int key) {
			this.x = x;
			this.y = y;
			this.key = key;
		}
	}
}
