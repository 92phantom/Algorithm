package SAMSUNG_LASTDAY;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class boj_16235_Namu {

	static ArrayList<Integer>[][] NAMU = new ArrayList[11][11];
	static int[][] map = new int[11][11];
	static int[][] YANG = new int[11][11];
	static int N, M, K;

	static int[] dx = { 0, 0, -1, 1, 1, -1, -1, 1 };
	static int[] dy = { -1, 1, 0, 0, 1, -1, 1, -1 };

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken()); // 맵 사이즈
		M = Integer.parseInt(st.nextToken()); // 심은 나무 정보
		K = Integer.parseInt(st.nextToken()); // K 년 , 총 년수

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= N; j++) {
				int input = Integer.parseInt(st.nextToken());
				YANG[i][j] = input;
				map[i][j] = 5;
			}
		}

		// 나무 맵 초기화 !
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				NAMU[i][j] = new ArrayList<>();
			}
		}

		// 심은 나무 정보
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());

			NAMU[y][x].add(z);

		}

		// 자 시작하자.
		func();

	}

	static void func() {

		while (K != 0) {

			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					Collections.sort(NAMU[i][j], new Sorting());
				}
			}

			K--;
			/*
			 * 봄에는 나무가 자신의 나이만큼 양분을 먹고, 나이가 1 증가한다. 각각의 나무는 나무가 있는 1×1 크기의 칸에 있는 양분만 먹을 수
			 * 있다. 하나의 칸에 여러 개의 나무가 있다면, 나이가 어린 나무부터 양분을 먹는다. 만약, 땅에 양분이 부족해 자신의 나이만큼 양분을 먹을
			 * 수 없는 나무는 양분을 먹지 못하고 즉시 죽는다.
			 */
			ArrayList<Node> death = new ArrayList<>();
			ArrayList<Node> alive = new ArrayList<>();

			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					int size = NAMU[i][j].size();
					for (int k = 0; k < size; k++) {
						int val = NAMU[i][j].get(k).intValue();
						
						System.out.println("x"+ j);
						System.out.println("y"+ i);
						System.out.println("val"+ val);
						if (map[i][j] >= val) {
							map[i][j] -= val;
							alive.add(new Node(j, i, val + 1));
						} else {
							System.out.println("왜죽죠?" + map[i][j]);
							death.add(new Node(j, i, val));
						}
					}
				}
			}

			/*
			 * 여름에는 봄에 죽은 나무가 양분으로 변하게 된다. 각각의 죽은 나무마다 나이를 2로 나눈 값이 나무가 있던 칸에 양분으로 추가된다. 소수점
			 * 아래는 버린다.
			 */

			for (int i = 0; i < death.size(); i++) {

				int x = death.get(i).x;
				int y = death.get(i).y;
				int val = death.get(i).val / 2;

				map[y][x] += val;

			}

			/*
			 * 가을에는 나무가 번식한다. 번식하는 나무는 나이가 5의 배수이어야 하며, 인접한 8개의 칸에 나이가 1인 나무가 생긴다. 어떤 칸 (r,
			 * c)와 인접한 칸은 (r-1, c-1), (r-1, c), (r-1, c+1), (r, c-1), (r, c+1), (r+1, c-1),
			 * (r+1, c), (r+1, c+1) 이다. 상도의 땅을 벗어나는 칸에는 나무가 생기지 않는다.
			 * 
			 */

			int aliveSize = alive.size();

			for (int i = 0; i < aliveSize; i++) {
				if (alive.get(i).val % 5 == 0) {
					int x = alive.get(i).x;
					int y = alive.get(i).y;

					for (int j = 0; j < 8; j++) {
						int nextX = x + dx[i];
						int nextY = y + dy[i];

						if (check(nextX, nextY)) {
							alive.add(new Node(nextX, nextY, 1));
						}

					}
				}
			}

			/*
			 * 
			 * 겨울에는 S2D2가 땅을 돌아다니면서 땅에 양분을 추가한다. 각 칸에 추가되는 양분의 양은 A[r][c]이고, 입력으로 주어진다.
			 * 
			 */

			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {

					map[i][j] += YANG[i][j];

				}
			}

			// 나무 복붙
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					NAMU[i][j] = new ArrayList<>();
				}
			}

			for (int i = 0; i < alive.size(); i++) {
				int y = alive.get(i).y;
				int x = alive.get(i).x;
				int val = alive.get(i).val;

				NAMU[y][x].add(val);
			}

			debug();

		}

		int ans = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				ans += NAMU[i][j].size();
			}
		}

		System.out.println(ans);
	}

	static void debug() {

		System.out.println("뭐야");

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				System.out.println("x" + j + "y" + i + "값" + NAMU[i][j]);

			}
		}

	}

	static boolean check(int x, int y) {

		if (x < 0 || y < 0 || x >= N || y >= N) {
			return false;
		}

		return true;

	}

	static class Sorting implements Comparator<Integer> {
		@Override
		public int compare(Integer o1, Integer o2) {
			// TODO Auto-generated method stub

			if (o1 > o2) {
				return 1;
			} else if (o2 < o2) {
				return -1;
			} else {
				return 0;
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
