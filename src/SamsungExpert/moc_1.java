package SamsungExpert;

import java.util.HashSet;
import java.util.Set;

public class moc_1 {

	static Set<String> list = new HashSet<>();
	static boolean ans = true;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arrA = { 7, 8, 10 };
		int[] arrB = { 10, 7, 8 };

		System.out.println(solution(arrA, arrB));

	}

	static boolean solution(int[] arrA, int[] arrB) {
//		boolean answer = true;

		if (arrA.length != arrB.length) {
			return false;
		} else {
			String arrBStr = "";
			// INPUT
			for (int i = 0; i < arrB.length; i++) {
				arrBStr += arrB[i];
			}

			makeList(arrBStr, 0);

			String arrAStr = "";
			for (int i = 0; i < arrA.length; i++) {
				arrAStr += arrA[i];
			}
			checkList(arrAStr, 0);

			return ans;
		}
	}

	static void checkList(String arrA, int cnt) {

		if (cnt == arrA.length()) {
			return;
		}

		String endLetter = arrA.charAt(arrA.length() - 1) + "";
		String origin = arrA.substring(0, arrA.length() - 1);

		if (!list.contains(endLetter + origin)) {
			ans = false;
			return;
		}

		makeList(endLetter + origin, cnt + 1);

	}

	static void makeList(String arrB, int cnt) {

		if (cnt == arrB.length()) {
			return;
		}

		String endLetter = arrB.charAt(arrB.length() - 1) + "";
		String origin = arrB.substring(0, arrB.length() - 1);
		list.add(endLetter + origin);
		makeList(endLetter + origin, cnt + 1);

	}
}
