package study.algorithm;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @ author             : hyunjin
 * @ date               : 21. 5. 19.
 * @ name               : 994. Rotting Oranges
 * @ link               : https://leetcode.com/problems/rotting-oranges/
 * @ time complexity    : O(n^2)
 *      Matrix Max Size = 100 ( 10 * 10 )
 * @ algorithm          : BFS
 */
public class LeetCode994 {

    int[] dx = {-1,1,0,0};
    int[] dy = {0,0,-1,1};

    public int orangesRotting(int[][] grid) {

        Queue<Node> q = new LinkedList<>();

        for(int i=0; i< grid.length; i++) {
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == 2){
                    q.add(new Node(i, j, grid[i][j], 0));
                }
            }
        }

        int maxValue = 0;

        while(!q.isEmpty()){

            Node cur = q.poll();

            maxValue = Math.max(maxValue, cur.count);

            for(int i=0; i<4; i++){

                int nextX = cur.x + dx[i];
                int nextY = cur.y + dy[i];

                if(nextX < 0 || nextY < 0 || nextX >= grid.length || nextY >= grid[0].length)
                    continue;

                else if(grid[nextX][nextY] == 1){
                    q.add(new Node(nextX, nextY, grid[nextX][nextY], cur.count+1));
                    // 썩은 사과로 변경
                    grid[nextX][nextY] = 2;
                }

            }

        }

        boolean flag = true;

        for(int i=0; i< grid.length; i++) {

            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == 1){
                    flag = false;
                    break;
                }
            }

        }

        return flag ? maxValue : -1;

    }

    @Test
    void test_1() {

        // given
        int[][] grid = { {2,1,1}, {1,1,0}, {0,1,1} };
        int expected = 4;

        // when
        int return_val = new LeetCode994().orangesRotting(grid);

        // then
        assertThat(return_val).isEqualTo(expected);
    }

    @Test
    void test_2() {

        // given
        int[][] grid = { {2,1,1}, {0,1,1}, {1,0,1} };
        int expected = -1;

        // when
        int return_val = new LeetCode994().orangesRotting(grid);

        // then
        assertThat(return_val).isEqualTo(expected);
    }

    @Test
    void test_3() {

        // given
        int[][] grid = { {0,2} };
        int expected = 0;

        // when
        int return_val = new LeetCode994().orangesRotting(grid);

        // then
        assertThat(return_val).isEqualTo(expected);
    }

    static class Node {
        int x, y, val, count;
        Node (int x, int y, int val, int count){
            this.x = x;
            this.y = y;
            this.val = val;
            this.count = count;
        }
    }

}
