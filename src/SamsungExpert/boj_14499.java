package SamsungExpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_14499 {

	static int N, M, x, y, K;
	static int[][] map, dice;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		dice = new int[4][3];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}


		st = new StringTokenizer(br.readLine(), " ");
		
		for (int i = 0; i < K; i++) {

			
			int direction = Integer.parseInt(st.nextToken());

			int nextX = x;
			int nextY = y;

			// 悼率
			if (direction == 1) {
				nextX += 1;
			}
			// 辑率
			else if (direction == 2) {
				nextX -= 1;
			}

			// 合率
			else if (direction == 3) {
				nextY -= 1;
			}

			// 巢率
			else if (direction == 4) {
				nextY += 1;
			}

			if (nextX < 0 || nextY < 0 || nextY >= N || nextX >= M)
				continue;

			else {
				x = nextX;
				y = nextY;

				String aa="";
				// 悼率
				if (direction == 1) {

					aa = "悼率";
					
					int temp = dice[1][0];
					dice[1][0] = dice[3][1];
					int temp2 = dice[1][1];
					dice[1][1] = temp;
					dice[1][2] = temp2;
					
					
					if(map[nextY][nextX] == 0){
						map[nextY][nextX] = dice[3][1];
						
					}
					else{
					dice[3][1] = map[nextY][nextX];
					}
				}
				// 辑率
				else if (direction == 2) {

					aa = "辑率";
					
					int temp = dice[1][2];						
					dice[1][2] = dice[3][1];
					int temp2 = dice[1][1];
					dice[1][1] = temp;
					dice[1][0] = temp2;
					
					if(map[nextY][nextX] == 0){
						map[nextY][nextX] = dice[3][1];
						
					}
					else{
					dice[3][1] = map[nextY][nextX];
					}
				}

				// 合率
				else if (direction == 3) {

					aa = "合率";
					
					int temp = dice[2][1];			
					dice[2][1] = dice[3][1];
					int temp2 = dice[1][1];
					dice[1][1] = temp;
					dice[0][1] = temp2;
					

					if(map[nextY][nextX] == 0){
						map[nextY][nextX] = dice[3][1];
						
					}
					else{
					dice[3][1] = map[nextY][nextX];
					}
				}

				// 巢率
				else if (direction == 4) {

					aa = "巢率";
					
					int temp = dice[0][1];
					dice[0][1] = dice[3][1];
					int temp2 = dice[1][1];
					dice[1][1] = temp;
					dice[2][1] = temp2;
					
					if(map[nextY][nextX] == 0){
						map[nextY][nextX] = dice[3][1];
						
					}
					else{
					dice[3][1] = map[nextY][nextX];
					}
				}

				
				System.out.println(aa+"===");
				for(int k=0; k<4; k++){
					System.out.println(Arrays.toString(dice[k]));
				}
			
				System.out.println(dice[1][1]);
				
			}
		}

	}

}
