import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_2661 {

	static int N;
	static int ans;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		ans = Integer.MAX_VALUE;

		for (int i = 1; i <= 3; i++) {
			func(i, "1");
		}
	}

	static void func(int count, String s) {

		if (count == N) {

			System.out.println(s);
			System.exit(0);

		} else {

			for (int i = 1; i <= 3; i++) {

				if (check(s + i)) {
					func(count + 1, s + i);
				}

			}

		}

	}

	static boolean check(String s) {

		int len = s.length();
		int loop = len / 2;
		int start = len - 1;
		int end = len;

		for (int i = 1; i <= loop; i++) {
			if (s.substring(start - i, end - i).equals(s.substring(start, end))) {
				return false;
			}
			start -= 1;
		}
		return true;
	}

}
