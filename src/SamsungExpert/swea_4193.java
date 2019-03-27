package SamsungExpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class swea_4193 {

	static int T;
	static int N;
	static int ans;
	static int[][] map;
	static int[][] visited;
	static int endY, endX;

	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {

			N = Integer.parseInt(br.readLine());
			map = new int[15][15];
			visited = new int[15][15];
			ans = Integer.MAX_VALUE;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");

				for (int j = 0; j < N; j++) {

					int temp = Integer.parseInt(st.nextToken());
					map[i][j] = temp;

				}

			}

			st = new StringTokenizer(br.readLine(), " ");

			int startY = Integer.parseInt(st.nextToken());
			int startX = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine(), " ");

			endY = Integer.parseInt(st.nextToken());
			endX = Integer.parseInt(st.nextToken());

			bfs(startX, startY);

			if (ans == Integer.MAX_VALUE) {
				System.out.println("#" + tc + " " + -1);

			} else {

				System.out.println("#" + tc + " " + ans);
			}

		}

	}

	static void bfs(int x, int y) {

		Queue<Node> q = new LinkedList<>();

		visited[y][x] = 0;
		
		q.add(new Node(x, y, 0));
		q.add(new Node(x, y, 1));
		q.add(new Node(x, y, 2));

		while (!q.isEmpty()) {

			Node cur = q.poll();

			// 여기서 아웃 조건 걸고
			if (cur.y == endY && cur.x == endX) {
				ans = Math.min(ans, cur.count);
			}

			for (int i = 0; i < 4; i++) {
				int nextX = cur.x + dx[i];
				int nextY = cur.y + dy[i];

				if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= N || map[nextY][nextX] == 1)
					continue;

				// 방문 안한 곳이랑  이동값이 더 작은곳으로 감 +1 한값 보다 클때만 감
				if (cur.count + 1 >= visited[nextY][nextX] || visited[nextY][nextX] == 0) {
					// 길 일때
					if (map[nextY][nextX] == 0) {
						visited[nextY][nextX] = cur.count + 1;
						// 바로 갈수도 있고 2초를 기다릴 수도 있음
						q.add(new Node(nextX, nextY, cur.count + 1));
						q.add(new Node(nextX, nextY, cur.count + 2));
						q.add(new Node(nextX, nextY, cur.count + 3));
					}

					/*
					 * 3으로 나머지가 0,과 1이면 소용돌이 있음 3으로 나눈 나머지가 2이면 소용돌이 없음.
					 */

					else if (map[nextY][nextX] == 2 && cur.count % 3 == 2) {

						visited[nextY][nextX] = cur.count + 1;
						//// 바로 갈수도 있고 2초를 기다릴 수도 있음
						q.add(new Node(nextX, nextY, cur.count + 1));
						q.add(new Node(nextX, nextY, cur.count + 2));
						q.add(new Node(nextX, nextY, cur.count + 3));

					}
				}

			}

		}

	}

	static class Node {

		int x, y, count;

		Node(int x, int y, int count) {
			this.x = x;
			this.y = y;
			this.count = count;
		}

	}
}
