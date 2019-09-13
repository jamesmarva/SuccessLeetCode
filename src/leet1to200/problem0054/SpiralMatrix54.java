package leet1to200.problem0054;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: SuccessLeetCode
 * @description: https://leetcode-cn.com/problems/spiral-matrix/
 * @author: James
 * @create: 2019-09-09 21:33
 **/
public class SpiralMatrix54 {

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
            for (int i = left; i <= right; i++) {
                resultList.add(matrix[top][i]);
            }
            top++;
            if (left > right || top > bottom) {
                break;
            }

            for (int i = top; i <= bottom; i++) {
                resultList.add(matrix[i][right]);
            }
            right--;
            if (left > right || top > bottom) break;

            for (int i = right; i >= left; i--) {
                resultList.add(matrix[bottom][i]);
            }
            bottom--;
            if (left > right || top > bottom) break;

            for (int i = bottom; i >= top; i--) {
                resultList.add(matrix[i][left]);
            }
            left++;
            if (left > right || top > bottom) break;
        }
        return resultList;
    }
}
