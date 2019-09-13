package leet1to200.problem0052;

/**
 * https://leetcode-cn.com/problems/n-queens-ii/
 * 52. N皇后 II
 * 给定一个整数 n，返回 n 皇后不同的解决方案的数量。
 */
public class NQueensII0052 {

    class MySolution {
        int count = 0;
        public int totalNQueens(int n) {
            int[] res = new int[n];
            getQueen(0, n, res);
            return count;
        }

        public void getQueen(int row, int length, int[] array) {
            if (row == length) {
                count++;
            }
            for (int i = 0; i < length; i++) {
                if (!canFight(array, row, i)) {
                    array[row] = i;
                    getQueen(row + 1, length, array);
                }
            }
        }

        public boolean canFight(int[] array, int row, int column) {
            for (int i = row - 1; i >= 0; i--) {
                if (array[i] == column) { // 是否同列
                    return true;
                }
                if (Math.abs(row - i) == Math.abs(column - array[i])) {//是否在一条斜线上
                    return true;
                }
            }
            return false;
        }
    }
}
