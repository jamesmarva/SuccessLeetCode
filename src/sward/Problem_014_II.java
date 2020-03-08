package sward;

/**
 * https://leetcode-cn.com/problems/jian-sheng-zi-ii-lcof/submissions/
 * @author Brilliant James
 * @date 2020-03-08 13:09
 **/
public class Problem_014_II {


    /**
     * 这一题已经不能用动态规划了，取余之后max函数就不能用来比大小了。
     *
     * https://leetcode-cn.com/problems/jian-sheng-zi-ii-lcof/solution/mian-shi-ti-14-ii-jian-sheng-zi-iitan-xin-er-fen-f/
     *
     * 贪心的思想，用来搞定这。
     * @param n
     * @return
     */
    public int cuttingRope(int n) {
        if (n == 2) {
            return 1;
        }

        if (n == 3) {
            return 2;
        }
        long res = 1;
        while(n > 4){
            res *= 3;
            res = res % 1000000007;
            n -= 3;
        }
        return (int)(res * n % 1000000007);
    }

    /**
     * 这个方法依然不行
     * @param n
     * @return
     */
    public int cuttingRope_01(int n) {
        long[] dp = new long[n + 1];
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i / 2; j++) {
                long left = Math.max(j, dp[j]);
                long right = Math.max(i - j, dp[i - j]);
                dp[i] = Math.max(dp[i], (left * right) % 1_000_000_007);
            }
        }
        return (int) dp[n];
    }
}
