package BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class boj_2561 {

	static int N;
	static int[] map;
	static ArrayList<Integer> RESULT;
	static ArrayList<Integer> STARTLIST;
	static ArrayList<Integer> ENDLIST;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		RESULT = new ArrayList<>();
		map = new int[N + 1];

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < N; i++) {
			int temp = Integer.parseInt(st.nextToken());
			map[i] = temp;
			RESULT.add(temp);
		}

		Collections.sort(RESULT);

		if (func(map)) {
			for (int i = 0; i < 3; i++) {
				System.out.println((STARTLIST.get(i) + 1) + " " + (ENDLIST.get(i) + 1));
			}
		}

		else {
			func2(map);
			for (int i = 0; i < 3; i++) {
				System.out.println((STARTLIST.get(i) + 1) + " " + (ENDLIST.get(i) + 1));
			}
		}
	}

	static boolean func2(int[] input) {

		STARTLIST = new ArrayList<>();
		ENDLIST = new ArrayList<>();

		int[] dup = new int[N];
		System.arraycopy(input, 0, dup, 0, N);

		for (int k = 0; k < 3; k++) {

			int count = 0;
			int start = 0;
			int end = 0;

			for (int i = N - 1; i >= 0; i--) {

				if (count == 2) {
					break;
				}

				if (count == 0 && dup[i] != RESULT.get(i)) {
					count += 1;
					end = i;
				}

				if (count == 1 && dup[i] == RESULT.get(end)) {
					start = i;
					count += 1;
				}

			}

			STARTLIST.add(start);
			ENDLIST.add(end);

			ArrayList<Integer> temp = new ArrayList<>();

			for (int i = end; i >= start; i--) {
				temp.add(dup[i]);
			}

			int idx = 0;

			for (int i = start; i <= end; i++) {
				dup[i] = temp.get(idx++);
			}

			System.out.println(temp);
			System.out.println(Arrays.toString(dup));
			
			if (k == 2) {

				for (int i = 0; i < N; i++) {
					if (dup[i] != RESULT.get(i)) {
						return false;
					}
				}
			}

		}

		return true;

	}

	static boolean func(int[] input) {

		STARTLIST = new ArrayList<>();
		ENDLIST = new ArrayList<>();

		int[] dup = new int[N];
		System.arraycopy(input, 0, dup, 0, N);

		for (int k = 0; k < 3; k++) {

			int count = 0;
			int start = 0;
			int end = 0;

			for (int i = 0; i < N; i++) {

				if (count == 2) {
					break;
				}

				if (count == 0 && dup[i] != RESULT.get(i)) {
					count += 1;
					start = i;
				}

				if (count == 1 && dup[i] == RESULT.get(start)) {
					end = i;
					count += 1;
				}

			}

			STARTLIST.add(start);
			ENDLIST.add(end);

			ArrayList<Integer> temp = new ArrayList<>();

			for (int i = end; i >= start; i--) {
				temp.add(dup[i]);
			}

			int idx = 0;

			for (int i = start; i <= end; i++) {
				dup[i] = temp.get(idx++);
			}

			System.out.println(temp);
			System.out.println(Arrays.toString(dup));

			if (k == 2) {

				for (int i = 0; i < N; i++) {
					if (dup[i] != RESULT.get(i)) {
						return false;
					}
				}
			}
//

		}

		return true;

	}

}
