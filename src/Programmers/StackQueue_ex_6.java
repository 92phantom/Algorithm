package Programmers;

// ž
import java.util.*;

public class StackQueue_ex_6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] prices = { 3,9,9,3,5,7,2};

		System.out.println(Arrays.toString(solution(prices)));
	}

	static int[] solution(int[] heights) {
		int[] answer = new int[heights.length];

		Stack<Node> s = new Stack<>();

		for (int i = 0; i < heights.length; i++) {
			s.add(new Node(heights[i], i+1));
		}

		while (!s.isEmpty()) {

			Node cur = s.pop();

			int idx = cur.idx;
			int height = cur.height;

			int recv = -1;
			
			for (int i = idx - 	1; i >= 0; i--) {

				if(heights[i] > height) {
					recv = i;
					break;
				}
				
			}
			
			if(recv != -1) {
				recv +=1;
			}else {
				recv = 0;
			}
			
			answer[idx-1] = recv;
			
		}

		return answer;
	}

	static class Node {
		int height, idx;

		Node(int height, int idx) {
			this.height = height;
			this.idx = idx;
		}
	}
}
