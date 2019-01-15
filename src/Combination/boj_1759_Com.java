package Combination;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_1759_Com {

	static char[] input;

	public static void main(String[] args) throws IOException {

		int r, n;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		r = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());

		input = new char[n];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < n; i++) {

			input[i] = st.nextToken().charAt(0);

		}

		Arrays.sort(input);

		doCombination(r, "", 0);

	}

	static boolean validCheck(String pw) {

		int consonant = 0; // ÀÚÀ½
		int vowel = 0;

		for (int i = 0; i < pw.length(); i++) {
			char c = pw.charAt(i);
			if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
				vowel++;
			} else {
				consonant++;
			}
		}
		return (consonant >= 2 && vowel >= 1);

	}

	static void doCombination(int length, String pw, int index) {

		if (length == pw.length()) {

			if (validCheck(pw)) {
				System.out.println(pw);
				return;
			}

		}

		if (index >= input.length) {
			return;
		}

		doCombination(length, pw + input[index], index + 1);
		doCombination(length, pw, index + 1);

	}

}
