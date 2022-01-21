package study.algorithm;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeeCode54 {

    int[] dx = {0,1,0,-1};
    int[] dy = {1,0,-1,0};

    class Node {
        int x, y;
        Node (int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public List<Integer> spiralOrder(int[][] matrix) {

        ArrayList<Integer> returnVal = new ArrayList<>();
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];

        int totalCount = matrix.length * matrix[0].length;

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, 0));
        int cnt = 0;

        while (!q.isEmpty()){

            Node cur = q.poll();
            returnVal.add(matrix[cur.x][cur.y]);
            visited[cur.x][cur.y] = true;

            if(cnt == totalCount) break;

            for(int i=0; i<4; i++){

                int nextX = cur.x + dx[i];
                int nextY = cur.y + dy[i];

                if(nextX < 0 || nextY < 0 || nextX>= matrix.length || nextY >= matrix[0].length || visited[nextX][nextY])
                    continue;

                visited[nextX][nextY] = true;
                q.add(new Node(nextX, nextY));
            }

        }


        return returnVal;

    }

    @Test
    void test_1() {

    }
}
