package leet1001to1200.problem1143;

/**
 * @author James
 * @program SuccessLeetCode
 * @description
 * @date 2019-10-07 20:44
 **/
public class LongestCommonSub1143 {


    /**
     * f[i][j]表示text1中到i下标为止的字符和text2中到j为止的下标的字符的最长公共子序列长度。
     *
     *
     */

    public int longestCommonSubsequence(String text1, String text2) {
        if (text1 == null || text2 == null || text1.length() == 0 || text2.length() == 0) {
            return 0;
        }
        int len1 = text1.length(), len2 = text2.length();
        char[] text1Chars = text1.toCharArray(), text2Chars = text2.toCharArray();
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 0; i < len1; ++i) {
            for (int j = 0; j < len2; ++j) {
                if (text1Chars[i] == text2Chars[j]) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                } else {
                    dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i+1][j]);
                }
            }
        }
        return dp[len1][len2];
    }


}
