package sward;

/**
 * @author Brilliant James
 * @date 2020-03-08 12:48
 **/
public class Problem_014_I {


    public int cuttingRope(int n) {
        int[] dp = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                int left = Math.max(j, dp[j]);
                int right = Math.max(i - j, dp[i - j]);
                dp[i] = Math.max(dp[i], left * right);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Problem_014_I p = new Problem_014_I();
        for (int i = 2; i <= 15; i++) {
            System.out.println("i " + i + ":" + p.cuttingRope(i));
        }
    }
}
