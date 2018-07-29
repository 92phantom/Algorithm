package DynamicProgramming;


/*
 * TwoByXTiling
 * 
 * @date 2018.07.29
 * @author HYUNJIN PARK
 * @result : 10100KB, 76ms
 * 
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TwoByXTiling {

	public static final int MAX = 1001;
	
	public static void main(String...args) throws NumberFormatException, IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int size = Integer.parseInt(br.readLine());
		
		int[] d = new int[MAX];
		
		d[0] = 1;
		d[1] = 1;
		
		for(int i=2; i<=size; i++){
			d[i] = d[i-1] + d[i-2];	
		}
		
		System.out.println(d[size]);
	}
	
}
	