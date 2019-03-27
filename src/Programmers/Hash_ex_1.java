package Programmers;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class Hash_ex_1 {

	static ConcurrentHashMap<String, Integer> list = new ConcurrentHashMap<>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] p = { "leo", "kiki", "eden" };
		String[] c = { "eden", "kiki" };

		System.out.println(solution(p, c));

	}

	static String solution(String[] participant, String[] completion) {

		for (int i = 0; i < participant.length; i++) {
			String temp = participant[i];
			if (list.keySet().contains(temp)) {
				int a = list.get(temp).intValue() + 1;
				list.replace(temp, a);
			} else {
				list.put(temp, 1);
			}
		}

		for (int i = 0; i < completion.length; i++) {
			String temp = completion[i];
			if (list.containsKey(temp)) {
				int a = list.get(temp).intValue() - 1;
				if (a == 0) {
					list.remove(temp);
				} else {
					list.replace(temp, a);
				}
			}
		}
		
		for(String a : list.keySet()) {
			return a;
		}
		return null;
		
	}

}
