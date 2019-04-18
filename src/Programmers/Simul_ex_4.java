package Programmers;

import java.util.ArrayList;

// Ä«Æê

public class Simul_ex_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int brown = 10;
		int red = 2;

		System.out.println(solution(brown, red));
	}

	static int[] solution(int brown, int red) {

		ArrayList<Integer> ans = new ArrayList<>();

		int sum = brown + red;
		int limit = (int) Math.sqrt(sum);
		for (int i = 3; i <= limit; i++) {

			if (sum % i == 0) {

				int temp = sum / i;
				if ((temp - 2) * (i - 2) == red) {
					ans.add(temp);
					ans.add(i);
					break;
				}

			}

		}

		int[] a = new int[ans.size()];

		for (int i = 0; i < ans.size(); i++) {
			a[i] = ans.get(i);
		}

		return a;
	}

}
