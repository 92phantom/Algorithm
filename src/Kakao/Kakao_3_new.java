package Kakao;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class Kakao_3_new {

	static Set<Set<String>> map = ConcurrentHashMap.newKeySet();
	static String[][] global_relation;

	public static void main(String[] args) {

		String[][] test = { { "100", "ryan", "music", "2" }, { "200", "apeach", "math", "2" },
				{ "300", "tube", "computer", "3" }, { "400", "con", "computer", "4" }, { "500", "muzi", "music", "3" },
				{ "600", "apeach", "music", "2" } };

		solution(test);
	}

	static int solution(String[][] relation) {

		global_relation = relation;
		int attrCnt = relation[0].length;

		int[] combArr;
		for (int i = 1; i <= attrCnt; i++) {

			combArr = new int[i];
			doCombination(combArr, attrCnt, i, 0, 0);

		}

		return map.size();

	}

	static void doCombination(int[] combArr, int n, int r, int index, int target) {

		if (r == 0) {

			Set<String> keySet = new HashSet<>();

			for (int i = 0; i < index; i++) {

				keySet.add(combArr[i]+"");

			}

			if (validCheck(combArr)) {

				if (map.size() >= 1) {
					if (isContains(keySet)) {
						map.add(keySet);
					}

				} else {
					map.add(keySet);
				}
			}
		} else if (target == n) {

			return;

		} else {

			combArr[index] = target;
			doCombination(combArr, n, r - 1, index + 1, target + 1);
			doCombination(combArr, n, r, index, target + 1);

		}

	}

	static boolean isContains(Set<String> checkKey) {

		Iterator<Set<String>> it = map.iterator();


		while (it.hasNext()) {

			Set<String> key = it.next();

			if (checkKey.containsAll(key)) {
				return false;
			}
		}

		return true;

	}
	
	static boolean validCheck(int[] indexArr) {

		Set<String> keySet = new HashSet<>();

		for (int i = 0; i < global_relation.length; i++) {

			String keyTemp = "";

			if (indexArr.length > 1) {

				for (int j = 0; j < indexArr.length; j++) {

					keyTemp += global_relation[i][indexArr[j]] + " ";

				}

			} else {
				keyTemp += global_relation[i][indexArr[0]];
			}

			keySet.add(keyTemp);
		}

		return keySet.size() == global_relation.length ? true : false;

	}
}
