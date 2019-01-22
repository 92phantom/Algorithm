package Combination;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 조합으로 풀면 시간 초과

public class boj_11053 {

	static int A, R;
	static int[] input;
	static int ans = 1;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		A = Integer.parseInt(br.readLine());
		input = new int[A];

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		boolean flag = true;
		int beforeNode = Integer.parseInt(st.nextToken());
		input[0] = beforeNode;
		for (int i = 1; i < A; i++) {
			input[i] = Integer.parseInt(st.nextToken());
			if (input[i] <= input[i - 1])
				flag = false;
		}

		int dp[] = new int[A];

		if (!flag) {

			for (int i = 0; i < A; i++) {
				dp[i] = 1;

				for (int j = 0; j < i; j++) {
					// dp[]의 값이 갱신되지 않았고, 검사점보다 이전 노드의 값이 클 경우에만 검사
					if (input[i] > input[j] && dp[i] <= dp[j]) {
						dp[i] += 1;
						ans = Math.max(ans, dp[i]);
					}
				}
			}
			System.out.println(ans);
			
		} else {
			System.out.println(A);
		}
	}

}
