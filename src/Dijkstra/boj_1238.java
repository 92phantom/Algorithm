package Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class boj_1238 {

	static int N, M, K, remap[][], map[][], INF = 1000 * 100 + 1;
	static int dist[], redist[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());

		map = new int[N + 1][N + 1];
		remap = new int[N + 1][N + 1];
		dist = new int[N + 1];
		redist = new int[N + 1];

		int maxDistance = -1;

		for (int i = 0; i < N + 1; i++) {

			dist[i] = redist[i] = INF;

			for (int j = 0; j < N + 1; j++) {

				map[i][j] = remap[i][j] = INF;
			}

		}

		for (int i = 0; i < M; i++) {

			int from = Integer.parseInt(br.readLine());
			int to = Integer.parseInt(br.readLine());
			int w = Integer.parseInt(br.readLine());
			map[from][to] = remap[to][from] = w;

		}

		dij(K, map, dist);
		dij(K, remap, redist);

		for (int i = 1; i < N + 1; i++) {
			if (maxDistance < dist[i] + redist[i]) {
				maxDistance = dist[i] + redist[i];
			}
		}

		System.out.println(maxDistance);

	}

	static void dij(int start, int[][] map, int[] dist) {

		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		pq.offer(start);
		dist[start] = 0;

		while (!pq.isEmpty()) {

			int x = pq.poll();

			for (int i = 1; i < N + 1; i++) {
				if (dist[i] > map[x][i] + dist[x]) {
					dist[i] = map[x][i] + dist[x];
					pq.offer(i);
				}
			}
			
		}

	}

}
