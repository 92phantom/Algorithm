package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj_11047 {

	static int N, K;
	static int ans = 0;
	static ArrayList<Integer> list = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			int temp = Integer.parseInt(br.readLine());
			if (temp <= K) {
				list.add(temp);
			}
		}

		check();
		
		System.out.println(ans);

	}

	static void check() {

		int size = list.size();

		for (int i = size - 1; i >= 0; i--) {

			if(K==0) {
				return;
			}
			
			if (K / list.get(i) > 0) {
				ans = ans + (K/list.get(i));
				K = K % list.get(i);
			} else if(K - list.get(i) >= 0) {
				ans += 1;
				K = K - list.get(i);
			}

		}

	}
}
