// 누울 자리를 찾아라
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_1652 {

	static int N;
	static char[][] map;
	static boolean[][] visited;

	static int[] dx = { 1, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		map = new char[N][N];

		// 가로 세로 상관없음
		// 똑바로 연속해서 2칸 이상
		// 출력: "가로" "세로"
		for (int i = 0; i < N; i++) {
			String temp = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = temp.charAt(j);
			}
		}

		// 가로 확인
		int garo = 0;
		for (int i = 0; i < N; i++) {
			int count = 0;
			for (int j = 0; j < N; j++) {

				if (map[i][j] == '.') {
					count += 1;
				} else if (map[i][j] == 'X') {
					count = 0;
				}
				
				if (count == 2) {
					garo+=1;
				}
			}
			
		}

		int sero = 0;
		for (int i = 0; i < N; i++) {
			int count = 0;
			for (int j = 0; j < N; j++) {

				if (map[j][i] == '.') {
					count += 1;
				} else if (map[j][i] == 'X') {
					count = 0;
				}
				
				if (count == 2) {
					sero +=1;
				}
			}
			
		}

		
		System.out.println(garo+" "+sero);
	}

}
