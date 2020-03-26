package leet0801to1000.problem0892;

/**
 * https://leetcode-cn.com/problems/surface-area-of-3d-shapes/submissions/
 * 892. 三维形体的表面积
 * @author Brilliant James
 * @date 2020-03-25 02:13
 **/
public class SurfaceAreaOfThreeShapes_0892 {

    /**
     * 取每个位置上的柱状图进行计算，算每个柱状体的露出的面积，
     * 每个柱状体对整体面积的贡献值
     * 比如
     * 1, 2
     * 3, 4
     * 1 6个面的贡献值：1（上） + 0（下）+ 1（左）+ 0（右） + 1（顶） + 1（底）
     * 2 6个面的贡献值：2（上） + 0（下）+ 1（左）+ 2（右） + 1（顶） + 1（底）
     * @param grid
     * @return
     */
    public int surfaceArea(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int rowLen = grid.length;
        int colLen = grid.length;
        int count = 0;
        int ans = 0;
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                int cur = grid[i][j];
                if (cur > 0) {
                    count++;
                }
                if (i + 1 < rowLen) {
                    ans += Math.max(cur - grid[i + 1][j], 0);
                } else {
                    ans += cur;
                }
                if (i - 1 >= 0) {
                    ans += Math.max(cur - grid[i - 1][j], 0);
                } else {
                    ans += cur;
                }
                if (j + 1 < colLen) {
                    ans += Math.max(cur - grid[i][j + 1], 0);
                } else {
                    ans += cur;
                }
                if (j - 1 >= 0) {
                    ans += Math.max(cur - grid[i][j - 1], 0);
                } else {
                    ans += cur;
                }
            }
        }
        return ans + count * 2;
    }
}
