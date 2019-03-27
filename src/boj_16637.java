import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

/*
 * 
 *  16637 :괄호 추가하기 
 *  다시 풀어봐야함
 */
public class boj_16637 {

	static int N;
	static char[] map = new char[20];
	static long ans = Integer.MIN_VALUE;
	static boolean[] GwalHo = new boolean[20];

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		String temp = br.readLine();

		for (int i = 0; i < N; i++) {
			map[i] = temp.charAt(i);
		}

		dfs(0);

		System.out.println(ans);
	}

	static void dfs(int idx) {

		if (idx >= N) {
			ans = Math.max(ans, cal());
			return;
		}

		for (int i = idx; i < N; i = i + 2) {

			if (i + 2 < N) {

				if (GwalHo[i] == false && GwalHo[i + 2] == false) {
					GwalHo[i] = true;
					GwalHo[i + 2] = true;
					dfs(idx + 2);
					GwalHo[i] = false;
					GwalHo[i + 2] = false;
				}

			} else {
				dfs(i + 1);
			}

		}

	}

	static long cal_func(long a, long b, char op) {
		if (op == '+') {
			return a + b;
		} else if (op == '-') {
			return a - b;
		} else {
			return a * b;
		}
	}

	static long cal() {

		ArrayList<String> v = new ArrayList<>();
		for (int i = 0; i < N;) {

			if (GwalHo[i] == false) {
				String s = "";
				s = s + map[i];
				v.add(s);
				i++;
			} else {

				long temp1 = Long.parseLong(map[i] + "");
				long temp2 = Long.parseLong(map[i + 2] + "");

				char op = map[i + 1];

				long temp_result = cal_func(temp1, temp2, op);
				v.add(temp_result + "");
				i = i + 3;
			}

		}

		long return_Val = Long.parseLong(v.get(0));

		for (int i = 1; i < v.size(); i = i + 2) {

			char op = v.get(i).charAt(0);
			long temp1 = Long.parseLong(v.get(i + 1));

			return_Val = cal_func(return_Val, temp1, op);

		}

		return return_Val;

	}

}
