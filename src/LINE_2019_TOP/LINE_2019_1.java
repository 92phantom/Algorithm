package LINE_2019_TOP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LINE_2019_1 {

	static long N, W, H;
	static long ans;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		ans = N;

		if (N < 4) {
			ans = N - 1;
		}

		else {
			for (int i = 1; i <= N / 2; i++) {

				long tempVal = i * (N / i);

				if (tempVal == N) {
					ans = Math.min(ans, Math.abs(tempVal));
				}
			}
		}

		System.out.println(ans);

	}

}
