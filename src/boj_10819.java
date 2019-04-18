import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj_10819 {

	static int N;
	static ArrayList<Integer> list = new ArrayList<>();
	static ArrayList<Integer> out = new ArrayList<>();
	static int ans = 0;
	static boolean[] v;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine(), " ");
		
		for (int i = 0; i < N; i++) {
			
			int temp = Integer.parseInt(st.nextToken());
			list.add(temp);
			
		}

		v = new boolean[N];

		for (int i = 0; i < list.size(); i++) {
			v[i] = true;
			out.add(list.get(i));
			dfs(i, 1);
			v[i] = false;
			out.remove(out.size() - 1);
		}

		System.out.println(ans);
	}

	static void dfs(int idx, int count) {

		if (count == list.size()) {
			cal();
		} else {

			for (int i = 0; i < list.size(); i++) {
				if (!v[i]) {
					v[i] = true;
					out.add(list.get(i));
					dfs(i, count + 1);
					v[i] = false;
					out.remove(out.size() - 1);
				}
			}
		}
	}

	static void cal() {

		int result = 0;
		for (int i = 0; i < out.size() - 1; i++) {
			result += Math.abs(out.get(i) - out.get(i + 1));
		}

		ans = Math.max(result, ans);

	}

}
