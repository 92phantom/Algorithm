package SamsungExpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class swea_2115 {

	static int T;
	static int N, M, C;
	static int[][] map;
	static boolean[][] visited;
	static boolean[] seVisited;
	static int ans = 0;
	static int seAns = 0;
	static int[] dx = { -1, 1 };

	static ArrayList<Node> saveMap = new ArrayList<>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		T = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < T; tc++) {

			st = new StringTokenizer(br.readLine(), " ");

			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			
			ans = 0;
			seAns = 0;
			map = new int[N][N];
			visited = new boolean[N][N];
			saveMap = new ArrayList<>();
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {

					map[i][j] = Integer.parseInt(st.nextToken());

				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					dfs(j, i);
				}
			}

			dfs2(0,0,0);
//			System.out.println("마지막점검" + seAns);

			System.out.println("#" + (tc + 1) + " " + seAns);
		}

	}

	static void dfs2(int idx, int sum, int cnt) {
		
		if(cnt == 2) {
			seAns = Math.max(seAns, sum);
			return;
		}
		
		if(idx >= saveMap.size()) return;
		
		int x = saveMap.get(idx).x;
		int y = saveMap.get(idx).y;
		
		boolean flag = false;
		
		for(int i=x; i<x+M; i++) {
			if(visited[y][i]) {
				flag = true;
				break;
			}
		}
		
		if(flag) {
			dfs2(idx+1, sum, cnt);
			return;
		}
		
		for(int i=x; i<x+M; i++) {
			visited[y][i] = true;
		}
		
		dfs2(idx+1, sum + saveMap.get(idx).value, cnt+1);
		
		for(int i=x; i<x+M; i++) {
			visited[y][i] = false;
		}
		
		dfs2(idx+1, sum, cnt);
	}
	
	static void select(int[] tempArr, int idx, int sum, int sSum) {
		
		if(idx == M) {
			ans = Math.max(ans, sSum);
			return;
		}
		
		if(sum+tempArr[idx] <= C) {
			select(tempArr, idx+1, sum+tempArr[idx], sSum+tempArr[idx]* tempArr[idx]);
		}
		
		select(tempArr, idx+1, sum, sSum);
		
	}

	static void dfs(int x, int y) {

		if (x + M > N) {
			return;
		}

		int[] tempArr = new int[M];

		int idx = 0;
		
		for (int i = x; i < x + M; i++) {
			tempArr[idx++] = map[y][i];
		}

		ans = 0;
		select(tempArr, 0, 0, 0);
		
		saveMap.add(new Node(ans, x, y));
	}

	static class Node {
		int value, x, y;

		Node(int value, int x, int y) {
			this.value = value;
			this.x = x;
			this.y = y;
		}
	}

}
