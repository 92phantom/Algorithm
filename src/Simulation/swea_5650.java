package Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.concurrent.ConcurrentHashMap;

public class swea_5650 {

	static int T; // TEST CASE
	static int N; // ARRAY SIZE
	static int ans = Integer.MIN_VALUE;

	static int[][] map;

	// DIRECTION
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	static ArrayList<Point> pointList = new ArrayList<>();
	static ConcurrentHashMap<Point, Integer> holeList = new ConcurrentHashMap<>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		T = Integer.parseInt(br.readLine());

		// TEST EXECUTION
		for (int i = 0; i < T; i++) {

			// INPUT MAP SIZE
			N = Integer.parseInt(br.readLine());

			// SET MAP
			map = new int[N][N];
			for (int j = 0; j < N; j++) {

				st = new StringTokenizer(br.readLine(), " ");

				for (int k = 0; k < N; k++) {

					int temp = Integer.parseInt(st.nextToken());
					map[j][k] = temp;

					if (temp == 0) {
						pointList.add(new Point(k, j, 0));
					}

					if (temp > 5) {
						holeList.put(new Point(k, j, 0), temp);
					}

				}

			}

			setStartPoint();

			System.out.println("#" + (i + 1) + " " + ans);

		}

	}

	static void setStartPoint() {

		// START TO CHECK ALL START POINT
		for (int i = 0; i < pointList.size(); i++) {
			setDirection(pointList.get(i));
		}

	}

	static void setDirection(Point p) {

		for (int i = 0; i < 4; i++) {

			int nextX = p.x + dx[i];
			int nextY = p.y + dy[i];

			if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= N)
				continue;

			/*
			 * 0 == 상 1 == 하 2 == 좌 3 == 우
			 */

			p.setDirection(i);

			startMove(0, p);
		}
	}

	static Point getNextHole(Point p, int holeNum) {

		int nextX = 0;
		int nextY = 0;
		Iterator<Point> it = holeList.keySet().iterator();

		while (it.hasNext()) {

			Point check = it.next();

			if (check.x != p.x && check.y != p.y && holeList.get(check) == holeNum) {
				nextX = check.x;
				nextY = check.y;

			}

		}

		return new Point(nextX, nextY, 0);
	}

	static void startMove(int count, Point p) {

		int direction = p.direction;
		int curX = p.x;
		int curY = p.y;
		boolean flag = true;

		if (direction == 0) {

			for (int i = curY - 1; i >= 0; i--) {

				if (map[i][curX] > 0) {

					// 블록을 만났을 때
					if (map[i][curX] > 6) {

						flag = false;
						Point next = blockSwitch(map[i][curX], p, new Point(curX, i, 0));
						startMove(count + 1, next);

						return;
					}

					// 웜홀을 만났을 떄
					else if (map[i][curX] <= 10) {

						flag = false;

						Point next = getNextHole(new Point(curX, i, 0), map[i][curX]);
						next.setDirection(direction);
						startMove(count, next);

						return;
					}

				}

				// 블랙홀 만남 종료
				else if (map[i][curX] == -1) {

					flag = false;
					ans = Math.max(ans, count);
					return;

				}

			}

			// 모두가 0일 때 반대 방향으로
			if (flag) {
				p.setDirection(1);
				startMove(count, p);
			}

		} else if (direction == 1) {

			for (int i = curY + 1; i < N; i++) {

				if (map[i][curX] > 0) {

					// 블록을 만났을 때
					if (map[i][curX] > 6) {

						flag = false;
						Point next = blockSwitch(map[i][curX], p, new Point(curX, i, 0));
						startMove(count + 1, next);

						return;
					}

					// 웜홀을 만났을 떄
					else if (map[i][curX] <= 10) {

						flag = false;

						Point next = getNextHole(new Point(curX, i, 0), map[i][curX]);
						next.setDirection(direction);
						startMove(count, next);

						return;
					}

				}

				// 블랙홀 만남 종료
				else if (map[i][curX] == -1) {

					flag = false;
					ans = Math.max(ans, count);
					return;

				}

			}

			// 모두가 0일 때 반대 방향으로
			if (flag) {
				p.setDirection(0);
				startMove(count, p);
			}

			
		} else if (direction == 2) {
			
			for (int i = curX - 1; i >= 0; i--) {

				if (map[curY][i] > 0) {

					// 블록을 만났을 때
					if (map[curY][i] > 6) {

						flag = false;
						Point next = blockSwitch(map[curY][i], p, new Point(i, curY, 0));
						startMove(count + 1, next);

						return;
					}

					// 웜홀을 만났을 떄
					else if (map[curY][i] <= 10) {

						flag = false;

						Point next = getNextHole(new Point(i, curY, 0), map[curY][i]);
						next.setDirection(direction);
						startMove(count, next);

						return;
					}

				}

				// 블랙홀 만남 종료
				else if (map[curY][i] == -1) {

					flag = false;
					ans = Math.max(ans, count);
					return;

				}

			}

			// 모두가 0일 때 반대 방향으로
			if (flag) {
				p.setDirection(1);
				startMove(count, p);
			}

			

		} else if (direction == 3) {
			
			
			for (int i = curX + 1; i < N; i++) {

				if (map[curY][i] > 0) {

					// 블록을 만났을 때
					if (map[curY][i] > 6) {

						flag = false;
						Point next = blockSwitch(map[curY][i], p, new Point(i, curY, 0));
						startMove(count + 1, next);

						return;
					}

					// 웜홀을 만났을 떄
					else if (map[curY][i] <= 10) {

						flag = false;

						Point next = getNextHole(new Point(i, curY, 0), map[curY][i]);
						next.setDirection(direction);
						startMove(count, next);

						return;
					}

				}

				// 블랙홀 만남 종료
				else if (map[curY][i] == -1) {

					flag = false;
					ans = Math.max(ans, count);
					return;

				}

			}

			// 모두가 0일 때 반대 방향으로
			if (flag) {
				p.setDirection(1);
				startMove(count, p);
			}


		}

	}

	static Point blockSwitch(int blockType, Point current, Point next) {

		if (blockType == 1) {

			if (current.y == next.y && current.x > next.x) {

				Point returnVal = next;
				returnVal.setDirection(0);

				return returnVal;
				// 위로 이동

			}

			else if (current.y < next.y && current.x == next.x) {

				// 우로 이동
				Point returnVal = next;
				returnVal.setDirection(3);

				return returnVal;

			} else {

				// 반대 방향
				int direction = 0;

				if (current.getDirection() == 0 || current.getDirection() == 1) {
					direction = Math.abs(current.getDirection() - 1);
				} else {
					if (current.getDirection() == 2) {
						direction = 3;
					} else {
						direction = 2;
					}

				}
				Point returnVal = next;
				returnVal.setDirection(direction);

				return returnVal;

			}

		} else if (blockType == 2) {

			if (current.y == next.y && current.x > next.x) {

				// 아래로
				Point returnVal = next;
				returnVal.setDirection(1);

				return returnVal;

			}

			else if (current.y > next.y && current.x == next.x) {

				// 우측으로

				Point returnVal = next;
				returnVal.setDirection(3);

				return returnVal;

			} else {

				// 반대 방향
				int direction = 0;

				if (current.getDirection() == 0 || current.getDirection() == 1) {
					direction = Math.abs(current.getDirection() - 1);
				} else {
					if (current.getDirection() == 2) {
						direction = 3;
					} else {
						direction = 2;
					}

				}
				Point returnVal = next;
				returnVal.setDirection(direction);

				return returnVal;

			}

		} else if (blockType == 3) {

			if (current.y == next.y && current.x < next.x) {

				// 아래로 아동
				Point returnVal = next;
				returnVal.setDirection(1);

				return returnVal;

			}

			else if (current.y > next.y && current.x == next.x) {

				// 좌로 이동
				Point returnVal = next;
				returnVal.setDirection(2);

				return returnVal;

			} else {

				// 반대 방향
				int direction = 0;

				if (current.getDirection() == 0 || current.getDirection() == 1) {
					direction = Math.abs(current.getDirection() - 1);
				} else {
					if (current.getDirection() == 2) {
						direction = 3;
					} else {
						direction = 2;
					}

				}
				Point returnVal = next;
				returnVal.setDirection(direction);

				return returnVal;

			}
		} else if (blockType == 4) {

			if (current.y == next.y && current.x < next.x) {

				// 위로 이동

				Point returnVal = next;
				returnVal.setDirection(0);

				return returnVal;
			}

			else if (current.y < next.y && current.x == next.x) {

				// 좌로 이동
				Point returnVal = next;
				returnVal.setDirection(2);

				return returnVal;

			} else {

				// 반대 방향
				int direction = 0;

				if (current.getDirection() == 0 || current.getDirection() == 1) {
					direction = Math.abs(current.getDirection() - 1);
				} else {
					if (current.getDirection() == 2) {
						direction = 3;
					} else {
						direction = 2;
					}

				}
				Point returnVal = next;
				returnVal.setDirection(direction);

				return returnVal;

			}
		} else {

			// 무조건 반대방향
			int direction = 0;

			if (current.getDirection() == 0 || current.getDirection() == 1) {
				direction = Math.abs(current.getDirection() - 1);
			} else {
				if (current.getDirection() == 2) {
					direction = 3;
				} else {
					direction = 2;
				}

			}
			Point returnVal = next;
			returnVal.setDirection(direction);

			return returnVal;

		}

	}

	static class Point {
		int x, y, direction;

		Point(int x, int y, int direction) {
			this.x = x;
			this.y = y;
			this.direction = direction;
		}

		public int getX() {
			return x;
		}

		public void setX(int x) {
			this.x = x;
		}

		public int getY() {
			return y;
		}

		public void setY(int y) {
			this.y = y;
		}

		public int getDirection() {
			return direction;
		}

		public void setDirection(int direction) {
			this.direction = direction;
		}

	}

}
