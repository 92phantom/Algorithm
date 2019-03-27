package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj_1931 {
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());

		int start, end;
		PriorityQueue<Meeting> pQ = new PriorityQueue<Meeting>(new Comparator<Meeting>() {

			@Override
			public int compare(Meeting m1, Meeting m2) {

				if (m1.end != m2.end) {
					if (m1.end > m2.end) {
						return 1;
					} else {
						return -1;
					}
				} else if (m1.end == m2.end) {
					if (m1.start > m2.start) {
						return 1;
					} else {
						return -1;
					}
				}
				return 0;

			}
		});

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			start = Integer.parseInt(st.nextToken());
			end = Integer.parseInt(st.nextToken());
			
			pQ.add(new Meeting(start, end));
		}
		
		int ans = 0;
		end = -1;
		
		while(!pQ.isEmpty()) {
			
			Meeting m = pQ.poll();
			
			if(m.start >= end) {
				ans ++;
				end = m.end;
			}
			
		}
		
		System.out.println(ans);

	}

	static class Meeting {
		int start, end;

		Meeting(int start, int end) {
			this.start = start;
			this.end = end;
		}

	}

}
