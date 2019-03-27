import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class boj_15905 {

	static int N;

	static ArrayList<Node> list = new ArrayList<>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		StringTokenizer st;

		for (int i = 0; i < N; i++) {

			st = new StringTokenizer(br.readLine(), " ");
			int solve = Integer.parseInt(st.nextToken());
			int sum = Integer.parseInt(st.nextToken());

			list.add(new Node(solve, sum));

		}

		Collections.sort(list);

		int solveNum = list.get(4).solve;

		int result = 0;

		for (int i = 5; i < list.size(); i++) {

			if (list.get(i).solve == solveNum) {
				result += 1;
			} else {
				break;
			}
		}

		System.out.println(result);

		// 패널티 차이로 수상하지 못한 학생들에게만 치킨 기프티콘을 보내주고자 한다.
		// 해결한 문제의 개수가 더 많은 참가자가 더 높은 순위를 가진다.
		// 해결한 문제의 수가 같을 때, 패널티 총합이 더 작은 참가자가 더 높은 순위를 가진다.
	}

	static class Node implements Comparable<Node> {
		int solve, sum;

		Node(int solve, int sum) {
			this.solve = solve;
			this.sum = sum;
		}

		@Override
		public int compareTo(Node arg) {
			if (arg.solve == this.solve)
				return this.sum - arg.sum;
			return arg.solve - this.solve;
		}
	}

}
