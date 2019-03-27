import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_17071 {

	static int N, K;

	static int[] bx = { -1, 1, 1 };

	static int broGPS = 0;
	static int broSpeed = 0;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken()); // 수빈
		K = Integer.parseInt(st.nextToken()); // 동생

		func();
	}

	static void func() {

		Queue<Node> subin = new LinkedList<>();
		subin.add(new Node(N, 0));

		broGPS = K;

		if (N == broGPS) {
			System.out.println(0);
			return;
		}

		while (true) {

			broSpeed += 1;
			broGPS += broSpeed;

			if (broGPS >= 500001) {
				System.out.println("-1");
				return;
			}
//			System.out.println("---------------");
//			System.out.println("동생의 현재 위치"+ broGPS);
			int size = subin.size();

			for (int i = 0; i < size; i++) {
				Node cur = subin.poll();
				
				for (int j = 0; j < 3; j++) {
					int nextX = cur.x + bx[j];
					if (j == 2) {
						nextX = 2 * cur.x;
					}

//					System.out.println("수빈의 위치"+ nextX);
					
					if (nextX < 0 || nextX >= 500001)
						continue;

					else {

						if (nextX == broGPS) {
							System.out.println(cur.count + 1);
							return;
						}

						subin.add(new Node(nextX, cur.count + 1));
					}
				}
			}

		}

	}

	static class Node implements Comparable<Node>{

		int x, count;

		Node(int x, int count) {
			this.x = x;
			this.count = count;
		}
		
		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return ;
		}

	}

}
