package BOJ20190401;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_14499 {

	static int N; // 세로
	static int M; // 가로
	static int x, y; // 주사위 좌표
	static int K; // 명령의 개수

	static int[][] map;

	static int[] DICE = { 1, 2, 3, 4, 5, 6 };

	// IDX 1 : 윗면
	// IDX 2 : 윗면의 북쪽
	// IDX 3 : 윗면의 동쪽
	// IDX 4 : 윗면의 서쪽
	// IDX 5 : 윗면의 남쪽
	// IDX 6 : 바닥 면

	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 방향 지시
		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < K; i++) {

			int dir = Integer.parseInt(st.nextToken()) - 1;

			int nextX = x + dx[dir];
			int nextY = y + dy[dir];

			if (nextX < 0 || nextY < 0 || nextX >= M || nextY >= N)
				continue;
			
			func(dir);
			
			// 바닥 면
			if(map[nextY][nextX] == 0) {
				map[nextY][nextX] = DICE[6];
			}
			
			

		}

	}

	static void func(int dir) {

		// 동쪽
		if (dir == 0) {
			int temp = DICE[5];

			x += 1;

			DICE[5] = map[y][x];

		}

		// 서쪽
		else if (dir == 1) {
			x -= 1;

			int temp = DICE[5];

			DICE[5] = map[y][x];

		}

		// 북쪾
		else if (dir == 2) {
			y -= 1;
			int temp = DICE[5];
			DICE[5] = map[y][x];

		}
		// 남쪽
		else if (dir == 3) {
			y += 1;
			int temp = DICE[5];
			DICE[5] = map[y][x];

		}

		System.out.println(DICE[0]);

	}

}
