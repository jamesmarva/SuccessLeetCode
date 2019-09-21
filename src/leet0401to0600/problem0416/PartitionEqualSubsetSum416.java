package leet0401to0600.problem0416;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *  myleetcode
 *  https://leetcode-cn.com/problems/partition-equal-subset-sum/
 * @author James
 * @date 2019-07-04 07:44
 **/
public class PartitionEqualSubsetSum416 {

    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length < 2) {
            return false;
        }
        int res = 0;
        for (int i = 0, len = nums.length; i < len; ++i) {
            res += nums[i];
        }
        if (res % 2 == 1) {
            return false;
        } else {
            return subSum(nums, res / 2) > 0;
        }
    }

    private int subSum(int[] nums, int target) {
        int[][] dp = new int[nums.length + 1][target + 1];
        dp[0][0] = 1;
        for (int i = 0, len = nums.length; i < len; ++i) {
            for (int j = 0; j <= target; ++j) {
                if (nums[i] <= target) {
                    dp[i + 1][j] = dp[i][j - nums[i]] + dp[i][j];
                } else {
                    dp[i + 1][j] = dp[i][j];
                }
            }
            if (dp[i][target] > 0) {
                return dp[i][target];
            }
        }
        return dp[nums.length][target];
    }

    public boolean canPartitionNew(int[] nums) {
        //计算出数组总和
        int n = nums.length;
        int sum = 0;
        for (int i = 0; i < n; i++){
            sum += nums[i];
        }
        //如果数组元素总和为奇数，直接返回false
        if (sum % 2 != 0){
            return false;
        }
        boolean[][] states = new boolean[n][sum/2 + 1];
        //对第一行元素特殊处理
        states[0][0] = true;
        if(nums[0] <= sum/2) {
            states[0][nums[0]] = true;
        }
        //数组最后一列为1，表示满足条件
        if (states[0][sum/2]){
            return true;
        }
        //考虑n个数组元素
        for (int i = 1; i < n; i++){
            //第i个数组元素不放入
            for (int j = 0; j <= sum/2; j++){
                //数组上一行的同一列为true
                if (states[i-1][j]){
                    states[i][j] = true;
                }
            }
            //第i个数组元素放入
            for (int j = 0; j <= sum/2 - nums[i]; j++){
                if (states[i-1][j]){
                    //数组本行的列+num[i]元素为true
                    states[i][j + nums[i]] = true;
                }
            }
            for (int j = 0; j <= sum/2; ++j ) {
              if (j <= sum/2) {
                  if (states[i-1][j]) {
                      states[i][j] = true;
                  }
              } else {

              }
            }
            //数组最后一列为1，表示满足条件
            if (states[i][sum/2]){
                return true;
            }
        }
        return false;
    }

    public boolean canPartitionBetter(int[] nums) {
        int sum = 0;
        for (int item : nums) {
            sum += item;
        }
        if (sum % 2 != 0) {
            return false;
        }
        int len = nums.length;
        int target = sum / 2;
        boolean[][] dp = new boolean[len + 1][target + 1];
        dp[0][0] = true;
        for (int i = 0; i <= len; ++i) {
            if (nums[i] > target) {
                return false;
            }
            dp[i][nums[i]] = true;
            dp[i][0] = true;
        }
        for (int i = 0; i <= target; ++i) {
            dp[0][i] = false;
        }
        for (int i = 1; i <= len; ++i) {
            for (int j = 1; j <= target; ++j) {
                dp[i][j] = dp[i -1][j];
                if (j > nums[i - 1]  && dp[i - 1][j - nums[i - 1]]) {
                    dp[i][j] = true;
                }
            }
        }
        return dp[len][target];
    }

    public boolean solution(int[] nums) {
        int sum = 0;

        for (int num : nums) {
            sum += num;
        }

        if ((sum & 1) == 1) {
            return false;
        }
        sum /= 2;

        int n = nums.length;
        boolean[][] dp = new boolean[n+1][sum+1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], false);
        }

        dp[0][0] = true;

        for (int i = 1; i < n+1; i++) {
            dp[i][0] = true;
        }
        for (int j = 1; j < sum+1; j++) {
            dp[0][j] = false;
        }

        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < sum+1; j++) {
                dp[i][j] = dp[i-1][j];
                if (j >= nums[i-1]) {
                    dp[i][j] = (dp[i][j] || dp[i-1][j-nums[i-1]]);
                }
            }
        }

        return dp[n][sum];
    }

    /**
     * 最好的答案了
     */
    public boolean canPartitionBest(int[] nums) {
        // check edge case
        if (nums == null || nums.length == 0) {
            return true;
        }
        // preprocess
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        // dp def
        boolean[] dp = new boolean[target + 1];
        // dp init
        dp[0] = true;
        // dp transition
        for (int i = 1; i <= nums.length; i++) {
            for (int j = target; j >= nums[i-1]; j--) {
                dp[j] = dp[j] || dp[j - nums[i-1]];
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
//        (n - 1) & hash : hash % (n - 1);
//        System.out.println(10 % 5);
//        System.out.println(10 % 4);
//
//        System.out.println((4-1) & 10);
    }

}
