package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class boj_6549 {

	/*
	 * 이 문제는 재귀로 풀면 안된다. "스택", "분할 정복"을 이용해야 한다.
	 * 
	 */

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		while (true) {


			st = new StringTokenizer(br.readLine(), " ");

			int N = Integer.parseInt(st.nextToken());

			if (N == 0) {
				break;
			}
			long ans = 0;

			int[] arr = new int[N + 2];
			Stack<Integer> stack = new Stack<>();

			for (int i = 1; i <= N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			stack.push(0);

			for (int i = 1; i <= N + 1; i++) {

				while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
					long height = arr[stack.peek()];
					stack.pop();
					long width = i - stack.peek() - 1;

					ans = Math.max(height * width, ans);
				}

				stack.push(i);

			}

			System.out.println(ans);

		}

	}

}
