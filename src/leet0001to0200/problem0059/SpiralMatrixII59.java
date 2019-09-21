package leet0001to0200.problem0059;

/**
 * @author  James
 * 59. 螺旋矩阵 II
 * 给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 * 示例:
 * 输入: 3
 * 输出:
 * [
 *  [ 1, 2, 3 ],
 *  [ 8, 9, 4 ],
 *  [ 7, 6, 5 ]
 * ]
 */
public class SpiralMatrixII59 {


    public static void  main(String[] args) {
        SpiralMatrixII59 generateMatrixSolution = new SpiralMatrixII59();
        System.out.print(generateMatrixSolution.generateMatrix(1));
    }

    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        if (n == 1) {
            matrix[0][0] = 1;
            return matrix;
        }
        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;
        int point = 0;
        while (true) {
            for (int i = left; i < right; i ++) {
                matrix[top][i] = ++point ;
            }
            for (int i = top; i < bottom; i++) {
                matrix[i][right] = ++point;
            }
            for (int i = right; i > left; i--) {
                matrix[bottom][i] = ++point;
            }
            for (int i = bottom; i > top; i--) {
                matrix[i][left] = ++point;
            }

            left++;
            if (left == right) {
                break;
            }

            top++;
            if (top >= bottom) {
                break;
            }

            right--;
            if (right == left) {
                matrix[left][top]= ++point;;
                break;
            }

            bottom--;
            if (bottom == top) {
                break;
            }
        }
        return matrix;
    }


    public int[][] good (int n) {
        int[][] matrix = new int[n][n];
        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;
        int count = 1;
        while (true) {
            for (int i = left; i <= right; i++) matrix[top][i] = count++;
            top++;
            if (left > right || top > bottom) break;

            for (int i = top; i <= bottom; i++) matrix[i][right] = count++;
            right--;
            if (left > right || top > bottom) break;

            for (int i = right; i >= left; i--) matrix[bottom][i] = count++;
            bottom--;
            if (left > right || top > bottom) break;

            for (int i = bottom; i >= top; i--) matrix[i][left] = count++;
            left++;
            if (left > right || top > bottom) break;
        }

        return matrix;

    }


    public int[][] generateMatrixGood(int n) {
        int[][] result = new int[n][n];
        int num = 1;
        int d = n - 1;
        int x = (n - d) / 2;
        int y = (n - d) / 2;
        while (d > 0) {
            for (int i = 0; i < d; i++) {
                result[x][y + i] = num++;
            }

            y += d;
            for (int i = 0; i < d; i++) {
                result[x + i][y] = num++;
            }

            x += d;
            for (int i = 0; i < d; i++) {
                result[x][y - i] = num++;
            }

            y = (n - d) / 2;
            for (int i = 0; i < d; i++) {
                result[x - i][y] = num++;
            }

            d -= 2;
            x = (n - d) / 2;
            y = (n - d) / 2;
        }

        if (d == 0) {
            result[x][y] = num;
        }
        return result;
    }


}
