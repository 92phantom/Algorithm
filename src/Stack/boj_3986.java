package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class boj_3986 {

	static int N;
	static int ans = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {

			String input = br.readLine();
			int SIZE = input.length();

			Stack<Integer> stack = new Stack<>();

			int[] arr = new int[SIZE];

//			System.out.println("input"+input);

			for (int j = 0; j < SIZE; j++) {
				arr[j] = input.charAt(j) - 'A';

			}

//			System.out.println(Arrays.toString(arr));

			stack.push(arr[0]);

			for (int j = 1; j < SIZE; j++) {

				if (!stack.isEmpty()) {
					// AA or BB
					// 현재 이전 비교 같으면 POP
					if (stack.peek() == arr[j]) {
						stack.pop();
					}

					else {
						// 다르면 삽입
						stack.push(arr[j]);
					}

				} else {
					// 현재값 들어감
					stack.push(arr[j]);
				}

			}

			if (stack.isEmpty()) {
				ans++;
			}

		}

		System.out.println(ans);

	}

}
