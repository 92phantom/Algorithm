// 이분 탐색, 랜선자르기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj_1654 {

	static int K;
	static long N;

	static ArrayList<Long> list;

	static long left, right;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		list = new ArrayList<>();

		K = Integer.parseInt(st.nextToken());
		N = Long.parseLong(st.nextToken());

		left = 0;
		right = Long.MIN_VALUE;

		for (int i = 0; i < K; i++) {
			long temp = Long.parseLong(br.readLine());
			list.add(temp);
			right = Math.max(right, temp);
		}

		while (left <= right) {

			long CUT = (left + right) / 2;

			long result = 0;

			for (int i = 0; i < list.size(); i++) {
				long input = list.get(i);

				while ((input - CUT) >= 0) {
					result += 1;
					input -= CUT;
					
					// 이거없으면 시간 초과
					if(result >= N) {
						break;
					}
					
				}

			}

			if (result >= N) {
				left = CUT + 1;
			} else if (result < N) {
				right = CUT - 1;

			}

		}

		System.out.println(right);

	}

}
