import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.concurrent.ConcurrentHashMap;

public class boj_15787 {

	static int N, M;
	static ArrayList<Order> list;
	static int[][] map;

	static final int MAX = 20;

	static int ans = 0;

	static Set<String> log = ConcurrentHashMap.newKeySet();

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N + 1][MAX + 1];

		list = new ArrayList<>();

		for (int i = 0; i < M; i++) {

			st = new StringTokenizer(br.readLine(), " ");

			int order, train, seat;

			if (st.countTokens() == 3) {
				order = Integer.parseInt(st.nextToken());
				train = Integer.parseInt(st.nextToken());
				seat = Integer.parseInt(st.nextToken());
			} else {
				order = Integer.parseInt(st.nextToken());
				train = Integer.parseInt(st.nextToken());
				seat = 0;
			}
			list.add(new Order(order, train, seat));
		}

		for (int i = 0; i < list.size(); i++) {
			func(i);
		}

		debug();
		check();

		System.out.println(log.size());

	}

	static void func(int idx) {

		Order cur = list.get(idx);

		int order = cur.order;
		int train = cur.train;
		int seat = cur.seat;
		if (order == 1) {

			// i번째 기차에(1 ≤ i ≤ N) x번째 좌석에(1 ≤ x ≤ 20) 사람을 태워라.
			// 이미 사람이 타있다면 , 아무런 행동을 하지 않는다.
			if (map[train][seat] != 1) {
				map[train][seat] = 1;
			}

		} else if (order == 2) {

			// i번째 기차에 x번째 좌석에 앉은 사람은 하차한다.
			// 만약 아무도 그자리에 앉아있지 않았다면, 아무런 행동을 하지 않는다.
			if (map[train][seat] == 1) {
				map[train][seat] = 0;
			}

		} else if (order == 3) {

			// i번째 기차에 앉아있는 승객들이 모두 한칸씩 뒤로간다.
			// i번째 앉은 사람은 i+1번째로 이동하여 앉는다.
			// 만약 20번째 자리에 사람이 앉아있었다면 그 사람은 이 명령 후에 하차한다.

			map[train][20] = 0;

			for (int i = 19; i >= 1; i--) {
				map[train][i + 1] = map[train][i];
				map[train][i] = 0;
			}


		} else if (order == 4) {

			// i번째 기차에 앉아있는 승객들이 모두 한칸씩 앞으로간다.
			// i번째 앉은 사람은 i-1 번째 자리로 이동하여 앉는다.
			// 만약 1번째 자리에 사람이 앉아있었다면 그 사람은 이 명령 후에 하차한다.

			map[train][1] = 0;
			for (int i = 2; i <= 20; i++) {

				map[train][i - 1] = map[train][i];
				map[train][i] = 0;
			}

		}

	}

	static void debug() {

		for (int i = 1; i <= N; i++) {
			System.out.println(i + "번째 열차" + Arrays.toString(map[i]));
		}

	}

	static void check() {

		// 기차는 순서대로 지나가며 기차가 지나갈 때
		// 승객이 앉은 상태를 목록에 기록하며
		// 이미 목록에 존재하는 기록이라면 해당 기차는 은하수를 건널 수 없다.

		for (int i = 1; i <= N; i++) {
			String logTemp = "";
			for (int j = 1; j <= MAX; j++) {

				logTemp+=map[i][j];
			}

//			System.out.println(logTemp);
//			
			if (!log.contains(logTemp)) {
//				System.out.println(logTemp);
				log.add(logTemp);
				ans += 1;
			}
		}

	}

	static class Order {
		int order, train, seat;

		Order(int order, int train, int seat) {
			this.order = order;
			this.train = train;
			this.seat = seat;
		}

	}

}
