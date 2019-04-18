package SAMSUNG_LASTDAY;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class boj_11559_Puyo {

	static char[][] map = new char[12][6];
	static boolean[][] v;

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < 12; i++) {
			String temp = br.readLine();
			for (int j = 0; j < 6; j++) {
				char input = temp.charAt(j);
				map[i][j] = input;
			}

		}

		int count = 0;

		while (true) {

			// ����
			Queue<Node> q = new LinkedList<>();
			for (int i = 0; i < 12; i++) {
				for (int j = 0; j < 6; j++) {
					if (map[i][j] != '.') {
						q.add(new Node(j, i, map[i][j]));
					}
				}
			}

			boolean flag = false;

			while (!q.isEmpty()) {

				// ���� �ִ� �� �ϳ��� ���¾��
				Node first = q.poll();

				ArrayList<Node> sameList = new ArrayList<>();
				Queue<Node> sameQ = new LinkedList<>();

				v = new boolean[12][6];

				sameList.add(first);
				sameQ.add(first);
				v[first.y][first.x] = true;

				// ���� ���� ��ã�ƿ�
				while (!sameQ.isEmpty()) {

					Node cur = sameQ.poll();

					for (int i = 0; i < 4; i++) {
						int nextX = cur.x + dx[i];
						int nextY = cur.y + dy[i];

						if (check(nextX, nextY, cur.color)) {
							sameList.add(new Node(nextX, nextY, map[nextY][nextX]));
							sameQ.add(new Node(nextX, nextY, map[nextY][nextX]));
							v[nextY][nextX] = true;
						}

					}
				}

				// ������ 4���׿�
				if (sameList.size() >= 4) {
					// ���� Ƚ�� �߰�~
					flag = true;

					// �μ�����
					for (int i = 0; i < sameList.size(); i++) {
						int x = sameList.get(i).x;
						int y = sameList.get(i).y;
						map[y][x] = '.';
					}

					debug("���������");
				}


			}

//			// �̵��ؾ���
//			// ����

			if (flag) {

				count += 1;

				for (int i = 0; i < 6; i++) {

					// ����
					Queue<Node> l = new LinkedList<>();

					for (int j = 11; j >= 0; j--) {
						// ���� �ִ� �͸� l�� �ֱ���
						if (map[j][i] != '.') {
							l.add(new Node(i, j, map[j][i]));
							map[j][i] = '.';
						}
					}

					// ���� �ִ� �� �ٴ����� ��������?
					int yStart = 11;
					while (!l.isEmpty()) {
						Node popOut = l.poll();
						map[yStart][i] = popOut.color;
						yStart--;
					}

				}
				
				debug("�̵��߾��");
			}
			else {
				break;
			}

		}

		System.out.println(count);
	}

	static void debug(String s) {
		System.out.println("=====" + s + "=======");
		for (int i = 0; i < 12; i++) {
			System.out.println(Arrays.toString(map[i]));
		}

	}

	static boolean check(int x, int y, char color) {

		if (x < 0 || y < 0 || x >= 6 || y >= 12 || color != map[y][x] || v[y][x]) {
			return false;
		}

		return true;

	}

	static class Node {

		int x, y;
		char color;

		Node(int x, int y, char color) {
			this.x = x;
			this.y = y;
			this.color = color;
		}

	}

}
