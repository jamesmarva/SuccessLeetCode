package leet0201to0400.problem0322;

import java.util.Arrays;

/**
 *
 * https://leetcode-cn.com/problems/coin-change/
 * @author Brilliant James
 * @date 2020-03-08 11:18
 **/
public class CoinChange_0322 {

    /**
     * dp[x] = min(dp[x - coins[0], dp[x - conins[1], ......, dp[x - conins[n - 1]) + 1
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        int len = coins.length;
        for (int i = 1; i <= amount; i++) {
            int temp = Integer.MAX_VALUE;
            boolean isEnough = false;
            for (int j = 0; j < len; j++) {
                if (i - coins[j] == 0) {
                    isEnough = true;
                    temp = 0;
                } else if (i - coins[j] > 0 && dp[i - coins[j]] != -1) {
                    isEnough = true;
                    temp = Math.min(temp, dp[i - coins[j]]);
                }
            }
            if (isEnough) {
                dp[i] = temp + 1;
            }
        }
        return dp[amount];
    }
}
