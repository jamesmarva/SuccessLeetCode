package leet0401to0600.problem0581;

import java.util.Arrays;

/**
 * @program: SuccessLeetCode
 * @description: https://leetcode-cn.com/problems/shortest-unsorted-continuous-subarray/
 * @author: James
 * @create: 2019-09-13 09:55
 **/
public class ShortestUnsortedContinuousSub581 {

    public int findUnsortedSubarray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] cloneNums = nums.clone();
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        while (left < right && cloneNums[left] == nums[left]) {
            left++;
        }

        while (left < right && cloneNums[right] == nums[right]) {
            right--;
        }
        if (left == right) {
            return 0;
        } else {
            return right - left + 1;
        }
    }

    public int findUnsortedSubarrayBetter(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] cloneNums = nums.clone();
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        while (left < right && cloneNums[left] == nums[left]) {
            left++;
        }

        while (left < right && cloneNums[right] == nums[right]) {
            right--;
        }
        if (left == right) {
            return 0;
        } else {
            return right - left + 1;
        }
    }
}
