package Combination;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1941_ {

	static char[][] map = new char[5][5];
	static char[] arr = new char[25];
	public static void main(String... args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=null;

		String temp= null;

		for (int i = 0; i < 25; i++) {
			if (i % 5 == 0){
				st = new StringTokenizer(br.readLine(), "");
				temp = st.nextToken();
			}
			map[i/5][i%5] = temp.charAt(i%5);
			arr[i] = temp.charAt(i%5);
		}

		
//		char[] arr = { 'A', 'B', 'C', 'D', 'E' };
		int[] res = new int[7];
//
		doCombination(arr, 25, 7, 0, 0, res);

	}

	static void doCombination(char[] arr, int N, int R, int index, int target, int[] res) {

		if (R == 0) {
			for (int i = 0; i < index; i++) {
				System.out.print(arr[res[i]] + " ");
			}
			System.out.println();
		} else if (target == N) {
			return;
		} else {

			res[index] = target;

			doCombination(arr, N, R - 1, index + 1, target + 1, res);
			doCombination(arr, N, R, index, target + 1, res);

		}

	}
}
