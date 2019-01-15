package BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_6603 {

	static int K;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		while (true) {
			
			st = new StringTokenizer(br.readLine(), " ");
			K = Integer.parseInt(st.nextToken());

			if(K==0) return;
			
			int[] arr = new int[K];
			for (int i = 0; i < K; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			Arrays.sort(arr);
			
			int[] res = new int[6];
			
			doCombination(arr, K, 6, 0, 0, res);
			System.out.println();
		}


	}

	static void doCombination(int[] arr, int N, int R, int index, int target, int[] res) {

		if (R == 0) {
			// PRINT
			for (int i = 0; i < index; i++)
				System.out.print(arr[res[i]]+" ");
			System.out.println();
			return;
		} else if (target == N) {
			return;
		}

		res[index] = target;
		doCombination(arr, N, R - 1, index + 1, target + 1, res);
		doCombination(arr, N, R, index, target + 1, res);

	}
}
