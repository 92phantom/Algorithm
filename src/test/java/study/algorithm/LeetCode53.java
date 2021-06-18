package study.algorithm;

import org.junit.jupiter.api.Test;

/**
 * @ author             : hyunjin
 * @ date               : 21. 5. 27.
 * @ name               : 53. Maximum Subarray
 * @ link               : https://leetcode.com/problems/maximum-subarray/
 * @ time complexity    : O(n^2)
 * @ algorithm          : Brutal Force
 */
public class LeetCode53 {

    public int maxSubArray(int[] nums) {

        if(nums.length == 1){
            return nums[0];
        }

        int ans = Integer.MIN_VALUE ;

        for(int i=0; i<nums.length; i++){
            int tmp = 0;

            for (int j=i; j<nums.length; j++){
                tmp += nums[j];
                ans = Math.max(tmp, ans);
            }

        }

        return ans;
    }

    @Test
    void test1() {

        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));

    }


}
