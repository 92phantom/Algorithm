package Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_16985 {

	// 5개의 판은 모두 회전이 가능하다.
	// 0 : 들어갈 수 없는 칸
	// 1 : 들어갈 수 있는 칸
	static int[][][][] map = new int[4][5][5][5];
	static int[][][] mazeMap = new int[5][5][5];

	static int aaaaa = 0;

	static boolean[] buildUp;
	static ArrayList<Integer> list;
	static boolean[][][] visited;
	static int[] dx = { 0, 0, -1, 1, 0, 0 };
	static int[] dy = { -1, 1, 0, 0, 0, 0 };
	static int[] dz = { 0, 0, 0, 0, 1, -1 };

	static int[] rotateMap;

	static int ans;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		buildUp = new boolean[5];
		list = new ArrayList<>();
		visited = new boolean[5][5][5];
		ans = Integer.MAX_VALUE;
		rotateMap = new int[5];

		for (int i = 0; i < 5; i++) {

			for (int j = 0; j < 5; j++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int k = 0; k < 5; k++) {
					map[0][i][j][k] = Integer.parseInt(st.nextToken());
				}
			}

			// 90
			for (int j = 0; j < 5; j++) {
				for (int k = 0; k < 5; k++) {
					map[1][i][j][k] = map[0][i][4 - k][j];
				}
			}

			// 180
			for (int j = 0; j < 5; j++) {
				for (int k = 0; k < 5; k++) {
					map[2][i][j][k] = map[1][i][4 - k][j];
				}
			}

			// 270
			for (int j = 0; j < 5; j++) {
				for (int k = 0; k < 5; k++) {
					map[3][i][j][k] = map[2][i][4 - k][j];
				}
			}

		}

//		debugMapPrint2();

		// 모든 가능 경우의 수
		for (int i = 0; i < 5; i++) {
			list.add(i);
			build(i);
		}

		if (ans == Integer.MAX_VALUE) {
			System.out.println("-1");
		} else {
			System.out.println(ans);
		}

	}

	static void debugMapPrint2() {
		System.out.println("==");
		for (int a = 0; a < 4; a++) {
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 5; j++) {
					for (int k = 0; k < 5; k++) {
						System.out.print(map[a][i][j][k] + " ");
					}
					System.out.println();

				}
			}
			System.out.println("--");
		}
	}

	// 판 쌓는 모든 경우의 수
	static void build(int idx) {

		if (list.size() == 5) {
//			aaaaa += 1;
//			System.out.println(list);
//			if (aaaaa < 3) {
			rotate();
//			}
		}

		// 1 - 5까지
		// 모든 경우를 쌓아햐함
		buildUp[idx] = true;

		for (int i = 0; i < 5; i++) {
			if (!buildUp[i]) {
				list.add(i);
				build(i);
			}
		}
		list.remove(list.size() - 1);
		buildUp[idx] = false;
	}

	// 경로 계산하자
	static void calRoute() {

		// 시작점과 끝점이 갈수 없는 곳이면 바로 OUT
		if (mazeMap[0][0][0] == 0 || mazeMap[4][4][4] == 0) {
			return;
		}

		Queue<Node> q = new LinkedList<>();

		q.add(new Node(0, 0, 0, 0));
		visited[0][0][0] = true;

		while (!q.isEmpty()) {

			Node cur = q.poll();

			if (cur.count >= ans) {
				return;
			}

			for (int i = 0; i < 6; i++) {

				int nextX = cur.x + dx[i];
				int nextY = cur.y + dy[i];
				int nextZ = cur.z + dz[i];

				if (nextX < 0 || nextY < 0 || nextZ < 0 || nextX >= 5 || nextY >= 5 || nextZ >= 5
						|| mazeMap[nextX][nextY][nextZ] == 0) {
					continue;
				}

				if (nextX == 4 && nextY == 4 && nextZ == 4) {
					ans = Math.min(ans, cur.count + 1);
					return;
				}

				if (!visited[nextX][nextY][nextZ]) {
					visited[nextX][nextY][nextZ] = true;
					q.add(new Node(nextX, nextY, nextZ, cur.count + 1));
				}

			}

		}

	}

	static void rotate() {

		
		for (int temp = 0; temp < 1024; temp++) {

			int brute = temp;

			for (int i = 0; i < 5; i++) {

				int dir = brute % 4;
				brute /= 4;

				for (int j = 0; j < 5; j++) {
					for (int k = 0; k < 5; k++) {

						mazeMap[i][j][k] = map[dir][list.get(i)][j][k];

					}
				}

			}

//			debugMapPrint();
			visited = new boolean[5][5][5];
			calRoute();

		}

//		for (int temp = 0; temp < 1024; temp++) {
//
//			int brute = temp;
//
//			for (int i = 0; i < 5; i++) {
//				int dir = brute % 4;
//				brute /= 4;
//				for (int j = 0; j < 5; j++) {
//					for (int k = 0; k < 5; k++) {
//						
//						
//						mazeMap[i][j][k] = map[dir][list.get(i)][j][k];
//					}
//				}
//
//				debugMapPrint();
//
//				visited = new boolean[5][5][5];
//				calRoute();
//			}
//
//		}

	}

	static void debugMapPrint() {
		System.out.println("==");
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				for (int k = 0; k < 5; k++) {
					System.out.print(mazeMap[i][j][k] + " ");
				}
				System.out.println();

			}
		}
	}

	static class Node {

		int x, y, z, count;

		Node(int x, int y, int z, int count) {
			this.x = x;
			this.y = y;
			this.z = z;
			this.count = count;
		}

	}

}
