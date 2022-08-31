package study.algorithm;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class LeetCode1400 {
    public boolean canConstruct(String s, int k) {

        int[] arr = new int[100];

        if(k > s.length()) {
            return false;
        }

        for(int i=0; i<s.length(); i++){
            arr[s.charAt(i)-'a'] ++;
        }

        int oddCount = 0;

        for(int i=0; i<arr.length; i++){
            int value = arr[i];
            if(value % 2 != 0) {
                oddCount+=1;
            }

            if (oddCount > k) return false;
        }

        return true;
    }

    @Test
    void test_1() {

        // given
        String data = "annabelle";
        int k = 2;
        boolean expectedResult = true;

        // when
        boolean result= canConstruct(data, k);

        // then
        Assertions.assertThat(result).isEqualTo(expectedResult);

    }

    @Test
    void test_2() {

        // given
        String data = "leetcode";
        int k = 3;
        boolean expectedResult = false;

        // when
        boolean result= canConstruct(data, k);

        // then
        Assertions.assertThat(result).isEqualTo(expectedResult);

    }

}
