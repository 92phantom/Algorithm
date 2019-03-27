package BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_2146 {
	static int N;
	static int[][] map;
//	static int[][] copyMap;
	static boolean[][] visited;
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };

	static int ans = 0;
	static int MAX = 100;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];

		for (int i = 0; i < N; i++) {

			st = new StringTokenizer(br.readLine(), " ");

			for (int j = 0; j < N; j++) {
				int temp = Integer.parseInt(st.nextToken());
				map[i][j] = temp;
			}
		}

		//영역 표기
		
		int color = 1;
		
		for( int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j] != 0 && !visited[i][j]) {
					func(j, i, color++);
				}
			}
		}
		
		
		ans = Integer.MAX_VALUE;
		
		visited = new boolean[N][N];
		for (int i = 1; i <= color; i++) {
			ans = Math.min(ans, dist(i));
		}
		System.out.println(ans);
	}

	static int dist(int color) {

		Queue<Node> q = new LinkedList<>();

		for (int i = 0; i < N; i++) {

			for (int j = 0; j < N; j++) {
				if (map[i][j] == color) {
					visited[i][j] = true;
					q.add(new Node(j, i));
				}
			}
		}

		int result = 0;

		while (!q.isEmpty()) {

			int qSize = q.size();

			for (int i = 0; i < qSize; i++) {

				Node cur = q.poll();

				for (int j = 0; j < 4; j++) {
					int nextY = cur.y + dy[j];
					int nextX = cur.x + dx[j];

					if (0 <= nextY && nextY < N && 0 <= nextX && nextX < N) {

						if (map[nextY][nextX] != 0 && map[nextY][nextX] != color) {
							return result;
						}

						else if (map[nextY][nextX] == 0 && !visited[nextY][nextX]) {
							visited[nextY][nextX] = true;
							q.add(new Node(nextX, nextY));
						}

					}
				}

			}

			result++;
		}
		return Integer.MAX_VALUE;
	}

	static void func(int x, int y, int color) {
		visited[y][x] = true;
		map[y][x] = color;
		
		for(int i=0; i<4; i++) {
			int nextY = y+dy[i];
			int nextX = x+dx[i];
			
			if(nextX<0 || nextX>=N || nextY<0 || nextY>=N) continue;
			
			if(map[nextY][nextX]!=0 && !visited[nextY][nextX]) {
				func(nextX, nextY, color);
			}
		}
		
	}

	static class Node {
		int x, y, count;

		Node(int x, int y) {
			this.x = x;
			this.y = y;
//			this.count = count;
		}
	}
}
