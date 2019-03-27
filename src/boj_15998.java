import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 최대 공약수 구하는 문제

public class boj_15998 {

	static int N;

	static long ans = 0;

	static ArrayList<Long> INorOUT = new ArrayList<>();
	static ArrayList<Long> REMAIN = new ArrayList<>();

	static long gcd(long a, long b) {

		return b > 0 ? gcd(b, a % b) : a;

	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());

		INorOUT.add((long) 0);
		REMAIN.add((long) 0);
		
		for (int i = 1; i <= N; i++) {

			st = new StringTokenizer(br.readLine(), " ");

			INorOUT.add(Long.parseLong(st.nextToken()));
			REMAIN.add(Long.parseLong(st.nextToken()));

			ans = gcd(ans, REMAIN.get(i) - REMAIN.get(i - 1) - INorOUT.get(i));

		}

		for (int i = 1; i <= N; i++) {

			if (REMAIN.get(i) - REMAIN.get(i - 1) == INorOUT.get(i))
				continue;

			if (ans > 0 && ans <= REMAIN.get(i) || INorOUT.get(i) > 0
					|| INorOUT.get(i) < 0 && Math.abs(INorOUT.get(i)) < REMAIN.get(i - 1)) {

				System.out.println(-1);
				return;
			}
		}

		System.out.println(ans > 0 ? ans : 1);

	}

}
