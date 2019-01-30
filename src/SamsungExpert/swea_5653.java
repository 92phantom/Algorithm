package SamsungExpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class swea_5653 {

	static int T; // TEST CASE
	static int N, M, K;
	static ArrayList<Pivot> list = new ArrayList<>();
	static ArrayList<Pivot> BLOCKlist = new ArrayList<>();
	static Set<BLOCK> block = new HashSet<>();

	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { 1, -1, 0, 0 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());
		StringTokenizer st;

		// TEST CASE LOOP
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			// BUILD MAP
			for (int j = 0; j < N; j++) {

				st = new StringTokenizer(br.readLine(), " ");

				for (int k = 0; k < M; k++) {
					int val = Integer.parseInt(st.nextToken());

					if (val == 0) {
						block.add(new BLOCK(k, j));
//						BLOCKlist.add(new Pivot(k, j, 0, 0, 0));
					} else {
						list.add(new Pivot(k, j, val, val));
					}
				}

			}

		}

	}

	static void dfs() {

		for (int i = 0; i < list.size(); i++) {

			Pivot p = list.get(i);

			int val = p.current - 1;

			if (val == -1) {

				for (int j = 0; j < 4; j++) {

					int nextX = p.x + dx[j];
					int nextY = p.y + dy[j];

					// 0인 곳일 떄
					if(block.contains(new BLOCK(nextX, nextY))) continue;
					
					// 0이 아닌 곳 일 때, 
					else {
						
						// 현재 값 죽은 것으로 -1이하는 죽은것으로
						p.setCurrent(val-1);
						
						// 새로운 노드 추가
						
						list.add(new Pivot(nextX, nextY, p.init, p.init));
						
					}
					
				}

			}

		}

	}

//
//	static void bfs() {
//
//		while (!list.isEmpty()) {
//
//			Pivot cur = list.poll();
//
//			int val = cur.current-1;
//			
//			// 확장 할 수 있을 때
//			if(val == -1) {
//				for(int i=0; i<4; i++) {
//					
//					int nextX = cur.x+dx[i];
//					int nextY = cur.y+dy[i];
//					
//					
//					
//					list.add(new Pivot(cur.x, cur.y, cur.init, cur.current, cur.count+1));
//
//				}
//			}
//			// 확장하지 못할 때
//			else {
//				
//				
//				
//				list.add(new Pivot(cur.x, cur.y, cur.init, cur.current, cur.count+1));
//
//			}
//			
//			
//		}
//
//	}

	static class BLOCK {
		int x, y;

		BLOCK(int x, int y) {
			this.x = x;
			this.y = y;

		}
	}

	static class Pivot {

		int x, y, init, current, count;

		Pivot(int x, int y, int init, int current) {

			this.x = x;
			this.y = y;
			this.init = init;
			this.current = current;
//			this.count = count;

		}

		public int getX() {
			return x;
		}

		public void setX(int x) {
			this.x = x;
		}

		public int getY() {
			return y;
		}

		public void setY(int y) {
			this.y = y;
		}

		public int getInit() {
			return init;
		}

		public void setInit(int init) {
			this.init = init;
		}

		public int getCurrent() {
			return current;
		}

		public void setCurrent(int current) {
			this.current = current;
		}

		public int getCount() {
			return count;
		}

		public void setCount(int count) {
			this.count = count;
		}
		
		

	}

}
