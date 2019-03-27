import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj_10802 {

	static long START, END;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		START = Long.parseLong(st.nextToken());
		END = Long.parseLong(st.nextToken());

		// 부르는 숫자가 3의 배수이거나 그 숫자에 3, 6, 9중 하나라도 들어 있는 경우에 숫자는 부르지 않고 박수를 친다.

		long result = 0;

		for (long i = START; i <= END; i++) {

			if (i % 3 == 0) {
				result += 1;
			} else {

				String temp = i + "";
				if (temp.contains("3") || temp.contains("6") || temp.contains("9")) {
					result += 1;
				}

			}

		}

		System.out.println(result%20150523);

	}

}
