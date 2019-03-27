package SegmentTree;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj_6549 {

	static int N;
	static ArrayList<Integer> list;
	static int ans;

	/*
	 * 이 문제는 재귀로 풀면 안된다.
	 * "스택", "분할 정복"을 이용해야 한다.
	 * 
	 */
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		while (true) {

			int min = Integer.MAX_VALUE;
			int max = Integer.MIN_VALUE;
			ans = 0;
			list = new ArrayList<>();

			st = new StringTokenizer(br.readLine(), " ");

			N = Integer.parseInt(st.nextToken());

			if (N == 0) {
				break;
			}

			for (int i = 0; i < N; i++) {
				int input = Integer.parseInt(st.nextToken());

				min = Math.min(input, min);
				max = Math.max(input, max);

				list.add(input);

			}

			func(0, list.get(0), 1);

			System.out.println(ans);
		}

	}

	static void func(int idx, int height, int garo) {

		
		if (idx == N - 1) {
			ans = Math.max(garo * height, ans);
			return;
		}

		int nextHeight = list.get(idx + 1);

		func(idx + 1, nextHeight, 1);

		// 작을 때
		if (nextHeight < height) {
			
			ans = Math.max((garo)* height, ans);
			ans = Math.max((garo+1)* nextHeight, ans);
			
		} else {
			ans = Math.max((garo + 1) * height, ans);
			func(idx + 1, height, garo + 1);
		}
	}

}
