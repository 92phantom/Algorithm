package DynamicProgramming;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_1463 {

	static int[] memoization;
	static int N;
	static int ans = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		memoization = new int[10000001];

		memoization[0] = 0;
		memoization[1] = 0;
		memoization[2] = 1;
		memoization[3] = 1;

		if (N > 3) {

			for (int i = 4; i <= N; i++) {

				int temp = Integer.MAX_VALUE;

				temp = Math.min(temp, memoization[i - 1] + 1);

				if (i % 3 == 0) {

					temp = Math.min(temp, memoization[i / 3] + 1);

				}
				if (i % 2 == 0) {
					temp = Math.min(temp, memoization[i / 2] + 1);

				}

				memoization[i] = temp;
			}

			System.out.println(memoization[N]);

		} else
			System.out.println(memoization[N]);

	}

}
