package Programmers;

import java.util.*;

//���۽ð� 2:30
//����ð� 3:04

public class StackQueue_ex_3 {

	static int[] arr;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		int bridge_length = 2;
//		int weight = 10;
//		int[] truck_weights = { 7, 4, 5, 6 };

		
		int bridge_length = 100;
		int weight = 100;
		int[] truck_weights = { 10,10,10,10,10,10,10,10,10,10};
		System.out.println(solution(bridge_length, weight, truck_weights));

	}

	static int solution(int bridge_length, int weight, int[] truck_weights) {

		int answer = 0;
		Queue<Integer> wait = new LinkedList<>();
		Queue<Node> ing = new LinkedList<>();
		Queue<Integer> pass = new LinkedList<>();

		for (int i = 0; i < truck_weights.length; i++) {
			wait.add(truck_weights[i]);
		}

		int time = 1;

		while (pass.size() != truck_weights.length) {
			

			if (!wait.isEmpty()) {
				int trcukWeight = wait.peek();

				if (trcukWeight <= weight) {
					weight -= trcukWeight;
					wait.poll();
					ing.add(new Node(trcukWeight, 0));
				}
			}
//			System.out.println("�����" + wait);

			// �̹� Ÿ�ִ°� �Ÿ� ����
			int size = ing.size();

			for (int i = 0; i < size; i++) {
				Node cur = ing.poll();

				cur.d += 1;
				if (cur.d < bridge_length) {
					ing.add(new Node(cur.weight, cur.d));
				} else if (cur.d == bridge_length) {
					weight += cur.weight;
					pass.add(cur.weight);
				}

			}
			
			time += 1;

//			System.out.println("�ð�"+time);
//			System.out.println("�н��ѻ��"+pass);


		}

//		System.out.println(time);

		return time;
	}

	static class Node {
		int weight, d;

		Node(int weight, int d) {
			this.weight = weight;
			this.d = d;
		}
	}

}
