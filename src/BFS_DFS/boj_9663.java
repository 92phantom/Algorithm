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
		
		// N-Queen ������ ũ�Ⱑ N �� N�� ü���� ���� �� N���� ���� ������ �� ���� ���� �����̴�.

//		for (int i = 1; i <= N; i++) {
//			
////			sero = new int[SIZE];
			
			
			// 1�� i���� �� ��
//			sero[1] = i;
			// 1�� i���� �� ������ ������ ��� ã��, 1�� 2�� 3�� ~�� ��üũ
			func(sero, 1);
//		}

		System.out.println(ans);
	}

	static boolean valid(int[] sero, int garo) {
		
		
		for (int i = 1; i < garo; i++) {
			// ���� ������ ���� �� ����
			if (sero[i] == sero[garo]) {
				return false;
			}

			// �밢�� ó����
			if (Math.abs(i - garo) == Math.abs(sero[i] - sero[garo]))
				return false;

		}

		// �ǳ�
		return true;

	}

	static void func(int[] sero, int garo) {
		// �� � ���� üũ
		if (garo == N) {
			ans += 1;
		} else {
			for (int i = 1; i <= N; i++) {
				//���࿡ ������ ����?
				sero[garo + 1] = i;
				
				// ���࿡ ���� �� �ִ��� üũ�ϰ� �Ǹ� �ѱ�
				if(valid(sero, garo+1)) {
					func(sero, garo+1);
				}
			}
		}
	}

}
