package Programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;


// 큰수 만들기
public class Greedy_ex_1 {

	static int GOAL = 0;
	static boolean[] visited;
	static String num = "";
	static long ans = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		StringBuilder sb = new StringBuilder();
		sb.append("abcdefg");
		sb.deleteCharAt(0);
		
		System.out.println(sb.toString());
		
		
		solution("0099", 1);

	}

	static String solution(String number, int K) {

		
		
		
		num = number;
		GOAL = number.length() - K;
		int size = number.length();
		visited = new boolean[size+1];

		for (int i = 0; i < size; i++) {
			dfs(i, 1, num.charAt(i) + "", size);
		}

//		System.out.println(ans);
		return ans + "";

	}

	static void dfs(int idx, int count, String s, int size) {
		if (count == GOAL) {
			long temp = Long.parseLong(s);
			ans = Math.max(temp, ans);
		} else {
			
			visited[idx] = true;

			for (int i = idx + 1; i < size; i++) {
				if (!visited[i]) {
					dfs(i, count + 1, s + num.charAt(i), size);
				}
			}

			visited[idx] = false;
		}
	}
}
