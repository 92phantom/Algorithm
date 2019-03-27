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

			// i��° ������(1 �� i �� N) x��° �¼���(1 �� x �� 20) ����� �¿���.
			// �̹� ����� Ÿ�ִٸ� , �ƹ��� �ൿ�� ���� �ʴ´�.
			if (map[train][seat] != 1) {
				map[train][seat] = 1;
			}

		} else if (order == 2) {

			// i��° ������ x��° �¼��� ���� ����� �����Ѵ�.
			// ���� �ƹ��� ���ڸ��� �ɾ����� �ʾҴٸ�, �ƹ��� �ൿ�� ���� �ʴ´�.
			if (map[train][seat] == 1) {
				map[train][seat] = 0;
			}

		} else if (order == 3) {

			// i��° ������ �ɾ��ִ� �°����� ��� ��ĭ�� �ڷΰ���.
			// i��° ���� ����� i+1��°�� �̵��Ͽ� �ɴ´�.
			// ���� 20��° �ڸ��� ����� �ɾ��־��ٸ� �� ����� �� ��� �Ŀ� �����Ѵ�.

			map[train][20] = 0;

			for (int i = 19; i >= 1; i--) {
				map[train][i + 1] = map[train][i];
				map[train][i] = 0;
			}


		} else if (order == 4) {

			// i��° ������ �ɾ��ִ� �°����� ��� ��ĭ�� �����ΰ���.
			// i��° ���� ����� i-1 ��° �ڸ��� �̵��Ͽ� �ɴ´�.
			// ���� 1��° �ڸ��� ����� �ɾ��־��ٸ� �� ����� �� ��� �Ŀ� �����Ѵ�.

			map[train][1] = 0;
			for (int i = 2; i <= 20; i++) {

				map[train][i - 1] = map[train][i];
				map[train][i] = 0;
			}

		}

	}

	static void debug() {

		for (int i = 1; i <= N; i++) {
			System.out.println(i + "��° ����" + Arrays.toString(map[i]));
		}

	}

	static void check() {

		// ������ ������� �������� ������ ������ ��
		// �°��� ���� ���¸� ��Ͽ� ����ϸ�
		// �̹� ��Ͽ� �����ϴ� ����̶�� �ش� ������ ���ϼ��� �ǳ� �� ����.

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
