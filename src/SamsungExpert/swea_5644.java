package SamsungExpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class swea_5644 {

	static int T;
	static int ans;
	static int map[][];
	static int M, A;
	static ArrayList<Integer> AMOVE;
	static ArrayList<Integer> BMOVE;
	static ArrayList<Node> BC;

	static int dx[] = { 0, 0, 1, 0, -1 };
	static int dy[] = { 0, -1, 0, 1, 0 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");

			ans = 0;
			AMOVE = new ArrayList<>();
			BMOVE = new ArrayList<>();
			BC = new ArrayList<>();

			M = Integer.parseInt(st.nextToken());
			A = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < M; i++) {
				AMOVE.add(Integer.parseInt(st.nextToken()));
			}

			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < M; i++) {
				BMOVE.add(Integer.parseInt(st.nextToken()));
			}

			for (int i = 0; i < A; i++) {

				st = new StringTokenizer(br.readLine(), " ");

				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				int p = Integer.parseInt(st.nextToken());

				BC.add(new Node(x, y, c, p));
			}

			Node A_INIT = new Node(1, 1, 0, 0);
			Node B_INIT = new Node(10, 10, 0, 0);

			int A_FIRST = 0;
			int A_IDX = 0;
			int A_SECOND = 0;
			int B_FIRST = 0;
			int B_IDX = 0;
			int B_SECOND = 0;

			for (int i = 0; i < A; i++) {

				int dist = getDist(A_INIT, i);
				if (BC.get(i).c >= dist) {

					if (A_FIRST < BC.get(i).p) {
						A_SECOND = A_FIRST;
						A_FIRST = BC.get(i).p;
						A_IDX = i;
					} else {
						if (A_SECOND < BC.get(i).p) {
							A_SECOND = BC.get(i).p;
						}
					}
				}

				dist = getDist(B_INIT, i);
				if (BC.get(i).c >= dist) {

					if (B_FIRST < BC.get(i).p) {
						B_SECOND = B_FIRST;
						B_FIRST = BC.get(i).p;
						B_IDX = i;
					} else {
						if (B_SECOND < BC.get(i).p) {
							B_SECOND = BC.get(i).p;
						}
					}
				}
			}

			setResult(A_FIRST, A_IDX, A_SECOND, B_FIRST, B_IDX, B_SECOND);

			for (int j = 0; j < M; j++) {
				A_INIT.x = A_INIT.x + dx[AMOVE.get(j)];
				A_INIT.y = A_INIT.y + dy[AMOVE.get(j)];

				B_INIT.x = B_INIT.x + dx[BMOVE.get(j)];
				B_INIT.y = B_INIT.y + dy[BMOVE.get(j)];

				A_FIRST = 0;
				A_IDX = 0;
				A_SECOND = 0;
				B_FIRST = 0;
				B_IDX = 0;
				B_SECOND = 0;
				
				for (int i = 0; i < A; i++) {

					int dist = getDist(A_INIT, i);
					if (BC.get(i).c >= dist) {

						if (A_FIRST < BC.get(i).p) {
							A_SECOND = A_FIRST;
							A_FIRST = BC.get(i).p;
							A_IDX = i;
						} else {
							if (A_SECOND < BC.get(i).p) {
								A_SECOND = BC.get(i).p;
							}
						}
					}

					dist = getDist(B_INIT, i);
					if (BC.get(i).c >= dist) {

						if (B_FIRST < BC.get(i).p) {
							B_SECOND = B_FIRST;
							B_FIRST = BC.get(i).p;
							B_IDX = i;
						} else {
							if (B_SECOND < BC.get(i).p) {
								B_SECOND = BC.get(i).p;
							}
						}
					}
				}

				setResult(A_FIRST, A_IDX, A_SECOND, B_FIRST, B_IDX, B_SECOND);

			}
			
			System.out.println("#"+tc+" "+ ans);

		}

	}

	static void setResult(int A_FIRST, int A_IDX, int A_SECOND, int B_FIRST, int B_IDX, int B_SECOND) {

		// A가 0개
		if (A_FIRST == 0)
			ans += B_FIRST;

		// A가 1개
		else if (A_FIRST != 0 && A_SECOND == 0) {

			if (B_FIRST == 0) {
				ans += A_FIRST;
			} else if (B_FIRST != 0 && B_SECOND == 0) {
				if (A_IDX == B_IDX) {
					ans += A_FIRST;
				} else {
					ans += A_FIRST + B_FIRST;
				}
			} else if (B_SECOND != 0) {
				if (A_IDX == B_IDX) {
					ans += A_FIRST + B_SECOND;
				} else {
					ans += A_FIRST + B_FIRST;
				}
			}

		} else if (A_SECOND != 0) {
			// b가 0개
			if (B_FIRST == 0) {
				ans += A_FIRST;
			}
			// b가 1개
			else if (B_FIRST != 0 && B_SECOND == 0) {
				if (A_IDX == B_IDX) {
					ans += B_FIRST + A_SECOND;
				} else {
					ans += B_FIRST + A_FIRST;
				}
			}
			// b가 2개
			else if (B_SECOND != 0) {
				if (A_IDX == B_IDX) {
					ans += A_FIRST + Math.max(A_SECOND, B_SECOND);
				} else {
					ans += A_FIRST + B_FIRST;
				}
			}
		}
	}

	static int getDist(Node node, int idx) {

		int x = Math.abs(node.x - BC.get(idx).x);
		int y = Math.abs(node.y - BC.get(idx).y);

		return x + y;
	}

	static class Node {
		int x, y, c, p;

		Node(int x, int y, int c, int p) {
			this.x = x;
			this.y = y;
			this.c = c;
			this.p = p;
		}

	}

}
