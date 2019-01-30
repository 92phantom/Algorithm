package Exercise;

public class tt {

	public static void main(String... args) {

		func(10, 0);
	}

	static void func(int a, int count) {

		boolean flag = true;
		for (int i = 0; i < a; i++) {

			System.out.println(i + "////" + count);
			if (i == 4) {
				flag = false;
				func(i, count + 1);
				return;
			}
			if (i == 3) {
				flag = false;
			}

		}

		if (flag) {
			func(4, 100);
		}

	}
}
