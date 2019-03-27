package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class boj_2493 {

	static int N; // Å¾ÀÇ¼ö

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		Stack<Integer> input = new Stack<>();
		Stack<Integer> index = new Stack<>();
		
		int first = Integer.parseInt(st.nextToken());
		
		input.add(first);
		index.add(1);
		
		System.out.print("0"+" ");
		
		for(int i=2; i<=N; i++) {
			
			int next = Integer.parseInt(st.nextToken());
			
			while(!input.isEmpty()) {
				
				if(next < input.peek()) {
					System.out.print(index.peek()+ " ");
					break;
				}
				
				input.pop();
				index.pop();
				
			}
			
			if(input.isEmpty()) {
				System.out.print("0"+" ");
			}
			
			input.push(next);
			index.push(i);
		}
	
	}

}
