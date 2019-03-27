import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_B {

	static int N, M;
	static int[][] map;
	static ArrayList<Node> list = new ArrayList<>();
	static ArrayList<Node> YOURS = new ArrayList<>();
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static int ans;
	static boolean[] visited;
	
	// �׷����� ������ Ǯ����� ! 
	// ��� ���� ���� �ϳ��� �ƴϱ� ���� -- > �ٸ������ ������ ����ϰ� �̼��ð�
	// ���鼭 0�� �ϳ��� ������ ���� �ʾҴ�.
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		ans = 0;
		
		
		
		// 0 : ��ĭ, 1 : ���� ��, 2: ��� ��
		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			for (int j = 0; j < M; j++) {
				int temp = Integer.parseInt(st.nextToken());

				if (temp == 0) {
					list.add(new Node(j, i));
				} else if (temp == 2) {
					YOURS.add(new Node(j, i));
				}
				map[i][j] = temp;
			}
		}

		visited = new boolean[list.size()+1];
		
		// ���� �ΰ� �ξ� ���� �� �ִ� ��뵹�� �ִ밹��
//		for (int i = 0; i < list.size(); i++) {
//			func(i, 1);
//		}

		func(1, 1);
		
		System.out.println(ans);
		
	}

	static void func(int idx, int count) {

		if(count == 2) {
			check();
			return;
		}
		
		visited[idx] = true;
		Node cur = list.get(idx);
		map[cur.y][cur.x] = 1; 
		
		
		for(int i=0; i<list.size(); i++) {
			
			if(!visited[i]) {
				visited[i] = true;
				Node next = list.get(i);
				map[next.y][next.x] = 1; 
						
				func(i, count+1);
				visited[i] = false;
//				Node next = list.get(i);
				map[next.y][next.x] = 0; 
				
			}
			
		}
		
		visited[idx] = false;
		map[cur.y][cur.x] = 0; 
		
	}

	// � �׾����� üũ
	static void check() {

		
		
		int kill = 0;
		System.out.println("--");
		for(int i=0; i<N; i++) {
			System.out.println(Arrays.toString(map[i]));
		}
		
		for (int i = 0; i < YOURS.size(); i++) {

			int x = YOURS.get(i).x;
			int y = YOURS.get(i).y;

			int count = 0;

			for (int j = 0; j < 4; j++) {

				int nextX = x + dx[j];
				int nextY = y + dy[j];

				if (nextX < 0 || nextY < 0 || nextY >= N || nextX >= M) {
					count += 1;
					
				}

				else if (nextX >= 0 && nextY >= 0 && nextY < N && nextX < M) {

					if (map[nextY][nextX] != 0) {
						count += 1;
					}

				}
				System.out.print("X"+x +"\tY:"+y);
				System.out.print("\tCOUNT"+count);
				System.out.println();
				if (count >= 4) {
					kill += 1;
				}

			}

		}
		System.out.println("KILL"+kill);
		ans = Math.max(kill, ans);
		
	}

	static class Node {

		int x;
		int y;

		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}
}
