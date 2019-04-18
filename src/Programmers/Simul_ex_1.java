package Programmers;

import java.util.ArrayList;
import java.util.Arrays;

public class Simul_ex_1 {

	static ArrayList<Integer> map1 = new ArrayList<>();
	static ArrayList<Integer> map2 = new ArrayList<>();
	static ArrayList<Integer> map3 = new ArrayList<>();

	static int size = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 1, 2,3,4,5 };
		System.out.println(Arrays.toString(solution(arr)));
	}

	static int[] solution(int[] answers) {
		int[] answer = new int[3];

		for (int i = 1; i <= 5; i++) {
			map1.add(i);
		}

		// 8°³
		map2.add(2);
		map2.add(1);
		map2.add(2);
		map2.add(3);
		map2.add(2);
		map2.add(4);
		map2.add(2);
		map2.add(5);

		// 10°³
		map3.add(3);
		map3.add(3);
		map3.add(1);
		map3.add(1);
		map3.add(2);
		map3.add(2);
		map3.add(4);
		map3.add(4);
		map3.add(5);
		map3.add(5);

		int max = Integer.MIN_VALUE;

		for (int i = 0; i < answers.length; i++) {
			if (answers[i] == map1.get(i % 5)) {
				answer[0] += 1;
				max = Math.max(answer[0], max);
			}
			if (answers[i] == map2.get(i % 8)) {
				answer[1] += 1;
				max = Math.max(answer[1], max);
			}
			if (answers[i] == map3.get(i % 10)) {
				answer[2] += 1;
				max = Math.max(answer[2], max);
			}
		}

		System.out.println(max);

		ArrayList<Integer> result = new ArrayList<>();

		for (int i = 0; i < answer.length; i++) {
			if (answer[i] == max) {
				result.add(i + 1);
			}
		}

		answer = new int[result.size()];
		
		for (int i = 0; i < result.size(); i++) {
			answer[i] = result.get(i);
		}

		return answer;

	}

}
