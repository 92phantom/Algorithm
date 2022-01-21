package study.algorithm;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LeetCode441 {

    // 등차수열 : k(k+1)/2
    // 이분탐색
    // 441. Arranging Coins
    // 시간복잡도 : O(logN)

    public int arrangeCoins(int n) {

        if(n <= 1 ) return n;

        int left = 0, right = n;
        int result = 0;

        while(left <= right) {

            int middle = (left + right) / 2;
            long sum = (long) middle * (middle+1) / 2;

            if(sum == n) {
                result = middle;
                break;
            }

            if(sum <= n) {
                result = middle;
                left = middle+1;
            }
            else {
                right = middle-1;
            }

        }

        return result;
    }

    @Test
    void test_1() {

        // given
        int n = 5;
        int expectedResult = 2;

        // when
        int result = arrangeCoins(n);

        // then
        assertThat(result).isEqualTo(expectedResult);

    }

    @Test
    void test_2() {

        // given
        int n = 8;
        int expectedResult = 3;

        // when
        int result = arrangeCoins(n);

        // then
        assertThat(result).isEqualTo(expectedResult);

    }

}
