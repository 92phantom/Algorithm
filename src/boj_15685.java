import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj_15685 {

	static int N;

	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, -1, 0, 1 };

	static ArrayList<Integer> list;
	static boolean[][] visited;

	static int startX, startY;

	static int ans = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		visited = new boolean[101][101];

		for (int i = 0; i < N; i++) {

			int d, g;
			st = new StringTokenizer(br.readLine(), " ");

			startX = Integer.parseInt(st.nextToken());
			startY = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			g = Integer.parseInt(st.nextToken());

			list = new ArrayList<>();

			list.add(d);

			draw(0, g);
		}

		square();

		System.out.println(ans);

	}

	static void square() {

		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {

				if (visited[i][j] && visited[i + 1][j] && visited[i][j + 1] && visited[i + 1][j + 1]) {
					ans += 1;
				}
			}
		}

	}

	static void draw(int curG, int g) {

		if (curG == g) {
			check();
			return;
		}

		int start = list.size() - 1;

		for (int i = start; i >= 0; i--) {

			int next = (list.get(i) + 1) % 4;

			list.add(next);

		}

		draw(curG + 1, g);

	}

	static void check() {

		visited[startY][startX] = true;

		for (int i = 0; i < list.size(); i++) {

			startY += dy[list.get(i)];
			startX += dx[list.get(i)];

			visited[startY][startX] = true;

		}
	}

}
