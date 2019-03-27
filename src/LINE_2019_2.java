import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class LINE_2019_2 {

	static ArrayList<String> charList = new ArrayList<>();
	static ArrayList<Integer> numList = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String input = br.readLine();

		for (int i = input.length() - 1; i >= 0; i--) {

			char temp = input.charAt(i);

			if (temp == '0') {
				numList.add(10);
				i--;
			}

			else if (temp >= '1' && temp <= '9') {
				numList.add(Integer.parseInt(temp + ""));
			}

			else if (temp >= 'a' && temp <= 'z') {
				int idx = i - 1;
				String save = input.charAt(idx) + "" + temp;
				charList.add(save);
				i--;
			} else if (temp >= 'A' && temp <= 'Z') {
				charList.add(temp + "");
			}
		}

		if (charList.size() != numList.size()) {
			System.out.println("error");
		} else {
			for (int i = charList.size() - 1; i >= 0; i--) {
				System.out.print(charList.get(i));
				if (numList.get(i) > 1) {
					System.out.print(numList.get(i));
				}
			}
		}



	}

}
