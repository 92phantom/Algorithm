package Programmers;

import java.util.*;

public class StackQueue_ex_2 {

	static int[] arr;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] priorities = { 2, 1, 3, 2 };
		int location = 2;
//		int[] priorities = { 1,1,9,1,1,1 };
//		int location = 0;
		System.out.println(solution(priorities, location));
	}

	static int solution(int[] priorities, int location) {
		arr = new int[priorities.length];
		ArrayList<Integer> list = new ArrayList<>();
		Queue<Integer> q = new LinkedList<>();

		for (int i = 0; i < priorities.length; i++) {

			int temp = priorities[i];
			list.add(temp);
			q.add(i);

		}

		int count = 0;
		
		while (true) {

			boolean flag = true;

			int start = list.get(0);

			for (int i = 1; i < list.size(); i++) {
				if (start < list.get(i)) {
					flag = false;
					break;
				}
			}

			if (flag) {
				list.remove(0);
				int idx = q.poll();
				arr[idx] = ++count;
				if (idx == location) {
					break;
				}

			} else {
				int idx = q.poll();
				q.add(idx);
				
				list.remove(0);
				list.add(start);
			}
			
		}

		return arr[location];
	}
}
