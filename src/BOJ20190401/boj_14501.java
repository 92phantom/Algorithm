package BOJ20190401;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_14501 {
	static int N;
	static Node[] list;
	static boolean[] v;
	static int ans = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());

		list = new Node[N + 1];
		v = new boolean[N + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int day = Integer.parseInt(st.nextToken());
			int price = Integer.parseInt(st.nextToken());

			list[i] = new Node(day, price);
		}

		for (int i = 1; i <= N; i++) {

			dfs(i, 0);

		}

		System.out.println(ans);

	}

	static void dfs(int cur, int price) {

		int next = cur + list[cur].day;

		if (next > N + 1) {
//			System.out.println(price);
			return;
		} else {
			
			price += list[cur].price;
			v[cur] = true;

			ans = Math.max(ans, price);

			for (int i = next; i <= N; i++) {
				if (i <= N + 1 && !v[i]) {
					dfs(i, price);
				}
			}

			v[cur] = false;
		}
	}

	static class Node {
		int day, price;

		Node(int day, int price) {
			this.day = day;
			this.price = price;
		}
	}

}
