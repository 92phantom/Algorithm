package SamsungExpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_14888 {

	static int N, R;
	static int[] map;
	static int[] res;
	static long max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		R = N - 1;
		res = new int[12];

		map = new int[N];
		int[] formualar = new int[12];

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {

			map[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine(), " ");

		int index = 0;

		for (int i = 0; i < 4; i++) {
			int temp = Integer.parseInt(st.nextToken());
			
			for (int j = index; j < index+temp; j++) {
				formualar[j] = i;
			}
			index+=temp;
		}
		doPermutation(formualar, 0);

		System.out.println(max);
		System.out.println(min);

	}

	static void doPermutation(int[] formular, int startPoint) {

		if (startPoint == R) {
			
			int result = map[0];

			for (int i = 1; i < N; i++) {

				int tempVal = map[i];

				if (formular[i - 1] == 0) {
					result += tempVal;
				} else if (formular[i - 1] == 2) {
					result *= tempVal;
				} else if (formular[i - 1] == 1) {
					result -= tempVal;
				} else if (formular[i - 1] == 3) {
					result /= tempVal;
				}

			}
			max = Math.max(max, result);
			min = Math.min(min, result);

			return;
		}

		for (int i = startPoint; i < R; i++) {

			swap(formular, startPoint, i);
			res[startPoint] = formular[startPoint];
			doPermutation(formular, startPoint + 1);
			swap(formular, startPoint, i);

		}

	}

	static void swap(int[] arr, int o1, int o2) {

		int temp = arr[o1];
		arr[o1] = arr[o2];
		arr[o2] = temp;

	}
}