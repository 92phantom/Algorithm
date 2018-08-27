package Basic;

import java.util.Arrays;

public class Permutation {
	
	static int res[];
	static int r;
	public static void main(String[] args){
		
		int arr[] = {1,2,3,4,5};
		
		int n = 5;
		r = 3;
		
		res = new int[r];
		doPermutation(arr, 0);
	}
	
	
	static void doPermutation(int[] arr, int startPoint){
		
		int size = arr.length;
		
		if(startPoint == r){
			System.out.println(Arrays.toString(res));
			return;
		}

		
		for(int i=startPoint; i<size; i++){
			
			swap(arr, startPoint, i);
			res[startPoint] = arr[startPoint];
			doPermutation(arr, startPoint+1);
			swap(arr, startPoint, i);
			
		}
		
	}
	
	static void swap(int[] arr, int n1, int n2){
		
		int temp = arr[n1];
		arr[n1] = arr[n2];
		arr[n2] = temp;
		
	}
}
