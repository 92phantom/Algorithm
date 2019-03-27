package Kakao;

public class Kakao_2019_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a1 = "01034344631";
		String a2 = "+82-10-3434-4631";
		String a3 = "010-3434-4631";
		String a4 = "+82-010-3434-4631";
		String a5 = "0104344631";

//		
		System.out.println(solution(a1));
		System.out.println(solution(a2));
		System.out.println(solution(a3));
		System.out.println(solution(a4));
		System.out.println(solution(a5));

	}

	static int solution(String phoneNumber) {

		if (phoneNumber.charAt(3) == '-') {

			if (phoneNumber.charAt(0) == '+') {

				// 유형 3
				String[] temp = phoneNumber.split("-");

				if (temp.length == 4) {

					if (temp[0].length() == 3 && temp[1].length() == 2 && temp[2].length() == 4
							&& temp[3].length() == 4) {
						return 3;
					}

					else {
						return -1;
					}
				}

			} else {

				// 유형 1
				String[] temp = phoneNumber.split("-");

				if (temp.length == 3) {

					if (temp[0].length() == 3 && temp[1].length() == 4 && temp[2].length() == 4) {
						return 1;
					}

				} else {
					return -1;
				}

			}

		} else if (!phoneNumber.contains("-") && phoneNumber.length() == 11) {
			// 유형 2
			return 2;
		} else {
			return -1;
		}

		return -1;

	}
}
