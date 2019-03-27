package TechCourse_2019_TOP;

public class Tech_2019_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = { 97, 98 };
		int[] b = { 197, 198 };

		System.out.println(solution(a, b));
		
		
	}

	static boolean checkFunc(int idx, int val) {

		if (val < 1 || val > 400) {
			return false;
		}
		if (idx == 0 && (val % 2 == 0)) {
			return false;
		}
		if (idx == 1 && (val % 2 != 0)) {
			return false;
		}

		return true;

	}

	static int solution(int[] pobi, int[] crong) {

		int pobiSum = 0;
		int crongSum = 0;

		if ((pobi[0] + 1) != pobi[1]) {
			return -1;
		}

		if ((crong[0] + 1) != crong[1]) {
			return -1;
		}

		/// POBI
		for (int i = 0; i < 2; i++) {
			int pageVal = pobi[i];

			if (!checkFunc(i, pageVal)) {
				return -1;
			}

			int add = 0, gob = 1;

			if (pageVal > 100) {

				int temp = 100;
				for (int j = 0; j < 2; j++) {
					add += (pageVal / temp);
					gob *= (pageVal / temp);
					pageVal %= temp;
					temp /= 10;
				}

				add += pageVal;
				gob *= pageVal;
			}

			else if (pageVal > 10) {
				add += ((pageVal / 10) + (pageVal % 10));
				gob *= ((pageVal / 10) * (pageVal % 10));
			}

			else {
				add = gob = pageVal;
			}

			pobiSum = Math.max(pobiSum, Math.max(add, gob));
		}

		
		// Å©·Õ
		for (int i = 0; i < 2; i++) {
			int pageVal = crong[i];

			if (!checkFunc(i, pageVal)) {
				return -1;
			}

			int add = 0, gob = 1;

			if (pageVal > 100) {

				int temp = 100;
				for (int j = 0; j < 2; j++) {
					add += (pageVal / temp);
					gob *= (pageVal / temp);
					pageVal %= temp;
					temp /= 10;
				}

				add += pageVal;
				gob *= pageVal;
			}

			else if (pageVal > 10) {
				add += ((pageVal / 10) + (pageVal % 10));
				gob *= ((pageVal / 10) * (pageVal % 10));
			}

			else {
				add = gob = pageVal;
			}

			crongSum = Math.max(crongSum, Math.max(add, gob));
		}

		System.out.println(pobiSum);
		System.out.println(crongSum);
		
		
		if (pobiSum == crongSum) {
			return 0;
		} else {
			return pobiSum > crongSum ? 1 : 2;
		}

	}
}
