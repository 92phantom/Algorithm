import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_5525 {

	static int N;
	static int M;
	static char[] S;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		S = new char[1000009];
		
		String input = br.readLine();
		
		int idx = 0;
		for(int i=1; i<=input.length(); i++) {
			S[i] = input.charAt(idx++);
		}
		
		int count = 0;
		int ans = 0;
		for (int i = 1; i <= M; ++i) {
			if (S[i] == 'I' && S[i + 1] == 'O' && S[i + 2] == 'I') {
				++count;
				++i;
			}

			else {
				if (count >= N) {
					ans += count - N + 1;
					count = 0;
				}
			}

		}

		System.out.println(ans);

	}

}