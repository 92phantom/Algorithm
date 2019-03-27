import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// N°ú M(2)

public class boj_15650 {

	static int N, M;
	static int[] arr;
	static ArrayList<Integer> result;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		result = new ArrayList<>();

		dfs(0);

	}

	static void dfs(int idx) {
		if (result.size() == M) {

			for (int i : result) {
				System.out.print((i + 1) + " ");
			}
			System.out.println();

		} else {

			for (int i = idx; i < N; i++) {
				result.add(i);
				dfs(i + 1);
				result.remove(result.size() - 1);
			}

		}

	}

}
