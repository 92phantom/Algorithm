package Kakao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Kakao_2017_7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		String[] arr = { "08:00", "08:01", "08:02", "08:03" };
//		System.out.println(solution(1, 1, 5, arr));

		String[] arr1 = { "09:10", "09:09", "08:00" };
		solution(2, 10, 2, arr1);
//
//		String[] arr2 = { "09:00", "09:00", "09:00", "09:00" };
//		solution(2, 1, 2, arr2);
////
		String[] arr3 = { "00:01", "00:01", "00:01", "00:01", "00:01" };
		solution(1, 1, 5, arr3);
////
//		String[] arr4 = { "23:59" };
//		solution(1, 1, 1, arr4);
////
//		String[] arr5 = { "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59",
//				"23:59", "23:59", "23:59", "23:59", "23:59", "23:59" };
//		solution(10, 60, 45, arr5);

	}

	static String solution(int n, int t, int m, String[] timetable) {

		int hour, min;
		StringTokenizer st;
		ArrayList<Integer> crew = new ArrayList<>();

		// ũ�� ����Ʈ ����
		for (int i = 0; i < timetable.length; i++) {
			st = new StringTokenizer(timetable[i], ":");
			hour = Integer.parseInt(st.nextToken());
			min = Integer.parseInt(st.nextToken());
			crew.add(hour * 60 + min);
		}

		// ��߽ð��� ���� ũ�� ���� ����
		Collections.sort(crew);

		// ���� ���� �ð� ����
		ArrayList<Integer> bus = new ArrayList<>();

		// 9�ú��� Ž
		int busStart = 9 * 60;

		if (n != 0)
			bus.add(busStart);
		for (int i = 1; i < n; i++) {
			busStart += t;
			bus.add(busStart);
		}

		Collections.sort(bus);

		int ansTemp = 0;

		int takeCrew = 0;
		
		for (int i = 0; i < n; i++) {

			int maxCount = m;

			// Ÿ����
			while (takeCrew != crew.size()) {

				if (maxCount > 0 && crew.get(takeCrew) <= bus.get(i)) {
					maxCount -= 1;
					takeCrew += 1;
				} else {
					break;
				}

			}

			// ������
			if (i == n - 1) {

				// ���� �ֳ�
				if (maxCount > 0) {
					ansTemp = bus.get(i);
				}

				// ���� ���� �տ� ��� ����Ž
				else {
					ansTemp = crew.get(takeCrew - 1) - 1;
				}

			}
		}

		return format(ansTemp);

	}

	static String format(int ansTemp) {

		String answer = "";
		// �ð�
		if ((ansTemp / 60) == 0)
			answer += "00:";
		else if ((ansTemp / 60) < 10)
			answer += "0" + (ansTemp / 60) + ":";
		else
			answer += ansTemp / 60 + ":";

		// ��
		if ((ansTemp % 60) == 0)
			answer += "00";
		else if ((ansTemp % 60) < 10)
			answer += "0" + (ansTemp % 60) + "";
		else
			answer += ansTemp % 60 + "";

		System.out.println(answer);
		return answer;
	}

}
