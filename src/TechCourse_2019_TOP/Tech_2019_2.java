package TechCourse_2019_TOP;

public class Tech_2019_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] lands = { { 10, 0, 30, 5 }, { 0, 30, 20, 50 }, { 30, 30, 40, 40 } };
		int[][] wells = { { 15, 15, 25, 25 }, { 40, 10, 50, 20 } };
		int[] point = { 10, 10, 30, 30 };

		System.out.println(solution(lands, wells, point));
		
		int[][] lands2 = {{0, 0, 20, 10}, {10, 20, 20, 40}, {30, 0, 50, 20}};
		int[][] wells2 = {{20, 40, 30, 50}, {30, 20, 50, 30}};
		int[] point2 = {20, 30, 30, 40};

		System.out.println(solution(lands2, wells2, point2));
		
	}

	static boolean solution(int[][] lands, int[][] wells, int[] point) {
		boolean answer = false;

		int newX1 = point[0];
		int newY1 = point[1];
		int newX2 = point[2];
		int newY2 = point[3];

		// �̹� �о� ���� ����
		int size = lands.length;
		for (int i = 0; i < size; i++) {

			int x1 = lands[i][0];
			int y1 = lands[i][1];
			int x2 = lands[i][2];
			int y2 = lands[i][3];

			// ���ο� ������ �̹� �о� ���� ���� ������ �� ��
			if (newX1 < x1 && newX2 > x2 && newY1 < y1 && newY2 > y2) {
				return false;
			}
			
			// �о� ���� ������ ���ο� ���� ���� �ȿ� �� ��
			if (newX1 > x1 && newX2 < x2 && newY1 > y1 && newY2 < y2) {
				
				return false;
			}

			// ������ ��ĥ ��
			if (newX2 > x1 && newX2 < x2 && newY2 >y1 && newY2 < y2) {
				return false;
			}

			if (newX1 > x1 && newX1 < x2 && newY1 > y1 && newY1 < y2) {
				return false;
			}

		}
		
		size = wells.length;
		for (int i = 0; i < size; i++) {

			int x1 = wells[i][0];
			int y1 = wells[i][1];
			int x2 = wells[i][2];
			int y2 = wells[i][3];

			// X ���� �ȿ� ����
			if (newX1 <= x1 && newX2 >= x2 && newY1 <= y1 && newY2 >= y2) {
				return true;
			}
			
		}
		

		return answer;
	}

}
