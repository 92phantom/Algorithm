package study.algorithm;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ConcurrentHashMap;

import static org.assertj.core.api.Assertions.assertThat;

public class LeetCode169 {


    ConcurrentHashMap<Integer, Integer> values = new ConcurrentHashMap<>();

    public int majorityElement(int[] nums) {

        int cur = 0;
        int max_index = 0;

        for(int i : nums) {

            int value = i;

            if(!values.containsKey(value)) {
                values.put(value, 1);
            }
            else {
                values.replace(value, values.get(value).intValue()+1);
            }

            if(cur < values.get(value).intValue()) {
                cur = values.get(value).intValue();
                max_index = value;
            }

        }

        return max_index;

    }

    @Test
    void test_1() {

        // given
        int[] nums = {3,2,3};
        int expectedValue = 3;

        // when
        int returnVal = majorityElement(nums);

        // then
        assertThat(returnVal).isEqualTo(expectedValue);

    }



}
