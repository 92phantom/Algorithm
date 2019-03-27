package BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_13460 {

	static int N, M;
	static char[][] map;

	static int RED_X, RED_Y;
	static int BLUE_X, BLUE_Y;
	static int HOLE_X, HOLE_Y;

	static int ans;

	static int dx[] = { -1, 1, 0, 0 };
	static int dy[] = { 0, 0, -1, 1 };

	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		ans = Integer.MAX_VALUE;

		map = new char[N][M];
		visited = new boolean[N][M];

		// R은 빨간 구슬 위치
		// B은 파란 구슬 위치
		// O은 구멍 위치

		// 목표 : 빨간 구슬을 구멍을 통해서 빼내는 것이다.
		// 파란 구슬이 구멍에 들어가면 안된다.

		/*
		 * 구슬을 왼쪽으로 기울이기 오른쪽으로 기울이기 위쪽으로 기울이기 아래쪽으로 기울이기
		 * 
		 * 같은 네 가지 동작이 가능하다.
		 */

		for (int i = 0; i < N; i++) {
			String temp = br.readLine();
			for (int j = 0; j < M; j++) {
				char input = temp.charAt(j);

				if (input == 'B') {
					BLUE_Y = i;
					BLUE_X = j;
				} else if (input == 'R') {
					RED_Y = i;
					RED_X = j;
				} else if (input == 'O') {
					HOLE_Y = i;
					HOLE_X = j;
				}

				map[i][j] = input;

			}
		}
		bfs();

		if (ans == Integer.MAX_VALUE) {
			System.out.println("-1");
		} else {
			System.out.println(ans);
		}
	}

	static void bfs() {

		Queue<Node> q = new LinkedList<>();
		q.add(new Node(RED_X, RED_Y, BLUE_X, BLUE_Y, 0));

		while (!q.isEmpty()) {

			if (q.peek().cnt >= 10) {
				break;
			}

			for (int i = 0; i < 4; i++) {
				// 좌
				if (i == 0) {
					boolean BFLAG = false;
					boolean RFLAG = false;
					Node cur = q.peek();
					int nRX = cur.red_x;
					int nBX = cur.blue_x;

					int cnt1 = 0;
					int cnt2 = 0;
					while (map[cur.red_y][nRX - 1] != '#') {

						if (map[cur.red_y][nRX - 1] == 'O') {
							RFLAG = true;
							break;
						}
						nRX--;
						cnt1 += 1;

					}

					while (map[cur.blue_y][nBX - 1] != '#') {
						if (map[cur.blue_y][nBX - 1] == 'O') {
							BFLAG = true;
							break;
						}
						nBX--;
						cnt2 += 1;
					}

					// R, B가 같을 때
					if (cur.blue_y == cur.red_y && nRX == nBX) {
						if (cur.red_x < cur.blue_x) {
							nBX++;
						} else {
							nRX++;
						}
					}

					// 레드볼 골인
					if (RFLAG && !BFLAG) {
						
//						if (cur.cnt + 1 < 10) {
//							System.out.println(cur.cnt + 1);
//						} else {
//							System.out.println("-1");
//						}syso
//						
//						System.out.println("@@");
//						System.out.println("좌" +(cur.cnt+1));
//						System.out.println("RED X / Y"+nRX +"\t"+cur.red_y + "BLUE X/ Y"+ nBX+"\t"+cur.blue_y);
						
						ans = Math.min(cur.cnt + 1, ans);

						return;
					}

					// 노골
					if (!RFLAG && !BFLAG && (cnt1 > 0 || cnt2 > 0)) {
//						System.out.println("좌" +(cur.cnt+1));
//						System.out.println("RED X / Y"+nRX +"\t"+cur.red_y + "BLUE X/ Y"+ nBX+"\t"+cur.blue_y);
						q.add(new Node(nRX, cur.red_y, nBX, cur.blue_y, cur.cnt + 1));
					}

				}

				// 우
				if (i == 1) {
					boolean BFLAG = false;
					boolean RFLAG = false;
					Node cur = q.peek();
					int nRX = cur.red_x;
					int nBX = cur.blue_x;

					int cnt1 = 0;
					int cnt2 = 0;

					while (map[cur.red_y][nRX + 1] != '#') {
						if (map[cur.red_y][nRX + 1] == 'O') {
							RFLAG = true;
							break;
						}
						nRX++;
						cnt1 += 1;
					}

					while (map[cur.blue_y][nBX + 1] != '#') {
						if (map[cur.blue_y][nBX + 1] == 'O') {
							BFLAG = true;
							break;
						}
						nBX++;
						cnt2 += 1;
					}

					// R, B가 같을 때
					if (cur.blue_y == cur.red_y && nRX == nBX) {
						if (cur.red_x < cur.blue_x) {
							nRX--;
						} else {
							nBX--;
						}
					}
					// 레드볼 골인
					if (RFLAG && !BFLAG) {
//						if (cur.cnt + 1 < 10) {
//							System.out.println(cur.cnt + 1);
//						} else {
//							System.out.println("-1");
//						}
//						System.out.println("골인@@");
//						System.out.println("우"+(cur.cnt+1));
//						System.out.println("RED X / Y"+nRX +"\t"+cur.red_y + "BLUE X/ Y"+ nBX+"\t"+cur.blue_y);
						
						ans = Math.min(cur.cnt + 1, ans);
						return;
					}

					// 노골
					if (!RFLAG && !BFLAG && (cnt1 > 0 || cnt2 > 0)) {
//						System.out.println("우"+(cur.cnt+1));
//						System.out.println("RED X / Y"+nRX +"\t"+cur.red_y + "BLUE X/ Y"+ nBX+"\t"+cur.blue_y);
						q.add(new Node(nRX, cur.red_y, nBX, cur.blue_y, cur.cnt + 1));
					}

				}

				// 상
				if (i == 2) {
					boolean BFLAG = false;
					boolean RFLAG = false;
					Node cur = q.peek();
					int nRY = cur.red_y;
					int nBY = cur.blue_y;

					int cnt1 = 0, cnt2 = 0;
					while (map[nRY - 1][cur.red_x] != '#') {
						if (map[nRY - 1][cur.red_x] == 'O') {
							RFLAG = true;
							break;
						}
						nRY--;
						cnt1 += 1;
					}

					while (map[nBY - 1][cur.blue_x] != '#') {
						if (map[nBY - 1][cur.blue_x] == 'O') {
							BFLAG = true;
							break;
						}
						nBY--;
						cnt2 += 1;
					}

					// R, B가 같을 때
					if (cur.blue_x == cur.red_x && nRY == nBY) {
						if (cur.red_y < cur.blue_y) {
							nBY++;
						} else {
							nRY++;
						}
					}
					// 레드볼 골인
					if (RFLAG && !BFLAG) {
//						System.out.println("@@골인");
//						System.out.println("상"+(cur.cnt+1));
//						System.out.println("RED X / Y"+cur.red_x +"\t"+nRY + "BLUE X/ Y"+ cur.blue_x+"\t"+nBY);
//						
						
//						if (cur.cnt + 1 < 10) {
//							System.out.println(cur.cnt + 1);
//						} else {
//							System.out.println("-1");
//						}
						ans = Math.min(cur.cnt + 1, ans);

						return;
//						System.out.println(cur.cnt + 1);
//						return;
					}

					// 노골
					if (!RFLAG && !BFLAG && (cnt1 > 0 || cnt2 > 0)) {
//						System.out.println("상"+(cur.cnt+1));
//						System.out.println("RED X / Y"+cur.red_x +"\t"+nRY + "BLUE X/ Y"+ cur.blue_x+"\t"+nBY);
						q.add(new Node(cur.red_x, nRY, cur.blue_x, nBY, cur.cnt + 1));
					}

				}

				// 하
				if (i == 3) {
					boolean BFLAG = false;
					boolean RFLAG = false;
					Node cur = q.peek();
					int nRY = cur.red_y;
					int nBY = cur.blue_y;

					int cnt1 = 0, cnt2 = 0;
					while (map[nRY + 1][cur.red_x] != '#') {
						if (map[nRY + 1][cur.red_x] == 'O') {
							RFLAG = true;
							break;
						}
						nRY++;
						cnt1 += 1;
					}

					while (map[nBY + 1][cur.blue_x] != '#') {
						if (map[nBY + 1][cur.blue_x] == 'O') {
							BFLAG = true;
							break;
						}
						nBY++;
						cnt2 += 1;
					}

					// R, B가 같을 때
					if (cur.blue_x == cur.red_x && nRY == nBY) {
						if (cur.red_y < cur.blue_y) {
							nRY--;
						} else {
							nBY--;
						}
					}
					// 레드볼 골인
					if (RFLAG && !BFLAG) {
//						System.out.println("골인");
//						System.out.println("하"+(cur.cnt+1));
//						System.out.println("RED X / Y"+cur.red_x +"\t"+nRY + "BLUE X/ Y"+ cur.blue_x+"\t"+nBY);
		
//						if (cur.cnt + 1 < 10) {
//							System.out.println(cur.cnt + 1);
//						} else {
//							System.out.println("-1");
//						}
						ans = Math.min(cur.cnt + 1, ans);

						return;

					}

					// 노골
					if (!RFLAG && !BFLAG && (cnt1 > 0 || cnt2 > 0)) {
//						System.out.println("하"+(cur.cnt+1));
//						System.out.println("RED X / Y"+cur.red_x +"\t"+nRY + "BLUE X/ Y"+ cur.blue_x+"\t"+nBY);
						q.add(new Node(cur.red_x, nRY, cur.blue_x, nBY, cur.cnt + 1));

					}

				}

			}
//			System.out.println("---------");
			q.poll();
		}
	}

	static class Node {

		int red_x, red_y, blue_x, blue_y, cnt;

		Node(int red_x, int red_y, int blue_x, int blue_y, int cnt) {
			this.red_x = red_x;
			this.red_y = red_y;
			this.blue_x = blue_x;
			this.blue_y = blue_y;
			this.cnt = cnt;

		}

	}

}
