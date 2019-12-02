package leet0201to0400.problem0221;

/**
 * @author James
 * @date 2019-12-01 18:37
 **/
public class MaximalSquare_0221 {

    /**
     *  int minValue = Math.min(dp[i - 1][j], Math.min(dp[i - 1][j - 1], dp[i][j - 1]));
     * dp[i][j] = minValue + 1;
     * @param matrix
     * @return
     */
    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int rowSize = matrix.length;
        int columnSize = matrix[0].length;
        int max = 0;
        int[][] dp = new int[rowSize][columnSize];
        for (int i = 0; i < rowSize; i++) {
            if (matrix[i][0] == '1') {
                dp[i][0] = 1;
                max = 1;
            }
        }

        for (int i = 0; i < columnSize; i++) {
            if (matrix[0][i] == '1') {
                dp[0][i] = 1;
                max = 1;
            }
        }
        for (int i = 1; i < rowSize; ++i) {
            for (int j = 1; j < columnSize; j++) {
                if (matrix[i][j] == '1') {
                    int minValue = Math.min(dp[i - 1][j], Math.min(dp[i - 1][j - 1], dp[i][j - 1]));
                    dp[i][j] = minValue + 1;
                    max = Math.max(dp[i][j], max);
                }
            }
        }
        return max * max;
    }
}
