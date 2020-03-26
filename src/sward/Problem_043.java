package sward;

/**
 * 面试题43. 1～n整数中1出现的次数
 * https://leetcode-cn.com/problems/number-of-digit-one/
 * @author Brilliant James
 * @date 2020-03-26 16:17
 **/
public class Problem_043 {

    public int countDigitOne(int n) {
        int len = ("" + n).length();
        int[] dp = new int[len + 1];
        int[] ten = new int[len + 1];
        if (n % 10 < 1) {
            dp[1] = 0;
        } else {
            dp[1] = 1;
        }
        ten[1] = 1;
        int temp = n / 10;
        for (int i = 2; i <= len; i++) {
            int lastDigit = temp % 10;
            temp /= 10;
            if (lastDigit == 0) {
                dp[i] = dp[i - 1];
            } else if (lastDigit == 1) {
                dp[i] = 1 * ten[i - 1] + dp[i - 1] + n % (int) Math.pow(10, i - 1) + 1;
            } else if (lastDigit > 1) {
                dp[i] = lastDigit * ten[i - 1] + dp[i - 1] + (int) Math.pow(10, i - 1);
            }
            ten[i] = 10 * ten[i - 1] + (int) Math.pow(10, i - 1);
        }
        return dp[len];
    }
}
