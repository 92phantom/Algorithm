import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class boj_2408 {

	static int N;
	static int buho;

	static int plus = 0;
	static int minus = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		ArrayList<String> list = new ArrayList<>();
		Stack<String> stack = new Stack<>();

		for (int i = 0; i < N + (N - 1); i++) {
			String temp = br.readLine();
			list.add(temp);
			stack.add(temp);

		}

		for (int i = list.size() - 1; i >= 0; i--) {
			if (list.get(i).equals("*")) {
				System.out.println("¿©±â");
				int first = Integer.parseInt(list.get(i - 1));
				int last = Integer.parseInt(list.get(i + 1));

				int result = first * last;

				System.out.println("Ã¹¹øÂ°"+first);
				System.out.println("µÎ¹øÂ°"+last);
				
				System.out.println("°á°úÀÓ½Ã"+result);
				
				for (int j = 0; j < 3; j++) {
					stack.remove(i - 1);
				}
//				String aa = stack.remove(i-1);
//				System.out.println("»ÌÈù°ª" + aa);
//				String bb = stack.remove(i-1);
//				System.out.println("»ÌÈù°ª" + bb);
//				String cc = stack.remove(i-1);
//				System.out.println("»ÌÈù°ª" + cc);

				stack.push(result + "");
				System.out.println(stack);

			}

			else if (list.get(i).equals("/")) {
				int first = Integer.parseInt(list.get(i - 1));
				int last = Integer.parseInt(list.get(i + 1));

				int result = first / last;

				for (int j = 0; j < 3; j++) {
					stack.remove(i - 1);
				}
				

				stack.push(result + "");
//				System.out.println(stack);

			}

		}

		Stack<Integer> number = new Stack<>();

		while (!stack.isEmpty()) {

			String aa = stack.pop();
			if (aa.equals("+")) {
				plus += 1;
			} else if (aa.equals("-")) {
				minus += 1;
			} else {
				number.add(Integer.parseInt(aa));
			}

		}
		
		int temp = number.pop();
		
		while(!number.isEmpty()) {
			
			if(minus > 0) {
				minus --;
				temp -= number.pop();
			}
			else if(plus > 0) {
				plus --;
				temp += number.pop();
			}
			
		}
		
		System.out.println(temp);
	}

}
