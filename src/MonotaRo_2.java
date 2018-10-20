import java.util.ArrayList;
import java.util.Arrays;

public class MonotaRo_2 {

	static boolean[] visited;
	static int[] map;
	static boolean check;
	static int ans = Integer.MAX_VALUE;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] A = { 5, 2, 4, 6, 3, 7 };
		// int[] A = { 1, 1, 1, 1, 1, 1 };

		System.out.println(MonotaRo(A));

	}

	public static boolean MonotaRo(int[] A) {

		visited = new boolean[A.length];
		map = A;

		
		System.out.println(Arrays.toString(map));
		for (int i = 1; i < (A.length - 1); i++) {

//			if (!check) {
				visited[i] = true;
				balancing(i, 0, A.length);
				visited[i] = false;
//			} else {
//				return true;
//			}
		}

		System.out.println(ans);
		
		return false;

	}

	static void balancing(int index, int depth, int length) {

		for (int i = index + 2; i < (length - 1); i++) {

			visited[i] = true;
			balancing(i, depth + 1, length);
			visited[i] = false;

		}

		if (depth > 1) {
			return;
		}

		if (depth == 1) {

			System.out.println(Arrays.toString(visited));

			int value = 0;

			ArrayList<Integer> values = new ArrayList<Integer>();

			for (int i = 0; i < length; i++) {

				if (visited[i]) {
//					value += map[i];
					values.add(map[i]);
				}

//				else {
//					values.add(value);
//					value = 0;
//				}
//
//				if (i == (length - 1)) {
//					values.add(value);
//				}
			}
//			values.add(value);

			int temp = 0;
			for(int i=0; i<values.size(); i++){
				temp += values.get(i);
				
			}
			
			ans = Math.min(ans, temp);
			System.out.println(values);

			// for (int i = 1; i < values.size(); i++) {
			//
			// if (values.get(i - 1) != values.get(i)) {
			// return;
			// }
			// }

//			check = true;

		}

	}

}
