package Programmers;

// 단어 변환
// 시작시간 18:30
// 종료시간 

public class DFS_BFS_ex_3 {

	static boolean[] visited;
	static String[] map;
	static String goal;
	static int ans = Integer.MAX_VALUE;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String begin = "hit";
		String target = "cog";

		String[] words = { "hot", "dot", "dog", "lot", "log" ,"cog"};

		System.out.println(solution(begin, target, words));
	}

	static int solution(String begin, String target, String[] words) {

		map = words.clone();
		goal = target;
		visited = new boolean[words.length];

		for (int i = 0; i < map.length; i++) {

			int count = 0;

			for (int j = 0; j < map[i].length(); j++) {

				if (begin.charAt(j) == map[i].charAt(j)) {
					count += 1;
				}

			}

			if (count == (map[i].length()-1)) {
//				System.out.println("시작"+map[i]);
				dfs(map[i], i, 1, map[i]);
			}

		}

		if(ans == Integer.MAX_VALUE) {
			ans = 0;
		}
		
		return ans;
	}

	static void dfs(String cur, int idx, int c, String s) {

		if (cur.equals(goal)) {
//			System.out.println(s);
			ans = Math.min(c, ans);
		} else {

			if (c >= ans) {
				return;
			}

			visited[idx] = true;

			for (int i = 0; i < map.length; i++) {

				if (!visited[i]) {

					int count = 0;

					for (int j = 0; j < map[i].length(); j++) {

						if (cur.charAt(j) == map[i].charAt(j)) {
							count += 1;
						}

					}

					if (count == (map[i].length()-1)) {
						dfs(map[i], i, c + 1, s+"->"+map[i]);
					}

				}
			}

			visited[idx] = false;

		}

	}

}
