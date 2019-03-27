import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1780 {

	static int N;
	static int map[][];
	
	static int a = 0;
	static int b = 0;
	static int c = 0;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		StringTokenizer st;
		
		int init = -1;
		boolean flag = true;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<N; j++) {
				
				int temp = Integer.parseInt(st.nextToken());
				if(init == -1) {
					init = temp;
				}else if(init != -1 && init != temp) {
					flag = false;
				}
				
				map[i][j] = temp;
				
			}
		}
	
		if(flag) {
			int a,b,c;
//			if(a==te)
		}
		
		else {
		
			int initX = 0;
			int initY = 0;
			
			
			for(int i=0; i<(N/3); i++) {
				for(int j=0; j<(N/3); j++) {
					
				}
			}
			
		}
		
		
		System.out.println(a+"\n"+c+"\n"+b);
	}
	
	static 

}
