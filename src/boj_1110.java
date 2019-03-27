import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_1110 {

	static String N;

	static int count;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = br.readLine();
		
		String check  = N;
		
		count = 0;
		
		
		
		while(true) {
			
			// 0보다 작을 경우
			if(Integer.parseInt(check) < 0) {				
				check = "0"+check;
			}
			// 0보다 클 때
			
			int first = 0;
			int second = 0;
			if(Integer.parseInt(check) > 9) {
				first = Integer.parseInt(check.charAt(0)+"");
				second = Integer.parseInt(check.charAt(1)+"");
			}else {
				first = 0;
				second = Integer.parseInt(check.charAt(0)+"");
			}
			
			int temp = func(first, second);
			
			int newNumber;
			
			if(temp < 10) {
				newNumber = Integer.parseInt(second+""+temp);
			}else {
				newNumber = Integer.parseInt(second+""+(temp+"").charAt(1));
			}
			
			count += 1;
		
			if(newNumber == Integer.parseInt(N)) {
				System.out.println(count);
				break;
			}else {
				check = newNumber +"";
			}
			
		}
	
	}

	static boolean check(int checkNum) {
		return Integer.parseInt(N) == checkNum ? true : false;
	}
	
	static int func(int first, int second) {
		
		return first+second;
	}
	
}
