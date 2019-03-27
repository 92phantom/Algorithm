package Programmers;

import java.util.Arrays;

// 보행자 천국
public class pro_heaven {

	static int MOD = 20170805;

	public static void main(String[] args) {
		// TODO Auto-generated metRIGHTod stub
		int m = 3;
		int n = 3;

//		int n = 6;
//		int[][] cityMap2 = { { 0, 2, 0, 0, 0, 2 }, { 0, 0, 2, 0, 1, 0 }, { 1, 0, 0, 2, 2, 0 } };
		int[][] cityMap2 = { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } };

		System.out.println(solution(m, n, cityMap2));

	}

	static int solution(int m, int n, int[][] cityMap) {
		int answer = 0;

		int[][] DOWN = new int[501][501]; // 아래로 갈수 있는 경우의 수
		int[][] RIGHT = new int[501][501]; // 오른쪽으로 갈수 있는 경우의 수

		DOWN[1][1] = RIGHT[1][1] = 1;

		for (int i = 1; i <= m; i++) {

			for (int j = 1; j <= n; j++) {

				if (cityMap[i - 1][j - 1] == 0) {

					DOWN[i][j] += (DOWN[i - 1][j] + RIGHT[i][j - 1]) % MOD;
					RIGHT[i][j] += (DOWN[i - 1][j] + RIGHT[i][j - 1]) % MOD;

				} else if (cityMap[i - 1][j - 1] == 1) {

					DOWN[i][j] = 0;
					RIGHT[i][j] = 0;

				} else {

					DOWN[i][j] = DOWN[i - 1][j];
					RIGHT[i][j] = RIGHT[i][j - 1];

				}

			}

		}

		answer = RIGHT[m][n] % MOD;
		return answer;
	}

}
