import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class boj_2816 {
	static int N;
	static String[] list;
	static int KBS1_IDX;
	static int KBS2_IDX;
	static final String[] GOAL = { "KBS1", "KBS2" };

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		list = new String[102];

		for (int i = 0; i < N; i++) {
			String temp = br.readLine();
			if (temp.equals("KBS1")) {
				KBS1_IDX = i;
			} else if (temp.equals("KBS2")) {
				KBS2_IDX = i;
			}

			list[i] = temp;
		}
		// 1,2 --> 화살표 이동, 초기값 0
		// 3,4 --> SWAP

		for (int i = 0; i < KBS1_IDX; i++) {
			System.out.print("1");
		}
		for (int i = 0; i < KBS1_IDX; i++) {
			System.out.print("4");
		}

		// KBS1이 KBS2보다 뒤에 있음
		if (KBS1_IDX > KBS2_IDX) {
			KBS2_IDX += 1;
		}

		for (int i = 0; i < KBS2_IDX; i++) {
			System.out.print("1");
		}

		for (int i = 0; i < KBS2_IDX - 1; i++) {
			System.out.print("4");
		}
	}

	static void swap(int a, int b) {

		String temp = list[a];

		list[a] = list[b];
		list[b] = temp;

	}

}
