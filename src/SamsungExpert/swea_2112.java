package SamsungExpert;
/*
 * ���۽ð� 14:47
 * ����ð� 17:34
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_2112 {

	static int T;
	static int D, W, K;
	static int[][] map;
	static int ans;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {

			map = new int[13][20];
			ans = Integer.MAX_VALUE;
			st = new StringTokenizer(br.readLine(), " ");

			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			for (int i = 0; i < D; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < W; j++) {
					int temp = Integer.parseInt(st.nextToken());
					map[i][j] = temp;
				}
			}

			if (ans != 0) {
				func(0, 0);
			}
			
			System.out.println("#" + tc + " " + ans);

		}

	}

	static void checkFunc(int cnt) {
		
		for (int i = 0; i < W; i++) {
			// ���� �˻�
			int same = 1;

			for (int j = 0; j < D - 1; j++) {
				// �ش� �������� �˿� ���

				if (same >= K)
					break;

				if (map[j][i] == map[j + 1][i])
					same += 1;

				else
					same = 1;

			}
			if (same < K)
				return;
		}

		// ���� �˻� ���
		ans = Math.min(ans, cnt);
	}

	static void func(int count, int idx) {

		if (count >= ans) {
			return;
		}

		if (idx >= D) {
			checkFunc(count);
			return;
		}

		func(count, idx + 1);

		// �ʱ� ���� ����
		int[] copied = new int[20];
		for(int i=0; i< W; i++) {
			copied[i] = map[idx][i];
		}
		
		// A�� ä���
		for (int j = 0; j < W; j++) {
			map[idx][j] = 0;
		}
		func(count + 1, idx + 1);

		// B�� ä���
		for (int j = 0; j < W; j++) {
			map[idx][j] = 1;
		}
		func(count + 1, idx + 1);

		// ��Ʈ��ŷ
		for (int j = 0; j < W; j++) {
			map[idx][j] = copied[j];
		}
		

	}

}
