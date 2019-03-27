// 이분 탐색, 나무 자르기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj_2805 {

	static int N;
	static long M;
	static ArrayList<Long> list;
	static long right, left;
	static long ans;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		list = new ArrayList<>();
		right = Long.MIN_VALUE;
		left = 0;
		ans = 0;
		N = Integer.parseInt(st.nextToken());
		M = Long.parseLong(st.nextToken());

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			long temp = Long.parseLong(st.nextToken());
			list.add(temp);
			right = Math.max(temp, right);
		}

		// 적어도 M미터의 나무를 집에 가져가기 위해서
		// 절단기에 설정할 수 있는 높이의 최댓값을 구하는 프로그램을 작성하시오.

		while (left <= right) {

			long cut = (left + right) / 2;
			long temp = 0;

			for (int i = 0; i < N; i++) {
				if (cut < list.get(i)) {
					temp += list.get(i) - cut;
				}
			}

			// 클때
			if (temp >= M) {
				left = cut + 1;
			}
			// 작을때
			else if (temp < M) {
				right = cut - 1;
			}

		}

		System.out.println(right);
	}

}
