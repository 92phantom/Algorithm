package SamsungExpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_4008 {

	static int T, N;
	static int[] map;
	static int[] opMap;
	static long min = Integer.MAX_VALUE;
	static long max = Integer.MIN_VALUE;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {

			N = Integer.parseInt(br.readLine());
			min = Integer.MAX_VALUE;
			max = Integer.MIN_VALUE;
			map = new int[N];
			opMap = new int[4];

			// 연산자 입력받기
			st = new StringTokenizer(br.readLine(), " ");

			int plu = Integer.parseInt(st.nextToken());
			int minus = Integer.parseInt(st.nextToken());
			int mul = Integer.parseInt(st.nextToken());
			int div = Integer.parseInt(st.nextToken());

//			for (int j = 0; j < 4; j++) {
//				opMap[j] = Integer.parseInt(st.nextToken());
//			}

			// 숫자입력받기
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[j] = Integer.parseInt(st.nextToken());
			}

			func(plu, minus, mul, div, 1, map[0]);
//			dfs(1, map[0]);

			System.out.println("#" + (i + 1) + " " + (max - min));

		}

	}

	static void func(int plu, int minus, int mul, int div, int idx, int result) {

		if (idx == N) {
			max = Math.max(result, max);
			min = Math.min(min, result);
			return;
		}

		if (plu != 0) {
			func(plu - 1, minus, mul, div, idx + 1, result + map[idx]);
		}
		if (minus != 0) {
			func(plu, minus - 1, mul, div, idx + 1, result - map[idx]);
		}
		if (mul != 0) {
			func(plu, minus, mul - 1, div, idx + 1, result * map[idx]);
		}
		if (div != 0) {
			func(plu, minus, mul, div - 1, idx + 1, result / map[idx]);
		}

	}

	static void dfs(int idx, int result) {

		if (idx == N) {
			max = Math.max(result, max);
			min = Math.min(min, result);
			return;
		}

		else {

			if (opMap[0] != 0) {
				opMap[0] -= 1;
				dfs(idx + 1, result + map[idx]);
				opMap[0] += 1;
			}
			if (opMap[1] != 0) {

				opMap[1] -= 1;
				dfs(idx + 1, result - map[idx]);
				opMap[1] += 1;
			}
			if (opMap[2] != 0) {

				opMap[2] -= 1;
				dfs(idx + 1, result * map[idx]);
				opMap[2] += 1;
			}
			if (opMap[3] != 0) {

				opMap[3] -= 1;
				dfs(idx + 1, result / map[idx]);
				opMap[3] += 1;
			}

		}

	}
}
