package gold;

import java.util.Map;

/**
 * @author Brilliant James
 * @date 2020-03-26 13:57
 **/
public class Pro_17_06 {


    /**
     * 12345
     * dp[1] =     5
     * dp[2] =    45
     * dp[3] =   345
     * dp[4] =  2345
     * dp[5] = 13245
     * 第 i 位的数字有以下几种情况：
     * 1. 0：
     * 比如 ：106: dp[2] = 06; dp[1] = 6 so dp[2] = dp[1]
     * 2. 1
     * 比如 ：106: dp[3] = 106; dp[3] = 1 * numberOf2sInRange(99) + dp[2]
     * 3. 2
     * 比如 ： 234: dp[3] =  234; dp[3] = 2 * numberOf2sInRange(99) + dp[2] + 35
     * 比如 ：2345: dp[4] = 2345; dp[4] = 2 * numberOf2sInRange(999) + dp[3] + 346
     * 4. > 2
     * 比如：345：dp[3] = 345; dp[3] = 3 * numberOf2sInRange(99) + dp[2] + 100(200~299);
     *
     * 在这里 numberOf2sInRange（99） 是符合第4种情况:
     * nine[i] = 9 * nine[i - 1] + nine[i - 1] + (int) Math.pow(10, i-1)
     *         = 10 * nine[i - 1] + (int)Math.pow(10, i - 1)
     * @param n
     * @return
     */
    public int numberOf2sInRange(int n) {
        int len = (""+n).length();
        int[] dp = new int[len + 1];
        int[] nine = new int[len + 1];
        if (n % 10 >= 2) {
            dp[1] = 1;
        } else {
            dp[1] = 0;
        }
        nine[1] = 1;
        for (int i = 2; i <= len; i ++) {
            int lastDigit = n % 10;
            if (lastDigit == 0) {
                dp[i] = dp[i-1];
            } else if (lastDigit == 1) {
                dp[i] = nine[i - 1] + dp[i - 1];
            } else if (lastDigit == 2) {
                dp[i] = 2 * nine[i - 1] + dp[i - 1] + n % (10 * (i - 1));
            } else if (lastDigit > 2) {
                dp[i] = lastDigit * nine[i - 1] + dp[i - 1] + (int)Math.pow(10, i - 1);
            }
            nine[i] = 10 * nine[i - 1] + (int)Math.pow(10, i - 1);
        }
        return dp[len];
    }

    public static void main(String[] args) {
        System.out.println((int)Math.pow(10, 4));
    }
}
