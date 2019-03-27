package SamsungExpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class swea_4223 {

	static int T;
	static int N;
	static int ans = Integer.MAX_VALUE;
	static String match = "SAMSUNG";

	static int[][] LP;
	static char[][] str;
	static int[] check;
	static int[] target;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {

			N = Integer.parseInt(br.readLine());
			ans = Integer.MAX_VALUE;

			target = new int[30];
			LP = new int[12][2];
			str = new char[12][12];
			check  = new int[30];

			for (int j = 0; j < match.length(); j++) {
				target[match.charAt(j) - 'A']++;
			}

			
			for (int j = 0; j < N; j++) {

				LP[j][0] = Integer.parseInt(br.readLine());
				st = new StringTokenizer(br.readLine(), " ");
				
//				System.out.println(LP[j][0]);
				
				for (int k = 0; k < LP[j][0]; k++) {
					
					char temp = st.nextToken().charAt(0);
//					System.out.println(temp);
					str[j][k] = temp;
				}
				LP[j][1] = Integer.parseInt(br.readLine());

			}

			dfs(0, 0, 0);

			if (ans == Integer.MAX_VALUE) {
				System.out.println("#" + (i + 1) + " " + "-1");

			} else {
				System.out.println("#" + (i + 1) + " " + ans);
			}
		}

	}

	static boolean checkFunc() {

		for (int i = 0; i < 26; i++) {

			if (target[i] > check[i]) {
				return false;
			}

		}
		return true;

	}

	static void dfs(int d, int pos, int value) {

//		boolean checked = checkFunc();

		if (d == N && !checkFunc()) {
			return;
		}

		if (checkFunc()) {
			ans = Math.min(ans, value);
			return;
		}

		for (int i = pos; i < N; i++) {

			for (int j = 0; j < LP[i][0]; j++) {
//				visited[input.get(i).charAt(j) - 'A']++;
				check[str[i][j] - 'A']++;
			}

			dfs(d + 1, i + 1, value + LP[i][1]);

			for (int j = 0; j < LP[i][0]; j++) {
//				visited[input.get(i).charAt(j) - 'A']--;
				check[str[i][j] - 'A']--;
			}

		}

	}

}
