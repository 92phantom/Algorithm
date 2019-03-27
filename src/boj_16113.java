import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_16113 {

	static int N;
	static char[] inputArr = new char[100003];
	static char[][] map = new char[20005][5];
	static int[] r = new int[100003];

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		String input = br.readLine();

		for (int i = 0; i < N; i++) {
			inputArr[i] = input.charAt(i);
		}

		for (int i = 0; i < N; i++) {
			map[i % (N / 5)][i / (N / 5)] = inputArr[i];
		}

		int cnt = 0;
		for (int i = 0; i < N / 5; i++) {

			if (map[i][0] == '.')
				continue;

			if (isOne(i)) {
				r[cnt++] = 1;
				i++;
				continue;
			}

			int ret = count(i);
			switch (ret) {

			case 2:
				r[cnt] = 8;
				break;
			case 3:
				if (map[i + 2][1] == '.')
					r[cnt] = 6;
				else if (map[i][3] == '.')
					r[cnt] = 9;
				else
					r[cnt] = 0;
				break;

			case 4:
				if (map[i + 2][1] == '.')
					r[cnt] = 5;
				else if (map[i][3] == '.')
					r[cnt] = 3;
				else
					r[cnt] = 2;
				break;
			case 6:
				r[cnt] = 4;
				break;
			case 8:
				r[cnt] = 7;
			}

			cnt++;
			i += 2;
		}
		for (int i = 0; i < cnt; i++) {
			System.out.print(r[i]);
		}
	}

	static int count(int x) {

		int ret = 0;
		for (int i = x; i < x + 3; i++) {
			for (int j = 0; j < 5; j++) {

				if (map[i][j] == '.') {
					ret += 1;
				}
			}
		}
		return ret;

	}

	static boolean isOne(int x) {
		for (int i = 0; i < 5; i++) {
			if (map[x][i] == '.' || map[x + 1][i] == '#')
				return false;

		}
		return true;
	}
}
