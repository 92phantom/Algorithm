package SamsungExpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class swea_5658 {

	static int T, N, K;
	static ArrayList<Integer> values;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());


		for (int k = 0; k < T; k++) {

			
			ArrayList<Object> map = new ArrayList<Object>();
			values = new ArrayList<Integer>();
			
			st = new StringTokenizer(br.readLine(), " ");

			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			int circle = N / 4;

			String temp = br.readLine();

			for (int i = 0; i < N; i++) {

				map.add(temp.charAt(i));

			}

			String temp16 = "";

			for (int i = 0; i <= circle; i++) {

				for (int j = 0; j < N; j++) {

					temp16 += map.get(j);

					if (j != 0 && (j + 1) % circle == 0) {

//						System.out.println(temp16);
//						System.out.println(Integer.parseInt(temp16, 16));

						if (!values.contains(Integer.parseInt(temp16, 16))) {
							values.add(Integer.parseInt(temp16, 16));
						}
						temp16 = "";
					}

				}

				if (i != circle - 1) {
					int endPoint = map.size() - 1;

					Object end = map.get(endPoint);

					for (int j = map.size() - 1; j > 0; j--) {

						map.set(j, map.get(j - 1));

					}

					map.set(0, end);
				}
			}

			Collections.sort(values, new Ascending());
			System.out.println("#" + (k + 1) + " " + values.get(K - 1));

		}

	}

}

class Ascending implements Comparator<Integer> {

	@Override
	public int compare(Integer a, Integer b) {
		return b.compareTo(a);
	}

}
