package BOJ20190401;

import java.io.*;
import java.util.StringTokenizer;

public class boj_14890 {
	static int N, L, result = 0;
	static int[][] map;
	static int[] slop;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < N; i++) {
			checkBuild(i, true);
			checkBuild(i, false);
		}

		System.out.println(result);
	}

	private static void checkBuild(int index, boolean vertical) {
		slop = new int[N];

		if (vertical) {

			for (int i = 0; i < N - 1; i++) {

				if (map[i][index] != map[i + 1][index]) {

					int diff = map[i][index] - map[i + 1][index];

					if (diff != -1 && diff != 1)
						return;

					// Condition 1) Over
					if (diff == -1) {

						for (int j = 0; j < L; j++) {
							if (i - j < 0 || slop[i - j] == 1)
								return;

							if (map[i][index] == map[i - j][index]) {
								slop[i - j] = 1;
							} else
								return;
						}
					}

					// Condition 2) Under
					else {

						for (int j = 1; j <= L; j++) {
							if (i + j >= N || slop[i + j] == 1)
								return;

							if (map[i][index] - 1 == map[i + j][index]) {
								slop[i + j] = 1;
							} else
								return;
						}

					}

				}

			}
			result++;

		} else {
			for (int i = 0; i < N - 1; i++) {
				if (map[index][i] != map[index][i + 1]) {
					int diff = map[index][i] - map[index][i + 1];
					if (diff != -1 && diff != 1)
						return;
					if (diff == -1) {

						for (int j = 0; j < L; j++) {

							if (i - j < 0 || slop[i - j] == 1) {

								return;

							}

							if (map[index][i] == map[index][i - j]) {

								slop[i - j] = 1;
							} else
								return;
						}
					} else {

						for (int j = 1; j <= L; j++) {
							if (i + j >= N || slop[i + j] == 1)
								return;

							if (map[index][i] - 1 == map[index][i + j])
								slop[i + j] = 1;
							else
								return;
						}
					}
				}
			}
			result++;
		}
	}
}
