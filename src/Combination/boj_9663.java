package Combination;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_9663 {
	static int N, cnt;
	static int[] map;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), "");

		N = Integer.parseInt(st.nextToken());

		map = new int[N + 1];

		// map[За] = ·Д
		// map[row] = column

		for (int i = 1; i <= N; i++) {
			map[1] = i;
			recursive(1);
		}

		System.out.println(cnt);

	}

	static void recursive(int row) {

		if (row == N) {
			cnt++;
			return;
		}

		for (int i = 1; i <= N; i++) {

			int nextRow = row + 1;
			map[nextRow] = i;

			if (checkPossible(nextRow)) {
				recursive(nextRow);
			}

		}

	}

	static boolean checkPossible(int nextRow) {

		for (int i = 1; i < nextRow; i++) {
			if (nextRow == i || map[nextRow] == map[i] || Math.abs(nextRow - i) == Math.abs(map[i] - map[nextRow])) {
				return false;
			}

		}
		return true;
	}
}
