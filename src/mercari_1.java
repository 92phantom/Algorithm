import java.util.ArrayList;
import java.util.StringTokenizer;

public class mercari_1 {

	static int max = 0;
	static ArrayList<String> list = new ArrayList<String>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s = "!";

		System.out.println(solution(s));

//		System.out.println(list);

	}

	static int solution(String s) {

		StringTokenizer st;

		if (s.contains(".")) {

			st = new StringTokenizer(s, ".");

			int size = st.countTokens();

			for (int i = 0; i < size; i++) {
				String temp = st.nextToken();

				solution(temp);

			}

		}

		else if (s.contains("?")) {

			st = new StringTokenizer(s, "?");

			int size = st.countTokens();

			for (int i = 0; i < size; i++) {
				String temp = st.nextToken();

				solution(temp);

			}

		}

		else if (s.contains("!")) {
			st = new StringTokenizer(s, "!");

			int size = st.countTokens();

			for (int i = 0; i < size; i++) {
				String temp = st.nextToken();

				solution(temp);

			}
		}

		if (!s.contains(".") && !s.contains("?") && !s.contains("!")) {

			list.add(s);
			
			if(s.contains(" ")){
				st = new StringTokenizer(s, " ");
				
				max = Math.max(max, st.countTokens());
			}
		}

		return max;
	}

}
