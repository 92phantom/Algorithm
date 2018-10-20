import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NHN_3 {

	static int days;

	static int numOfCoin;

	static int buy;
	static int sell;
	static int profit;
	static int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

	static int[] price;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		days = Integer.parseInt(br.readLine());
		price = new int[days];

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < days; i++)

			price[i] = Integer.parseInt(st.nextToken());

		for (int i = 0; i < days; i++) {

			min = price[i] < min ? price[i] : min;
			max = price[i] > max ? price[i] : max;

			// Last Day
			if (i == (days - 1)) {

				if (numOfCoin > 0) {
					sell = numOfCoin * price[i];
					profit += sell - buy - 1;
					numOfCoin = 0;
					buy = 0;
					break;
				} else {

					break;
				}
			}

			// 구매
			if (price[i] <= price[i + 1]) {
				numOfCoin += 1;
				buy += price[i];
			}

			// 보류
			else if (price[i + 1] == min && i!=days-2) {

			}

			// 판매
			else if ((price[i] > price[i + 1]) && numOfCoin > 0) {
				sell = numOfCoin * price[i];
				profit = sell - buy - 1;
				numOfCoin = 0;
				buy = 0;
			}

		}

		System.out.println(profit);

	}

}
