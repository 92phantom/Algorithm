package Kakao;

import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.concurrent.ConcurrentHashMap;

public class Kakao_1 {

	static ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] data = { "Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo",
				"Change uid4567 Ryan", "Enter uid4567 Ryan", "Change uid1234 Muzi" };
		
		String[] result = solution(data);
		
		for(int i=0; i<result.length; i++){
			
			System.out.println(result[i]);
			
		}
		
		
	}

	static String[] solution(String[] data) {

		int arrSize = data.length;

		for (int i = 0; i < data.length; i++) {

			if (data[i].contains("Change")) {
				arrSize -= 1;
			}

		}
		
		
		String[] ans = new String[arrSize];

		int pointer = 0;
		
		for (int i = 0; i < data.length; i++) {
			StringTokenizer st = new StringTokenizer(data[i], " ");

			String sort = st.nextToken();
			String id = st.nextToken();

			if (sort.matches("Enter|Change")) {
				
				String name = st.nextToken();

				if (sort.contains("Enter")) {
					ans[pointer] = id + " 들어왔습니다.";
					pointer += 1;
					map.put(id, name);

				} else {
						
					map.replace(id, name);
					
				}
				

			} else if (sort.contains("Leave")) {
				
				ans[pointer] = id + " 나갔습니다.";				
				pointer += 1;
				
			}

		}

		
		
		for(int i=0; i<ans.length; i++){
			
			String temp = ans[i].split(" ")[0];
			if(map.containsKey(temp)){
				
				ans[i] = ans[i].replaceAll(temp, map.get(temp)+"님이");
				
			}
			
		}
		
		return ans;
	}

}
