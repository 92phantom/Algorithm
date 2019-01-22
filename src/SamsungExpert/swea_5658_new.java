package SamsungExpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
public class swea_5658_new {

	static int T, N, K;
	static int BLOCK_SIZE;
	static String input;
	static ArrayList<Integer> map = new ArrayList<>();

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {

			st = new StringTokenizer(br.readLine(), " ");

			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			input = br.readLine();

			BLOCK_SIZE = N / 4;
			map = new ArrayList<>();
			
			while (true) {
				String temp = "";
				int cnt = 0;
				for (int j = 1; j <= N; j++) {

					temp += input.charAt(j - 1) + "";

					if (j % BLOCK_SIZE == 0) {
						// 16진수 10진수로 변환해서 저장
						int val = Integer.parseInt(temp, 16);
						if (map.contains(val)) {
							cnt += 1;
						} else {
							map.add(val);
						}
						temp = "";
					}

				}

				input = shiftInput(input);

				if (cnt == 4) {

					System.out.println("#" + (i + 1) + " " + printOut());
					break;
				}

			}

		}

	}

	static String printOut() {

		Collections.sort(map);
		Collections.reverse(map);
		return map.get(K - 1) + "";
	}

	static String shiftInput(String input) {

		String endLetter = input.charAt(N - 1) + "";
		String temp = input.substring(0, N - 1);

		return endLetter + temp;

	}
}
