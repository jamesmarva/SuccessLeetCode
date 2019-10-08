package leet1001to1200.problem1035;

/**
 * @author James
 * @program SuccessLeetCode
 * @description
 * @date 2019-10-08 07:46
 **/
public class UncrossedLines1035 {

    public int maxUncrossedLines(int[] A, int[] B) {
        if (A == null || B == null || A.length == 0 || B.length == 0) {
            return 0;
        }
        int len1 = A.length, len2 = B.length;
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 0; i < len1; ++i) {
            for (int j = 0; j < len2; ++j) {
                if (A[i] == B[j]) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                } else {
                    dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i+1][j]);
                }
            }
        }
        return dp[len1][len2];
    }
}
