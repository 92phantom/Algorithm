package Programmers;

import java.util.Collections;
import java.util.PriorityQueue;

public class Heap_ex_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] aa = { 1, 2, 3, 9, 10, 12 };
		System.out.println(solution(aa, 7));
	}

	static int solution(int[] scoville, int K) {

		PriorityQueue<Integer> list = new PriorityQueue<>();

		for (int i = 0; i < scoville.length; i++) {
			list.add(scoville[i]);
		}

		int count = 0;
		while (true) {

			boolean flag = true;

			int init = list.peek();
			if (init < K) {
				flag = false;
				if (list.size() == 1) {
					return -1;
				}
			} else {
				return count;
			}

			if (!flag) {
				count += 1;
				int min = list.poll();
				int sec_min = list.poll() * 2;

				int total = min + sec_min;

				list.add(total);
			}
		}

	}

}
