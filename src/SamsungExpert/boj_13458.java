package SamsungExpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_13458 {

	static int N, B, C; 
	static long cnt;
	static int[] A;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		A = new int[1000001];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < N; i++) {

			A[i] = Integer.parseInt(st.nextToken());

		}

		st = new StringTokenizer(br.readLine(), " ");

		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			++cnt;
			A[i] -= B;
			if (A[i] <= 0)
				continue;
			cnt += (A[i] % C == 0 ? A[i] / C : A[i] / C + 1);

		}

		System.out.println(cnt);
	}

}
