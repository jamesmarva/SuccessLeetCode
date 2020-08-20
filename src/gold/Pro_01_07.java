package gold;

/**
 * @author Brilliant James
 * @date 2020-04-07 05:22
 **/
public class Pro_01_07 {

    /**
     * [2, 0] => [0, 0]
     * [0, 0] => [0, 2]
     * [0, 2] => [2, 2]
     * [2, 2] => [2, 0]
     *
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        if (matrix.length == 0 || matrix.length != matrix[0].length) {
            return;
        }
        int len  = matrix.length;
        for (int i = 0; i < len ; i++) {
            for (int j = i + 1; j < len; j++) {
                int t = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = t;
            }
        }
        int mid = len / 2;
        for (int i = 0; i <= mid; i++) {
            for (int j = 0; j < len; j++) {
                int t = matrix[i][j];
                matrix[i][j] = matrix[i][len - 1 - j];
                matrix[i][len - 1 - j] = t;
            }
        }
    }
}
