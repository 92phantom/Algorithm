package Kakao;

import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class Kakao_2019_4 {

	static ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap<>();
	static int ans = 1;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] in = {"alex111 100", "cheries2 200", "coco 150", "luna 100", "alex111 120", "coco 300", "cheries2 110"};
		System.out.println(sol(3, in));
	}

	static int sol(int K, String[] user_scores) {
		int answer = 0;

		for (int i = 0; i < user_scores.length; i++) {

			String[] parse = user_scores[i].split(" ");

			int score = Integer.parseInt(parse[1]);
			String name = parse[0];

			if (map.keySet().size() == 3) {
				
				boolean flag = false;
				Iterator<Integer> it = map.keySet().iterator();
				int minValue = Integer.MAX_VALUE;
				while (it.hasNext()) {

					int storeScore = it.next();

					if (storeScore < minValue) {
						minValue = storeScore;
					}

					if (score > storeScore) {
						System.out.println(name+"\t" + score);
						flag = true;
					}

				}

				if (flag) {
					map.remove(minValue);
					map.put(score, name);
					ans += 1;
					System.out.println("중간 점검"+ map.keySet());

				}else {
					System.out.println("안넣을 때 "+ map.keySet());
				}

			} else {
				
				map.put(score, name);

			}

		}

		return ans;

	}
}
