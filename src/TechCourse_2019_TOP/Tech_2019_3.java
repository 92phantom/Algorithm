package TechCourse_2019_TOP;

public class Tech_2019_3 {

	// ¾ËÆÄºª 26°³
	static char[] small = new char[30];
	static char[] big = new char[30];

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		char temp = 'A';
		System.out.println((int) temp);
		temp = 'Z';
		System.out.println((int) temp);

		int aa = 122;
		System.out.println((char) aa);

		System.out.println(solution("I love you"));
	}

	static String solution(String word) {

		int idx = 0;
		for (int i = 122; i >= 97; i--) {
			small[idx++] = (char) i;
		}

		idx = 0;
		for (int i = 90; i >= 65; i--) {
			big[idx++] = (char) i;
		}

		String result = "";

		for(int i=0; i<word.length(); i++) {
			
			char temp = word.charAt(i);
			
			if(temp>='a' && temp<='z') {
				result += small[(int)temp -'a']+"";
			}
			else if(temp>='A' && temp<='Z') {
				result += big[(int)temp -'A']+"";
			}else if(temp==' ') {
				result += " ";
			}
			
		}
		
		
		return result;
	}

}
