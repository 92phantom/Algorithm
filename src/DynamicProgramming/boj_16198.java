package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj_16198 {

	static int N;
	static long ans = 0;
	static ArrayList<Integer> list = new ArrayList<>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < N; i++) {

			int input = Integer.parseInt(st.nextToken());
			list.add(input);

		}

		dfs(0);
		System.out.println(ans);

	}

	static void dfs(long input) {

		int size = list.size();

		if (size == 2) {

			if (input > ans) {
				ans = input;
			}
			return;
		}

		int cur;
		long temp;

		for (int i = 1; i < size - 1; i++) {

			cur = list.get(i);
			temp = list.get(i - 1) * list.get(i + 1);
			list.remove(i);
			dfs(input + temp);
			list.add(i, cur);
		}

		return;
	}
}
