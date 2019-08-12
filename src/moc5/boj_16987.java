package moc5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj_16987 {

	static int N;
	static ArrayList<Node> list = new ArrayList<>();
	static boolean[] eggVisited;
	static int ans;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		eggVisited = new boolean[N];
		ans = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int negu = Integer.parseInt(st.nextToken());
			int muge = Integer.parseInt(st.nextToken());

			list.add(new Node(negu, muge));

		}

		func(0, list);

		System.out.println(ans);

	}

	static void func(int idx, ArrayList<Node> eggList) {

        int count2 = 0;
		for (int i = 0; i < eggList.size(); i++) {
			if (eggList.get(i).negu <= 0) {
				count2 += 1;
			}
		}

		ans = Math.max(ans, count2);

        
		if (idx == N) {

			int count = 0;

			
			for (int i = 0; i < eggList.size(); i++) {
				if (eggList.get(i).negu <= 0) {
					count += 1;
				}
			}

			ans = Math.max(ans, count);

			return;
		}
		
		Node cur = eggList.get(idx);

		if (cur.negu > 0) {
			int nextIdx = -1;

			for (int i = 0; i < N; i++) {

				// ���� �� ��� ���� ���� �ִ� �ֺ� ����� ã�´�.
				if (i != idx) {

					nextIdx = i;

					if (!eggVisited[nextIdx]) {

						Node next = eggList.get(nextIdx);
						cur.negu -= next.muge;
						next.negu -= cur.muge;

						if (cur.negu <= 0) {
							eggVisited[idx] = true;
						}
						if (next.negu <= 0) {
							eggVisited[nextIdx] = true;
						}

						func(idx + 1, eggList);

						if (cur.negu <= 0) {
							eggVisited[idx] = false;
						}
						if (next.negu <= 0) {
							eggVisited[nextIdx] = false;
						}

						cur.negu += next.muge;
						next.negu += cur.muge;
					}
				}

			}

		}

		// ���� �� ����� ������ ������ ���� ���� �� ���
		else {
		
			int count = 0;
			for (int i = 0; i < eggList.size(); i++) {
				if (eggList.get(i).negu <= 0) {
					count += 1;
				}
			}

			ans = Math.max(ans, count);
			
			func(idx + 1, eggList);
		}

	}

	static class Node {
		int negu, muge;

		Node(int negu, int muge) {

			this.negu = negu;
			this.muge = muge;

		}
	}
}
