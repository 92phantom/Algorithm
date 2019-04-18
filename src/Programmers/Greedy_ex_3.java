package Programmers;

// 조이스틱
import java.util.Arrays;

public class Greedy_ex_3 {

	static int GOAL = 0;
	static boolean[] visited;
	static String num = "";
	static long ans = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] people = { 70, 50, 80, 50 };
		int limit = 100;

//		int[] people = { 70, 80, 50 };
//		int limit = 100;

//		int[] people = { 100, 20, 30, 40, 50, 60, 20 };
//		int limit = 50;

		System.out.println(solution("JAZ"));

	}

	static int solution(String name) {

		int answer1 = 0;
		int answer2 = 0;

		answer1 = Math.min(name.charAt(0) - 'A', 'Z' - name.charAt(0) + 1);
		answer2 = answer1;

		System.out.println("시작"+answer1);
		System.out.println("시작"+answer2);
		
		// 우측으로
		for (int i = 1; i < name.length(); i++) {

			boolean flag = true;

			if (name.charAt(i) != 'A') {
				flag = false;
				break;
			}

			if (flag) {
				break;
			}

			answer1 += 1;
			answer1 += name.charAt(i) - 'A';

		}

		System.out.println(answer1);
		
		// 좌측으로
		for (int i = name.length() - 1; i >= 1; i--) {

			System.out.println("뭐여");
			
			

			answer2 += 1;
			answer2 += 'Z' - name.charAt(i) + 1;

			System.out.println("중간"+answer2);
		}
		
		System.out.println(answer2);

		int temp = Math.min(answer1, answer2);

		return temp;
	}

}
