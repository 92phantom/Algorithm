package SamsungExpert;

import java.util.Scanner;

public class BigSmallEqual_2070 {

	public static void main(String... args) {

		Scanner sc = new Scanner(System.in);
		int lines = sc.nextInt();
		for (int i = 0; i < lines; i++) {
			double avg = 0;
			for (int j = 0; j < 10; j++) {
				int n = sc.nextInt();
				avg = avg + n;

				if (j == 9) {
					avg /= 10;
				}

			}
			System.out.println("#" + (i + 1) + " " + Math.round(avg));
		}

		sc.close();

	}
}
