import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_14499 {

	static int N, M;
	static int diceX, diceY, order;
	static int[][] map;
	static int[] dice;

	static int[] dx = { 0, 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		diceY = Integer.parseInt(st.nextToken());
		diceX = Integer.parseInt(st.nextToken());
		order = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		dice = new int[7];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine(), " ");
		
		for (int i = 0; i < order; i++) {

			int dir = Integer.parseInt(st.nextToken());

			int nextX = dx[dir] + diceX;
			int nextY = dy[dir] + diceY;
			
			if(nextX >= 0 && nextY >= 0 && nextY < N && nextX < M) {
			
				move(dir);
				
				if(map[nextY][nextX] == 0) {
					map[nextY][nextX] = dice[6];
				} else {
					dice[6] = map[nextY][nextX];
					map[nextY][nextX] = 0;	
				}
				
				diceX = nextX;
				diceY = nextY;
				
				System.out.println(dice[1]);
				
			}
			
		}
	}

	static void move(int dir) {
		
		// 1 : 悼率
		// 2 : 辑率
		// 3 : 合率
		// 4 : 巢率

		int[] copy = dice.clone();

		if (dir == 1) {

			dice[1] = copy[4];
			dice[3] = copy[1];
			dice[4] = copy[6];
			dice[6] = copy[3];
			
		} else if (dir == 2) {

			dice[1] = copy[3];
			dice[3] = copy[6];
			dice[4] = copy[1];
			dice[6] = copy[4];
			
		} else if (dir == 3) {

			dice[1] = copy[5];
			dice[2] = copy[1];
			dice[5] = copy[6];
			dice[6] = copy[2];
			
		} else if (dir == 4) {
			
			dice[1] = copy[2];
			dice[2] = copy[6];
			dice[5] = copy[1];
			dice[6] = copy[5];
			
		}
	}

}
