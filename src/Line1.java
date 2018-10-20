import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Line1 {

	
	static int price = 720;
	static int totalPrice= 0;
	static final int Ihave = 20000;
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		
		while(st.hasMoreTokens()){
			
			int distance = Integer.parseInt(st.nextToken());
			
			if(distance<=40){
				totalPrice += price;
//				System.out.println(price);
			}
			
			if(distance>40){
				
				int temp = (distance - 40)/8;
				
				
				int spare = (distance - 40)%8;
				
				if(spare==0){
					totalPrice += (price+(80*(temp)));

				}else{
					totalPrice += (price+(80*(temp+1)));

				}
				
				
				
//				System.out.println(price+(80*(temp+1)));

			}
		}
		
		
		System.out.println(Ihave - totalPrice);
		
	}
}
