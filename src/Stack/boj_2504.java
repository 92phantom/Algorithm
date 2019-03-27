package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class boj_2504 {

	static ArrayList<Integer> list;
	static long ans = 0;
	static boolean flag = false;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		Stack<Character> stack = new Stack<>();

		int temp = 1;

		// STACK���� '(' �̳� '[' �� �־� �ش�.

		for (int i = 0; i < input.length(); i++) {

			if (input.charAt(i) == '(') {
				temp *= 2;
				stack.push('(');
			}

			else if (input.charAt(i) == '[') {
				temp *= 3;
				stack.push('[');
			}

			// �Ұ����� ��� ���� ó��

			else if (input.charAt(i) == ')' && (stack.isEmpty() || stack.peek() != '(')) {

				flag = true;
				break;

			} else if (input.charAt(i) == ']' && (stack.isEmpty() || stack.peek() != '[')) {
				
				flag = true;
				break;

			}

			// ��ȣ �ȿ� ��ȣ�� ��
			else if (input.charAt(i) == ')') {
				if (input.charAt(i - 1) == '(') {
					ans += temp;
				}
				stack.pop();
				temp /= 2;
			}

			else if (input.charAt(i) == ']') {
				if (input.charAt(i - 1) == '[') {
					ans += temp;
				}
				stack.pop();
				temp /= 3;
			}

		}

		if (flag || !stack.isEmpty()) {
			System.out.println("0");
		} else {
			System.out.println(ans);
		}

	}
}
