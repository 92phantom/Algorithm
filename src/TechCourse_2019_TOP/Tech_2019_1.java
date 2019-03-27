package TechCourse_2019_TOP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Tech_2019_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.println(Arrays.toString(solution(50237)));
		System.out.println(Arrays.toString(solution(15000)));

	}

	static int[] solution(int money) {

		int[] answer = {0,0,0,0,0,0,0,0,0};

		while (money != 0) {
			if (money >= 50000) {
				int fiveManwon = 0;

				fiveManwon = money / 50000;
				money = money - (50000 * fiveManwon);
				answer[0] = fiveManwon;
			}

			if (money >= 10000) {
				int oneManwon = 0;

				oneManwon = money / 10000;
				money = money - (10000 * oneManwon);
				answer[1] = oneManwon;
				
			}

			if (money >= 5000) {
				int fiveChunwon = 0;

				fiveChunwon = money / 5000;
				money = money - (5000 * fiveChunwon);
				answer[2] = fiveChunwon;
				
			}
			if (money >= 1000) {
				int oneChunwon = 0;

				oneChunwon = money / 1000;
				money = money - (1000 * oneChunwon);
				answer[3] = oneChunwon;
			}
			if (money >= 500) {
				int oneChunwon = 0;

				oneChunwon = money / 500;
				money = money - (500 * oneChunwon);
				answer[4] = oneChunwon;
			}
			if (money >= 100) {
				int oneChunwon = 0;

				oneChunwon = money / 100;
				money = money - (100 * oneChunwon);
				answer[5] = oneChunwon;
			}
			if (money >= 50) {
				int oneChunwon = 0;

				oneChunwon = money / 50;
				money = money - (50 * oneChunwon);
				answer[6] = oneChunwon;
			}
			if (money >= 10) {
				int oneChunwon = 0;

				oneChunwon = money / 10;
				money = money - (10 * oneChunwon);
				answer[7] = oneChunwon;
			}
			if (money >= 1) {
				int oneChunwon = 0;

				oneChunwon = money / 1;
				money = money - (1 * oneChunwon);
				answer[8] = oneChunwon;
			}
		}
		
		return answer;

	}

}
