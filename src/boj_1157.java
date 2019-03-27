import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_1157 {

	// 대문자 A : 65 Z : 90
	// 소문자 a : 97 z : 122
	static int[] map = new int[30];

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine().toUpperCase();

		int maxVal = 0;

		for (int i = 0; i < input.length(); i++) {
			map[input.charAt(i) - 'A']++;
			maxVal = Math.max(maxVal, map[input.charAt(i) - 'A']);
		}

		int count = 0;
		int idx = 0;

		for (int i = 0; i < 30; i++) {
			if (count == 2) {
				System.out.println("?");
				break;
			}
			if (map[i] == maxVal) {
				count += 1;
				idx = i;
			}
		}

		if (count < 2) {
			System.out.println((char) (idx + 'A'));
		}
	}

}
