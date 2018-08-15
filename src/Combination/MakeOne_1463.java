package Combination;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MakeOne_1463 {

	public static void main(String... args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[] min = new int[1000001];
		min[1] = 0;
		for (int i = 2; i < N + 1; i++) {
			min[i] = min[i - 1] + 1;
			if (i % 2 == 0 && min[i / 2] + 1 < min[i]) {
				min[i] = min[i / 2] + 1;
			}
			if (i % 3 == 0 && min[i / 3] + 1 < min[i]) {
				min[i] = min[i / 3] + 1;
			}

		}
		System.out.println(min[N]);
	}

}
