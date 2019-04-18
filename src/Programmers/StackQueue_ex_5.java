package Programmers;

// 주식 가격
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// 시작시간 3:06
// 종료시간 3:30

public class StackQueue_ex_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] prices = { 1, 2, 3, 2, 3 };

		System.out.println(Arrays.toString(solution(prices)));
	}

	static int[] solution(int[] prices) {
		int[] answer = new int[prices.length];

		Queue<Node> q = new LinkedList<>();

		for (int i = 0; i < prices.length; i++) {
			q.add(new Node(prices[i], i));
		}

		while (!q.isEmpty()) {
			Node cur = q.poll();

			int idx = cur.idx;
			int price = cur.price;

			int count = 0;
			for (int i = idx + 1; i < prices.length; i++) {
				if (prices[i] >= price) {
					count += 1;
				} else {
					count += 1;
					break;
				}
			}

			answer[idx] = count;

		}

		return answer;
	}

	static class Node {
		int price, idx;

		Node(int price, int idx) {
			this.price = price;
			this.idx = idx;
		}
	}

}
