package Programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Sorting_ex_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] array = { 1, 5, 2, 6, 3, 7, 4 };
		int[][] command = { { 2, 5, 3 }, { 4, 4, 1 }, { 1, 7, 3 } };
		System.out.println(Arrays.toString(solution(array, command)));

	}

	static int[] solution(int[] array, int[][] commands) {
		int[] answer = new int[commands.length];

		for (int i = 0; i < commands.length; i++) {

			int start = commands[i][0] - 1;
			int end = commands[i][1] - 1;
			int K = commands[i][2] - 1;

			ArrayList<Integer> list = new ArrayList<>();

			for (int j = start; j <= end; j++) {
				
				list.add(array[j]);
			}

			Collections.sort(list);
			answer[i] = list.get(K);
		}

		return answer;
	}
}
