package TechCourse_2019_TOP;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Tech_2019_7 {

	static boolean[] visited;
	static int[] dx = { -1, 1 };

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(solution("aaaa"));

	}

	static String solution(String cryptogram) {

		char[] arr = cryptogram.toCharArray();

		boolean flag = false;
		int SIZE = cryptogram.length();
		visited = new boolean[cryptogram.length()];

		for (int i = 0; i < cryptogram.length(); i++) {
			ArrayList<Node> sameList = new ArrayList<>();
			Queue<Node> sameList2 = new LinkedList<>();

			sameList.add(new Node(i, cryptogram.charAt(i)));
			sameList2.add(new Node(i, cryptogram.charAt(i)));

			while (!sameList2.isEmpty()) {

				Node cur = sameList2.poll();
				visited[cur.x] = true;

				for (int j = 0; j < 2; j++) {

					int nextX = cur.x + dx[j];

					if (nextX < 0 || nextX >= SIZE) {
						continue;
					}

					if (!visited[nextX] && (int) cryptogram.charAt(nextX) == cur.letter) {
						sameList.add(new Node(nextX, cryptogram.charAt(nextX)));
						sameList2.add(new Node(nextX, cryptogram.charAt(nextX)));
					}

				}

			}

			if (sameList.size() > 1) {
				flag = true;
				for (int j = 0; j < sameList.size(); j++) {
					arr[sameList.get(j).x] = '.';
				}
			}

		}
		String temp = "";
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != '.') {
				temp += arr[i];
			}
		}

		if (flag) {
			if (temp.length() > 0) {
				temp = solution(temp);
			}
		}

		return temp;
	}

	static class Node {
		int x;
		char letter;

		Node(int x, char letter) {
			this.x = x;
			this.letter = letter;
		}
	}
}
