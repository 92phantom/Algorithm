package Programmers;


// 구명 보트
import java.util.Arrays;

public class Greedy_ex_2 {

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

		System.out.println(solution(people, limit));

	}

	static int solution(int[] people, int limit) {

		int withBoat = 0;
		Arrays.sort(people);

		int totalPeople = people.length;

		int start = 0;
		int end = totalPeople - 1;

		while (start < end) {

			if (people[start] + people[end] <= limit) {
				withBoat++;
				start++;
				end--;
			}

			// 둘 합친게 크면
			else {
				end--;
			}

		}

		return totalPeople - withBoat;

	}

}
