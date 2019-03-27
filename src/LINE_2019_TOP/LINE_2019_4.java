package LINE_2019_TOP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class LINE_2019_4 {

	static int N;
	static int ans;
	static ArrayList<Integer> list;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		list = new ArrayList<>();

		int idx = 0;
		int input = 0;
		for (int i = 0; i < N; i++) {
			input = Integer.parseInt(br.readLine());
			list.add(input);
		}

		boolean flag = false;

		while (true) {
			for (int i = idx + 1; i < N; i++) {

				if (list.get(i) >= list.get(idx)) {
					ans = Math.max(ans, Math.abs(i - idx));
					idx = i;
				}

				if (i == N - 1) {
					flag = true;
				}

			}

			if (flag) {
				break;
			}
		}

		System.out.println(ans);

	}

}
