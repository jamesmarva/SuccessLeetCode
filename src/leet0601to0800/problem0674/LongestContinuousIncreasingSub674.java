package leet0601to0800.problem0674;

/**
 * @author James
 * @program SuccessLeetCode
 * @description https://leetcode-cn.com/problems/longest-continuous-increasing-subsequence/
 * @date 2019-10-08 21:20
 **/
public class LongestContinuousIncreasingSub674 {

    public static int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int start = 0;
        int ans = 1;
        for (int i = 1, len = nums.length; i < len; ++i) {
            if (i == len - 1 && nums[i] > nums[i-1]) {
                ans = Math.max(ans, i - start + 1);
            } else if (nums[i] < nums[i - 1]) {
                ans = Math.max(ans, i - start);
                start = i;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] test = {1,3,5,4,7,8,9};
        System.out.println(findLengthOfLCIS(test));
    }

}
