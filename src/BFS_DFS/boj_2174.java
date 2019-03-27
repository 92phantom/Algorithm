package BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_2174 {

	static int A, B;
	static int N, M;

	static ArrayList<Node> robot = new ArrayList<>();
	static Queue<Order> orderList = new LinkedList<>();
	static Queue<String> out = new LinkedList<>();
	static int[][] map;

	// N:0, W:1, E:2, S:3
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[102][102];

		robot.add(new Node(0,0,0));
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			// NWES
			// �� 0 ��1 ��2 ��3
			int d = 0;

			String temp = st.nextToken();
			if (temp.matches("N|W|E|S")) {
				if (temp.equals("N")) {
					d = 3;
				} else if (temp.equals("W")) {
					d = 2;
				} else if (temp.equals("E")) {
					d = 0;
				} else if(temp.equals("S")){
					d = 1;
				}
			}
			robot.add(new Node(x - 1, B - y, d));
			
			map[B - y][x - 1] = i;
		}

		for (int i = 1; i <= M; i++) {

			st = new StringTokenizer(br.readLine(), " ");
			int robotNum = Integer.parseInt(st.nextToken());
			/*
			 * L: �κ��� ���ϰ� �ִ� ������ �������� �������� 90�� ȸ���Ѵ�. 0 R: �κ��� ���ϰ� �ִ� ������ �������� ���������� 90��
			 * ȸ���Ѵ�. 1 F: �κ��� ���ϰ� �ִ� ������ �������� ������ �� ĭ �����δ�. 2
			 */
			char order = st.nextToken().charAt(0);
			int count = Integer.parseInt(st.nextToken());

			orderList.add(new Order(robotNum, order, count));
		}

		
		
		while (!orderList.isEmpty()) {

			Order curO = orderList.poll();

			int robotNum = curO.robot;

			int x,y,d;
			int nextX  =0 ;
			int nextY = 0;
			for (int i = 0; i < curO.count; i++) {
				
				// �̵�
				if(curO.order == 'F') {
					
					y = robot.get(robotNum).y;
					x = robot.get(robotNum).x;
					d = robot.get(robotNum).d;
					
					nextY = y + dy[d];
					nextX = x + dx[d];
					
					if(nextX < 0 || nextY <0 || nextX >=A || nextY >= B) {
						out.add("Robot " + robotNum + " crashes into the wall");
						break;
					}
					
					else if(map[nextY][nextX] != 0) {
						out.add("Robot " + robotNum + " crashes into robot " + map[nextY][nextX]);
						break;
					}
					else if(nextX>= 0 && nextY>= 0 && nextX<A && nextY<B) {
						map[y][x] = 0;
						robot.get(robotNum).x = nextX;
						robot.get(robotNum).y = nextY;
						map[nextY][nextX] = robotNum;
					}
				}
				
				// ���� ȸ��
				else if(curO.order == 'L') {
					d = robot.get(robotNum).d;
					robot.get(robotNum).d = (d+3)%4;
				}

				else if(curO.order == 'R') {
					d = robot.get(robotNum).d;
					robot.get(robotNum).d = (d+1)%4;
				}
				
			}

		}

		if (out.size() != 0) {
			System.out.println(out.poll());
		} else {
			System.out.println("OK");
		}
	}

	static class Order {
		int robot, count;
		char order;
		Order(int robot, char order, int count) {
			this.robot = robot;
			this.order = order;
			this.count = count;
		}
	}

	static class Node {
		int x, y, d;

		Node(int x, int y, int d) {
			this.x = x;
			this.y = y;
			this.d = d;
		}
	}

}
