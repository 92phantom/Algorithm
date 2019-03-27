import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.concurrent.ConcurrentHashMap;

public class boj_14467 {

	static int N;

	static ConcurrentHashMap<Integer, Integer> map = new ConcurrentHashMap<>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());

		int count = 0;
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int cow = Integer.parseInt(st.nextToken());
			int location = Integer.parseInt(st.nextToken());
			
			if(!map.containsKey(cow)) {
				map.put(cow, location);
			}
			
			else if(map.containsKey(cow)){
				int current = map.get(cow);
				if(current != location) {
					count +=1;
					map.replace(cow, location);
				}
				
			}
			
		}
		
		System.out.println(count);
		
	}

}
