package study.algorithm;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @ author             : hyunjin
 * @ date               : 21. 5. 19.
 * @ name               : 815. Bus Routes
 * @ link               : https://leetcode.com/problems/bus-routes/
 * @ time complexity    : O(n * m[height] * n) = O(n^2)
 *         n = routes[i].length (10^5)
 *         m = routes.length (500)
 * @ algorithm          : BFS, Hash
 */
public class LeetCode815 {


    public int numBusesToDestination(int[][] routes, int source, int target) {

        // 왜 1로 출력되지; 출발점과 목적지가 같은경우 0
        if(source == target){
            return 0;
        }

        // Solution : 내가 속한 곳에서 방문 가능한 ROW(행)를 리스트에 넣고, 방문 가능한 행을 탐색한다.
        ConcurrentHashMap<Integer, ArrayList<Integer>> list = new ConcurrentHashMap<>();
        boolean[] v = new boolean[routes.length];

        for(int i=0; i<routes.length; i++){

            for(int j=0; j<routes[i].length; j++) {

                int node = routes[i][j];

                // 내 위치에서 방문 가능한 행
                ArrayList<Integer> tmp;
                if(!list.containsKey(node)){
                    tmp = new ArrayList<>();
                }
                else {
                    tmp = list.get(node);
                }

                tmp.add(i);
                list.put(node, tmp);
            }

        }

        Queue<Integer> q = new LinkedList<>();
        q.add(source);
        int step = 0;

        while(!q.isEmpty()){

            ++step;
            int size = q.size();

            for(int i=0; i<size; i++){
                int cur = q.poll();

                ArrayList<Integer> possible = list.get(cur);

                // 현재 내 위치에서 갈수 있는 대상(행)들
                for(Integer curPosition: possible) {

                    // 방문하지 않은 대상이라면
                    if(!v[curPosition]) {
                        v[curPosition] = true;

                        // 내가 속한 행에서 방문 가능한 정류장
                        for(Integer route : routes[curPosition]){

                            if(route == target) {
                                return step;
                            }
                            q.add(route);
                        }

                    }
                }
            }

        }

        // 도달할 수 없는 경우
        return -1;

    }

    @Test
    void test_1() {

        // given
        int[][] routes = {{1,2,7},{3,6,7}};
        int source = 1;
        int target = 6;

        int expected = 2;

        // when
        int return_val = new LeetCode815().numBusesToDestination(routes, source, target);

        // then
        assertThat(return_val).isEqualTo(expected);

    }

    @Test
    void test_2() {

        // given
        int[][] routes = {{7,12},{4,5,15},{6},{15,19}, {9,12,13}};
        int source = 15;
        int target = 12;

        int expected = -1;

        // when
        int return_val = new LeetCode815().numBusesToDestination(routes, source, target);

        // then
        assertThat(return_val).isEqualTo(expected);

    }



}
