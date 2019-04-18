package BOJ20190401;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_13458 {

	static int N;
	static ArrayList<Integer> list = new ArrayList<>();

	static int B, C;
	static int[] v;
	static boolean[] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		v = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < N; i++) {
			int temp = Integer.parseInt(st.nextToken());
			list.add(temp);
		}

		st = new StringTokenizer(br.readLine(), " ");

		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		for (int i = 0; i < list.size(); i++) {
			visited = new boolean[N];
			func(i, 0, 0);
		}

	}

	static void func(int i, int flag, int c) {

		System.out.println("인덱스" + i);

		if (c == list.size()-1) {
			int total = 0;
			for (int j = 0; j < N; j++) {
				total += v[j];
			}

			System.out.println(Arrays.toString(v));
			System.out.println("TOTAL" + total);
			return;
		}
		// 첫번 노드
		if (flag == 0) {
			// 사이즈가 같을 때

			int count = 0;

			if (list.get(i) <= B) {
				count += 1;
			} else {
				int temp = list.get(i) - B;
				count += 1;
				count += temp / C;
				if (temp % C != 0) {
					count += 1;
				}
			}
			v[i] = count;
			visited[i] = true;
		}
		// 다음번 노드
		else {
			int temp = list.get(i);
			int count = list.get(i) / C;
			if (temp % C != 0) {
				count += 1;
			}

			v[i] = count;
			visited[i] = true;
		}

		// 다음 노드부터
//		func(i + 1, 1);

		for (int j = 0; j < list.size(); j++) {
			if (!visited[j]) {
				func(j, 1, c + 1);
			}
		}

	}

}
