import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 그냥 DFS로 풀면 시간 초과가 남
 * 해결 방법: 체크판으로 생각해서 반으로 나누어 탐색해주면됨
 * 
 */

public class boj_1799 {

	static int N;
	static int[] ans = new int[2];
	static ArrayList<Node> list;
	static ArrayList<Node> blacklist;
	static boolean[][] visited;
	static int white;
	static int black;
	static int[] dx = { 1, -1, 1, -1 };
	static int[] dy = { 1, -1, -1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());

		list = new ArrayList<>();
		blacklist = new ArrayList<>();

		visited = new boolean[11][11];

		white = 0;
		black = 0;

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= N; j++) {

				int temp = Integer.parseInt(st.nextToken());

				if (temp == 1) {
					if (i % 2 == 0 && j % 2 == 0) {
						list.add(new Node(j, i, 1));

					} else if (i % 2 == 1 && j % 2 == 1) {
						list.add(new Node(j, i, 1));

					} else {
						blacklist.add(new Node(j, i, 0));
					}
				}
			}
		}
		if (list.size() > 0) {
			dfs(0, 0, list.get(0).color);

		}
		if (blacklist.size() > 0) {
			dfs2(0, 0, blacklist.get(0).color);
		}

		System.out.println(ans[0] + ans[1]);
	}

	static void dfs2(int idx, int cnt, int c) {


		if (idx == blacklist.size()) {
			ans[c] = Math.max(ans[c], cnt);
			return;
		}

		Node cur = blacklist.get(idx);
		int x = cur.x;
		int y = cur.y;
		
		if (check(x, y)) {
			visited[y][x] = true;
			dfs2(idx + 1, cnt + 1, c);
		}
		visited[y][x] = false;

		dfs2(idx + 1, cnt, c);

	}

	static void dfs(int idx, int cnt, int c) {

		if (ans[c] < cnt) {
			ans[c] = cnt;
		}

		if (idx == list.size()) {
			return;
		}

		Node cur = list.get(idx);
		int x = cur.x;
		int y = cur.y;

		if (check(x, y)) {
			visited[y][x] = true;
			dfs(idx + 1, cnt + 1, c);
		}
		visited[y][x] = false;

		dfs(idx + 1, cnt, c);

	}

	static boolean check(int x, int y) {

		for (int j = 1; j <= N; j++) {
			for (int i = 0; i < 4; i++) {
				int nextX = x + dx[i] * j;
				int nextY = y + dy[i] * j;

				// 범위 조건 만족할 때
				if (nextX >= 0 && nextY >= 0 && nextX <= N && nextY <= N) {
					if (visited[nextY][nextX]) {						
						return false;
					}
				}

			}
		}

		return true;
	}

	static class Node {

		int x, y, color;

		Node(int x, int y, int color) {
			this.x = x;
			this.y = y;
			this.color = color;
		}

	}
}
