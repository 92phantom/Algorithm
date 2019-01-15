package DynamicProgramming;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_9095 {

	static int T, N;
	static int[] memoization;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());
		
		memoization = new int[12];
		memoization[1] = 1;
		memoization[2] = 2;
		memoization[3] = 4;
		memoization[4] = 7;
		memoization[7] = 44;
		
		for (int i = 5; i <= 11; i++) {

			memoization[i] = memoization[i - 3] + memoization[i - 2] + memoization[i - 1];
		}

		
		
		for (int i = 0; i < T; i++) {
			
			N = Integer.parseInt(br.readLine());
			System.out.println(memoization[N]);

		}


	}
}
