package SamsungExpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_1952 {

	static int T;
	static int day, month, month_three, year;
	static int[] map;
	static int ans;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {

			map = new int[12];
			
			st = new StringTokenizer(br.readLine(), " ");

			day = Integer.parseInt(st.nextToken());
			month = Integer.parseInt(st.nextToken());
			month_three = Integer.parseInt(st.nextToken());
			year = Integer.parseInt(st.nextToken());

			ans = year;
			
			st = new StringTokenizer(br.readLine(), " ");

			for (int i = 0; i < 12; i++) {
				map[i] = Integer.parseInt(st.nextToken());
			}

			func(0, map, 0);
			
			System.out.println("#"+tc+" "+ ans);
		}

	}

	static void func(int idx, int[] map, int money) {

		int[] dupMap = map;

		if (idx >= 12) {
			ans = Math.min(ans, money);
			return;
		} else {
			
			if (dupMap[idx] != 0) {

				int temp = dupMap[idx];
				// 1일 개수
				func(idx + 1, dupMap, money + temp * day);
				// 1달
				func(idx + 1, dupMap, money + month);
				// 3달
				func(idx + 3, dupMap, money + month_three);

			}

			else {
				func(idx + 1, dupMap, money);
			}

		}

	}

}
