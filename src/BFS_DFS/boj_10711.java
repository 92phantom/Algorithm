package BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_10711 {

	static int H, W;
	static char[][] map;
	static int dx[] = { -1, -1, -1, 0, 1, 1, 1, 0 };
	static int dy[] = { -1, 0, 1, 1, 1, 0, -1, -1 };
	static Queue<Node> list;
	static int[][] visited;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		list = new LinkedList<>();
		map = new char[H][W];
		visited = new int[H][W];

		// 입력받는다
		for (int i = 0; i < H; i++) {
			String temp = br.readLine();
			for (int j = 0; j < W; j++) {
				char input = temp.charAt(j);
				map[i][j] = input;
			}
		}

		// 파도 녹아내릴곳 찾는다 - 처음
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {

				if (map[i][j] == '.')
					continue;

				int cnt = 0;

				for (int k = 0; k < 8; k++) {
					int nextX = j + dx[k];
					int nextY = i + dy[k];
					if (nextX < W && nextY < H && nextX >= 0 && nextY >= 0) {
						if (map[nextY][nextX] == '.') {
							++cnt;
						}
					}
				}
				if (cnt >= map[i][j] - '0') {
					list.add(new Node(j, i));
					visited[i][j] = 1;
				}
			}
		}

		while (!list.isEmpty()) {

//			System.out.println("durl");
			Node cur = list.poll();

			int curX = cur.x;
			int curY = cur.y;

			map[curY][curX] = '.';

			for (int k = 0; k < 8; k++) {
				int nextX = curX + dx[k];
				int nextY = curY + dy[k];

				if (nextX < W && nextY < H && nextX >= 0 && nextY >= 0) {
//					System.out.println("뭐야");
					if (map[nextY][nextX] != '.' && visited[nextY][nextX] == 0) {
//						System.out.println("여기는?");
						int cnt = 0;

						for (int i = 0; i < 8; i++) {
							int Xnext = nextX + dx[i];
							int Ynext = nextY + dy[i];

							if (map[Ynext][Xnext] == '.' && Xnext < W && Ynext < H && Xnext >= 0 && Ynext >= 0) {
								++cnt;
							}
						}

//						System.out.println(cnt);
						if (cnt >= map[nextY][nextX] - '0') {
							visited[nextY][nextX] = visited[cur.y][cur.x] + 1;
//							System.out.println("durl2");
							list.add(new Node(nextX, nextY));
						}

					}
				}
			}

		}
		int ans = 0;
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				ans = Math.max(ans, visited[i][j]);
			}
		}

		System.out.println(ans);

	}

	static class Node {

		int x, y;

		Node(int x, int y) {
			this.x = x;
			this.y = y;
//			this.value = value;
		}

	}

}