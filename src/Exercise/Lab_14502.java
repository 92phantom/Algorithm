package Exercise;

import java.util.Scanner;
import java.util.StringTokenizer;


public class Lab_14502 {

	static int N, M;
	static int map[][];
	static boolean visisted[][];
	static int x[] = { 1, 0, -1, 0 };
	static int y[] = { 0, 1, 0, -1 };

	
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);		
		String word;
		StringTokenizer st= new StringTokenizer(input.nextLine(), " " );

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		
		
		System.out.println(N+" "+M);
		map = new int[N][M];
		visisted = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			word = input.nextLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = (word.charAt(j) - '0');
			}
		}
		

		for(int i=0; i<N; i++){
			for(int j=0; i<M; j++){
				
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		
		func();
		
		input.close();
		
	}
	static void func(){
		
		
		
		
	}
}
