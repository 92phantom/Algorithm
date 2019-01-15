package Basic;

public class Combination {

	public static void main(String[] args) {

		int[] sample = { 1, 2, 3 };
		int n = sample.length;
		int r = 2;

		int[] combArr = new int[n];

		doCombination(combArr, n, r, 0, 0, sample);

	}

	static void doCombination(int[] combArr, int n, int r, int index, int target, int[] input) {

		if (r == 0) {

			for (int i = 0; i < index; i++) {
				System.out.println(input[combArr[i]] + " ");
			}

		} else if (target == n) {
			return;
		} else {

			combArr[index] = target;

			doCombination(combArr, n, r - 1, index + 1, target + 1, input);
			doCombination(combArr, n, r, index, target + 1, input);

		}

	}
}
