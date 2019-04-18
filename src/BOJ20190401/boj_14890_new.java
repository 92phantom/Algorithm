package BOJ20190401;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_14890_new {

	static int N, L;
	static int[][] map = new int[101][101];
	static int ans = 0;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken()); // ������
		L = Integer.parseInt(st.nextToken()); // ������ ����

		for (int i = 0; i < N; i++) {

			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				int temp = Integer.parseInt(st.nextToken());
				map[i][j] = temp;
			}

		}

		for (int i = 0; i < N; i++) {
			garoFunc(i);
		}
		System.out.println(ans);

		for (int i = 0; i < N; i++) {
			seroFunc(i);
		}
	}

	static void garoFunc(int sero) {

		int start = map[sero][0];

		boolean[] visited = new boolean[N];

		Queue<Integer> q = new LinkedList<>();
		q.add(0);

		boolean flag = true;

		System.out.println("==="+sero);
		for (int i = 1; i < N; i++) {
			int next = map[sero][i];

			if (start == next) {
				q.add(i);
			}
			

			System.out.println("IDX:"+i+"---");
			
			if(visited[i]) {
				continue;
			}
			
			// ���� ��尡 �� Ŭ���
			else if (start < next) {

				if (start == (next - 1)) {
					// ����� ��ħ�� ���� ���
					
					System.out.println("ũ��"+"����"+start+"ť������"+q.size());
					if (q.size() < L) {
						flag = false;
						break;
					}
					// �ٸ��� ���� �� ���� ���
					else {
						q.clear();
						q.add(i);
					}
				}
				// ���̰� 1���� ���� ���
				else {
					flag = false;
					break;
				}
				
				start = next;

			}
			// ���� ��尡 ���� ���
			else if (start > next) {
				q.clear();
				
				System.out.println("��ŸƮ::"+start+"�۾ƿ�?"+q.size());

				if ((start - 1) == next) {
					q.add(i);
					// L�� ���̰� 1�� ���
					if (L == 1) {
						visited[i+1] = true;
					}
					// L�� ���̰� 1���� Ŭ��
					else if (L > 1) {
						int count = 1;
						for (int j = (i + 1); j < N; j++) {
							if (map[sero][j] == next) {
								count += 1;
								visited[j] = true;
							}
						}

						// ���� ��忡 ���� �� ���� ���
						if (count != L) {
							flag = false;
						}
					}

				}
				// ���̰� 1���� �� ���� �� ���
				else {
					flag = false;
					break;
				}
				
				start = next;

			}
		}

		if(flag) {
			System.out.println("�ε���"+sero);
			ans +=1;
		}
	}

	static void seroFunc(int garo) {

		int start = map[0][garo];

		boolean flag = true;

		for (int i = 1; i < N; i++) {

		}

	}

}
