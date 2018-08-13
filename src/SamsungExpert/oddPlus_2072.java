package SamsungExpert;

import java.util.Scanner;

public class oddPlus_2072 {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int lines = sc.nextInt();
		for (int i = 0; i < lines; i++) {
			int sum = 0;
			for (int j = 0; j < 10; j++) {
				int n = sc.nextInt();
				if (n % 2 == 1)
					sum += n;
			}
			System.out.println("#" + (i + 1) + " " + sum);
		}

		sc.close();
	}

}