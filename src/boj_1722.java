import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1722 {

	static boolean[] visited;
	static int N;
	static int COUNT = 0;
	static String temp;
	static int k, outputNum = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		k = Integer.parseInt(st.nextToken());

		if (k == 1) {
			outputNum = Integer.parseInt(st.nextToken());
			
			for(int i=1; i<N; i++) {
				int pos = N-1-i;
				int a = 0;
				
			}
			
		} else {
			int size = st.countTokens();
			temp = st.nextToken();
			for (int i = 0; i < size - 1; i++) {
				temp = temp + " " + st.nextToken();
			}
		}

		visited = new boolean[N + 1];
		for (int i = 1; i <= N; i++) {
			dfs(i, 1, i + "");
		}

	}

}
