package SamsungExpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_1865 {

	static int T;
	static int N;
	static double ans;
	static double[][] map;
	static boolean[] visited;
	static double maxValue;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {

			N = Integer.parseInt(br.readLine());

			map = new double[N][N];
			visited = new boolean[N];
			ans = Double.MIN_VALUE;
			maxValue = Integer.MIN_VALUE;

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");

				for (int j = 0; j < N; j++) {

					map[i][j] = Double.parseDouble(st.nextToken()) / 100;

				}

			}

			dfs(0.0, 0, 1.0);
			System.out.printf("#%d %.6f\n", tc, ans);
		}

	}

	static void dfs(double value, int count, double sosu) {

		if(sosu * 100 <= ans) return;
//		if (value <= maxValue) {
//			System.out.println(value);
//			System.out.println(maxValue);
//			System.out.println("¹Ù·Î>?");
//			return;
//		}
		if (count == N) {

			if (sosu * 100 > ans) {
//			if (value > maxValue) {
				maxValue = value;
				ans = sosu * 100;
			}

			return;
		}

		for (int i = 0; i < N; i++) {

			if (!visited[i]) {
				visited[i] = true;
				dfs(value + map[count][i], count + 1, sosu * map[count][i]);
				visited[i] = false;
			}

		}

	}

}
