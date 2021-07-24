package study.algorithm;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class LeetCode997 {

    public int findJudge(int n, int[][] trust) {


        int[] trust_list = new int[n + 1];

        for (int i = 0; i < trust.length; i++) {

            int key = trust[i][0];
            int trustPeople = trust[i][1];

            trust_list[key] -= 1;
            trust_list[trustPeople] += 1;

        }

        for (int i = 1; i <= n; i++) {
            if (trust_list[i] == n - 1) {
                return i;
            }
        }

        return -1;
    }

    @Test
    void case_1() {

        // given
        int n = 2;
        int[][] trust = {{1, 2}};
        int expected = 2;

        // when
        int returnVal = findJudge(n, trust);

        // then
        assertThat(returnVal).isEqualTo(expected);

    }


    @Test
    void case_2() {

        // given
        int n = 3;
        int[][] trust = {{1, 3}, {2, 3}};
        int expected = 3;

        // when
        int returnVal = findJudge(n, trust);

        // then
        assertThat(returnVal).isEqualTo(expected);

    }


}
