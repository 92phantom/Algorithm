package SAMSUNG_LASTDAY;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class boj_16235_Namu {

	static ArrayList<Integer>[][] NAMU = new ArrayList[11][11];
	static int[][] map = new int[11][11];
	static int[][] YANG = new int[11][11];
	static int N, M, K;

	static int[] dx = { 0, 0, -1, 1, 1, -1, -1, 1 };
	static int[] dy = { -1, 1, 0, 0, 1, -1, 1, -1 };

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken()); // �� ������
		M = Integer.parseInt(st.nextToken()); // ���� ���� ����
		K = Integer.parseInt(st.nextToken()); // K �� , �� ���

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= N; j++) {
				int input = Integer.parseInt(st.nextToken());
				YANG[i][j] = input;
				map[i][j] = 5;
			}
		}

		// ���� �� �ʱ�ȭ !
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				NAMU[i][j] = new ArrayList<>();
			}
		}

		// ���� ���� ����
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());

			NAMU[y][x].add(z);

		}

		// �� ��������.
		func();

	}

	static void func() {

		while (K != 0) {

			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					Collections.sort(NAMU[i][j], new Sorting());
				}
			}

			K--;
			/*
			 * ������ ������ �ڽ��� ���̸�ŭ ����� �԰�, ���̰� 1 �����Ѵ�. ������ ������ ������ �ִ� 1��1 ũ���� ĭ�� �ִ� ��и� ���� ��
			 * �ִ�. �ϳ��� ĭ�� ���� ���� ������ �ִٸ�, ���̰� � �������� ����� �Դ´�. ����, ���� ����� ������ �ڽ��� ���̸�ŭ ����� ����
			 * �� ���� ������ ����� ���� ���ϰ� ��� �״´�.
			 */
			ArrayList<Node> death = new ArrayList<>();
			ArrayList<Node> alive = new ArrayList<>();

			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					int size = NAMU[i][j].size();
					for (int k = 0; k < size; k++) {
						int val = NAMU[i][j].get(k).intValue();
						
						System.out.println("x"+ j);
						System.out.println("y"+ i);
						System.out.println("val"+ val);
						if (map[i][j] >= val) {
							map[i][j] -= val;
							alive.add(new Node(j, i, val + 1));
						} else {
							System.out.println("������?" + map[i][j]);
							death.add(new Node(j, i, val));
						}
					}
				}
			}

			/*
			 * �������� ���� ���� ������ ������� ���ϰ� �ȴ�. ������ ���� �������� ���̸� 2�� ���� ���� ������ �ִ� ĭ�� ������� �߰��ȴ�. �Ҽ���
			 * �Ʒ��� ������.
			 */

			for (int i = 0; i < death.size(); i++) {

				int x = death.get(i).x;
				int y = death.get(i).y;
				int val = death.get(i).val / 2;

				map[y][x] += val;

			}

			/*
			 * �������� ������ �����Ѵ�. �����ϴ� ������ ���̰� 5�� ����̾�� �ϸ�, ������ 8���� ĭ�� ���̰� 1�� ������ �����. � ĭ (r,
			 * c)�� ������ ĭ�� (r-1, c-1), (r-1, c), (r-1, c+1), (r, c-1), (r, c+1), (r+1, c-1),
			 * (r+1, c), (r+1, c+1) �̴�. ���� ���� ����� ĭ���� ������ ������ �ʴ´�.
			 * 
			 */

			int aliveSize = alive.size();

			for (int i = 0; i < aliveSize; i++) {
				if (alive.get(i).val % 5 == 0) {
					int x = alive.get(i).x;
					int y = alive.get(i).y;

					for (int j = 0; j < 8; j++) {
						int nextX = x + dx[i];
						int nextY = y + dy[i];

						if (check(nextX, nextY)) {
							alive.add(new Node(nextX, nextY, 1));
						}

					}
				}
			}

			/*
			 * 
			 * �ܿ￡�� S2D2�� ���� ���ƴٴϸ鼭 ���� ����� �߰��Ѵ�. �� ĭ�� �߰��Ǵ� ����� ���� A[r][c]�̰�, �Է����� �־�����.
			 * 
			 */

			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {

					map[i][j] += YANG[i][j];

				}
			}

			// ���� ����
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					NAMU[i][j] = new ArrayList<>();
				}
			}

			for (int i = 0; i < alive.size(); i++) {
				int y = alive.get(i).y;
				int x = alive.get(i).x;
				int val = alive.get(i).val;

				NAMU[y][x].add(val);
			}

			debug();

		}

		int ans = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				ans += NAMU[i][j].size();
			}
		}

		System.out.println(ans);
	}

	static void debug() {

		System.out.println("����");

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				System.out.println("x" + j + "y" + i + "��" + NAMU[i][j]);

			}
		}

	}

	static boolean check(int x, int y) {

		if (x < 0 || y < 0 || x >= N || y >= N) {
			return false;
		}

		return true;

	}

	static class Sorting implements Comparator<Integer> {
		@Override
		public int compare(Integer o1, Integer o2) {
			// TODO Auto-generated method stub

			if (o1 > o2) {
				return 1;
			} else if (o2 < o2) {
				return -1;
			} else {
				return 0;
			}
		}
	}

	static class Node {
		int x, y, val;

		Node(int x, int y, int val) {
			this.x = x;
			this.y = y;
			this.val = val;
		}
	}

}
