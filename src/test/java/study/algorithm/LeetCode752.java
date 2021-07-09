package study.algorithm;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @ author             : hyunjin
 * @ date               : 21. 7. 10.
 * @ name               : 752. Open the Lock
 * @ link               : https://leetcode.com/problems/open-the-lock/
 * @ time complexity    :
 * @ algorithm          : BFS (완탐)
 */
public class LeetCode752 {

    public int openLock(String[] deadends, String target) {
        Queue<String> queue = new LinkedList();
        Set<String> deadendsSet = new HashSet();
        Set<String> hasVisitedSet = new HashSet();

        for (String deadend : deadends)
            deadendsSet.add(deadend);

        int moves = 0;
        String startLock = "0000";
        if (deadendsSet.contains(startLock))
            return -1;

        if (startLock.equals(target))
            return moves;

        hasVisitedSet.add(startLock);
        queue.add(startLock);

        while (!queue.isEmpty()) {
            int queueLen = queue.size();
            moves++;
            while (queueLen-- > 0) {
                char[] curChs = queue.poll().toCharArray();
                for (int i = 0; i < 4; i++) {
                    int curVal = curChs[i] - '0';
                    curChs[i] = (char) ('0' + ((curVal + 10 + 1) % 10));
                    // 정방향 0 -> 1
                    String oneMoveString1 = new String(curChs);
                    curChs[i] = (char) ('0' + ((curVal + 10 - 1) % 10));
                    // 역방향 0 -> 9
                    String oneMoveString2 = new String(curChs);
                    curChs[i] = (char) (curVal + '0');

                    if (!hasVisitedSet.contains(oneMoveString1) && !deadendsSet.contains(oneMoveString1)) {
                        if (oneMoveString1.equals(target))
                            return moves;
                        queue.add(oneMoveString1);
                        hasVisitedSet.add(oneMoveString1);
                    }
                    if (!hasVisitedSet.contains(oneMoveString2) && !deadendsSet.contains(oneMoveString2)) {
                        if (oneMoveString2.equals(target))
                            return moves;
                        queue.add(oneMoveString2);
                        hasVisitedSet.add(oneMoveString2);
                    }
                }
            }
        }
        return -1;
    }

    @Test
    void test() {

        // given
        String[] deadends = {"0201", "0101", "0102", "1212", "2002"};
        String target = "0202";

        int expected = 6;

        // when
        int result  = openLock(deadends, target);

        // then
        assertThat(result).isEqualTo(expected);

    }

}
