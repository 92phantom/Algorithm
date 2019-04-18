package Programmers;

// 시작시간 17:00
// 종료시간 
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class DFS_BFS_ex_1 {
	static ConcurrentHashMap<String, Integer> map;
	static ArrayList<String>[] list;
	static int idx = 0;
	static boolean[] visited;
	static int GOAL = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String[][] ti = { { "ICN", "SFO" }, { "ICN", "ATL" }, { "SFO", "ATL" }, { "ATL", "ICN" }, { "ATL", "SFO" } };
		String[][] ti = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
		System.out.println(solution(ti));
	}

	static String[] solution(String[][] tickets) {
		String[] answer = {};

		GOAL = tickets.length + 1;
		map = new ConcurrentHashMap<String, Integer>();
		list = new ArrayList[20000];
		for (int i = 0; i < list.length; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < tickets.length; i++) {

			if (!map.containsKey(tickets[i][0])) {
				map.put(tickets[i][0], idx);
				list[idx].add(tickets[i][1]);
				idx += 1;

			} else {
				int getIdx = map.get(tickets[i][0]).intValue();
				list[getIdx].add(tickets[i][1]);
				Collections.sort(list[getIdx]);
			}

		}

		String key = "ICN";
		int index = map.get(key).intValue();
		System.out.println("출발지" + key);
//			System.out.println(index);
		System.out.println(list[index]);
		visited = new boolean[idx + 1];

		int size = list[index].size();

		for (int i = 0; i < size; i++) {

			String dest = list[index].get(i);
			int val = map.get(dest).intValue();
			System.out.println("목적지" + dest);

			list[index].remove(0);
			dfs(dest, val, key + "," + dest, 1);
			list[index].add(dest);
			Collections.sort(list[index]);
		}

		return answer;
	}

	static void dfs(String dest, int idx, String s, int count) {

		if (count == GOAL-1) {
			System.out.println(s);
		}

		visited[idx] = true;
		int index = map.get(dest).intValue();

		for (int i = 0; i < list[index].size(); i++) {

			String next = list[index].get(i);

			int nextIdx = map.get(next).intValue();

			System.out.println("현재" + dest);
			System.out.println("다음" + next);
			System.out.println(count);
			System.out.println("제거"+ list[index].get(0));
			if(list[index].size()>1) {
			list[index].remove(0);
			}
			dfs(next, nextIdx, s + "," + next, count + 1);
			
			list[index].add(next);
			Collections.sort(list[index]);
		}

	}

}
