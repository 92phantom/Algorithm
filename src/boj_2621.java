import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class boj_2621 {

	static int[] card;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		card = new int[15];

		int maxNum = 0;
		int minNum = 0;

		for (int i = 0; i < 5; i++) {

			st = new StringTokenizer(br.readLine(), " ");

			char temp = st.nextToken().charAt(0);

			int color = 0;
			int cardNum = Integer.parseInt(st.nextToken());

			// R = 10, B = 11, Y =12, G =13
			if (temp == 'R') {
				color = 10;
			} else if (temp == 'B') {
				color = 11;
			} else if (temp == 'Y') {
				color = 12;
			} else if (temp == 'G') {
				color = 13;
			}

			maxNum = Math.max(maxNum, cardNum);
			minNum = Math.min(minNum, cardNum);

			card[cardNum] += 1;
			card[color] += 1;

		}

		int cardNumCount = 0;
		int cardNumIdx = 0;

		ArrayList<Integer> list = new ArrayList<>();

		for (int i = 1; i < 10; i++) {
//			cardNumCount = Math.max(cardNumCount, card[i]);

			if (card[i] != 0) {
				list.add(i);
			}

			if (cardNumCount < card[i]) {
				cardNumCount = card[i];
				cardNumIdx = i;
			}
		}
		boolean same = true;

		if (list.size() == 5) {
			Collections.sort(list);

			int start = list.get(0);

			for (int i = 1; i < list.size(); i++) {
//				if (start == list.get(i)) {
//					break;
//				}
				if (start+1 == list.get(i)) {
//					System.out.println("기준값"+start+1);
//					System.out.println("비교값"+list.get(i));
					start = list.get(i);
				}else {
					same=false;
					break;
				}
			}
//			same = true;
		}

		int cardColorCount = 0;
		int cardColorIdx = 0;

		for (int i = 10; i < 14; i++) {
//			cardColorCount = Math.max(cardColorCount, card[i]);
			if (cardColorCount < card[i]) {
				cardColorCount = card[i];
				cardColorIdx = i;
			}

		}

		if (cardNumCount == 4 && cardColorCount != 5) {
			System.out.println(cardNumIdx + 800);
			return;
		}

		else if (cardNumCount == 3 && cardColorCount != 5) {

			int tempIdx = 0;

			for (int i = 0; i < 10; i++) {

				if (card[i] == 2) {
					tempIdx = i;
					break;
				}
			}

			if (tempIdx != 0) {
				System.out.println(cardNumIdx * 10 + (tempIdx + 700));
			} else {
				System.out.println(400 + cardNumIdx);
			}
			return;

		}

		else if (cardNumCount == 2 && cardColorCount != 5) {

			int tempIdx = 0;

			for (int i = 0; i < 10; i++) {

				if (card[i] == 2 && i != cardNumIdx) {
					tempIdx = i;
					break;
				}
			}
			if (tempIdx != 0) {
				System.out.println(tempIdx > cardNumIdx ? (tempIdx * 10) + (cardNumIdx + 300)
						: (cardNumIdx * 10) + (tempIdx + 300));
			} else {
				System.out.println(cardNumIdx + 200);
			}
			return;
		}

		else if (cardColorCount == 5) {
			
			if (same) {
//				System.out.println("여기들어왓다고?");
//				System.out.println(list);
				System.out.println(900 + maxNum);
				return;
			} else if (!same) {
				System.out.println(600 + maxNum);
				return;
			}
		}

		else if (cardColorCount != 5) {
			if (same) {
				System.out.println(500 + maxNum);
				return;
			}
		} 
		System.out.println(100 + maxNum);
		

	}

}
