package BOJ20190401;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class boj_A {

	static char[][] map;
	static final int SERO = 12;
	static final int GARO = 6;

	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	static ArrayList<Node> list = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		map = new char[SERO][GARO];

		for (int i = 0; i < SERO; i++) {
			String temp = br.readLine();
			for (int j = 0; j < GARO; j++) {
//				System.out.println(temp);
				char input = temp.charAt(j);
				map[i][j] = input;
				if (input != '.') {
					list.add(new Node(j, i, input));
				}
			}
		}

		func();

	}

	static void func() {

		int count = 0;

		while (true) {

			Queue<Node> q = new LinkedList<>();

			for (int i = 0; i < SERO; i++) {
				for (int j = 0; j < GARO; j++) {
					char temp = map[i][j];
					if (temp != '.') {
						q.add(new Node(j, i, map[i][j]));
					}
				}
			}
			


			int size = q.size();

			for (int i = 0; i < size; i++) {

				Node cur = q.poll();

				int x = cur.x;
				int y = cur.y;
				char cor = cur.color;

				int same = 1;
				boolean flag = false;

				
				ArrayList<Node> sameList = new ArrayList<>();
				Queue<Node> sameQ = new LinkedList<>();
				boolean[][] v = new boolean[SERO][GARO];

				sameList.add(new Node(x, y, cor));
				sameQ.add(new Node(x, y, cor));
				v[y][x] = true;

				while (!sameQ.isEmpty()) {

					Node n = sameQ.poll();

					for (int j = 0; j < 4; j++) {
						int nextX = x + dx[j];
						int nextY = y + dy[j];

						if (nextX < 0 || nextY < 0 || nextX >= GARO || nextY >= SERO)
							continue;

						if (v[nextY][nextX] || map[nextY][nextX] != cor) {
							continue;
						}

						same += 1;
						v[nextY][nextX] = true;
						sameQ.add(new Node(nextX, nextY, map[nextY][nextX]));
						sameList.add(new Node(nextX, nextY, map[nextY][nextX]));
					}
				}

				if (same >= 4) {
					flag = true;

					// ºÎ¼ö±â
					for (int j = 0; j < sameList.size(); j++) {
						int xx = sameList.get(j).x;
						int yy = sameList.get(j).y;
						map[yy][xx] = '.';
					}

				}
				
				if (!flag) {
					continue;
				}

				// »Ñ½Ã±â
				else if (flag) {

					System.out.println("°³¼ö" + count);
					// ¿¬¼â È½¼ö Áõ°¡
					count++;

					// ¸Ê ÀÌµ¿ÇÏ±â
					for (int j = 0; j < GARO; j++) {

						LinkedList<Node> l = new LinkedList<>();

						for (int k = (SERO - 1); k >= 0; k--) {
							if (map[k][j] != '.') {
								l.add(new Node(j, k, map[k][j]));
								map[k][j] = '.';
							}
						}

						int current = SERO - 1;
						int lSize = l.size();

						for (int k = 0; k < lSize; k++) {
							Node cc = l.poll();
							map[current][j] = cc.color;
							current--;
						}

					}

					for (int j = 0; j < SERO; j++) {
						for (int k = 0; k < GARO; k++) {
							if (map[i][j] != '.') {
								q.add(new Node(j, i, map[i][j]));
							}
						}
					}

				}

			}

			printDebug();



		}

		System.out.println(count);

	}

	static void printDebug() {

		for (int i = 0; i < SERO; i++) {
			System.out.println(Arrays.toString(map[i]));
		}

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
