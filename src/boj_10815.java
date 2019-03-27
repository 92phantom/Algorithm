import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.concurrent.ConcurrentHashMap;

public class boj_10815 {

	static int N, M;

	static Set<Integer> sang = ConcurrentHashMap.newKeySet();

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < N; i++) {
			int temp = Integer.parseInt(st.nextToken());
//			if (temp > 0) {
//				temp *= 2;
//			} else {
//				temp = Math.abs(temp);
//			}
			
			sang.add(temp);
		}
		
		M = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine(), " ");
		
		for(int i=0; i<M; i++) {
			int temp = Integer.parseInt(st.nextToken());
			
//			if(temp > 0) {
//				temp *=2;
//			}else {
//				temp = Math.abs(temp);
//			}
			
			if(sang.contains(temp)) {
				System.out.print("1 ");
			}else {
				System.out.print("0 ");
			}
			
		}

	}

}
