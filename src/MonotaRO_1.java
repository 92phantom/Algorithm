
public class MonotaRO_1 {

	static int cnt;
	static boolean visited[];
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] A = {1, 4, -1, 3, 2};
		
		solution(A);
		
		
	}

	
	static void solution(int[] A){
		
		visited = new boolean[A.length];
		
		
		
		func(A[0], A);
		
		System.out.println(cnt);
	}
	
	static void func(int index, int[] A){
		
		
		int temp = A[index];
		System.out.println("temp"+ temp);
		
		
		if(A[index] != -1){
			visited[temp] = true;
			
			cnt += 1;
			
			
			func(temp, A);
			
		}
		else{
			visited[A.length-1] = true;
			
		}
		
	}
}
