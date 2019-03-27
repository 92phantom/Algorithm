package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class boj_1725 {

	static int N;
	static int[] arr;
	static int ans;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		// ����� �ϳ� �� ũ�� ���� ������ ���� ����, �� ������ �Ҵ���� ���� �κ��� 0�̹Ƿ� while�� ���ǿ� �ɸ��� �ȴ�.
		arr = new int[N + 2];
		ans = 0;

		// Stack�� ���� ���� �ε��� ���̴�.
		Stack<Integer> stack = new Stack<>();

		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		/*
		 * 1) ���̰� "4"�� ����� ���� ����(���� 5)�� �����Ͽ� WIDTH = 2 HEIGHT =4 �� ���簢���� ���� �� ���� 
		 * 2) ���̰� "5"�� ����� "��/��" ��� �ڽ� ���� ���̰� ���� ������ �ٸ� ����� ������ �� ����.
		 * 
		 * == > ���: ���� ���� ���̸� �������� ������ ����� ���ļ� ���簢���� ���� ���� ������ ���� �������� �ʴ´�.
		 */
		
		stack.push(0);

		for (int i = 1; i <= N + 1; i++) {
			 
			// ���� ���� ���� ��(������ Top)���� ���� ���
			// ��� : �ٸ� ����� ������ �� ���� ����� ������ ���⼭ �ѹ� ���̸� ������ش�.
			
			// �� �ڿ����� �� 
			while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {

				int height = arr[stack.peek()];
				stack.pop();
				int width = i - stack.peek() - 1;
				ans = Math.max(ans, width * height);

			}

			stack.push(i);

		}

		System.out.println(ans);

	}

}
