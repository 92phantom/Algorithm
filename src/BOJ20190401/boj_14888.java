package BOJ20190401;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj_14888 {

	static int N;
	static ArrayList<Integer> list = new ArrayList<>();
	static int minVal = Integer.MAX_VALUE;
	static int maxVal = Integer.MIN_VALUE;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine()); // 수의 개수

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < N; i++) {
			int temp = Integer.parseInt(st.nextToken());
			list.add(temp);
		}

		int plus, minus, mul, div;

		st = new StringTokenizer(br.readLine(), " ");
		plus = Integer.parseInt(st.nextToken());
		minus = Integer.parseInt(st.nextToken());
		mul = Integer.parseInt(st.nextToken());
		div = Integer.parseInt(st.nextToken());

		func(1, plus, minus, mul, div, list.get(0));

		System.out.println(maxVal);
		System.out.println(minVal);
	}

	static void func(int idx, int plus, int minus, int mul, int div, int result) {

		if (idx == list.size()) {
			minVal = Math.min(minVal, result);
			maxVal = Math.max(maxVal, result);
			return;
		} else {
			if (plus > 0) {
				func(idx + 1, plus - 1, minus, mul, div, result + list.get(idx));
			}
			if (minus > 0) {
				func(idx + 1, plus, minus - 1, mul, div, result - list.get(idx));
			}
			if (mul > 0) {
				func(idx + 1, plus, minus, mul - 1, div, result * list.get(idx));
			}
			if (div > 0) {
				func(idx + 1, plus, minus, mul, div - 1, result / list.get(idx));
			}
		}
	}

}
