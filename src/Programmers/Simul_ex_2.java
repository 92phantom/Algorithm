package Programmers;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
// 소수찾기

public class Simul_ex_2 {

	static boolean[] visited;
	static char[] arr;
	static Set<Integer> map = ConcurrentHashMap.newKeySet();
	static int ans = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "17";
		System.out.println(solution(input));
	}

	static int solution(String numbers) {

		arr = numbers.toCharArray();

		visited = new boolean[arr.length];

		for (int i = 0; i < arr.length; i++) {
			dfs(arr[i] + "", i);
		}

		return ans;
	}

	static void dfs(String s, int idx) {

		int temp = Integer.parseInt(s);

		if (!map.contains(temp)) {

			map.add(temp);
			if (isPrime(temp)) {
				ans += 1;
			}

		}

		visited[idx] = true;

		for (int i = 0; i < arr.length; i++) {
			if (!visited[i]) {
				dfs(s + arr[i], i);
			}
		}

		visited[idx] = false;

	}

	static boolean isPrime(int input) {

		int count = 0;

		if (input == 1 || input == 0) {
			return false;
		}

		for (int i = 1; i <= input; i++) {
			if (input % i == 0) {
				count += 1;
			}
			if (count >= 3) {
				return false;
			}
		}

		return true;
	}

}
