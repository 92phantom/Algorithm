package BOJ20190401;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/*
 * 		Baekjoon Online Judge 17135 - ĳ�� ���潺
 * 
 * 		https://www.acmicpc.net/problem/17135
 */

public class boj_17135 {

	static int N, M, D;
	static int count, res;
	static List<enemy> targets;
	static List<enemy> copyTargets;

	static class enemy implements Comparable<enemy> { // ������ ��ǥ, �Ÿ�

		int r;
		int c;
		int dist;

		public enemy(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

		@Override
		public int compareTo(enemy o) { // �Ÿ� ��������, �Ÿ��� ������ ���� ���������� �������� ����

			if (o.dist < dist)
				return 1;
			else if (o.dist == dist) {
				if (o.c < c)
					return 1;
			}

			return -1;
		}
	}

	public static void solve(int i, List<Integer> archer) { // �ü��� ��ġ�� ��� ������ ã��

		if (archer.size() == 3) { // �ü� ������ ��ġ�� ������ 
			count = 0;
			
			targets.clear();
			for (int j = 0; j < copyTargets.size(); j++) {
				targets.add(new enemy(copyTargets.get(j).r, copyTargets.get(j).c));
			} // ���� ��ġ �ʱ�ȭ
			
			while (!targets.isEmpty()) {
				attack(archer); // ���� ����
				falling(); // ���� ����
			}

			if (count > res) {
				res = count;
			}

			return;
		} else {
			for (int j = i + 1; j < M; j++) {
				archer.add(new Integer(j));
				solve(j, archer);
				archer.remove(new Integer(j));
			}

		}

	}

	public static void falling() {
		List<enemy> delete = new ArrayList<>();
		for (int i = 0; i < targets.size(); i++) {
			enemy e = targets.get(i);
			if (e.r == N-1) { // ���� �����ϸ� ����
				delete.add(e);
			} else {
				e.r++;
			}
		}

		for (int i = 0; i < delete.size(); i++) {
			targets.remove(delete.get(i));
		}

	}

	public static void attack(List<Integer> archer) {

		List<enemy> delete = new ArrayList<>();
		for (int i = 0; i < archer.size(); i++) { 
			int now = archer.get(i);

			for (int j = 0; j < targets.size(); j++) {
			
				targets.get(j).dist = Math.abs(N - targets.get(j).r) + Math.abs(now - targets.get(j).c);

			} // �ü����� ��� ������ �Ÿ��� ���

			Collections.sort(targets); // �Ÿ���, �Ÿ��� ���� ��� ���� �켱���� ����
 
			
			
			for (int j = 0; j < targets.size(); j++) {
				enemy e = targets.get(j);
				if (e.dist <= D) { // ���� �Ÿ��� D���� ������
					if (!delete.contains(e)) // ���� ��󸮽�Ʈ�� ���������� ����Ʈ�� �߰�
						delete.add(e);
					break;
				}
			}
		}

		for (int i = 0; i < delete.size(); i++) { // óġ Ƚ���� ������Ű�鼭 ���� ����
			count++;
			targets.remove(delete.get(i));
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		D = sc.nextInt();

		targets = new ArrayList<>();
		copyTargets = new ArrayList<>();
		res = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				int now = sc.nextInt();

				if (now == 1) {
					targets.add(new enemy(i, j));
				}
			}
		} // �Է°� �ʱ�ȭ
		
		for (int i = 0; i < targets.size(); i++) {
			copyTargets.add(new enemy(targets.get(i).r, targets.get(i).c));
		} // ���� �ʱ� ��ġ ����

		solve(-1, new ArrayList<Integer>());
		System.out.println(res);
	}

}