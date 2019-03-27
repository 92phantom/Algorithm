package Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_16988 {

	static int N, M;
	static int[][] map;
	static ArrayList<Node> list = new ArrayList<>();
	static ArrayList<Node> YOURS = new ArrayList<>();
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static int ans;
	static boolean[] visited;
	static int color = 10;

	static ArrayList<Node>[] colorMap = new ArrayList[1000];

	// 그룹으로 나누어 풀어야함 !
	// 모든 검은 돌이 하나가 아니기 떄문 -- > 다리만들기 문제랑 비슷하게 미술시간
	// 돌면서 0이 하나라도 있으면 죽지 않았다.

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		ans = 0;

		// 0 : 빈칸, 1 : 나의 돌, 2: 상대 돌
		map = new int[N][M];

		for (int i = 0; i < 1000; i++) {
			colorMap[i] = new ArrayList<>();
		}

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			for (int j = 0; j < M; j++) {
				int temp = Integer.parseInt(st.nextToken());

				if (temp == 0) {
					list.add(new Node(j, i));
				} else if (temp == 2) {
					YOURS.add(new Node(j, i));
				}
				map[i][j] = temp;
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 2) {
					func2(j, i);
				}
			}
		}
//
//		for (int i = 0; i < N; i++) {
//			System.out.println(Arrays.toString(map[i]));
//		}

		visited = new boolean[list.size() + 1];
//
//		func(1, 1);
		for (int i = 0; i < list.size(); i++) {
			func(i, 1);
		}
//
		System.out.println(ans);

	}

	static void func2(int x, int y) {
		Queue<Node> q = new LinkedList<>();
		map[y][x] = color;
		colorMap[color].add(new Node(x, y));

		q.add(new Node(x, y));

		while (!q.isEmpty()) {
			Node a = q.poll();

			for (int i = 0; i < 4; i++) {
				int nextX = a.x + dx[i];
				int nextY = a.y + dy[i];

				if (nextX < 0 || nextY < 0 || nextY >= N || nextX >= M)
					continue;

				if (map[nextY][nextX] == 2) {
					map[nextY][nextX] = color;
					colorMap[color].add(new Node(nextX, nextY));
					q.add(new Node(nextX, nextY));
				}
			}
		}

		color += 1;
	}

	static void func(int idx, int count) {

		if (count == 2) {
			check();
			return;
		}

		visited[idx] = true;
		Node cur = list.get(idx);
		map[cur.y][cur.x] = 1;

		for (int i = 0; i < list.size(); i++) {

			if (!visited[i]) {

				visited[i] = true;
				Node next = list.get(i);
				map[next.y][next.x] = 1;

				func(i, count + 1);

				visited[i] = false;
				map[next.y][next.x] = 0;

			}

		}

		visited[idx] = false;
		map[cur.y][cur.x] = 0;

	}

	// 몇개 죽었는지 체크
	static void check() {

		Queue<Node> q = new LinkedList<>();
		int kill = 0;

		for (int i = 10; i <= color; i++) {
			q.clear();
			
			for (int j = 0; j < colorMap[i].size(); j++) {
				q.add(colorMap[i].get(j));
			}

			boolean notDie = false;

			while (!q.isEmpty()) {

				Node current = q.poll();

				for (int k = 0; k < 4; k++) {

					int nextX = current.x + dx[k];
					int nextY = current.y + dy[k];

					if (nextX >= 0 && nextY >= 0 && nextY < N && nextX < M) {

						if (map[nextY][nextX] == 0) {
							notDie = true;
						}
					}

				}
				
			}
//			System.out.println("--");
//			System.out.println("flag:::::::;"+notDie);
			if (!notDie) {
				

//				for(int z=0; z<N; z++) {
//					System.out.println(Arrays.toString(map[z]));
//				}
				
//				System.out.println("언제지?");
				kill += colorMap[i].size();
			}
		}

		ans = Math.max(kill, ans);

	}

	static class Node {

		int x;
		int y;

		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}
}
