package study.algorithm;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LeetCode1588 {

    public int sumOddLengthSubarrays(int[] arr) {

        int sum = 0;

        int l = arr.length;

        for (int i = 0; i < l; i++) {
            // j = sum range
            for (int j = i; j < l; j += 2) {
                // index
                for (int k = i; k <= j; k++) {
                    sum += arr[k];
                }
            }
        }

        return sum;
    }

    @Test
    void 테스트1() {
        // given
        int[] data = {1,4,2,5,3};
        int expectedResult = 58;

        // when
        int result= sumOddLengthSubarrays(data);

        // then
        Assertions.assertThat(result).isEqualTo(expectedResult);
    }

}
