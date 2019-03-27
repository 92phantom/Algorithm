package Kakao;

import java.util.ArrayList;
import java.util.Collections;

public class Kakao_2019_3_new {

	static int[] map;
	static int size;
	static int curCnt = 0;
	static boolean[] visited;
	static ArrayList<Integer> output = new ArrayList<>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {4,2, 2,5,3};
		sol(3, arr);

	}

	static int[] sol(int N, int[] coffee_times) {

		int[] answer = {};
		map = coffee_times;
		size = N;
		visited = new boolean[coffee_times.length];

		boolean flag = true;
		while (flag) {
			
			ArrayList<Integer> store = new ArrayList<>();
			int minValue = Integer.MAX_VALUE;
			int minIdx = 0;
			for (int i = 0; i < coffee_times.length; i++) {
				if (curCnt == N) {
					break;
				}
				else if (!visited[i]) {
					visited[i] = true;
					store.add(i);
					curCnt+=1;
				}
			}
			
			
			Collections.sort(store);
			
			System.out.println(store);
			
			break;
			
		}

		return answer;
	}
	
}
