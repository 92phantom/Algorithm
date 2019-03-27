package SamsungExpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class swea_1953 {

	static int T, N, M, R, C, L, ans;
	static int[][] map;
	static boolean[][] visited;

	// 이동별 -> 서 ; 동; 남 ; 북
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {

			st = new StringTokenizer(br.readLine(), " ");
			ans = 0;
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());

			map = new int[50][50];
			visited = new boolean[50][50];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < M; j++) {
					int temp = Integer.parseInt(st.nextToken());
					map[i][j] = temp;
				}
			}

			bfs(C, R);

			System.out.println("#" + tc + " " + ans);
		}
	}

	static void bfs(int x, int y) {
		
		Queue<Node> q = new LinkedList<>();

		q.add(new Node(x, y, map[y][x]));

		visited[y][x] = true;
		ans += 1;

		while (true) {

			L -= 1;

			if (L == 0) {
				break;
			}

			int size = q.size();

			for (int j = 0; j < size; j++) {

				Node cur = q.poll();

				for (int i = 0; i < 4; i++) {

					int nextX = cur.x + dx[i];
					int nextY = cur.y + dy[i];

					if (nextX < 0 || nextY < 0 || nextX >= M || nextY >= N || visited[nextY][nextX])
						continue;

					boolean flag = false;
					int b = map[nextY][nextX];

					if (cur.val == 1) {
						if (i == 0 && (b == 1 || b == 3 || b == 4 || b == 5))
							flag = true;
						else if (i == 1 && (b == 1 || b == 3 || b == 6 || b == 7))
							flag = true;
						else if (i == 2 && (b == 1 || b == 2 || b == 4 || b == 7))
							flag = true;
						else if (i == 3 && (b == 1 || b == 2 || b == 5 || b == 6))
							flag = true;
					} else if (cur.val == 2) {
						if (i == 2 && (b == 1 || b == 2 || b == 4 || b == 7))
							flag = true;
						else if (i == 3 && (b == 1 || b == 2 || b == 5 || b == 6))
							flag = true;
					} else if (cur.val == 3) {
						if (i == 0 && (b == 1 || b == 3 || b == 4 || b == 5))
							flag = true;
						else if (i == 1 && (b == 1 || b == 3 || b == 6 || b == 7))
							flag = true;
					} else if (cur.val == 4) {
						if (i == 1 && (b == 1 || b == 3 || b == 6 || b == 7))
							flag = true;
						else if (i == 3 && (b == 1 || b == 2 || b == 5 || b == 6))
							flag = true;
					} else if (cur.val == 5) {
						if (i == 1 && (b == 1 || b == 3 || b == 6 || b == 7))
							flag = true;
						else if (i == 2 && (b == 1 || b == 2 || b == 4 || b == 7))
							flag = true;
					} else if (cur.val == 6) {
						if (i == 0 && (b == 1 || b == 3 || b == 4 || b == 5))
							flag = true;
						else if (i == 2 && (b == 1 || b == 2 || b == 4 || b == 7))
							flag = true;
					} else if (cur.val == 7) {
						if (i == 0 && (b == 1 || b == 3 || b == 4 || b == 5))
							flag = true;
						else if (i == 3 && (b == 1 || b == 2 || b == 5 || b == 6))
							flag = true;
					}

					if (flag) {
						visited[nextY][nextX] = true;
						ans += 1;
						q.add(new Node(nextX, nextY, map[nextY][nextX]));
					}
				}

			}

		}

	}

	static class Node {
		int x, y, val;

		Node(int x, int y, int val) {
			this.x = x;
			this.y = y;
			this.val = val;
		}
	}
}