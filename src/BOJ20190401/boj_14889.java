package BOJ20190401;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj_14889 {
	static int N;
	static int[][] map = new int[21][21];
	static boolean[] v = new boolean[21];
	static int ans = Integer.MAX_VALUE;
	static ArrayList<Integer> pick = new ArrayList<>();
	static int total = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		StringTokenizer st;

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				total = total + map[i][j] + map[j][i];
			}
		}

		dfs(1, 0);

		System.out.println(ans);
	}

	static void dfs(int idx, int count) {

		if (count == N / 2) {

			int teamA = 0, teamB = 0;

//			ArrayList<Integer> unPick = new ArrayList<>();
//			for (int i = 1; i <= N; i++) {
//				if (!v[i]) {
//					unPick.add(i);
//				}
//			}

			for (int i = 0; i < pick.size(); i++) {
				for (int j = i + 1; j < pick.size(); j++) {
					teamA += map[pick.get(i)][pick.get(j)];
					teamA += map[pick.get(j)][pick.get(i)];
				}
			}

			teamB = total - teamA;
			
//			for (int i = 0; i < unPick.size(); i++) {
//				for (int j = i + 1; j < unPick.size(); j++) {
//					teamB += map[unPick.get(i)][unPick.get(j)];
//					teamB += map[unPick.get(j)][unPick.get(i)];
//				}
//			}

			int result = Math.abs(teamA - teamB);

			ans = Math.min(result, ans);
			return;
		}

		if (idx == N + 1) {
			return;
		}

		pick.add(idx);
		v[idx] = true;
		dfs(idx + 1, count + 1);
		pick.remove(pick.size() - 1);
		v[idx] = false;

		dfs(idx + 1, count);

	}

}
