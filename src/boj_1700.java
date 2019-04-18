import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.concurrent.ConcurrentHashMap;

public class boj_1700 {

	static int N, K;
	static ArrayList<Integer> list = new ArrayList<>();

	static Set<Integer> multi = ConcurrentHashMap.newKeySet();

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < K; i++) {
			int input = Integer.parseInt(st.nextToken());
			list.add(input);
		}

		int pullOut = 0;

		for (int i = 0; i < K; i++) {

			int cur = list.get(i);

			if (multi.contains(cur)) {
				continue;
			}

			if (multi.size() == N) {

				int idx = -3, target = 0;

				for (int id : multi) {
					int tIdx = Integer.MAX_VALUE;

					// 제일 안쓰는 것
					for (int j = i + 1; j < K; j++) {
						// 같은게 있나요?
						if (id == list.get(j)) {
							tIdx = j;
							break;
						}

					}

					if (tIdx == Integer.MAX_VALUE) {
						target = id;
						break;
					} else {
						if (tIdx > idx) {
							idx = tIdx;
							target = list.get(tIdx);
						}
					}
				}

				multi.remove(target);
				pullOut += 1;

			}

			multi.add(cur);

		}
		System.out.println(pullOut);
	}

}
