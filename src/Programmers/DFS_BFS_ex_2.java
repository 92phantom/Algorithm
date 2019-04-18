package Programmers;

// 타겟 넘버
// 시작시간 18:00
// 종료시간 18:26

public class DFS_BFS_ex_2 {
	static int[] map;
	static int goal;
	static int ans = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String[][] ti = { { "ICN", "SFO" }, { "ICN", "ATL" }, { "SFO", "ATL" }, { "ATL", "ICN" }, { "ATL", "SFO" } };
		int[] arr = { 1, 1, 1, 1, 1 };
		System.out.println(solution(arr, 3));
	}

	static int solution(int[] numbers, int target) {
		
		map = numbers.clone();
		goal = target;

		dfs(0, map[0], map[0] + "");
		dfs(0, -map[0], map[0] + "");

		return ans;
	}

	static void dfs(int idx, int result, String s) {

		if (idx == (map.length - 1)) {

			if (result == goal) {
				ans += 1;
				return;
			}

		} else {
			dfs(idx + 1, result + map[idx + 1], s + "+" + map[idx + 1]);
			dfs(idx + 1, result - map[idx + 1], s + "-" + map[idx + 1]);
		}

	}

}
