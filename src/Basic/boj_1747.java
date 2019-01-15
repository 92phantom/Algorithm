package Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_1747 {

	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		char[] map;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		for (int i = N; i <= 1000000; i++) {

			if(i==1) {
				System.out.println(2);
				break;
			}
			
			String temp = i + "";
			int size = temp.length();
			map = new char[size];

			for (int j = 0; j < temp.length(); j++) {
				map[j] = temp.charAt(j);
			}
			
			String front = "", end = "";

			if (size % 2 == 0) {

				for (int j = 0; j < size / 2; j++) {
					front += map[j] + "";
				}

				for (int j = (size - 1); j >= (size / 2); j--) {
					end += map[j] + "";
				}

			} else {

				for (int j = 0; j < size / 2; j++) {
					front += map[j] + "";
				}
				for (int j = (size - 1); j > size / 2; j--) {
					end += map[j] + "";
				}

			}

			if (front.equals(end)) {

				if (isPrime(i)) {
					System.out.println(i);
					break;
				}
			}

		}

	}

	static boolean isPrime(int value) {

		for (int i = 2; i < value; i++) {

			if (value % i == 0) {
				return false;
			}

		}

		return true;

	}

}
