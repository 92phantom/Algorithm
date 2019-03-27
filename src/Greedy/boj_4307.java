package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_4307 {

	static int T;
	static int LENGTH, N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {

			st = new StringTokenizer(br.readLine(), " ");

			LENGTH = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			
			int min = Integer.MIN_VALUE;
			int max = Integer.MIN_VALUE;
			
			
			for(int j=0; j<N; j++) {
				
				st= new StringTokenizer(br.readLine());
				
				int ant = Integer.parseInt(st.nextToken());
				
				int antMin = Math.min(ant, LENGTH-ant);
				int antMax = Math.max(ant, LENGTH-ant);
				
				min = Math.max(min, antMin);
				max = Math.max(max, antMax);
				
			}
			
			System.out.println(min + " "+ max);
		}

	}

}
