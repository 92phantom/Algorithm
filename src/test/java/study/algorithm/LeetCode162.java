package study.algorithm;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LeetCode162 {

    // 162. Find Peak Element
    // 이분탐색
    // 최고값을 뽑는 것아닌 peak Element 아무거나 하나를 출력하는 것 (좌우보다 큰 중앙값)
    // 시간복잡도 : log N

    public int findPeakElement(int[] nums) {

        if(nums == null || nums.length == 0)    return -1;

        int len = nums.length;
        int start = 0;
        int end = len -1;

        while(start <= end) {

            int mid = (start + end ) / 2;

            // 좌측끝점에 왔거나, 우측 끝점인 경우 예외처리 추가
            if((mid == 0 || nums[mid-1] <= nums[mid])
                && (mid == len -1 || nums[mid] >= nums[mid+1])) {
                return mid;
            }

            else if(mid > 0  && nums[mid-1] > nums[mid] ) {
                end = mid -1;
            }

            else start = mid + 1;

        }

        return -1;
    }


    @Test
    void test_1() {

        //given
        int[] nums = {1, 2, 3, 1};
        int expectedOutput = 2;

        // when
        int output = findPeakElement(nums);

        // then
        assertThat(output).isEqualTo(expectedOutput);

    }

    @Test
    void test_2() {

        //given
        int[] nums = {1,2,1,3,5,6,4};
        int expectedOutput = 5;

        // when
        int output = findPeakElement(nums);

        // then
        assertThat(output).isEqualTo(expectedOutput);

    }


}
