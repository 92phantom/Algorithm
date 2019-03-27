package Programmers;

import java.util.Arrays;

//하노이탑
//이건 외우자 mid, mid = mid+1, mid= mid-1;

public class pro_hanoi {

	static int count = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 2;

		int[][] a = solution(2);

		for (int i = 0; i < a.length; i++) {
			System.out.println(Arrays.toString(a[i]));
		}
//		System.out.println(Arrays.toString(solution(1)));
	}

	static int[][] solution(int n) {

		int[][] ans = new int[(int) Math.pow(2, n) - 1][2];

		return solution(ans, n, 1, 2, 3);

	}

	static int[][] solution(int[][] map, int n, int first, int mid, int end) {

		if (n == 0) {
			return map;
		}

		if (n == 1) {
			map[count][0] = first;
			map[count][1] = end;
			count += 1;
			return map;
		}

		else {

			map = solution(map, n - 1, first, end, mid);
			map[count][0] = first;
			map[count][1] = end;
			count += 1;

			return solution(map, n - 1, mid, first, end);
		}

	}

}
