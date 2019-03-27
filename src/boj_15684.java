import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_15684 {

	static int N, M, H;
	static int[][] map;
	static boolean flag;
	static int ans = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		flag = false;
		
		map = new int[32][11];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a, b;
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());

			map[a][b] = 1;
			map[a][b + 1] = 2;

		}

		for (int i = 0; i < 5; i++) {

			if (i == 4) {
				ans = -1;
				break;
			}

			cal(1, 1, 0, i);
			if (flag) {
				break;
			}

		}

		System.out.println(ans);

	}

	static void cal(int nowI, int nowJ, int num, int count) {
		if (flag)
			return;

		if (num == count) {
			if (check()) {
				ans = num;
				flag = true;				
			}
			return;
		}

		for (int i = nowI; i <= H; i++) {

			for (int j = nowJ; j < N; j++) {

				if (map[i][j] != 1 && map[i][j] != 2 && map[i][j + 1] != 1 && map[i][j + 1] != 2) {

					map[i][j] = 1;
					map[i][j + 1] = 2;
					cal(i, nowJ + 1, num + 1, count);
					
					if (flag) {
						return;
					}
					
					map[i][j] = 0;
					map[i][j + 1] = 0;

				}

				if (j + 2 >= N) {
					nowJ = 1;
				}

			}

		}
	}

	static boolean check() {

		for (int j = 1; j < N; j++) {

			int startJ = j;
			int startI = 1;

			while (true) {

				if (startI == (H + 1)) {
					if (startJ == j)
						break;
					else
						return false;
				}

				if (map[startI][startJ] != 1 && map[startI][startJ] != 2) {

					startI += 1;
					continue;

				} else if (map[startI][startJ] == 1) {

					startI += 1;
					startJ += 1;

					continue;

				} else if (map[startI][startJ] == 2) {

					startI += 1;
					startJ -= 1;
					continue;

				}

			}

		}

		return true;
	}

}
