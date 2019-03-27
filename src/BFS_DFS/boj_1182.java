package BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj_1182 {

	static int N, S;
	static ArrayList<Integer> list;
	static int ans;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		ans = 0;
		list = new ArrayList<>();

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {

			int temp = Integer.parseInt(st.nextToken());
			list.add(temp);
		}

		dfs(0, 0, 0);
		
		System.out.println(ans);
	}

	static void dfs(int idx, int sum, int length) {

		if (idx == N) {

			if (sum == S && length != 0) {
				ans++;
			}

			return;

		}

		dfs(idx + 1, sum + list.get(idx), length + 1);
		dfs(idx + 1, sum, length);

		return;
	}

}
