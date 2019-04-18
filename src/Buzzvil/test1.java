package Buzzvil;

import java.util.Arrays;
import java.util.Stack;

public class test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] arr = { "{[()]}", "{[(])}","{{[[(())]]}}" };
		System.out.println(Arrays.toString(braces(arr)));
	}

	static String[] braces(String[] values) {

		String[] ans = new String[values.length];
		for (int i = 0; i < values.length; i++) {

			String temp = values[i];
			Stack<Character> s = new Stack<>();

			for (int j = 0; j < temp.length(); j++) {
				char c = temp.charAt(j);
				if (c == '{' || c == '[' || c == '(') {
					s.add(c);
				}
				else if (c == '}' || c == ']' || c == ')') {

					if (!s.isEmpty() && c == '}' && s.peek() == '{') {
						s.pop();
					} else if (c == ']' && s.peek() == '[') {
						s.pop();
					} else if (c == ')' && s.peek() == '(') {
						s.pop();
					}
					else {
						break;
					}
				}
			}

			if (s.empty()) {
				ans[i] = "YES";
			} else {
				ans[i] = "NO";
			}

		}

		return ans;

	}

}
