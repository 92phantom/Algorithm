package SamsungExpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.concurrent.ConcurrentHashMap;

public class swea_2447 {

	static int T;
	static int N, M;
	static int customerNum;
	static int A; // 지갑을 두고간 고객의 접수 창구 번호
	static int B; // 지갑을 두고간 고객의 정비 창구 번호
	static int ans;

	static ArrayList<Node> RECEPTION = new ArrayList<>();
	static ArrayList<Node> REPAIR = new ArrayList<>();
	static ArrayList<CustomerStruc> CUSTOMER = new ArrayList<>();

	static Set<Integer> out = ConcurrentHashMap.newKeySet();

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {

			RECEPTION = new ArrayList<>();
			REPAIR = new ArrayList<>();
			out = ConcurrentHashMap.newKeySet();
			CUSTOMER = new ArrayList<>();
			ans = 0;
			
			st = new StringTokenizer(br.readLine(), " ");

			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			customerNum = Integer.parseInt(st.nextToken());
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());

			// 접수 창구 입력
			st = new StringTokenizer(br.readLine(), " ");

			for (int i = 0; i < N; i++) {
				RECEPTION.add(new Node(i, Integer.parseInt(st.nextToken()), false, -1, -1, -1, ""));
			}

			// 정비 창구 입력
			st = new StringTokenizer(br.readLine(), " ");

			for (int i = 0; i < M; i++) {
				REPAIR.add(new Node(i, Integer.parseInt(st.nextToken()), false, -1, -1, -1, ""));
			}

			Collections.sort(RECEPTION, new Sorting());
			Collections.sort(REPAIR, new Sorting());

			// 고개 정보 입력
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < customerNum; i++) {
				CUSTOMER.add(new CustomerStruc(i, Integer.parseInt(st.nextToken()), false, false));
			}

			func();

			String[] temp = RECEPTION.get(A - 1).idxSave.split(",");
			String[] temp2 = REPAIR.get(B - 1).idxSave.split(",");

			for (int i = 0; i < temp.length; i++) {
				if (!out.contains(Integer.parseInt(temp[i]))) {
					System.out.println(temp[i]);
					out.add(Integer.parseInt(temp[i]));
					ans += Integer.parseInt(temp[i]);
				}
			}
			for (int i = 0; i < temp2.length; i++) {
				if (!out.contains(Integer.parseInt(temp2[i]))) {
					System.out.println(temp2[i]);
					out.add(Integer.parseInt(temp2[i]));
					ans += Integer.parseInt(temp2[i]);
				}
//				out.add(Integer.parseInt(temp2[i]));
			}

			System.out.println("#" + tc + " " + ans);
		}

	}

	static void func() {

		Queue<CustomerStruc> q = new LinkedList<>();
		Queue<CustomerStruc> wjdql = new LinkedList<>();

		int time = 0;
		int finishCustomer = 0;

		while (true) {

			if (finishCustomer == customerNum) {
				break;
			}

			for (int i = 0; i < customerNum; i++) {

				// 고객의 도착시간이 현재 시간과 동일 할 때
				// 끝난 고객이 아닐때
				// 이미 처리중인 고객이 아닐 때
				if (!CUSTOMER.get(i).isFinish && !CUSTOMER.get(i).isProcess && CUSTOMER.get(i).time <= time) {
					CUSTOMER.get(i).isProcess = true;
					q.add(new CustomerStruc(CUSTOMER.get(i).idx, 0, false, true));
				}
			}

			// 접수하자
			for (int i = 0; i < RECEPTION.size(); i++) {

				if (!q.isEmpty() && !RECEPTION.get(i).isUsing) {

					CustomerStruc cc = q.poll();
					RECEPTION.get(i).isUsing = true;
					RECEPTION.get(i).currentCus = cc.idx;
					RECEPTION.get(i).howTakes = cc.time;
					RECEPTION.get(i).idxSave += (cc.idx + 1) + ",";
				}
			}

			// 접수한거 처리 비워주기
			for (int i = 0; i < RECEPTION.size(); i++) {
				if (RECEPTION.get(i).isUsing) {
					RECEPTION.get(i).howTakes += 1;

					if (RECEPTION.get(i).howTakes == RECEPTION.get(i).time) {

						// 사용 가능상태로 변경
						RECEPTION.get(i).isUsing = false;

						wjdql.add(new CustomerStruc(RECEPTION.get(i).currentCus, 0, false, true));

					}
				}
			}

			// 정비처에 집어 넣자
			for (int i = 0; i < REPAIR.size(); i++) {

				if (!wjdql.isEmpty() && !REPAIR.get(i).isUsing) {

					CustomerStruc cc = wjdql.poll();
					REPAIR.get(i).isUsing = true;
					REPAIR.get(i).currentCus = cc.idx;
					REPAIR.get(i).howTakes = cc.time;
					REPAIR.get(i).idxSave += (cc.idx + 1) + ",";

				}
			}

			// 정비한거 처리 비워주기
			for (int i = 0; i < REPAIR.size(); i++) {
				if (REPAIR.get(i).isUsing) {
					REPAIR.get(i).howTakes += 1;

					if (REPAIR.get(i).howTakes == REPAIR.get(i).time) {
						
						// 사용 가능상태로 변경
						REPAIR.get(i).isUsing = false;

						// 완료된 고객 수 증가 및 증가 처리!
						CUSTOMER.get(RECEPTION.get(i).currentCus).isFinish = true;

						finishCustomer += 1;
					}
				}
			}

			// 정비 완료 체크하자!

			time++;
		}
	}

	static class Sorting implements Comparator<Node> {
		@Override
		public int compare(Node n1, Node n2) {
			// TODO Auto-generated method stub
			if (n1.num > n2.num) {
				return 1;
			} else if (n1.num < n2.num) {
				return -1;
			}
			return 0;
		}
	}

	static class CustomerStruc {

		int idx, time;
		boolean isFinish;
		boolean isProcess;

		CustomerStruc(int idx, int time, boolean isFinish, boolean isProcess) {
			this.idx = idx;
			this.time = time;
			this.isFinish = isFinish;
			this.isProcess = isProcess;
		}
	}

	static class Node {

		int num, time, currentCus, howTakes, cusIDX;
		boolean isUsing;
		String idxSave;

		Node(int num, int time, boolean isUsing, int currentCus, int howTakes, int cusIDX, String idxSave) {
			this.num = num;
			this.time = time;
			this.isUsing = isUsing;
			this.currentCus = currentCus;
			this.howTakes = howTakes;
			this.idxSave = idxSave;
		}

	}

}
