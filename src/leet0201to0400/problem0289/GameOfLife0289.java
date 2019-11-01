package leet0201to0400.problem0289;

/**
 * https://leetcode-cn.com/problems/game-of-life/
 * 输入:
 * [
 *   [0,1,0],
 *   [0,0,1],
 *   [1,1,1],
 *   [0,0,0]
 * ]
 * 输出:
 * [
 *   [0,0,0],
 *   [1,0,1],
 *   [0,1,1],
 *   [0,1,0]
 * ]
 *
 * 链接：https://leetcode-cn.com/problems/game-of-life
 * @author James
 * @date 2019-10-27 10:52
 **/
public class GameOfLife0289 {

    /**
     * 如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡；
     * 如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活；
     * 如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡；
     * 如果死细胞周围正好有三个活细胞，则该位置死细胞复活；
     * 起始状态有两个01，终了状态也有两种01
     * 起始    终了  状态码
     * 0      0     2
     * 0      1     3    死细胞周围正好有三个活细胞，则该位置死细胞复活；
     * 1      0     4    活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡；如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡；
     * 1      1     5    活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活；
     */
    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0){
            return;
        }
        int rowSize = board.length;
        int colSize = board[0].length;
        for (int i = 0; i < rowSize; ++i) {
            for (int j = 0; j < colSize; ++j) {
                getTempResult(i, j, rowSize, colSize, board);
            }
        }


        for (int i = 0; i < rowSize; ++i) {
            for (int j = 0; j < colSize; ++j) {
                if (board[i][j] == 2 || board[i][j] == 4) {
                    board[i][j] = 0;
                }
                if (board[i][j] == 3 || board[i][j] == 5) {
                    board[i][j] = 1;
                }
            }
        }
    }

    /**
     * 起始    终了  状态码
     * 0      0     2
     * 0      1     3    死细胞周围正好有三个活细胞，则该位置死细胞复活；
     * 1      0     4    活细胞周围八个位置的活细胞数少于2个，则该位置活细胞死亡；如果活细胞周围八个位置有超过3个活细胞，则该位置活细胞死亡；
     * 1      1     5    活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活；
     */
    private int getTempResult(int rowIndex, int colIndex, int rowSize, int colSize, int[][] board) {
        int top = Math.max(0, rowIndex - 1);
        int bottom = Math.min(rowSize - 1, rowIndex + 1);

        int left = Math.max(0, colIndex -1);
        int right = Math.min(colSize - 1, colIndex + 1);
        int count = 0;
        for (int i = top; i <= bottom; ++i) {
            for (int j = left; j <= right; ++j) {
                if (i == rowIndex && j == colIndex) {
                    continue;
                }
                if (board[i][j] == 1 || board[i][j] == 4 || board[i][j] == 5 ) {
                    count++;
                }
            }
        }
        if (board[rowIndex][colIndex] == 0) {
            if (count == 3) {
                board[rowIndex][colIndex] = 3;
            } else {
                board[rowIndex][colIndex] = 2;
            }
        } else {
            if (count < 2 || count > 3) {
                board[rowIndex][colIndex] = 4;
            } else if (count == 2 || count == 3) {
                board[rowIndex][colIndex] = 5;
            }
        }
        return  0;
    }
}
