import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class boj_1941 {

	static char[][] map;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { 1, -1, 0, 0 };
	static boolean[][] visited;
	static boolean[] check;
	static int ans;
	static ArrayList<Integer> list = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		map = new char[5][5];

		ans = 0;

		for (int i = 0; i < 5; i++) {
			String temp = br.readLine();
			for (int j = 0; j < 5; j++) {
				map[i][j] = temp.charAt(j);
			}
		}

		// »Ì±â
		for (int i = 0; i < 25; i++) {

			visited = new boolean[5][5];
			check = new boolean[25];
			dfs(1, i, 0);

		}

		System.out.println(ans);
	}

	static void dfs(int count, int idx, int valid) {

		if (map[idx / 5][idx % 5] == 'S') {
			valid += 1;
		}

//		visited[idx / 5][idx % 5] = true;
		check[idx] = true;

		if (count == 7) {
//			System.out.println(list);

			if (valid >= 4) {

				int x = 0, y = 0;
				for (int i = 0; i < 25; i++) {
					if(check[i]) {
						x = i%5;
						y = i/5;
						break;
					}
				}

				System.out.println("x" + x);
				System.out.println("y" + y);

				if (check(x, y)) {
					ans += 1;
				}

			}
		}
		
		for (int i = idx; i < 25; i++) {
			
			if (!check[i]) {
				dfs(count + 1, i, valid);
			}

		}

//		visited[idx / 5][idx % 5] = false;
		check[idx] = false;

	}

	static boolean check(int x, int y) {

		
		for(int i=0; i<5; i++) {
			System.out.println(Arrays.toString(visited[i]));
		}
		
		Queue<Node> q = new LinkedList<>();

		boolean[][] aa = new boolean[5][5];

		q.add(new Node(x, y));
		aa[y][x] = true;

		int count = 0;

		while (!q.isEmpty()) {

			Node cur = q.poll();

			for (int i = 0; i < 4; i++) {

				int nextX = cur.x + dx[i];
				int nextY = cur.y + dy[i];

				if (nextX < 0 || nextY < 0 || nextY >= 5 || nextX >= 5)
					continue;

				if (aa[nextY][nextX])
					continue;

				else if (visited[nextY][nextX]) {
					count += 1;
					aa[nextY][nextX] = true;
					q.add(new Node(nextX, nextY));
				}

			}

		}

		System.out.println("count"+count);
		
		if (count >= 7) {
			return true;
		} else {
			return false;
		}

	}

	static class Node {
		int x, y;

		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

}
