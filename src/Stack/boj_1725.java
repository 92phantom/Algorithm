package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class boj_1725 {

	static int N;
	static int[] arr;
	static int ans;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		// 사이즈를 하나 더 크게 해준 이유는 종료 조건, 맨 마지막 할당되지 않은 부분은 0이므로 while문 조건에 걸리게 된다.
		arr = new int[N + 2];
		ans = 0;

		// Stack에 들어가는 값은 인덱스 값이다.
		Stack<Integer> stack = new Stack<>();

		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		/*
		 * 1) 높이가 "4"인 막대는 다음 막대(높이 5)를 포함하여 WIDTH = 2 HEIGHT =4 인 직사각형을 만들 수 있음 
		 * 2) 높이가 "5"인 막대는 "좌/우" 모두 자신 보다 높이가 낮기 때문에 다른 막대와 합쳐질 수 없다.
		 * 
		 * == > 결론: 왼쪽 막대 높이를 기준으로 오른쪽 막대와 합쳐서 직사각형을 만들 수는 있지만 역은 성립하지 않는다.
		 */
		
		stack.push(0);

		for (int i = 1; i <= N + 1; i++) {
			 
			// 다음 값이 현재 값(스택의 Top)보다 작을 경우
			// 결론 : 다른 막대와 합쳐질 수 없는 경우임 때문에 여기서 한번 넓이를 계산해준다.
			
			// 맨 뒤에값일 때 
			while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {

				int height = arr[stack.peek()];
				stack.pop();
				int width = i - stack.peek() - 1;
				ans = Math.max(ans, width * height);

			}

			stack.push(i);

		}

		System.out.println(ans);

	}

}
