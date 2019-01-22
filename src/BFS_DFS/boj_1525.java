package BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.concurrent.ConcurrentHashMap;

public class boj_1525 {

	static final String BLANK = "0";
	static String GOAL = "123456780";
	static String INPUT = "";
	static ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<String, Integer>();
	static Queue<String> q = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for (int i = 0; i < 3; i++) {

			st = new StringTokenizer(br.readLine(), " ");

			for (int j = 0; j < 3; j++) {
				INPUT += st.nextToken();
			}

		}

		System.out.println(bfs());

	}

	static String swap(String input, int blankIdx, int changeIdx) {

		StringBuilder sb = new StringBuilder(input);

		sb.setCharAt(blankIdx, input.charAt(changeIdx));
		sb.setCharAt(changeIdx, BLANK.charAt(0));

		return sb.toString();

	}

	static void addFunc(String popedStr, String changedStr) {

		if (!map.containsKey(changedStr)) {
			q.add(changedStr);
			map.put(changedStr, map.get(popedStr) + 1);
		}

	}

	static String bfs() {

		q.add(INPUT);
		map.put(INPUT, 0);

		while (!q.isEmpty()) {

			String popedStr = q.poll();

			if (popedStr.equals(GOAL))
				return map.get(popedStr) + "";

			int blankIdx = popedStr.indexOf(BLANK);
			int changeIdx = 0;

			// 위로 이동이 가능 경우
			if (blankIdx >= 3) {

				changeIdx = blankIdx - 3;
				String changedStr = swap(popedStr, blankIdx, changeIdx);

				addFunc(popedStr, changedStr);

			}

			// 아래로 이동이 가능 할 경우
			if (blankIdx < 6) {
				changeIdx = blankIdx + 3;
				String changedStr = swap(popedStr, blankIdx, changeIdx);

				addFunc(popedStr, changedStr);

			}

			// 우로 이동이 가능 할 경우
			if (blankIdx % 3 != 2) {
				changeIdx = blankIdx + 1;
				String changedStr = swap(popedStr, blankIdx, changeIdx);

				addFunc(popedStr, changedStr);

			}

			// 좌로 이동이 가능 할 경우
			if (blankIdx % 3 != 0) {
				changeIdx = blankIdx - 1;
				String changedStr = swap(popedStr, blankIdx, changeIdx);

				addFunc(popedStr, changedStr);

			}

		}

		return -1 + "";

	}

}
