package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

import Greedy.boj_1931.Meeting;

public class boj_1493 {

	static int LENGTH, WIDTH, HEIGHT;
	static int N; // 큐브의 종류
	static long[] INPUT_BOX;
	static ArrayList<Integer> available = new ArrayList<>();
	static long ans = 0;
	static boolean possible = true;
	static PriorityQueue<cube> pQ;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		LENGTH = Integer.parseInt(st.nextToken());
		WIDTH = Integer.parseInt(st.nextToken());
		HEIGHT = Integer.parseInt(st.nextToken());

		N = Integer.parseInt(br.readLine());

		INPUT_BOX = new long[22];

		pQ = new PriorityQueue<cube>(new Comparator<cube>() {

			@Override
			public int compare(cube c1, cube c2) {

				if (c1.size > c2.size) {
					return -1;
				} else if (c1.size == c2.size) {
					return 0;
				} else {
					return 1;
				}

			}
		});

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			int idx = Integer.parseInt(st.nextToken());
			int cnt = Integer.parseInt(st.nextToken());
			pQ.add(new cube((int) Math.pow(2, idx), cnt));

		}

		func(LENGTH, WIDTH, HEIGHT);

		System.out.println(possible ? ans : -1);
	}

	static void func(int x, int y, int z) {

		if (!possible)
			return;

		if (x == 0 || y == 0 || z == 0)
			return;

		
		for (int i = 0; i < available.size(); i++) {

			if (INPUT_BOX[available.get(i)] > 0 && x >= (int) Math.pow(2, available.get(i))
					&& y >= (int) Math.pow(2, available.get(i)) && z >= (int) Math.pow(2, available.get(i))) {

				ans += 1;
				INPUT_BOX[available.get(i)] -= 1;

				func(x, y, z - (int) Math.pow(2, available.get(i)));
				func(x, y - (int) Math.pow(2, available.get(i)), z);
				func(x - (int) Math.pow(2, available.get(i)), y, z);
				return;
			}

		}

		possible = false;

	}

	static class cube {
		int size, count;

		cube(int size, int count) {
			this.size = size;
			this.count = count;
		}

	}

}
