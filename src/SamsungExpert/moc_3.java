package SamsungExpert;

public class moc_3 {

	static int[][] map;
	static int N;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] board = { { 11, 13, 15, 16 }, { 12, 1, 4, 3 }, { 10, 2, 7, 8 }, { 5, 14, 6, 9 } };
		int[] nums = { 14, 3, 2, 4, 13, 1, 16, 11, 5, 15 };

		System.out.println(solution(board, nums));

	}

	static int solution(int[][] board, int[] nums) {
		int answer = 0;

		map = board;
		N = map.length;

		for (int i = 0; i < nums.length; i++) {

			answer = checkLine(nums[i], i, nums.length);
		}

		return answer;
	}

	static int checkLine(int input, int cur, int end) {
		int result = 0;
		for (int i = 0; i < N; i++) {

			for (int j = 0; j < N; j++) {
				if (map[i][j] == input) {
					map[i][j] = 0;
				}
			}

		}

		if (cur == (end - 1)) {

			// 가로
			for (int i = 0; i < N; i++) {
				boolean clearLine = true;

				for (int j = 0; j < N; j++) {
					if (map[i][j] > 0) {
						clearLine = false;
					}
				}

				if (clearLine)
					result += 1;
			}
			// 세로
			for (int i = 0; i < N; i++) {
				boolean clearLine = true;

				for (int j = 0; j < N; j++) {
					if (map[j][i] > 0) {
						clearLine = false;
					}
				}

				if (clearLine)
					result += 1;
			}

			for (int i = 0; i < 1; i++) {
				boolean clearLine = true;

				for (int j = 0; j < N; j++) {
					if (map[j][j] > 0) {
						clearLine = false;
					}
				}

				if (clearLine)
					result += 1;
			}

			for (int i = 0; i < 1; i++) {
				boolean clearLine = true;

				for (int j = 0; j < N; j++) {
					if (map[(N - 1) - j][j] > 0) {
						clearLine = false;
					}
				}

				if (clearLine)
					result += 1;
			}
		}
		return result;

	}
}
