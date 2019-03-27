import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class boj_11728 {

	static int N, M;
	static ArrayList<Integer> map;
	static ArrayList<Integer> map2;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new ArrayList<>();
		map2 = new ArrayList<>();

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			map.add(Integer.parseInt(st.nextToken()));
		}
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < M; i++) {
			map2.add(Integer.parseInt(st.nextToken()));
		}

		String output = "";

		int first = 0, snd = 0;
//		int size = N + M;
		while (first < N && snd < M) {

			if (map.get(first) < map2.get(snd)) {
				output += (map.get(first++) + " ");
			} else {
				output += (map2.get(snd++) + " ");
			}

		}

		if (first < N) {
			while (true) {
				if (first == N) {
					break;
				} else {
					output += (map.get(first++)+" ");
				}
			}
		} else {
			while (true) {

				if (snd == M) {
					break;
				} else {
					output += (map2.get(snd++)+" ");
				}
			}
		}
		
		System.out.println(output);
	}

}
