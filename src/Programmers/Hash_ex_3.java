package Programmers;

import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class Hash_ex_3 {

	static ConcurrentHashMap<String, Integer> list = new ConcurrentHashMap<>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[][] input = { { "yellow_hat", "headgear" }, { "blue_sunglasses", "eyewear" },
				{ "green_turban", "headgear" } };
//		String[][] input = { { "crow_mask", "face" }, { "blue_sunglasses", "face" }, { "smoky_makeup", "face" } };

		solution(input);

	}

	static int solution(String[][] clothes) {

		int answer = 0;

		// 입력 Map에 넣어주기
		for (int i = 0; i < clothes.length; i++) {

			String kind = clothes[i][1];

			if (!list.keySet().contains(kind)) {
				list.put(kind, 2);
			} else {
				int temp = list.get(kind);
				list.replace(kind, temp + 1);
			}

		}

	
		answer = 1;
		
		Iterator<String> it = list.keySet().iterator();
		
		while(it.hasNext()) {
			String key = it.next();
			answer *= list.get(key);
			
		}

		return answer-1;

	}

}
