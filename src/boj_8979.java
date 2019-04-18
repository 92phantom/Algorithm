import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.concurrent.ConcurrentHashMap;

public class boj_8979 {

	static int N, K;
	static int[][] map;
	static ArrayList<Nation> list = new ArrayList<>();
	static ConcurrentHashMap<Integer, Integer> out = new ConcurrentHashMap<>();

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken()); // ������ ��
		K = Integer.parseInt(st.nextToken()); // ����� �˰� ���� ����

		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int idx = Integer.parseInt(st.nextToken());
			int gold = Integer.parseInt(st.nextToken());
			int silver = Integer.parseInt(st.nextToken());
			int bronze = Integer.parseInt(st.nextToken());

			list.add(new Nation(idx, gold, silver, bronze, 1));

		}

		Collections.sort(list, new Sorting());

		calRank();
		
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).idx == K) {
				System.out.println(list.get(i).grade);
				break;
			}
		}

	}

	static void calRank() {
		for (int i = 1; i < list.size(); i++) {

			if (list.get(i).gold == list.get(i - 1).gold && list.get(i).silver == list.get(i - 1).silver
					&& list.get(i).bronze == list.get(i - 1).bronze) {

				list.get(i).grade = list.get(i - 1).grade;

			} else {
				list.get(i).grade = i + 1;
			}

		}
	}

	static class Sorting implements Comparator<Nation> {
		@Override
		public int compare(Nation o1, Nation o2) {
			// TODO Auto-generated method stub
			// �ݸ޴� ������ ���� ���
			if (o1.gold == o2.gold) {

				if (o1.silver == o2.silver) {
					if (o1.bronze == o2.bronze) {
						return 0;
					} else if (o1.bronze > o2.bronze) {
						return -1;
					} else if (o1.bronze < o2.bronze) {
						return 1;
					}
				} else {
					if (o1.silver > o2.silver) {
						return -1;
					} else if (o1.silver < o2.silver) {
						return 1;
					}
				}
			}

			else if (o1.gold > o2.gold) {
				return -1;
			} else if (o1.gold < o2.gold) {
				return 1;
			}

			return 0;
		}
	}

	static class Nation {
		int idx, gold, silver, bronze, grade;

		Nation(int idx, int gold, int silver, int bronze, int grade) {
			this.idx = idx;
			this.gold = gold;
			this.silver = silver;
			this.bronze = bronze;
//			this.same = same;
			this.grade = grade;
		}
	}

}
