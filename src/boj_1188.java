import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1188 {

	static long gcd(long a, long b) {

		return b > 0 ? gcd(b, a % b) : a;

	}
	
	static int N, M;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		
		System.out.println(gcd(M,N));
		
		System.out.println(M-gcd(M, N));
		
		
		
		
	}

}
