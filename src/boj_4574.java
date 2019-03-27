import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj_4574 {

	static int N;
	static int[][] map;
	static ArrayList<Node> list;
	static boolean flag;
	static int tc = 1;

	static class Node {
		int x, y;

		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		while (true) {
			N = Integer.parseInt(br.readLine());
			list = new ArrayList<>();
			map = new int[10][10];
			flag = false;

			if (N == 0) {
				System.exit(0);
			} else {

				for (int i = 0; i < N; i++) {
					st = new StringTokenizer(br.readLine(), " ");

					// VALUE
					int U = Integer.parseInt(st.nextToken());
					// ÁÂÇ¥
					String LU = st.nextToken();

					int y = (int) (LU.charAt(0) - 'A') + 1;
					int x = Integer.parseInt(LU.charAt(1) + "");

					map[y][x] = U;

					int V = Integer.parseInt(st.nextToken());
					String LV = st.nextToken();

					y = (int) (LV.charAt(0) - 'A') + 1;
					x = Integer.parseInt(LV.charAt(1) + "");

					map[y][x] = V;

				}

				st = new StringTokenizer(br.readLine(), " ");
				for (int i = 1; i <= 9; i++) {
					String temp = st.nextToken();

					int y = (int) (temp.charAt(0) - 'A') + 1;
					int x = Integer.parseInt(temp.charAt(1) + "");

					map[y][x] = i;

				}

				for (int i = 1; i <= 9; i++) {
					for (int j = 1; j <= 9; j++) {
						if (map[i][j] == 0) {
							list.add(new Node(j, i));
						}
					}
				}

				fill(0);

			}
		}
	}

	static void fill(int idx) {
		if (flag)
			return;

		if (idx == list.size()) {

			System.out.println("Puzzle " + (tc++));
			// Ãâ·Â
			for (int i = 1; i <= 9; i++) {
				for (int j = 1; j <= 9; j++) {
					System.out.print(map[i][j] + "");
				}
				System.out.println();
			}
			flag = true;
		}

		else {
			int x = list.get(idx).x;
			int y = list.get(idx).y;

			for (int i = 1; i <= 9; i++) {
				if (isSafe(i, y, x)) {
					map[y][x] = i;
					fill(idx + 1);
					// back
					map[y][x] = 0;
				}
			}
		}
	}

	static boolean isSafe(int val, int y, int x) {

		if (checkY(y, val) && checkX(x, val) && checkBox(y, x, val)) {
			return true;
		}
		return false;
	}

	static boolean checkY(int y, int val) {

		for (int i = 1; i <= 9; i++) {
			if (map[y][i] == val) {
				return false;
			}
		}
		return true;
	}

	static boolean checkX(int x, int val) {
		for (int i = 1; i <= 9; i++) {
			if (map[i][x] == val) {
				return false;
			}
		}
		return true;
	}

	static boolean checkBox(int y, int x, int val) {
		int cY = ((int) Math.ceil(y / 3.0) - 1) * 3 + 1;
		int cX = ((int) Math.ceil(x / 3.0) - 1) * 3 + 1;

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (map[cY + i][cX + j] == val) {
					return false;
				}
			}
		}
		return true;
	}

}
