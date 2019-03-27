import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class boj_3568 {

	static String TYPE = "";
	static String input = "";

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		input = br.readLine();

		String strt = "";
		String temp = "";
		String value = "";

		boolean flag = true;
		for (int i = 0; i < input.length(); i++) {

			if (input.charAt(i) == ' ' && flag) {
				strt = temp;
				temp = "";
				flag = false;

			} else if (input.charAt(i) == ',' || input.charAt(i) == ';') {

				System.out.print(strt);

				for (int j = temp.length() - 1; j >= 0; j--) {

					if (temp.charAt(j) == '[')
						System.out.print("]");
					else if (temp.charAt(j) == ']') {
						System.out.print("[");
					} else {
						System.out.print(temp.charAt(j));
					}

				}

				System.out.print(" " + value + ";");
				System.out.println();
				value = "";
				temp = "";
			}

			else if (!flag && ((input.charAt(i) <= 'z' && input.charAt(i) >= 'a')
					|| 'A' <= input.charAt(i) && input.charAt(i) <= 'Z')) {
				value += input.charAt(i);
			} else if (input.charAt(i) != ' ') {
				temp += input.charAt(i) + "";

			}

		}

	}

}
