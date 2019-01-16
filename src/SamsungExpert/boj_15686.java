package SamsungExpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj_15686 {

	static int N, M;
	static int ans = Integer.MAX_VALUE;
	static int[][] map;
	static int[] selectedChick;
	static ArrayList<Node> homeList = new ArrayList<>();
	static ArrayList<Node> chickList = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			for (int j = 0; j < N; j++) {

				int id = Integer.parseInt(st.nextToken());

				if (id == 1) {
					homeList.add(new Node(i, j, false));
				} else if (id == 2) {
					chickList.add(new Node(i, j, false));
				}

				map[i][j] = id;

			}

		}

		selectedChick = new int[chickList.size()];

		for (int i = 0; i < chickList.size(); i++) {

			chickList.get(i).visited = true;
			chickSelect(i, 0);

			// Back Tracking
			chickList.get(i).visited = false;

		}

		System.out.println(ans);

	}

	static void chickSelect(int index, int depth) {

		selectedChick[depth] = index;

		// 3 SELECT
		if (depth == (M - 1)) {

			int sum = 0;
			int distance = 0;

			for (int i = 0; i < homeList.size(); i++) {

				int min = Integer.MAX_VALUE;

				for (int j = 0; j < M; j++) {
					distance = Math.abs(homeList.get(i).x - chickList.get(selectedChick[j]).x)
							+ Math.abs(homeList.get(i).y - chickList.get(selectedChick[j]).y);
					min = Math.min(min, distance);
				}

				sum += min;

			}

			ans = Math.min(ans, sum);

		}
		
		
		for (int i = index; i < chickList.size(); i++) {

			if (chickList.get(i).visited)
				continue;

			chickList.get(i).visited = true;
			chickSelect(i, depth + 1);
			// Back
			chickList.get(i).visited = false;
		}



	}

}

class Node {

	int y, x;
	boolean visited;

	Node(int y, int x, boolean visited) {
		this.y = y;
		this.x = x;
		this.visited = visited;
	}

}