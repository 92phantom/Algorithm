package Kakao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class Kakao_2019_3 {

	static ArrayList<Integer> output = new ArrayList<>();

	static ConcurrentHashMap<Integer, Integer> list = new ConcurrentHashMap<>();

	static boolean visited[];
	static int curCnt = 0;
	static int available;
	static int[] map;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = { 4, 2, 2, 5, 3 };
//		int[] arr = {100, 1, 50, 1, 1};
//
		System.out.println(Arrays.toString(solution(3, arr)));
	}

	static int[] solution(int N, int[] coffee_times) {

		int[] answer = new int[coffee_times.length];
		available = N;
		visited = new boolean[coffee_times.length];
		map = coffee_times;

		for (int i = 0; i < map.length; i++) {
			if (curCnt >= N) {

				func();

			} else {
				if (!visited[i]) {

					list.put(i, coffee_times[i]);
					visited[i] = true;
					curCnt += 1;

				}
			}

		}

//		System.out.println(list.keySet().toString());

		func();

//		System.out.println("나왓어");
		if (list.keySet().size() > 0) {
			boolean finalFlag = true;
			while (finalFlag) {

				Iterator<Integer> it = list.keySet().iterator();
				int minValue = Integer.MAX_VALUE;
				int minKey = 0;
				while (it.hasNext()) {

					int key = it.next();
					if (list.get(key).intValue() >= 0) {
						if (minValue > list.get(key).intValue()) {
							minValue = list.get(key).intValue();
							minKey = key;
						}
					}
					output.add(minKey);
					list.remove(minKey);

				}

				if (list.keySet().size() == 0)
					finalFlag = false;

			}

		}

		
		
		for (int i = 0; i < output.size(); i++) {

			answer[i] = output.get(i) + 1;
		}
		
//		System.out.println("마지막"+output);
		
		
		return answer;

	}

	static void func() {

		if(output.size() == map.length)
			return;
		
		boolean flag = true;
		while (flag) {

			Iterator<Integer> it = list.keySet().iterator();
			while (it.hasNext()) {

				int key = it.next();
//				System.out.println("key"+key);
				if (list.get(key) > 0) {
					list.replace(key, list.get(key).intValue() - 1);
				} else if (list.get(key).intValue() == 0) {

//					System.out.println("빠져 나갈 키는?\t" + key);
					output.add(key);
					list.remove(key);
					curCnt -= 1;
					flag = false;
				}
			}
		}

		boolean sFlag = false;

		for (int i = 0; i < map.length; i++) {
//			System.out.println(i);
			if (!visited[i]) {
				sFlag = true;
			}
		}

		if (sFlag) {
//			System.out.println("inputCall");
			input();
		} else {
//			System.out.println("현재값" + output);

			return;
		}

	}

	static void input() {

		for (int i = 0; i < map.length; i++) {

			if (curCnt >= available) {
				func();

			} else {
				if (!visited[i]) {

//					System.out.println("새로들어간 키\t" + i);

					list.put(i, map[i]);
					visited[i] = true;
					curCnt += 1;

				}
			}

		}

	}

}
