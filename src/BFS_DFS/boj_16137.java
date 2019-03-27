package BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_16137 {

	static int N, M;
	static int[][] map;
	static boolean[][] visited;
	static ArrayList<Node> list;
	static int ans;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		ans = Integer.MAX_VALUE;

		list = new ArrayList<>();
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {

				int temp = Integer.parseInt(st.nextToken());
				map[i][j] = temp;
				if (temp == 0) {
					list.add(new Node(j, i, 0));
				}

			}

		}
		visited = new boolean[N][N];

		if (list.size() == 0) {
			bfs(0, 0);
//			for (int j = 0; j < N; j++) {
//				System.out.println(Arrays.toString(visited[j]));
//			}
		} else {
			for (int i = 0; i < list.size(); i++) {

				Node cur = list.get(i);

				// 교차하는 곳 검색
				if (check(cur.x, cur.y)) {

					visited = new boolean[N][N];
					// 오작교 놓음
					map[cur.y][cur.x] = M;
					bfs(cur.x, cur.y);

//					for (int j = 0; j < N; j++) {
//						System.out.println(Arrays.toString(visited[j]));
//					}

					// 백트래킹
					map[cur.y][cur.x] = 0;

				}

			}
		}
		System.out.println(ans);

	}

	static void bfs(int x, int y) {

		Queue<Node> q = new LinkedList<>();
		q.add(new Node(0, 0, 0));
		visited[0][0] = true;

		while (!q.isEmpty()) {

			Node cur = q.poll();

			if (cur.x == N - 1 && cur.y == N - 1) {
				ans = Math.min(ans, cur.val);
			}

			for (int i = 0; i < 4; i++) {

				int nextX = cur.x + dx[i];
				int nextY = cur.y + dy[i];

				if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= N || map[nextY][nextX] == 0
						|| visited[nextY][nextX])
					continue;

				
				// 오작교 이동, 2번 중복 안됨
				if (map[cur.y][cur.x] == 1 && map[nextY][nextX] > 0 && ((cur.val + 1) % map[nextY][nextX] == 0)) {
					visited[nextY][nextX] = true;
					q.add(new Node(nextX, nextY, cur.val + 1));
				}

				// 앞으로 가
				else if (map[nextY][nextX] == 1) {
					visited[nextY][nextX] = true;
					q.add(new Node(nextX, nextY, cur.val + 1));
				}
				
				
				// 대기해
				else if(map[nextY][nextX] > 0 && ((cur.val + 1) % map[nextY][nextX] != 0)){
					q.add(new Node(cur.x, cur.y, cur.val+1));
				}

			}

			
		}

	}

	static boolean check(int x, int y) {

		boolean garo = false;
		boolean sero = false;

		for (int i = 0; i < 2; i++) {
			int nextX = x + dx[i];

			if (nextX < 0 || nextX >= N)
				continue;

			if (map[y][nextX] == 0) {
				garo = true;
			}

		}

		for (int i = 2; i < 4; i++) {
			int nextY = y + dy[i];

			if (nextY < 0 || nextY >= N)
				continue;

			if (map[nextY][x] == 0) {
				sero = true;
			}
		}

		if (sero && garo) {
			return false;
		} else {
			return true;
		}
	}

	static class Node {

		int x, y, val;

		Node(int x, int y, int val) {
			this.val = val;
			this.x = x;
			this.y = y;

		}

	}

}
