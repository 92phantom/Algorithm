package Programmers;

// 箭磊具备

public class Simul_ex_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] baseball = { { 123, 1, 1 }, { 356, 1, 0 }, { 327, 2, 0 }, { 489, 0, 1 } };

		System.out.println(solution(baseball));
	}

	static int solution(int[][] baseball) {

		int answer = 0;

		for (int i = 123; i < 1000; i++) {

			String avail = i + "";

			boolean flag = true;

			if (avail.charAt(0) == '0' || avail.charAt(1) == '0' || avail.charAt(2) == '0') {
				continue;
			}

			if (avail.charAt(0) == avail.charAt(1) || avail.charAt(0) == avail.charAt(2)
					|| avail.charAt(1) == avail.charAt(2)) {
				continue;
			}

			for (int j = 0; j < baseball.length; j++) {

				String val = baseball[j][0] + "";
				int strike = baseball[j][1];
				int ball = baseball[j][2];

				// strike 眉农
				int s_temp = 0;

				for (int z = 0; z < 3; z++) {
					if (val.charAt(z) == avail.charAt(z)) {
						s_temp += 1;
					}
				}
				if (s_temp != strike)
					flag = false;

				// ball 眉农
				int b_temp = 0;

//				if (val.charAt(0) == avail.charAt(1) || val.charAt(0) == avail.charAt(2))
//					b_temp += 1;
//				if (val.charAt(1) == avail.charAt(0) || val.charAt(1) == avail.charAt(2))
//					b_temp += 1;
//				if (val.charAt(2) == avail.charAt(1) || val.charAt(2) == avail.charAt(0))
//					b_temp += 1;
				for (int z = 0; z < 3; z++) {
					if (avail.contains(val.charAt(z) + "") && (val.charAt(z) != avail.charAt(z))) {
						s_temp += 1;
					}
				}

				if (b_temp != ball)
					flag = false;
			}

			if (flag) {
//				System.out.println(avail);
				answer += 1;
			}

		}

		return answer;
	}

}
