package Combination;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_1339 {

	static int N, sum;
	public static void main(String...args) throws NumberFormatException, IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		int map[] = new int[26];
		String word[] = new String[N];
		
		int len;
		
		for(int i=0; i<N; i++){
			len = (word[i] = br.readLine()).length();
			for(int j=0; j<len; j++)
				map[word[i].charAt(j)-65] += (int)Math.pow(10,  len-j-1);
			
			
		}
		
		
	}
	
	static void sort(int map[], int start, int end){
		
		if(start>= end) return;
		
		int i= start-1, j=end, pivot = map[end];
		
		while(true){
			while(map[++i]>pivot && i<end);
			while(map[--j]<pivot && j>start);
			if(i>=j) break;
			swap(map, i, j);
			
		}
		
		swap(map, i, end);
		sort(map, start, i-1);
		sort(map, i+1, end);
		
	}
	
	static void swap(int map[], int a, int b){
		int temp = map[a];
		map[a] = map[b];
		map[b] = temp;
	}
}
