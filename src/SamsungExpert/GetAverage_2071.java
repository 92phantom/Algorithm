package SamsungExpert;

import java.io.IOException;
import java.util.Scanner;

public class GetAverage_2071 {

	
	
	public static void main(String... args) throws IOException {

		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int i = 0; i < T; i++) {
			
			int N = sc.nextInt();
			boolean[][] visited = new boolean[N][N];
			int [][] arr = new int[N][N];
			
			for (int j = 0; j < N; j++) {
				
				for(int k = 0; k<N; k++){
					
					arr[j][k] = sc.nextInt();
				
				}
				
				
			}
//			System.out.println("#" + (i + 1) + " " + sum);
		}

		sc.close();
		
		
		
		
	}
}
