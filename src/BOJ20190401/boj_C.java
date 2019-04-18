package BOJ20190401;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj_C {
	static int N, M;
	static int[][] map;
	static ArrayList<Node> chicken = new ArrayList<>();
	static ArrayList<Node> home = new ArrayList<>();
	static int ans = Integer.MAX_VALUE;

	static ArrayList<Node> pick = new ArrayList<>();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				int temp = Integer.parseInt(st.nextToken());
				map[i][j] = temp;
				if (temp == 2) {
					chicken.add(new Node(j, i));
				} else if (temp == 1) {
					home.add(new Node(j, i));
				}
			}
		}

		func(0, 0);

		System.out.println(ans);

	}

	static void func(int idx, int count) {

		if (count == M) {
			dis();
			return;
		}

		if (idx == chicken.size()) {
			return;
		}

		pick.add(chicken.get(idx));
		func(idx + 1, count + 1);
		pick.remove(pick.size() - 1);
		func(idx + 1, count);
		// °³¼ö »Ì±â
	}

	static void dis() {

		int result = 0;

		for (int i = 0; i < home.size(); i++) {

			int x = home.get(i).x;
			int y = home.get(i).y;
			int min = Integer.MAX_VALUE;

			for (int j = 0; j < pick.size(); j++) {

				int cX = pick.get(j).x;
				int cY = pick.get(j).y;

				int d = Math.abs(cX - x) + Math.abs(cY - y);

				min = Math.min(min, d);

			}
			result += min;
		}

		ans = Math.min(result, ans);

	}

	static class Node {

		int x, y;

		Node(int x, int y) {
			this.x = x;
			this.y = y;

		}

	}

}
