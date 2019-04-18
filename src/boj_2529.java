import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj_2529 {

	static int K;
	static ArrayList<Character> list = new ArrayList<>();
	static ArrayList<Integer> out = new ArrayList<>();
	static boolean[] v;
	static long max = Long.MIN_VALUE;
	static long min = Long.MAX_VALUE;
	
	static String maxStr = "";
	static String minStr = "";
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		K = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < K; i++) {
			list.add(st.nextToken().charAt(0));
		}

		v = new boolean[10];

		for (int i = 0; i < 10; i++) {
			if (!v[i]) {
				out.add(i);
				v[i] = true;
				func(i);
				v[i] = false;
				out.remove(out.size() - 1);
			}
		}
		
		System.out.println(maxStr);
		System.out.println(minStr);
		
	}

	static void func(int idx) {
		if (out.size() == K + 1) {
//			System.out.println(out);
			check();
		} else {

			for (int i = 0; i < 10; i++) {
				if (!v[i]) {
					out.add(i);
					v[i] = true;
					func(i);
					v[i] = false;
					out.remove(out.size() - 1);
				}
			}

		}
	}

	static void check() {

		boolean flag = true;
		for (int i = 0; i < list.size(); i++) {
			int front = out.get(i);
			int end = out.get(i + 1);

			char buho = list.get(i);

			if (buho == '<') {
				if(front >= end) {
					flag = false;
					break;
				}
			} else if(buho == '>'){
				if(front <= end) {
					flag = false;
					break;
				}
			}

		}
		
		if(flag) {
			String temp = "";
			for(int i=0; i<out.size(); i++) {
				temp += out.get(i);
			}
			
			if(max < Long.parseLong(temp)) {
				max = Long.parseLong(temp);
				maxStr = temp;
			}
			
			if(min > Long.parseLong(temp)) {
				min = Long.parseLong(temp);
				minStr = temp;
			}
//			max = Math.max(max, Integer.parseInt(temp));
//			min = Math.min(min, Integer.parseInt(temp));
		}
	}

}
