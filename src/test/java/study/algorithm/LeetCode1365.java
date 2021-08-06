package study.algorithm;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;


public class LeetCode1365 {

    public final int MAXSIZE = 101;

    public int[] smallerNumbersThanCurrent(int[] nums) {

        int[] answer = new int[nums.length];

        int[] save_index = new int[MAXSIZE];

        for(int i=0; i<nums.length; i++) {
            save_index[nums[i]]++;
        }

        for(int i=0; i<nums.length; i++) {

            for(int j=0; j<nums[i]; j++) {
                if(save_index[j] != 0){
                    answer[i] += save_index[j];
                }
            }
        }

        return answer;

    }


    @Test
    void 테스트_1() {

        // given
        int[] nums = {8,1,2,2,3};
        int[] expected = {4,0,1,1,3};

        // when
        int[] answer = smallerNumbersThanCurrent(nums);

        // then
        assertThat(answer).isEqualTo(expected);

    }

    @Test
    void 테스트_2() {

    }

}
