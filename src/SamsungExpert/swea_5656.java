package SamsungExpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class swea_5656 {

	static int T, W, H;
	static int map[][];
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, -1, 0, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {

			st = new StringTokenizer(br.readLine(), " ");

			int N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());

			map = new int[H][W];
			int[][] dupMap = new int[H][W];

			for (int j = 0; j < H; j++) {

				st = new StringTokenizer(br.readLine(), " ");
				for (int k = 0; k < W; k++) {
					int val = Integer.parseInt(st.nextToken());
					map[j][k] = val;
					dupMap[j][k] = val;
				}

			}

			for (int j = 0; j < W; j++) {
				for (int k = 0; k < H; k++) {
					if (dupMap[k][j] > 0) {

						if (j == 2 && k == 1) {
							System.out.println(dupMap[k][j] + "x= " + j + "y= " + k);
							dfs(j, k, dupMap, N);

							break;

							
						}

					}
				}
			}

		}

	}

	static void dfs(int x, int y, int[][] dupMap, int count) {

		int size = dupMap[y][x];
		System.out.println("사이즈" + size);
		dupMap[y][x] = 0;

		for (int i = 1; i <= size; i++) {

			System.out.println("드러감?");
			
			for (int j = 0; j < 4; j++) {

				
				int nextX = x + i * dx[j];
				int nextY = y + i * dy[j];


				
				if (nextX < 0 || nextY < 0 || nextX > W || nextY > H || dupMap[nextY][nextX] == 0)
					continue;

				System.out.println("여기는?"+ nextX + " " + nextY);

				
				
				if (dupMap[nextY][nextX] == 1)
					dupMap[nextY][nextX] = 0;
				else if (dupMap[nextY][nextX] > 1)
					System.out.println("뭐함?");
				
				for(int k=0; k<H; k++)
					System.out.println(Arrays.toString(dupMap[k]));
				
				dfs(nextX, nextY, dupMap, count);
			}

		}

	}

}
