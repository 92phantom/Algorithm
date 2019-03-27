// 수들의 합

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2003 {

	static int N, M;
	static int map[];

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N];
		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < N; i++) {
			map[i] = Integer.parseInt(st.nextToken());
		}

		int left = 0, right = 0;

		int count = 0;
		int result = 0;
		while (true) {

			
			if (result >= M) {
				result -= map[right];
				right += 1;
			} else if (left == N) {
				break;
			} else {
				result += map[left];
				left += 1;
			}

			if (result == M) {
				count += 1;
			}

		}

		System.out.println(count);
	}

}
