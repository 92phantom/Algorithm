package moc6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_2468 {

	static int N, M, K;
	static int[][] map;
	static int ans = Integer.MAX_VALUE;
	
	static ArrayList<Node> cir = new ArrayList<>();
	static ArrayList<Integer> out = new ArrayList<>();

	static boolean[] v;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());

			cir.add(new Node(r, c, s));
		}
		v = new boolean[cir.size()];

		// K 모든 경우의 수
		func(0, 0);

		
		System.out.println(ans);
	}

	static void func(int idx, int count) {

		if (count == cir.size()) {

			go();

		} else {

			for (int i = 0; i < cir.size(); i++) {
				if (!v[i]) {
					v[i] = true;
					out.add(i);
					func(i, count + 1);
					v[i] = false;
					out.remove(out.size() - 1);
				}
			}
		}
	}

	static void go() {

		// 배열 카피
		int[][] dup = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				dup[i][j] = map[i][j];
			}
		}
		
		// 회전 수행
		for(int i=0; i<out.size(); i++) {
			
			int idx = out.get(i);
			Node cur = cir.get(idx);
			
			int topY = (cur.r - cur.s)-1;
			int topX = (cur.c - cur.s)-1;
			
			int btmY = (cur.r + cur.s)-1;
			int btmX = (cur.c + cur.s)-1;
			
			while(true) {
				
				if(topY == btmY && topX == btmX) break;
				
				ArrayList<Integer> copy = new ArrayList<>();
				
				// 맨윗줄
				for(int j=topX; j<btmX; j++) {
					copy.add(dup[topY][j]);
				}
				// 맨오른쪽줄
				for(int j=topY; j<btmY; j++) {
					copy.add(dup[j][btmX]);
				}
				// 맨 아랫줄
				for(int j=btmX; j>topX; j--) {
					copy.add(dup[btmY][j]);
				}
				// 맨 왼쪽줄
				for(int j=btmY; j>topY; j--) {
					copy.add(dup[j][topX]);
				}
				
//				System.out.println("copy"+copy);
//				print(dup);

				// 복사
				// 맨윗줄
				int cursor = 0;
				dup[topY][topX] = copy.get(copy.size()-1);
				
				for(int j=topX+1; j<btmX; j++) {
					dup[topY][j] = copy.get(cursor++);
				}
				// 맨오른쪽줄
				for(int j=topY; j<btmY; j++) {
					dup[j][btmX] = copy.get(cursor++);
				}
				// 맨 아랫줄
				for(int j=btmX; j>topX; j--) {
					dup[btmY][j] = copy.get(cursor++);
				}
				// 맨 왼쪽줄
				for(int j=btmY; j>topY; j--) {
					dup[j][topX] = copy.get(cursor++);
				}
				
//				print(dup);
				
				topY+=1;
				topX+=1;
				btmY-=1;
				btmX-=1;
			}
			
		}
		
		// 최소값 도출
		int minValue = Integer.MAX_VALUE;
		for(int i=0; i<N; i++) {
			int val = 0;
			for(int j=0; j<M; j++) {
				val += dup[i][j];
			}
			minValue = Math.min(val, minValue);
		}
		
		
		ans = Math.min(minValue, ans);
		
	}

	static void print(int[][] dup) {
		System.out.println("@@@@@@@@@@@@@");
		for(int i=0; i<N; i++) {
			System.out.println(Arrays.toString(dup[i]));
		}
	}
	
	static class Node {
		int r, c, s;

		Node(int r, int c, int s) {
			this.r = r;
			this.c = c;
			this.s = s;
		}
	}

}
