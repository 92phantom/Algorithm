package Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_2933 {

	static int r, c, n;
	static char[][] map;
	static boolean[][] visited;
	static Queue<Node> q = new LinkedList<>();
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		map = new char[r][c];

		for (int i = 0; i < r; i++) {
			map[i] = br.readLine().toCharArray();
		}

		n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());

		System.out.println("시작!!");
		for (int j = 0; j < r; j++) {
			System.out.println(Arrays.toString(map[j]));
		}
		
		for (int i = 0; i < n; i++) {
			int row = r - Integer.parseInt(st.nextToken());

			System.out.println("ROW"+ row);
			// 미네랄 파괴
			broke(row, i);
			// 클러스터 내리
			solve();
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < r; i++) {
			sb.append(map[i]);
			sb.append("\n");
		}
		System.out.print(sb.toString());
	}

	static void solve() {
		visited = new boolean[r][c];
		ArrayList<Node> cluster = new ArrayList<>();

		// 땅에 붙어있는 클러스터 체크
		for (int j = 0; j < c; j++) {
			if (map[r - 1][j] == '.' || visited[r - 1][j])
				continue;

			visited[r - 1][j] =  true;
			q.add(new Node(r - 1, j));

			while (!q.isEmpty()) {
				Node cur = q.poll();

				for (int i = 0; i < 4; i++) {
					int nx = cur.x + dx[i];
					int ny = cur.y + dy[i];

					if (!isRange(nx, ny) || visited[nx][ny] || map[nx][ny] == '.')
						continue;

					visited[nx][ny] = true;
					q.add(new Node(nx, ny));
				}
			}
		}

		// 공중에 떠 있는 클러스터 찾기. (땅에서부터 시작해서 방문하지 못한 미네랄을 검색)
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (!visited[i][j] && map[i][j] == 'x') {
					map[i][j] = '.';
					cluster.add(new Node(i, j));
				}
			}
		}

		if (cluster.isEmpty()) {
			return;
		}

		// 얼마나 내릴 수 있는지 체크.
		boolean down = true;
		while (down) {
			for (Node node : cluster) {
				int nx = node.x + 1;
				int ny = node.y;

				if (!isRange(nx, ny) || map[nx][ny] == 'x') {
					down = false;
					break;
				}
			}
			if (down) {
				for (Node node : cluster) {
					node.x++;
				}
			}
		}

		// mark
		for (Node node : cluster) {
			map[node.x][node.y] = 'x';
		}
		
		
		System.out.println("클러스터 내렸다!");
		for (int j = 0; j < r; j++) {
			System.out.println(Arrays.toString(map[j]));
		}

	}

	static boolean isRange(int x, int y) {
		if (x < 0 || x >= r || y < 0 || y >= c)
			return false;
		return true;
	}

	static void broke(int row, int i) {
		if (i % 2 == 0) {
			for (int j = 0; j < c; j++) {
				if (map[row][j] == 'x') {
					map[row][j] = '.';
					break;
				}
			}
		} else {
			for (int j = c - 1; j >= 0; j--) {
				if (map[row][j] == 'x') {
					map[row][j] = '.';	
					break;
				}
			}
		}

		System.out.println("미네랄 부숨 ! ");
		for (int j = 0; j < r; j++) {
			System.out.println(Arrays.toString(map[j]));
		}

	}

}

class Node {
	int x;
	int y;

	Node(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
