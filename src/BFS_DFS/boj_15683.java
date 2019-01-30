package BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_15683 {

	static int N, M, ans = 0, ANS = Integer.MAX_VALUE;
	static int[][] map;
//	static boolean[][] visited;
	static ArrayList<Pivot> list = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
//		visited = new boolean[N][M];

//		ans = N * M;

//		System.out.println(ans);
		for (int i = 0; i < N; i++) {

			st = new StringTokenizer(br.readLine(), " ");

			for (int j = 0; j < M; j++) {

				int temp = Integer.parseInt(st.nextToken());
				map[i][j] = temp;
				if (temp > 0 && temp < 6) {
					list.add(new Pivot(i, j, temp));
//					ans -= 1;
				} else if (temp == 6) {
//					ans -= 1;
				}
			}

		}

		// Check True Camera 5
		for (int i = 0; i < list.size(); i++) {

			if (list.get(i).cameraNum == 5) {

				ans += 1;

				int curX = list.get(i).x;
				int curY = list.get(i).y;

				// x축 변환
				for (int j = 0; j < M; j++) {
					if (map[curY][j] == 6) {
						break;
					} else if (map[curY][j] == 0) {
						map[curY][j] = 9;
//						ans -= 1;
					}
				}

				// y축 변환
				for (int j = 0; j < N; j++) {
					if (map[j][curX] == 6) {
						break;
					} else if (map[j][curX] == 0) {
						map[j][curX] = 9;
//						ans -= 1;
					}
				}

			}

		}

		int temp = 0;

		for (int i = 0; i < N; i++) {

			for (int j = 0; j < M; j++) {

				if (map[i][j] == 0) {
					temp += 1;
				}
			}

		}

		ANS = Math.min(ANS, temp);

		dfs(0, map);

		System.out.println(ANS);
	}

	static void dfs(int index, int[][] dupMap) {

		int[][] visited = new int[N][M];

		if (index == (list.size() - ans)) {
			int temp = 0;

			for (int i = 0; i < N; i++) {

				for (int j = 0; j < M; j++) {

					if (dupMap[i][j] == 0) {
						temp += 1;
					}
				}

			}

			ANS = Math.min(ANS, temp);

		}

		else {

			Pivot p = list.get(index);
			int cNum = p.cameraNum;
			int cX = p.x;
			int cY = p.y;

//			System.out.println(cNum);

			if (cNum == 1) {

				for (int k = 0; k < 4; k++) {

					for (int i = 0; i < N; i++) {
						visited[i] = Arrays.copyOf(dupMap[i], M);
					}
					detect(visited, cY, cX, k);
					dfs(index + 1, visited);
				}

			} else if (cNum == 2) {

				for (int k = 0; k < 2; k++) {

					for (int i = 0; i < N; i++) {
						visited[i] = Arrays.copyOf(dupMap[i], M);
					}

					detect(visited, cY, cX, k);
					detect(visited, cY, cX, k + 2);
					dfs(index + 1, visited);
				}

			} else if (cNum == 3) {

				for (int k = 0; k < 4; k++) {

					for (int i = 0; i < N; i++) {
						visited[i] = Arrays.copyOf(dupMap[i], M);
					}

					detect(visited, cY, cX, k);
					detect(visited, cY, cX, (k + 1) % 4);
					dfs(index + 1, visited);
				}

			} else if (cNum == 4) {

				for (int k = 0; k < 4; k++) {

					for (int i = 0; i < N; i++) {
						visited[i] = Arrays.copyOf(dupMap[i], M);
					}

					detect(visited, cY, cX, k);
					detect(visited, cY, cX, (k + 1) % 4);
					detect(visited, cY, cX, (k + 2) % 4);

					dfs(index + 1, visited);
				}

			}

		}

	}

	static void detect(int[][] visited, int y, int x, int direction) {

		switch (direction) {

		case 0:
			for (int k = x; k >= 0; k--) {
				if (map[y][k] == 6) {
					break;
				}
				visited[y][k] = 9;
			}

			break;
		case 1:

			for (int k = y; k >= 0; k--) {
				if (map[k][x] == 6) {
					break;
				}
				visited[k][x] = 9;
			}

			break;
		case 2:
			for (int k = x; k < M; k++) {
				if (map[y][k] == 6) {
					break;
				}
				visited[y][k] = 9;
			}
			break;

		case 3:

			for (int k = y; k < N; k++) {
				if (map[k][x] == 6) {
					break;
				}
				visited[k][x] = 9;
			}

			break;

		}

	}

	static class Pivot {
		int x, y, cameraNum;

		Pivot(int y, int x, int cameraNum) {
			this.x = x;
			this.y = y;
			this.cameraNum = cameraNum;
		}
	}
}
