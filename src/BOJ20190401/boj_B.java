package BOJ20190401;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_B {
	static int N, M;
	static int[][] map;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static boolean[][] visited;
	static ArrayList<Node> ZERO = new ArrayList<>();
	static ArrayList<Node> VIRUS = new ArrayList<>();
	static int ans = 0;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		ans = 0;
		map = new int[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				int temp = Integer.parseInt(st.nextToken());
				map[i][j] = temp;
				if (temp == 0) {
					ZERO.add(new Node(j, i));
				} else if (temp == 2) {
					VIRUS.add(new Node(j, i));
				}
			}
		}

		func(0, 0);

		System.out.println(ans);

	}

	static void func(int idx, int count) {

		if (count == 3) {
			spread();
			return;
		}

		if (idx == ZERO.size()) {
			return;
		}

		// 벽을 세운다
		map[ZERO.get(idx).y][ZERO.get(idx).x] = 1;
		func(idx + 1, count + 1);
		map[ZERO.get(idx).y][ZERO.get(idx).x] = 0;
		func(idx + 1, count);

	}

	static void spread() {

//		// 바이러스를 퍼트린다.		
		boolean[][] visited = new boolean[N][M];
		int[][] dup = new int[N][M];
		
		
		// 복사
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				dup[i][j] = map[i][j];
			}
		}

		Queue<Node> q = new LinkedList<>();
		//바이러스 추가
		for (int i = 0; i < VIRUS.size(); i++) {
			q.add(new Node(VIRUS.get(i).x, VIRUS.get(i).y));
			visited[VIRUS.get(i).y][VIRUS.get(i).x] = true;
		}

		while (!q.isEmpty()) {

			Node cur = q.poll();
			visited[cur.y][cur.x] = true;

			for (int i = 0; i < 4; i++) {
				int nextX = cur.x + dx[i];
				int nextY = cur.y + dy[i];

				if (nextX >= M || nextY >= N || nextX < 0 || nextY < 0 || visited[nextY][nextX]
						|| dup[nextY][nextX] == 1)
					continue;

				// 바이러스로 바꾸어줌
				dup[nextY][nextX] = 2;
				q.add(new Node(nextX, nextY));
			}

		}

		check(dup);
		
		return;
	}

	static void check(int[][] dup) {
		
		int result = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (dup[i][j] == 0) {
					result += 1;
				}
			}
		}
		ans = Math.max(ans, result);

	}
	
	static class Node {
		int x, y;

		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
