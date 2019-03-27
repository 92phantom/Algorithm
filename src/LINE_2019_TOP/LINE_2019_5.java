package LINE_2019_TOP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class LINE_2019_5 {

	static int C, B;

	static int[] bx = { -1, 1, 1 };

	static int conyGPS = 0;
	static int conySpeed = 0;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		C = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());

		func();
	}

	static void func() {

		Queue<Node> brown = new LinkedList<>();
		brown.add(new Node(B, 0));

		conyGPS = C;

		if (B == conyGPS) {
			System.out.println(0);
			return;
		}

		while (true) {

			conySpeed += 1;
			conyGPS += conySpeed;

			if (conyGPS >= 200001) {
				System.out.println("-1");
				return;
			}

			int size = brown.size();

			for (int i = 0; i < size; i++) {
				Node cur = brown.poll();

				for (int j = 0; j < 3; j++) {
					int nextX = cur.x + bx[j];
					if (j == 2) {
						nextX = 2 * cur.x;
					}

					if (nextX < 0 || nextX >= 200001)
						continue;

					else {

						if (nextX == conyGPS) {
							System.out.println(cur.count + 1);
							return;
						}

						brown.add(new Node(nextX, cur.count + 1));
					}
				}
			}

		}

	}

	static class Node {

		int x, count;

		Node(int x, int count) {
			this.x = x;
			this.count = count;
		}

	}

}
