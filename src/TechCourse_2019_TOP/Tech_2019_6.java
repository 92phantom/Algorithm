package TechCourse_2019_TOP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.concurrent.ConcurrentHashMap;

public class Tech_2019_6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] aa = { "woni request 09:12:29", "brown request 09:23:11", "brown leave 09:23:44",
				"jason request 09:33:51", "jun request 09:33:56", "cu request 09:34:02" };

		System.out.println(Arrays.toString(solution(10, aa)));
	}

	static ConcurrentHashMap<String, Boolean> map = new ConcurrentHashMap<>();
	
	static String[] solution(int totalTicket, String[] logs) {

		int hour, min, sec;

		StringTokenizer st;
		ArrayList<Client> client = new ArrayList<>();

		// 손님 리스트 저장
		for (int i = 0; i < logs.length; i++) {

			st = new StringTokenizer(logs[i], " ");

			String name = st.nextToken();
			String type = st.nextToken();

			String timeTable = st.nextToken();

			st = new StringTokenizer(timeTable, ":");

			hour = Integer.parseInt(st.nextToken());
			min = Integer.parseInt(st.nextToken());
			sec = Integer.parseInt(st.nextToken());

			map.put(name, true);
			
			client.add(new Client(name, type, (hour * 3600 + min * 60 + sec)));
		}

		// 입장 순서 대로 정렬
		Collections.sort(client, new Sorting());

		for (int i = client.size() - 1; i >= 0; i--) {

			String name = client.get(i).name;
			String type = client.get(i).type;
			long time = client.get(i).time;

			boolean flag = true;
			
			for (int j = (i-1); j >= 0; j--) {

				String nextName = client.get(j).name;
				String nextType = client.get(j).type;
				long nextTime = client.get(j).time;

				// 도중에 나갈 경우
				if (name.equals(nextName) && type.equals("leave")) {
					if (Math.abs(nextTime - time) < 60) {
						flag = false;
						break;
					}
				}

				// 내가 접속한 시간에 새로운 사람이 왔을 경우
				else {

					if (Math.abs(nextTime - time) < 60 && nextType.equals("request")) {
						flag = false;
						break;
					}

				}

			}
			
			if (!flag) {
				map.replace(name, false);
			}

		}
		
		Iterator<String> it = map.keySet().iterator();
		ArrayList<String> output = new ArrayList<>();

		while(it.hasNext()) {
			String key = it.next();
			if(map.get(key)) {
				output.add(key);
			}
		}
		
		Collections.sort(output);
		
		String[] returnArr = new String[output.size()];
		
		for(int i=0; i<output.size(); i++) {
			returnArr[i] = output.get(i);
		}
		
		return returnArr;
	}

	static class Sorting implements Comparator<Client> {
		@Override
		public int compare(Client o1, Client o2) {
			// TODO Auto-generated method stub
			if (o1.time < o2.time) {
				return -1;
			} else if (o1.time > o2.time) {
				return 1;
			} else {
				return 0;
			}
		}

	}

	static class Client {

		String name;
		String type;
		long time;

		Client(String name, String type, long time) {
			this.name = name;
			this.type = type;
			this.time = time;
		}

	}
}
