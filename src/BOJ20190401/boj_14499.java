package BOJ20190401;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_14499 {

	static int N; // ����
	static int M; // ����
	static int x, y; // �ֻ��� ��ǥ
	static int K; // ����� ����

	static int[][] map;

	static int[] DICE = { 1, 2, 3, 4, 5, 6 };

	// IDX 1 : ����
	// IDX 2 : ������ ����
	// IDX 3 : ������ ����
	// IDX 4 : ������ ����
	// IDX 5 : ������ ����
	// IDX 6 : �ٴ� ��

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

		// ���� ����
		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < K; i++) {

			int dir = Integer.parseInt(st.nextToken()) - 1;

			int nextX = x + dx[dir];
			int nextY = y + dy[dir];

			if (nextX < 0 || nextY < 0 || nextX >= M || nextY >= N)
				continue;
			
			func(dir);
			
			// �ٴ� ��
			if(map[nextY][nextX] == 0) {
				map[nextY][nextX] = DICE[6];
			}
			
			

		}

	}

	static void func(int dir) {

		// ����
		if (dir == 0) {
			int temp = DICE[5];

			x += 1;

			DICE[5] = map[y][x];

		}

		// ����
		else if (dir == 1) {
			x -= 1;

			int temp = DICE[5];

			DICE[5] = map[y][x];

		}

		// �ϦU
		else if (dir == 2) {
			y -= 1;
			int temp = DICE[5];
			DICE[5] = map[y][x];

		}
		// ����
		else if (dir == 3) {
			y += 1;
			int temp = DICE[5];
			DICE[5] = map[y][x];

		}

		System.out.println(DICE[0]);

	}

}
