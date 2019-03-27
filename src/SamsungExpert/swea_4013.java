package SamsungExpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class swea_4013 {
	static int k;
	static int[][] arr;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		for (int i = 1; i <= tc; i++) {
			arr = new int[4][8];
			k = Integer.parseInt(br.readLine());
			for (int j = 0; j < 4; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < 8; k++)
					arr[j][k] = Integer.parseInt(st.nextToken());
			}
			for (int j = 0; j < k; j++) {
				// 1�ð� -1 �ݽð�
				st = new StringTokenizer(br.readLine());
				int num = Integer.parseInt(st.nextToken());
				int rotate = Integer.parseInt(st.nextToken());
				solve(num - 1, rotate);
			}
			// ���� ���
			int result = 0;
			for (int j = 0; j < 4; j++)
				if (arr[j][0] == 1)
					result += Math.pow(2, j);
			sb.append("#" + i + " " + result + "\n");
		}
		System.out.print(sb);
	}

	private static void solve(int num, int rotate) {
		Queue<Pair> queue = new LinkedList<>();
		queue.add(new Pair(num, rotate));
		boolean[] visited = new boolean[4];
		visited[num] = true;
		while (!queue.isEmpty()) {
			Pair t = queue.poll();
			// 3�� -> 2 , 9�� -> 6
			// ���� üũ
			if (t.num - 1 >= 0) {
				// �����̴� �� 6���� ���� 2���� ��
				if (arr[t.num][6] != arr[t.num - 1][2] && !visited[t.num - 1]) {
					queue.add(new Pair(t.num - 1, t.rotate * -1));
					visited[t.num - 1] = true;
				}
			}
			// ������ üũ
			if (t.num + 1 < 4) {
				// �������̴� �� 2���� ���� 6���� ��
				if (arr[t.num][2] != arr[t.num + 1][6] && !visited[t.num + 1]) {
					queue.add(new Pair(t.num + 1, t.rotate * -1));
					visited[t.num + 1] = true;
				}
			}
			rotate(t.num, t.rotate);
		}
	}

	private static void rotate(int num, int rotate) {
		int t = 0;
		switch (rotate) {
		case 1: // �ð�
			t = arr[num][7];
			for (int i = 7; i > 0; i--)
				arr[num][i] = arr[num][i - 1];
			arr[num][0] = t;
			break;
		case -1: // �� �ð�
			t = arr[num][0];
			for (int i = 0; i < 7; i++)
				arr[num][i] = arr[num][i + 1];
			arr[num][7] = t;
			break;
		}
	}

	static class Pair {
		private int num, rotate;

		public Pair(int num, int rotate) {
			this.num = num;
			this.rotate = rotate;
		}
	}
	
}
