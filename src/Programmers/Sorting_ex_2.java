package Programmers;

import java.util.Arrays;
import java.util.Comparator;

public class Sorting_ex_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] array = { 6, 2, 10 };
//		int[][] command = { { 2, 5, 3 }, { 4, 4, 1 }, { 1, 7, 3 } };
		System.out.println(solution(array));

	}

	static String solution(int[] numbers) {
		String answer = "";

		// int 배열을 String 배열로 변환
		String[] arr = new String[numbers.length];
		for (int i = 0; i < numbers.length; i++) {
			arr[i] = (String.valueOf(numbers[i]));
		}

		Arrays.sort(arr, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {

				int s1s2 = Integer.parseInt(s1 + s2);
				int s2s1 = Integer.parseInt(s2 + s1);

				if (s1s2 > s2s1) {
					//앞자리를 더한게 더크면 s1이 앞으로
					return -1;
				} else if (s1s2 < s2s1) {
					//뒷자리를 더한게 더크면 s1 뒤로
					return 1;
				} else {
					//제자리
					return 0;
				}

			}
		});

		if (arr[0].equals("0"))
			return "0";

		for (int i = 0; i < arr.length; i++) {
			answer += arr[i];
		}
		
		return answer;
	}

}
