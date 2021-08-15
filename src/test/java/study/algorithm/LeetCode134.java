package study.algorithm;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LeetCode134 {

    public int canCompleteCircuit(int[] gas, int[] cost) {

        int rotate = 0;
        for (int i = 0; i < gas.length; i++) {
            int sum = 0;
            while (gas[i] < cost[i]) {
                i++;
                if (i == gas.length) {
                    return -1;
                }
            }
            int j = i;
            boolean a = false;
            while (sum >= 0) {
                if (j == i && a) {
                    return i;
                }
                sum += gas[j];
                sum -= cost[j];
                j++;
                if (j >= gas.length) {
                    j = j % gas.length;
                    a = true;
                }
            }
        }
        return -1;
    }

    @Test
    void test_1() {

        // given
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};
        int expectedValue = 3;

        // when
        int returnVal = canCompleteCircuit(gas, cost);

        // then
        assertThat(returnVal).isEqualTo(expectedValue);

    }

}
