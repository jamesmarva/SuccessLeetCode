package leet0001to0200.problem0054;

import java.util.ArrayList;
import java.util.List;

/**
 * 54. 螺旋矩阵
 * https://leetcode-cn.com/problems/spiral-matrix/
 * @author James
 * @date 2019-09-09 21:33
 **/
public class SpiralMatrix54 {

    /**
     * 四个指针
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> resultList = new ArrayList<Integer>();
        if (matrix.length == 0) {
            return resultList;
        }
        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;
        while (true) {
            // 最外一层第一行遍历
            for (int i = left; i <= right; i++) {
                resultList.add(matrix[top][i]);
            }
            top++;
            if (left > right || top > bottom) {
                break;
            }

            // 最外一层最后一个列遍历
            for (int i = top; i <= bottom; i++) {
                resultList.add(matrix[i][right]);
            }
            right--;
            if (left > right || top > bottom) {
                break;
            }

            // 最外一层最后一行遍历
            for (int i = right; i >= left; i--) {
                resultList.add(matrix[bottom][i]);
            }
            bottom--;
            if (left > right || top > bottom) {
                break;
            }

            // 最外一层 第一列遍历
            for (int i = bottom; i >= top; i--) {
                resultList.add(matrix[i][left]);
            }
            left++;
            if (left > right || top > bottom) {
                break;
            }
        }
        return resultList;
    }
}
