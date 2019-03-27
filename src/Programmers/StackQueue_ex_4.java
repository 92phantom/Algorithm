package Programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// 시작시간 3:06
// 종료시간 3:30

public class StackQueue_ex_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] progresses = { 93, 30, 55 };
		int[] speeds = { 1, 30, 5 };

		System.out.println(Arrays.toString(solution(progresses, speeds)));
	}

	static int[] solution(int[] progresses, int[] speeds) {
		int[] answer = new int[progresses.length];
		Queue<Node> onGoing = new LinkedList<>();

		for (int i = 0; i < progresses.length; i++) {
			onGoing.add(new Node(i, progresses[i], speeds[i]));
		}

		int time = 0;
		while (true) {

			int size = onGoing.size();

			if (size == 0) {
				break;
			}

			for (int i = 0; i < size; i++) {

				Node cur = onGoing.poll();

				int nextProgress = cur.progress + cur.speed;

				if (nextProgress >= 100) {
					answer[cur.idx] = time;
				} else {
					onGoing.add(new Node(cur.idx, nextProgress, cur.speed));
				}
			}

			time += 1;
		}

		ArrayList<Integer> out = new ArrayList<>();

		for (int i = 0; i < answer.length; i++) {

			int start = answer[i];
			int count = 1;
			if (start != 0) {
				for (int j = i + 1; j < answer.length; j++) {
					int next = answer[j];
					if (next <= start) {
						count += 1;
						answer[j] = 0;
					} else {
						break;
					}
				}
				out.add(count);
			}
		}
		
		
		answer = new int[out.size()];
		
		for(int i=0; i<out.size(); i++) {
			answer[i] = out.get(i);
		}

		return answer;
	}

	static class Node {
		int idx, progress, speed;

		Node(int idx, int progress, int speed) {
			this.idx = idx;
			this.progress = progress;
			this.speed = speed;
		}
	}
}
