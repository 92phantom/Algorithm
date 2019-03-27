import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_3019 {
	static int C, BLOCK_NUM;
	static int[] MAP;
	static int ans = 0;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		C = Integer.parseInt(st.nextToken());
		BLOCK_NUM = Integer.parseInt(st.nextToken());

		MAP = new int[C];

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < C; i++) {
			MAP[i] = Integer.parseInt(st.nextToken());
		}

		block(BLOCK_NUM);

		System.out.println(ans);
	}

	static void block(int blockNum) {

		switch (blockNum) {
		case 1:// l
			check("0");
			check("0000");
			break;
		case 2:// ¤±
			check("00");
			break;
		case 3:
			check("110");
			check("01");
			break;
		case 4:
			check("011");
			check("10");
			break;
		case 5:
			check("000");
			check("10");
			check("010");
			check("01");
			break;
		case 6:
			check("000");
			check("00");
			check("100");
			check("02");
			break;
		case 7:
			check("000");
			check("20");
			check("001");
			check("00");
			break;
		}

	}

	static void check(String s) {

		for (int i = 0; i <= C - s.length(); i++) {

			int gap = (s.charAt(0) - '0') + MAP[i];
			boolean flag = true;

			for (int j = 0; j < s.length(); j++) {
				if (((s.charAt(j) - '0') + MAP[i + j]) != gap) {
					flag = false;
					break;
				}
			}

			if (flag) {
				ans += 1;
			}

		}

	}

}
