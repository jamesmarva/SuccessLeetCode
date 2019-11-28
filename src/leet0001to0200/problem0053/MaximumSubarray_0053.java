package leet0001to0200.problem0053;

/**
 * @author James
 * @date 2019-11-28 13:07
 **/
public class MaximumSubarray_0053 {


    /**
     * 如果对当前的为是在正的值，那么就留下
     *
     * 53. 最大子序和
     * https://leetcode-cn.com/problems/maximum-subarray/
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length ==0) {
            return 0;
        }
        int len = nums.length;
        int[] dp = new int[len];
        int max = 0;
        if (nums[0] > 0) {
            dp[0] = nums[0];
        }
        for (int i = 1; i < len; i++) {
            if (dp[i - 1] + nums[i] > 0) {
                dp[i] = dp[i - 1] + nums[i];
            } else {
                dp[i] = nums[i];
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }


    int max = Integer.MIN_VALUE;

    public int maxSubArray_1(int[] nums) {
        //类似寻找最大最小值的题目，初始值一定要定义成理论上的最小最大值
        int numsSize = nums.length;
        int result = maxSubArrayHelper(nums, 0, numsSize - 1);
        return result;
    }

    int maxSubArrayHelper(int[] nums, int left, int right) {
        if (left == right){
            return nums[left];
        }
        int mid = left + ((right - left) >> 1);
        int leftSum = maxSubArrayHelper(nums, left, mid);
        //注意这里应是mid + 1，否则left + 1 = right时，会无线循环
        int rightSum = maxSubArrayHelper(nums, mid + 1, right);
        int midSum = findMaxCrossingSubarray(nums, left, mid, right);
        int result = Math.max(Math.max(leftSum, rightSum), midSum);
        return result;
    }

    int findMaxCrossingSubarray(int[] nums, int left, int mid, int right) {
        int leftSum = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = mid; i >= left; i--) {
            sum += nums[i];
            leftSum = Math.max(leftSum, sum);
        }

        int rightSum = Integer.MIN_VALUE;
        sum = 0;
        //注意这里i = mid + 1，避免重复用到nums[i]
        for (int i = mid + 1; i <= right; i++) {
            sum += nums[i];
            rightSum = Math.max(rightSum, sum);
        }
        return (leftSum + rightSum);
    }


}
