package DynamicProgramming;

/*
 * SumOneTwoThree
 * 
 * @date 2018.07.29
 * @author HYUNJIN PARK
 * @result : 9952KB, 76ms
 * 
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SumOneTwoThree {

	public static final int MAX = 11;

	public static void main(String... args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		int[] temp = new int[T];
		
		int[] D = new int[MAX + 1];

		D[1] = 1;
		D[2] = 2;
		D[3] = 4;

		for (int i = 4; i <= MAX; i++) {
			D[i] = D[i - 1] + D[i - 2] + D[i - 3];
		}
		
		for(int i=0; i<T; i++){
			temp[i] = Integer.parseInt(br.readLine());
			temp[i] = D[temp[i]];
		}
		for(int i=0; i<T; i++){
			System.out.println(temp[i]);
		}

	}
}
