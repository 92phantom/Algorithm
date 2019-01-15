package Combination;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_1759_DFS {

	// N�� ��ü ������, R�� ã�����ϴ� ������
	// ���� : ã���� �ϴ� ��츦 ��� �����ϴ� ���� 6P4
	// ���� : ã���� �ϴ� ��츸, �ߺ� x 6C4

	// �������� �����ߴµ� Ʋ��.. ����?
	
	static char[] arr;
	static int[] result;
	static int N;
	static int M;
	
	public static void main(String[] a) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new char[M];
		result = new int[M];
		
		st = new StringTokenizer(br.readLine(), " ");

//		System.out.println(st.nextToken());
		
		for (int i = 0; i < M; i++) {
			arr[i] = st.nextToken().charAt(0);
		}
		
		System.out.println(Arrays.toString(arr));
		
		Arrays.sort(arr);
		DFS(0,0,0,0);

		
	}

	static void DFS(int start, int depth, int ja, int mo){
		
		for(int i = start; i< M; i++){
			
			result[i] = 1;
			
			DFS(i+1, depth +1, ja + (!check(arr[i]) ? 1: 0), mo + (!check(arr[i]) ? 0 : 1));
			
			result[i] = 0;
		}
		
		if(depth==N && ja >=2 && mo>= 1)
			print();
		
	}
	
	static void print(){
		
		for(int i=0; i<M; i++){
			
			if(result[i] == 1){
				System.out.print(arr[i]);
			}
			
		}
		System.out.println();
		
	}
	
	static boolean check(char a){
		
		if(a == 'a' || a =='e' || a =='i' || a == 'o' || a=='u')
			return true;
		else
			return false;
		
	}
	
	static void doCombination(char[] map, int N, int R, int index, int target, int[] res) {

		if (R == 0) {

			for (int i = 0; i < index; i++) {
				System.out.print(map[res[i]]);
			}
			System.out.println();
			
			return;

		} else if (target == N) {

			return;

		} else {

			res[index] = target;

			doCombination(map, N, R - 1, index + 1, target + 1, res);
			doCombination(map, N, R, index, target + 1, res);

		}

	}

}
