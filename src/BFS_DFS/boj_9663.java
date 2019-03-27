package BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_9663 {

	static final int SIZE = 15;
	static int N;
	static int[] sero;
	static int ans;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		ans = 0;
		
		// N-Queen 문제는 크기가 N × N인 체스판 위에 퀸 N개를 서로 공격할 수 없게 놓는 문제이다.

//		for (int i = 1; i <= N; i++) {
//			
////			sero = new int[SIZE];
			
			
			// 1행 i열에 퀸 둠
//			sero[1] = i;
			// 1행 i열에 퀸 놓으면 가능한 경우 찾기, 1열 2열 3열 ~쭉 다체크
			func(sero, 1);
//		}

		System.out.println(ans);
	}

	static boolean valid(int[] sero, int garo) {
		
		
		for (int i = 1; i < garo; i++) {
			// 같은 세로임 놓을 수 없음
			if (sero[i] == sero[garo]) {
				return false;
			}

			// 대각선 처리요
			if (Math.abs(i - garo) == Math.abs(sero[i] - sero[garo]))
				return false;

		}

		// 되네
		return true;

	}

	static void func(int[] sero, int garo) {
		// 됨 몇개 인지 체크
		if (garo == N) {
			ans += 1;
		} else {
			for (int i = 1; i <= N; i++) {
				//담행에 놓을수 있음?
				sero[garo + 1] = i;
				
				// 담행에 놓을 수 있는지 체크하고 되면 넘김
				if(valid(sero, garo+1)) {
					func(sero, garo+1);
				}
			}
		}
	}

}
