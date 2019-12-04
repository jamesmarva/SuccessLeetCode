package leet0601to0800.problem0498;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/diagonal-traverse/
 * 498. 对角线遍历
 * @author James
 * @date 2019-12-04 04:05
 **/
public class DiagonalTraverse_0498 {

    /**
     *
     * @param matrix
     * @return
     */
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }
        boolean up = true;
        int row = 0, col = 0, rowSize = matrix.length, colSize = matrix[0].length, index = 0;
        int[] ans = new int[rowSize * colSize];
        while (true){
            if (up) {
                while (row >= 0 && row < rowSize && col >= 0 && col < colSize) {
                    ans[index] = matrix[row][col];
                    index++;
                    row--;
                    col++;
                }
                row++;
                col--;
                if (col + 1 < colSize) {
                    col++;
                } else if (row + 1 < rowSize){
                    row++;
                } else if (col + 1 >= colSize && row + 1  >= rowSize) {
                    break;
                }
                up = false;
            } else {
                while (row >= 0 && row < rowSize && col >= 0 && col < colSize) {
                    ans[index] = matrix[row][col];
                    index++;
                    row++;
                    col--;
                }
                row--;
                col++;
                if (row + 1 < rowSize) {
                    row++;
                } else if (col + 1 < colSize){
                    col++;
                } else if (col + 1 >= colSize && row + 1 >= rowSize) {
                    break;
                }
                up = true;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] test = {
                        {1, 4, 7, 8},
                        {2, 3, 5, 6}
                        };

        DiagonalTraverse_0498 diagonalTraverse_0498 = new DiagonalTraverse_0498();
        int[] ans = diagonalTraverse_0498.findDiagonalOrder(test);
        System.out.println(Arrays.toString(ans));

    }
}
