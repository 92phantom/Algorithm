package Programmers;

import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class Hash_ex_2 {

	static Set<String> list = ConcurrentHashMap.newKeySet();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] phone_book = { "119", "97674223", "1195524421" };
//		String[] phone_book = { "123", "456", "789" };
//		String[] phone_book = { "123", "12", "1235", "567", "88" };
//		String[] phone_book = { "113", "12340", "123440", "12345", "9" };

		System.out.println(solution(phone_book));

	}

	static boolean solution(String[] phone_book) {
		boolean answer = true;

		int shortSize = Integer.MAX_VALUE;

		for (int i = 0; i < phone_book.length; i++) {
			int temp = phone_book[i].length();

			shortSize = Math.min(temp, shortSize);

		}

		for (int i = 0; i < phone_book.length; i++) {

			String temp = phone_book[i];

			if (!list.contains(temp)) {

				int input = temp.length();

				for (String s : list) {

					int compare = s.length();

					if (input > compare) {
						String temp2 = temp.substring(0, compare);

						if (temp2.equals(s)) {
							return false;
						}

					} else {
						s = s.substring(0, input);

						if (temp.equals(s)) {
							return false;
						}
					}

				}

				list.add(temp);

			} else {

				return false;
			}

		}

		return answer;
	}

}
