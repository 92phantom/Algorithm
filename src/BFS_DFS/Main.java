package BFS_DFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
public class Main {
	// 개행 문자 상수
	private static final char NEW_LINE = '\n';
	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		// 버퍼를 통해 결과 값을 만듬
		StringBuilder sb = new StringBuilder();
		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			// 국가 간 비행기로 이동 가능 여부 저장 배열 초기화
			boolean[][] nations = new boolean[N + 1][N + 1];
			while (M-- > 0) {
				st = new StringTokenizer(br.readLine(), " ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				nations[a][b] = nations[b][a] = true;
			}
			// 방문 여부 확인 배열 초기화
			boolean[] isVisited = new boolean[N + 1];
			// 타게될 최소 비행기 대수 저장 변수 초기화
			int cnt = 0;
			for (int start = 1; start <= N; start++) {
				for (int end = 1; end <= N; end++) {
					if (nations[start][end] && !isVisited[start]) {
						isVisited[start] = true;
						// 큐 객체 변수 초기화
						Queue<Integer> queue = new LinkedList<>();
						queue.offer(start);
						// 루프를 돌며 bfs를 실행하여 완전 탐색을 위한 최소 간선 갯수를 구함
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
		// 결과 값 한꺼번에 출력
		System.out.println(sb.toString());
	}
}