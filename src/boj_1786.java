import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_1786 {

	static String T, P;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = br.readLine();
		P = br.readLine();

		// ���� ���� ã��
		char start = P.charAt(0);
		char second = P.charAt(1);

		long count = 0;

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < T.length() - P.length();) {
			String temp = T.substring(i, (i + P.length()));

			// P�� ������ ���ڿ� ã��
			boolean flag = true;

			if (temp.charAt(0) == start && temp.charAt(1) == second) {

				// �˻� ����
				int next = 0;
				
				
				for (int j = 2; j < temp.length(); j++) {
					if (temp.charAt(j) != P.charAt(j)) {
						flag = false;
					}
				}
				if (flag) {
					System.out.println(temp);
					System.out.println("����");
					sb.append((i + 1) + "\n");
					i += 2;
					count += 1;
					
				} else {

					i +=2;
					System.out.println("����IDX" + i);
					System.out.println(T.charAt(i));
				}

			} else {
				for (int j = 2; j < temp.length() - 1; j++) {
					if (temp.charAt(j) == start && temp.charAt(j + 1) == second) {
						i += j;
						break;
					}
				}
				
				System.out.println("���ۺ��ʹٸ� IDX"+ i);
			}

//			if (temp.equals(P)) {
//				sb.append((i + 1) + "\n");
//				count += 1;
//				i++;
//			} else {
//
//				boolean flag = true;
//				for (int j = 1; j < temp.length() - 1; j++) {
//					if (start == temp.charAt(j) && second == temp.charAt(j + 1)) {
//						flag = false;
//						i = (i + j);
//						break;
//					}
//				}
//
//				if (flag) {
//					i += P.length();
//				}
//			}
		}

		System.out.println(count);
		System.out.println(sb);
	}

}
