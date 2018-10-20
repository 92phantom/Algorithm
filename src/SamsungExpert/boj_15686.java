package SamsungExpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_15686 {

	static int N, M;
	static int map[][];
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, -1, 0, 1 };
	static int DISTANCE_MIN = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1){
					
					dfs(new Point15686(j, i, M));
					
				}
			}
		}
		
		System.out.println(DISTANCE_MIN);

	}

	static void dfs(Point15686 p) {

		int tempMin = Integer.MAX_VALUE;
		
		for (int i = 0; i < N; i++) {

			for (int j = 0; j < N; j++) {

				if (map[i][j] == 2) {

					int disX = Math.abs(j - p.x);
					int disY = Math.abs(i - p.y);

					if(tempMin> (disX + disY)){
						tempMin = disX + disY;
					}
				}

			}

		}
		
		if(DISTANCE_MIN > tempMin)
			DISTANCE_MIN = tempMin;
		
		map[p.y][p.x] = 0;

	}

}

class Point15686 {

	int x, y, chick;

	Point15686(int x, int y, int chick) {
		this.x = x;
		this.y = y;
		this.chick = chick;
	}

}
