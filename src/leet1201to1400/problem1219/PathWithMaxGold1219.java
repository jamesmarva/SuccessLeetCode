package leet1201to1400.problem1219;

/**
 * @author James
 * @program SuccessLeetCode
 * @description https://leetcode-cn.com/problems/path-with-maximum-gold/
 * @date 2019-10-14 02:21
 **/
public class PathWithMaxGold1219 {

    private int ans = Integer.MIN_VALUE;
    private int rowSize = 0;
    private int columnSize = 0;
    public int getMaximumGold(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        rowSize = grid.length;
        columnSize = grid[0].length;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < rowSize; ++i) {
            for (int j = 0; j < columnSize; ++j) {
                dfs(i, j, 0, grid, visited);
            }
        }
        return ans;
    }


    public int dfs(int rowIndex, int columnIndex, int temp, int[][] grid, boolean[][] visited) {
        if ((rowIndex < rowSize && columnIndex < columnSize && rowIndex >= 0 && columnIndex >= 0)
                && grid[rowIndex][columnIndex] == 0 || visited[rowIndex][columnIndex]) {
            return temp;
        }
        visited[rowIndex][columnIndex] = true;
        temp += grid[rowIndex][columnIndex];
        int temp1 = dfs(rowIndex + 1, columnIndex, temp, grid, visited);
        int temp2 = dfs(rowIndex - 1, columnIndex, temp, grid, visited);
        int temp3 = dfs(rowIndex, columnIndex + 1, temp, grid, visited);
        int temp4 = dfs(rowIndex, columnIndex - 1, temp, grid, visited);
        visited[rowIndex][columnIndex] = false;

        int maxTemp = Math.max(temp1, Math.max(temp2, Math.max(temp3, temp4)));
        ans = Math.max(ans, maxTemp);
        return maxTemp;
    }
}
