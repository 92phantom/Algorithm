package BOJ20190401;
import java.io.*;
import java.util.*;

public class boj_3190 {

	static int N, K, L, dir, time;
	static char curDir;
	static int map[][] = new int[101][101];
	static int dx[] = {-1,0,1,0}, dy[] = {0,1,0,-1};	// 상 우 하 좌
	static Deque<Node> dq = new LinkedList<>();
	static boolean flag = false;
	public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());	// 보드 크기
		K = Integer.parseInt(br.readLine());	// 사과 개수
		dir = 1;	curDir='D';
		int x, y;
		for(int i=1;i<=K;i++) {
			st= new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());	
			map[x][y] = 2;	// 사과의 위치
		}
		map[1][1] =1; //	뱀의 위치
		L = Integer.parseInt(br.readLine());

		time=0;  char C;
		dq.add(new Node(1, 1));
		for(int i=1;i<=L;i++) {
			st= new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());		// 시간
			C = st.nextToken().charAt(0);						// 회전 방향 (왼 L, 오 D)

			move(t-time, C);
			if(flag) break;	// 벽이나 몸에 부딪혔나?
			
			if(curDir=='D') {	
				dir = (dir+1)%4;
			} else if(curDir=='L') {
				dir = (dir+3)%4;
			}
			
			if(i==L) {	//마지막에는 계속 가야함
				t = Integer.MAX_VALUE;
				move(t, C);
			}
		}

		System.out.println(time);
	}

	private static void move(int t, char c) {

		if(t==0) {
			curDir = c;
			return;
		}

		time++;
		int x=dq.peek().x;	int y = dq.peek().y;
		int nx=0, ny=0;
		nx = x+dx[dir];
		ny = y+dy[dir];


		if(!isRange(nx, ny) || map[nx][ny]==1) {		//벽 부딪 or 자신의 몸에 부딪
			flag = true;
			return;
		}

		if(map[nx][ny]==0) {			// 아무것도 없다
			dq.addFirst(new Node(nx, ny));
			Node n = dq.pollLast();
			map[nx][ny] = 1;
			map[n.x][n.y] =0;
		}else if(map[nx][ny]==2) {	// 사과가 있다
			map[nx][ny] =1;
			dq.addFirst(new Node(nx, ny));
		}

		move(t-1, c);

	}

	private static boolean isRange(int nx, int ny) {		
		return nx>0 && ny>0 && nx<=N && ny<=N;
	}

	private static class Node{
		int x, y;
		Node(int x, int y){
			this.x = x; this.y = y;
		}
	}

}