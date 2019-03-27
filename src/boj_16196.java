import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class boj_16196 {

	static String number;
	static int N;
	static Set<String> local;
	static int[] days = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	static String C_local = "";

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

//		System.out.println(Math.pow(2, 3));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		local = ConcurrentHashMap.newKeySet();

		number = br.readLine();

		for (int i = 0; i < 6; i++) {
			C_local += number.charAt(i);
		}

		N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			String temp = br.readLine();
			local.add(temp);
		}

		solve();
	}

	static boolean leapYear(int y) {

		if(y %4 == 0 && y % 100 != 0 || y % 400 == 0) {
			return true;
		}

		return false;
	}

	static void solve() {

		if (!local.contains(C_local)) {
			System.out.println("I");
			return;
		}

		int year = Integer.parseInt(number.substring(6, 10));

		if (year < 1900 || year > 2011) {
			System.out.println("I");
			return;
		}

		int month = Integer.parseInt(number.substring(10, 12));

		if (month < 1 || month > 12) {
			System.out.println("I");
			return;
		}

		int day = Integer.parseInt(number.substring(12, 14));

		if (day < 1) {
			System.out.println("I");
			return;
		}

		if(leapYear(year) && month == 2) {
			if(day > 29) {
				System.out.println("I");
				return;
			}
		}else {
			if(day > days[month]) {
				System.out.println("I");
				return;
			}
		}
		
		int order = Integer.parseInt(number.substring(14, 17));
		
		if(order == 0) {
			System.out.println("I");
			return;
		}
		
		String x = number.substring(17);
		
		int checkSum;
		if(x.equals("X")) checkSum = 10;
		else checkSum = Integer.parseInt(x);
		
		for(int i=0; i<17; i++) {
		
			checkSum += ((number.charAt(i) -'0') *(Math.pow(2, 17-i)));
			checkSum %= 11;
			
		}
		
		if(checkSum != 1) {
			System.out.println("I");
			return;
		}else {
			if(order %2 == 1) {
				System.out.println("M");
			}else {
				System.out.println("F");
			}
			return;
		}
	}

}
