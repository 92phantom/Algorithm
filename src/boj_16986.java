import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.concurrent.ConcurrentHashMap;

public class boj_16986 {

	static int N, K;
	static int[][] map;
	static ArrayList<Integer> list;
	static ArrayList<Integer> minho;

	static int[][] chalMap;

	static boolean win = false;

	static boolean[] visited;

	static Set<ArrayList<Integer>> key = ConcurrentHashMap.newKeySet();
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		list = new ArrayList<>();
		minho = new ArrayList<>();
		map = new int[N][N];
		chalMap = new int[3][20];
		visited = new boolean[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < 20; i++) {
			chalMap[1][i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < 20; i++) {
			chalMap[2][i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i <= N; i++) {
			visited[i - 1] = true;
			list.add(i);
			func(i, 1);
			list.remove(list.size()-1);
			visited[i - 1] = false;
		}

		// 출력 조건
		// 지우가 우승 가능할까?
		// 우승 가능하면 1
		if (win) {
			System.out.println("1");
		}
		// 우승 불가능 0
		else {
			System.out.println("0");
		}

	}

	static void func(int motion, int count) {

		if (list.size() == 20 && !key.contains(list)) {

			key.add(list);
			
			System.out.println(list);
//			for (int i = 0; i < 20; i++) {
//				chalMap[0][i] = Integer.parseInt(s.charAt(i) + "");
//			}
//
//			if (check()) {
//				win = true;
//				return;
//			}
		}
		else if(list.size()== 20 && key.contains(list)){
			return;
		}

		for (int i = (motion + 1) % 3; i <= N; i++) {

			if (motion != i) {
				list.add(i);
				func(i, count + 1);

			}
		}
		
		list.remove(list.size() - 1);

	}

	static boolean check() {

		int winCount = 0;

		int winner = 0;
		int challenger = 1;
		// 0 - 지우
		// 1 - 경희
		// 2 - 민호

		// 조건 1) 경기 순서: 지우 - 경희 - 민호
		// 조건 2) 이전 라운드의 결과와 무관하게
		// 지우와 경희가 같은 손동작을 냈으면 경희의 승리이고,
		// 지우와 민호가 같은 손동작을 냈으면 민호의 승리이고,
		// 경희와 민호가 같은 손동작을 냈으면 민호의 승리이다.
		// 2 = 이긴다 1 = 비긴다 0 = 진다
		for (int i = 0; i < 20; i++) {

			int winnerWhat;
			int challengerWhat;

			winnerWhat = chalMap[winner][i] - 1;
			challengerWhat = chalMap[challenger][i] - 1;

			if (map[winnerWhat][challengerWhat] == 0) {
				winner = challenger;
				challenger = (challenger + 1) % 3;
			}

			else if (map[winnerWhat][challengerWhat] == 1) {

				if (winner == 0 && challenger == 1) {
					winner = 1;
					challenger = 2;
				} else if (winner == 0 && challenger == 2) {
					winner = 2;
					challenger = 1;
				} else if (winner == 1 && challenger == 2) {
					winner = 2;
					challenger = 0;
				} else if (winner == 2 && challenger == 1) {
					winner = 1;
					challenger = 0;
				}

			}

			// 이긴다
			else if (map[winnerWhat][challengerWhat] == 2) {
				challenger = (challenger + 1) % 3;
				if (winner == 0) {
					winCount += 1;
				}
			}

			if (winCount >= K) {
				return true;
			}
		}

		return false;
	}

}
