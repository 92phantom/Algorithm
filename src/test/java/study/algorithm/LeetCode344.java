package study.algorithm;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

public class LeetCode344 {

    public void reverseString(char[] s) {

        int left = 0;
        int right = s.length - 1;

        while(left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;

            left++;
            right--;
        }

        System.out.println(Arrays.toString(s));

    }

    @Test
    void test1() {

        // given
        char[] s = {'h','e','l','l','o'};

        // when
        reverseString(s);

        // then

    }

    @Test
    void test2() {

    }

}
