package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ComplexIndexing_2667 {

	static boolean[][] visited = new boolean[26][26];
	static String[] vertex = { "x" , "y" };
	
	public static void main(String... args) throws NumberFormatException, IOException {

		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), "");

		int N = Integer.parseInt(st.nextToken());

		int[][] square = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), "");
			for (int j = 0; j < N; j++) {

				square[i][j] = Integer.parseInt(st.nextToken(" "));

			}

		}

		dfs(0, 0,square);

	}

	static void dfs(int x, int y, int[][] square) {

		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(0, 0, 0));
		visited[x][y] = true;

		while(!queue.isEmpty()){
			
			Node temp = queue.poll();
			int xpos = temp.xpos;
			int ypos = temp.ypos;	
			int cnt = temp.cnt;
			
			for(int i=0; i<vertex.length; i++){
				
				int next;
				
				if(vertex[i].equals("x")){
					next = xpos+1;
				}else{
					next = ypos+1;
				}
				
				if(!visited[xpos][ypos]){
					
				}
				
			}
//			int nextPos = xpos + 1;
			
			
			
			
		}
		
		
	}

	static class Node {
		int xpos, ypos,cnt;

		public Node(int xpos, int ypos, int cnt) {
			this.ypos = ypos;
			this.xpos = xpos;
			this.cnt = cnt;
		}
	}
}
