package SamsungExpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 수영 대회
 * 시작 시간: 14:10
 */

public class swea_4192 {

	static int T;
	static int N;
	static int ans;
	static int[][] map;
	static int endY, endX;
	static boolean[][] visited;
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {

			N = Integer.parseInt(br.readLine());
			map = new int[15][15];
			visited = new boolean[15][15];
			ans = Integer.MAX_VALUE;
			for (int i = 0; i < N; i++) {

				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}

			}

			st = new StringTokenizer(br.readLine(), " ");
			int startY = Integer.parseInt(st.nextToken());
			int startX = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine(), " ");
			endY = Integer.parseInt(st.nextToken());
			endX = Integer.parseInt(st.nextToken());

			bfs(startX, startY);

			if(ans== Integer.MAX_VALUE) {

				System.out.println("#" + tc + " " + -1);	
			}
			
			else  {

				System.out.println("#" + tc + " " + ans);	
			}
		}

	}

	static void bfs(int x, int y) {

		Queue<Node> q = new LinkedList<>();
		q.add(new Node(x, y, 0));
		visited[y][x] = true;

		while (!q.isEmpty()) {

			Node cur = q.poll();
			
			if(cur.count >= ans) {
				continue;
			}
			
			if (cur.y == endY && cur.x == endX) {
				ans = Math.min(cur.count, ans);
			}

			for (int i = 0; i < 4; i++) {

				int nextX = cur.x + dx[i];
				int nextY = cur.y + dy[i];

				if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= N || visited[nextY][nextX] || map[nextY][nextX] ==1)
					continue;

				if (!visited[nextY][nextX] && map[nextY][nextX] == 0) {
					visited[nextY][nextX] = true;
					q.add(new Node(nextX, nextY, cur.count+1));

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
