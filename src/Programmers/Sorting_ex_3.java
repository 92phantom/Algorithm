package Programmers;

public class Sorting_ex_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] array = { 1, 1, 2, 4, 7, 8, 9 };
//		int[][] command = { { 2, 5, 3 }, { 4, 4, 1 }, { 1, 7, 3 } };
		System.out.println(solution(array));

	}

	static int solution(int[] citations) {
//		int answer = 0;

		int max = 0;
		for (int i = 0; i < citations.length; i++) {
			max = Math.max(citations[i], max);
		}

		int count = 0;
		int idx = 0;

		if (max == 0) {
			return 0;
		}

		while (max >= 0) {

			for (int i = 0; i < citations.length; i++) {
				if (citations[i] == max) {
					count += 1;
				} else if (citations[i] > max) {
					count += 1;
				}
			}

			if (max <= count) {
				break;
			}

			max--;
			count = 0;

		}

//		System.out.println(max);
		return max;
	}

}
