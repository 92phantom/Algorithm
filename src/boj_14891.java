import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_14891 {

	static int[][] map;
	static int K;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		map = new int[4][8];

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < 4; i++) {

			String temp = br.readLine();

			for (int j = 0; j < 8; j++) {
				map[i][j] = Integer.parseInt(temp.charAt(j) + "");
			}

		}

		K = Integer.parseInt(br.readLine());

		StringTokenizer st;
		for (int i = 0; i < K; i++) {

			st = new StringTokenizer(br.readLine(), " ");
			int deviceNum = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken());
			// 1 시계, -1 반시계
			visited = new boolean[4];

			func(deviceNum - 1, dir);

//			for (int j = 0; j < 4; j++) {
//				System.out.println(Arrays.toString(map[j]));
//			}

		}

		int result = 0;
		for (int i = 0; i < 4; i++) {
			if (map[i][0] == 1) {
				result += Math.pow(2, i);
			}
		}

		System.out.println(result);

	}

	static void func(int deviceNum, int dir) {
		Queue<Device> q = new LinkedList<>();

		q.add(new Device(deviceNum, dir));

		visited[deviceNum] = true;

		while (!q.isEmpty()) {

			Device cur = q.poll();
			int idx = cur.deviceNum;
			int curDir = cur.dir;

			int left = idx - 1;
			int right = idx + 1;

			if (left >= 0) {
				if (map[idx][6] != map[left][2] && !visited[left]) {
					q.add(new Device(left, curDir * -1));
					visited[left] = true;
				}
			}

			if (right < 4) {
				if (map[idx][2] != map[right][6] && !visited[right]) {
					q.add(new Device(right, curDir * -1));
					visited[right] = true;
				}
			}

			// 회전하자
			int temp = 0;
			// 시계
			if (curDir == 1) {

				temp = map[idx][7];

				for (int i = 7; i > 0; i--) {
					map[idx][i] = map[idx][i - 1];
				}

				map[idx][0] = temp;

			}

			// 반 시계
			else if (curDir == -1) {

				temp = map[idx][0];

				for (int i = 0; i < 7; i++) {
					map[idx][i] = map[idx][i + 1];
				}

				map[idx][7] = temp;
			}

		}

	}

	static class Device {

		int deviceNum;
		int dir;

		Device(int deviceNum, int dir) {
			this.deviceNum = deviceNum;
			this.dir = dir;
		}

	}
}
