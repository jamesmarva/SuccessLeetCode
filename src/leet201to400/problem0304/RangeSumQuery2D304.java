package leet201to400.problem0304;

/**
 * @program: SuccessLeetCode
 * @description:
 * @author: James
 * @create: 2019-09-21 07:15
 **/
public class RangeSumQuery2D304 {

    private int[][] dp;
    public RangeSumQuery2D304(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        int rowLen = matrix.length;
        int columnLen = matrix[0].length;
        dp = new int[rowLen + 1][columnLen + 1];
        for (int i = 0; i < rowLen; ++i) {
            for (int j = 0; j < columnLen; ++j) {
                dp[i + 1][j + 1] = -dp[i][j] + matrix[i][j] + dp[i][j + 1] + dp[i + 1][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return dp[row2 + 1][col2 + 1] - dp[row1][col2 + 1] - dp[row2 + 1][col1] + dp[row1][col1];
    }

    public static void main(String[] args) {
        int[][] test = {{3,0,1,4,2},
                        {5,6,3,2,1},
                        {1,2,0,1,5},
                        {4,1,0,1,7},
                        {1,0,3,0,5}};
        RangeSumQuery2D304 rangeSumQuery2D304 = new RangeSumQuery2D304(test);
        rangeSumQuery2D304.sumRegion(2, 1, 4, 3);
    }
}
