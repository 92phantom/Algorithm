package SamsungExpert;

import java.util.Arrays;

public class moc_2 {

	static int visited[];
	static int[] map;
	static boolean flag = false;
	static int ans = 1;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int l = 15;
		int[] v = { 15, 5, 3, 7, 9, 14, 0 };
//		int l = 5;
//		int[] v = { 2,5 };

		solution(l, v);
	}

	static int solution(int l, int[] v) {

		map = v;

		for (int i = 1; i <= l; i++) {
			dfs(i, l);

			if (flag) {
				break;
			}
		}

		System.out.println(ans);

		return ans;

	}

	static void dfs(int distance, int l) {

		visited = new int[l + 1];

		for (int i = 0; i < map.length; i++) {

			visited[map[i]] = visited[map[i]] + 2;

			for (int j = 1; j <= distance; j++) {

				int next = map[i] + j, prev = map[i] - j;

				if (j == distance) {
					if (next < l + 1) {
						visited[next] = visited[next] + 1;
					}
					if (prev >= 0) {
						visited[prev] = visited[prev] + 1;
					}
				} else {
					if (next < l + 1) {
						visited[next] = visited[next] + 2;
					}
					if (prev >= 0) {
						visited[prev] = visited[prev] + 2;
					}
				}

				System.out.println("DISTANCE" + distance);
				System.out.println(Arrays.toString(visited));

			}

		}
		System.out.println("===============");
		System.out.println("END" + distance);
		System.out.println(Arrays.toString(visited));
		System.out.println("===============");

		for (int i = 0; i < visited.length; i++) {

			if (i == 0) {
				if (visited[i] < 1) {
					flag = false;
					return;

				}
			} else {
				if (visited[i] < 2) {
					flag = false;
					return;
				}
			}
			ans = distance;
			flag = true;

		}

	}
}
