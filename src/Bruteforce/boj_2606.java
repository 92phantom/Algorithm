package Bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj_2606 {

	static int Com;
	static int vertex;
	static ArrayList<Integer>[] list;
	static boolean[] visited;
	static int count;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Com = Integer.parseInt(br.readLine());
		vertex = Integer.parseInt(br.readLine());

		//
		list = new ArrayList[101];
		visited = new boolean[101];
		count = 0;
		for (int i = 0; i < 101; i++) {
			list[i] = new ArrayList<Integer>();
		}

		StringTokenizer st;

		for (int i = 0; i < vertex; i++) {

			st = new StringTokenizer(br.readLine(), " ");

			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());

			list[start].add(end);
			list[end].add(start);
		}

		if (list[1].size() == 0) {

			for (int i = 1; i <= Com; i++) {

				for (int j = 0; j < list[i].size(); j++) {

					int nodeInfo = list[i].get(j);

					if (nodeInfo == 1) {
//						System.out.println("연결된 node" + i);
						dfs(i);
					}
				}

			}
		} else {
			dfs(1);
		}

		System.out.println(count);
	}

	static void dfs(int node) {

		if (node != 1) {
			count += 1;
		}
		
		visited[node] = true;

		for (int i = 0; i < list[node].size(); i++) {

			int nodeInfo = list[node].get(i);

			if (!visited[nodeInfo]) {
//				System.out.println("체크된 노드" + nodeInfo);
				dfs(nodeInfo);
			}

		}

	}

}
