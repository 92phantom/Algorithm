package LINE_2019_TOP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;

public class LINE_2019_3 {

	static int N;

	static Set<String> paramName = ConcurrentHashMap.newKeySet();
	static ArrayList<String> lllist;
//	static ArrayList<String> list;
//	static ArrayList<String> list2;

	static ConcurrentHashMap<Integer, String> list = new ConcurrentHashMap<>();
	static ConcurrentHashMap<Integer, String> list2 = new ConcurrentHashMap<>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		lllist = new ArrayList<>();

		int paramCount = 0;

		for (int loop = 0; loop < 2; loop++) {

			N = Integer.parseInt(br.readLine());
//			list = new ArrayList<>();
//			list2 = new ArrayList<>();

			st = new StringTokenizer(br.readLine(), " ");

			int size = st.countTokens();

			int idIDXF = 0;
			int idIDXS = 0;

			for (int i = 0; i < size; i++) {

				String temp = st.nextToken();
//				System.out.println(temp);
				if (lllist.size() == 0) {
					lllist.add(temp);
				} else {
					for (int j = 0; j < lllist.size(); j++) {
						if (lllist.get(j).equals(temp)) {

						} else {
							lllist.add(temp);
						}
					}
				}
				paramName.add(temp);
				if (temp == "id" && loop == 0) {
					idIDXF = i;
				}
				if (temp == "id" && loop == 1) {
					idIDXS = i;
				}
			}

			for (int i = 1; i < N; i++) {

				String temp = br.readLine();

				String[] parser = temp.split(" ");

				if (loop == 0) {
					String putStr = "";
					for (int j = 0; j < parser.length; j++) {

						if (j == idIDXF) {

						} else {
							putStr += (parser[j] + " ");
						}

					}

					list.put(Integer.parseInt(parser[idIDXF]), putStr);

				} else if (loop == 1) {
					String putStr = "";
					for (int j = 0; j < parser.length; j++) {

						if (j == idIDXS) {

						} else {
							putStr += (parser[j] + " ");
						}

					}

					paramCount = parser.length - 1;

					int tempKey = Integer.parseInt(parser[idIDXS]);

					if (list.containsKey(tempKey)) {
						list2.put(tempKey, putStr);
					}
//
//					// 포함하지않을 경우
//					else {
//
//					}
//
//					list2.put(tempKey, putStr);

				}

			}
//
//			if (loop == 1) {
//				Iterator<Integer> it = list.keySet().iterator();
//
//				while (it.hasNext()) {
//					int key = it.next();
//					if (!list2.containsKey(key)) {
//						list.remove(key);
//					}
//				}
//			}
		}

		String p = paramName.toString();
		p = p.replaceAll(Pattern.quote("["), "");
		p = p.replaceAll(Pattern.quote("]"), "");
		p = p.replaceAll(Pattern.quote(" "), "");

		String[] paParser = p.split(",");
		
		for(int i=paParser.length-1; i>=0; i--) {
			System.out.print(paParser[i]+" ");
		}
		

//		System.out.println(lllist.size());
//		for (int i = 0; i < lllist.size(); i++) {
//			System.out.print(lllist.get(i) + " ");
//		}
		System.out.println();
//		System.out.println("---------");
		Iterator<Integer> it = list.keySet().iterator();

		while (it.hasNext()) {

			int key = it.next();

			System.out.print(key + " " + list.get(key));

			if (list2.containsKey(key)) {
				System.out.print(list2.get(key));

			} else {
				for (int i = 0; i < paramCount; i++) {
					System.out.print("NULL ");
				}

			}
			System.out.println();

		}

	}

}
