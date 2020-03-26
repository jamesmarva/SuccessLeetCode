package gold;

/**
 * https://leetcode-cn.com/problems/the-masseuse-lcci/
 * 面试题 17.16. 按摩师
 * @author Brilliant James
 * @date 2020-03-24 00:52
 **/
public class Pro_17_16 {

    public int massage(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        // dp[i] = max(dp[i - 1], dp[i - 2] + nums[i]);
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = nums[0];
        dp[1] = Math.max(dp[0], nums[1]);
        for (int i = 2; i < len; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
        }
        return dp[len - 1];
    }
}
