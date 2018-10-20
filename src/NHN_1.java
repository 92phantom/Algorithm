import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class NHN_1 {

	static int C, P, N, cnt;

	static int[] map;
	static Stack<Integer> stack = new Stack<Integer>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		C = Integer.parseInt(br.readLine());
		P = Integer.parseInt(br.readLine());

		map = new int[C];
		createMap();

		for (int i = 0; i < P; i++) {

			N = Integer.parseInt(br.readLine());

			cnt = 0;

			func(N, 0, C);

		}
		
		for(int i=0; i<5; i++){
			System.out.println(map[i]);
		}
	}

	static void func(int index, int start, int end) {
		
		for (int j = (end - 1); j >= end - N; j--) {
			stack.add(map[j]);
			map[j] = 0;
			cnt++;
		}

		for (int k = (index-1); k >= start; k--) {
			stack.add(map[k]);
			map[k] = 0;
			cnt++;
		}

		if ((C-cnt) >= (2 * N)) {
			func(cnt, start+N, end-N);
			
		}else{
			
			for(int i=(C-1); i>=0; i--){
				if(map[i]!=0)
					stack.add(map[i]);
			}
			
			for(int i=0; i<C; i++){
				map[i] = stack.pop();
			}
			
		}

	}

	static void createMap() {

		for (int i = 1; i <= C; i++) {
			map[i - 1] = i;
		}
	}
}
