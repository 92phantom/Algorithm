
public class Rakuten_1 {


	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		int N = 6;
//		int M = 6;
//		
//		System.out.println(N^M);
//		
		System.out.println(solution(5, 8));
	}

	static int solution(int M, int N) {

		if(M==N)
			return 0;
		
		int temp=M;
		
		for (int i = M+1; i <= N; i++) 
			temp ^= i;

		return temp;

	}

}
