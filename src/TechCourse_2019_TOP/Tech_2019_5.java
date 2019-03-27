package TechCourse_2019_TOP;

public class Tech_2019_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(solution(33));
	}

	static int solution(int number) {
		int answer = 0;

		for (int i = 1; i <= number; i++) {

			String temp = i + "";

			for (int j = 0; j < temp.length(); j++) {
				if (temp.charAt(j)=='3') {
					answer += 1;
				} else if (temp.charAt(j)=='6') {
					answer += 1;
				} else if (temp.charAt(j)=='9') {
					answer += 1;
				}
			}

		}

		return answer;
	}

}
