package BFS_DFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
public class Main {
	// ���� ���� ���
	private static final char NEW_LINE = '\n';
	public static void main(String args[]) throws Exception {
		// ���۸� ���� �Է� ���� ����
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		// ���۸� ���� ��� ���� ����
		StringBuilder sb = new StringBuilder();
		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			// ���� �� ������ �̵� ���� ���� ���� �迭 �ʱ�ȭ
			boolean[][] nations = new boolean[N + 1][N + 1];
			while (M-- > 0) {
				st = new StringTokenizer(br.readLine(), " ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				nations[a][b] = nations[b][a] = true;
			}
			// �湮 ���� Ȯ�� �迭 �ʱ�ȭ
			boolean[] isVisited = new boolean[N + 1];
			// Ÿ�Ե� �ּ� ����� ��� ���� ���� �ʱ�ȭ
			int cnt = 0;
			for (int start = 1; start <= N; start++) {
				for (int end = 1; end <= N; end++) {
					if (nations[start][end] && !isVisited[start]) {
						isVisited[start] = true;
						// ť ��ü ���� �ʱ�ȭ
						Queue<Integer> queue = new LinkedList<>();
						queue.offer(start);
						// ������ ���� bfs�� �����Ͽ� ���� Ž���� ���� �ּ� ���� ������ ����
						while (!queue.isEmpty()) {
							int current = queue.poll();
							for (int next = 1; next <= N; next++) {
								if (nations[current][next] && !isVisited[next]) {
									cnt++;
									isVisited[next] = true;
									queue.offer(next);
								}
							}
						}
					}
				}
			}
			sb.append(cnt).append(NEW_LINE);
		}
		br.close();
		// ��� �� �Ѳ����� ���
		System.out.println(sb.toString());
	}
}