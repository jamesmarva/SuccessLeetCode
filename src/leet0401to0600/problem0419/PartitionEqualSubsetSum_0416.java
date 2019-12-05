package leet0401to0600.problem0419;

import java.util.Arrays;

/**
 * @author James
 * @date 2019-12-04 22:45
 **/
public class PartitionEqualSubsetSum_0416 {


    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        Arrays.sort(nums);
        dfs(0, 0, nums, target, nums.length);
        return ans;
    }

    private boolean ans = false;
    private void dfs(int index, int temp, int[] nums, int target, int len) {
        if (ans) {
            return;
        }
        if (target == temp) {
            ans = true;
            return;
        }
        for (int i = index; i < len; ++i) {
            if (temp + nums[i] < target) {
                dfs(i + 1, temp + nums[i], nums, target, len);
            }
        }
    }



    public boolean canPartition_1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        int len = nums.length;
        boolean[][] dp = new boolean[len][target + 1];
        dp[0][0] = true;
        dp[0][nums[0]] = true;
        for (int i = 1; i < len; ++i) {
            for (int j = 0; j <= target; j++){
                dp[i][j] = dp[i-1][j];
                if (j >= nums[i]) {
                    dp[i][j] = dp[i-1][j - nums[i]] || dp[i - 1][j];
                }
            }
        }
//        for (int i = 0; i < len; ++i) {
//            if (dp[i][target] ) {
//                return true;
//            }
//        }
        return dp[len - 1][target];
    }

    public static void main(String[] args) {
        int[] test = {1, 5, 11, 5};
        PartitionEqualSubsetSum_0416 pp = new PartitionEqualSubsetSum_0416();
        pp.canPartition(test);
    }

    private int test1(int[] nums, int n, int maxWeight) {
        boolean[][] state = new boolean[n][maxWeight + 1];
        state[0][0] = true;
        if (nums[0] < maxWeight) {
            state[0][nums[0]] = true;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= maxWeight; ++j) {
                if (state[i-1][j]) {
                    state[i][j] = true;
                }
            }
            for (int j = nums[i]; j <= maxWeight; j++) {
                if (state[i-1][j - nums[i]]) {
                    state[i][j] = true;
                }
            }
        }
        for (int i = maxWeight; i >= 0; --i) {
            if (state[n - 1][i]) {
                return i;
            }
        }
        return 0;
    }
}
