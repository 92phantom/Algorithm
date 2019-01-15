package Kakao;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.concurrent.ConcurrentHashMap;

public class Kakao_1 {

	public static ConcurrentHashMap<String, Info> map = new ConcurrentHashMap<String, Info>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] input = new String[5];
		input[0] = "Enter uid1234 Muzi";
		input[1] = "Enter uid4567 Prodo";
		input[2] = "Leave uid1234";
		input[3] = "Enter uid1234 Prodo";
		input[4] = "Change uid4567 Ryan";

		solution(input);
		
	}

	static String[] solution(String[] record) {

		ArrayList<String> arList = new ArrayList<String>();

		StringTokenizer st;

		// STORE TO ARR(answer)
		for (int i = 0; i < record.length; i++) {

			st = new StringTokenizer(record[i], " ");

			String status = st.nextToken();
			String id = st.nextToken();

			if (status.matches("Enter|Change")) {

				String nickName = st.nextToken();
				map.put(id, new Info(nickName, status));

				if (status.equals("Enter")) {
					arList.add(id + "_님이 들어왔습니다.");
				}

				else if (status.equals("Change")) {
					
					// ID -> Nickname 변경
					map.get(id).setNickName(nickName);

				}
				
			} else {

				map.get(id).setStatus(status);
				arList.add(id + "_님이 나갔습니다.");

			}

		}

		// SYSOUT ID-> NICKNAME

		String[] answer = new String[arList.size()];

		for (int i = 0; i < arList.size(); i++) {

			String[] arr = arList.get(i).split("_");
			String key = arr[0];
			String nickName = map.get(key).nickName;

			answer[i] = nickName + arr[1];

		}

		return answer;
	}
}

class Info {

	String nickName, status;

	Info(String nickName, String status) {

		setNickName(nickName);
		setStatus(status);

	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
