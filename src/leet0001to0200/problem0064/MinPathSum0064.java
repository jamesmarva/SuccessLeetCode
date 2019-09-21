package leet0001to0200.problem0064;

/**
 * @program: SuccessLeetCode
 * @description: https://leetcode-cn.com/problems/minimum-path-sum/
 * @author: James
 * @create: 2019-09-13 08:36
 **/
public class MinPathSum0064 {

    public static int minPathSum(int[][] grid) {
        int lengthHeng = grid[0].length;
        int lengthZong = grid.length;
        int[][] temp = new int[lengthZong][lengthHeng];
        for (int i = 0; i < lengthZong; i++) {
            for (int j = 0; j < lengthHeng; j++) {
                if (i == 0 && j == 0) {
                    temp[0][0] = grid[0][0];
                } else if (i == 0) {
                    temp[0][j] = grid[0][j] + temp[0][j -1];
                } else if (j == 0) {
                    temp[i][0] = grid[i][0] + temp[i-1][0];
                } else {
                    temp[i][j] = Math.min(temp[i - 1][j], temp[i][j - 1]) + grid[i][j];
                }
            }
        }
        return temp[lengthZong - 1][lengthHeng - 1];
    }

    public int good_minPathSum(int[][] grid) {
        int m = grid.length;
        if(0 == m) {
            return 0;
        }

        int n = grid[0].length;
        int [][] minpath = new int[m+1][n+1];
        //init 0th row and 0th column to Max
        for(int i = 0;i <= m;i ++) {
            minpath[i][0] = Integer.MAX_VALUE;
        }

        for(int j = 0;j <= n;j ++) {
            minpath[0][j] = Integer.MAX_VALUE;
        }
        minpath[0][1] = 0;

        for(int i = 1;i <= m;i ++) {
            for(int j = 1;j <= n;j++) {
                minpath[i][j] = Math.min(minpath[i-1][j],minpath[i][j-1]) + grid[i-1][j-1];
            }
        }
        return minpath[m][n];
    }
}
