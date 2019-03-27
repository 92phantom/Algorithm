import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj_2580 {

	static int[][] map;
	static int curX, curY;
	static ArrayList<Node> list = new ArrayList<>();
	static boolean flag = false;

	static class Node {
		int x, y;

		Node(int x, int y) {
			this.x = x;
			this.y = y;

		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st;
		map = new int[10][10];
		for (int i = 1; i <= 9; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= 9; j++) {
				int temp = Integer.parseInt(st.nextToken());
				map[i][j] = temp;
				if (temp == 0) {
					list.add(new Node(j, i));
				}
			}
		}

		fill(0);

	}

	static void fill(int idx) {
		if (flag)
			return;

		if (idx == list.size()) {
//			System.out.println("여기안와?");
			// 출력
			for (int i = 1; i <= 9; i++) {
				for (int j = 1; j <= 9; j++) {
					System.out.print(map[i][j] + " ");
				}
				System.out.println();
			}
			flag = true;
		}

		else {
			int x = list.get(idx).x;
			int y = list.get(idx).y;

			for (int i = 1; i <= 9; i++) {
//				System.out.println("IDX" + idx);
//				System.out.println("val" + i);
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
