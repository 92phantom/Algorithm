package BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj_1707_new {

	static int K; // Loop
	static int V, E;
	static int[] NODE;
	static int cnt = 0;
	static ArrayList<Integer>[] list = (ArrayList<Integer>[]) new ArrayList[20001];

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		K = Integer.parseInt(br.readLine());

		for (int i = 0; i < K; i++) {

			st = new StringTokenizer(br.readLine(), " ");

			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());

			NODE = new int[20001];

			boolean flag = true;

			// Edge Loop

			for(int j = 1; j<=V; j++) {
				
				list[j] = new ArrayList<Integer>();
				
			}
			
			for (int j = 0; j < E; j++) {

				st = new StringTokenizer(br.readLine(), " ");

				int startNode, endNode;

				startNode = Integer.parseInt(st.nextToken());
				endNode = Integer.parseInt(st.nextToken());

				list[startNode].add(endNode);
				list[endNode].add(startNode);
			}
			
			for (int j=1; j<=V; j++) {
				
				if(NODE[j] == 0) {
					dfs(j, 1);
				}
			}
			
			for(int j=1; j<=V; j++) {
				
				for(int k=0; k<list[j].size(); k++) {
					
					int nextNode = list[j].get(k);
					
					if(NODE[j] == NODE[nextNode]) {
						flag = false;
					}
					
				}
				
			}
			
			System.out.println(flag? "YES": "NO");
		
		}

	}

	static void dfs(int index, int color) {
		
		NODE[index] = color;
		
		int nextColor = 0;
		
		if(NODE[index] ==1) {
			nextColor = 2;
		}else {
			nextColor = 1;
		}
		
		for(int i=0; i<list[index].size(); i++) {
			
			int nextNode = list[index].get(i);
			
			if(NODE[nextNode] == 0) {
				
				dfs(nextNode, nextColor);
				
			}
			
			
		}
		
	}

}
