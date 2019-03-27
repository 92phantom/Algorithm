package SamsungExpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class swea_2117 {

	static int T;
	static int ans;
	static int N, VALUE;
	static int[][] map;
	static boolean[][] visited;

	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {

			ans = Integer.MIN_VALUE;

			st = new StringTokenizer(br.readLine(), " ");

			N = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			visited = new boolean[N][N];

			VALUE = Integer.parseInt(st.nextToken());

			int temp = 0;

			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine(), " ");

				for (int k = 0; k < N; k++) {

					int input = Integer.parseInt(st.nextToken());
					map[j][k] = input;
					if (input == 1) {
						temp += 1;
					}
				}
			}

			if (temp == N * N) {
				ans = N * N;
				System.out.println("#" + (i + 1) + " " + ans);
			} else {
				for (int j = 0; j < N; j++) {

					for (int k = 0; k < N; k++) {

						for (int z = 1; z <= N; z++) {
							visited = new boolean[N][N];

							bfs(j, k, z);
						}

					}

				}

				System.out.println("#" + (i + 1) + " " + ans);
			}
		}
	}

	static void bfs(int x, int y, int range) {

		Queue<Node> q = new LinkedList<>();
		ArrayList<Integer> list = new ArrayList<>();
		q.add(new Node(x, y, 1));

		int maxRange = range;

		visited[y][x] = true;

		if (map[y][x] == 1) {
			list.add(0);
		}

		while (!q.isEmpty()) {

			Node node = q.poll();
			int currentRange = node.range;

			for (int i = 0; i < 4; i++) {

				int nextX = node.x + dx[i];
				int nextY = node.y + dy[i];

				if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= N || visited[nextY][nextX])
					continue;

				if (currentRange == maxRange)
					continue;

				if (map[nextY][nextX] == 1) {
					list.add(0);
				}
				if (!visited[nextY][nextX]) {

					visited[nextY][nextX] = true;
					q.add(new Node(nextX, nextY, currentRange + 1));

				}

			}

		}

		int operFee = maxRange * maxRange + ((maxRange - 1) * (maxRange - 1));
		int profit = list.size() * VALUE;

//		ans = Math.max(ans, profit-operFee);
//		
		if (profit - operFee >= 0) {

			int coverHOME = list.size();

			ans = Math.max(ans, coverHOME);

		}
//		System.out.println("운영비용" + operFee);
//		System.out.println("이익" + profit);
//		System.out.println("전체이익" + (profit - operFee));
//		System.out.println("========");
	}

	static class Node {
		int x, y, range;

		Node(int x, int y, int range) {
			this.x = x;
			this.y = y;
			this.range = range;
		}
	}

}
