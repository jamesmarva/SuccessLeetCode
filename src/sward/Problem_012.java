package sward;

/**
 * @author Brilliant James
 * @date 2020-05-02 06:19
 **/
public class Problem_012 {

    private final static int[][] MOVE = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
    };

    public boolean exist(char[][] board, String word) {
        if (word == null || word.length() == 0) {
            return true;
        }
        char[] chars = word.toCharArray();
        int rowSize = board.length;
        int colSize = board[0].length;
        boolean[][] moved = new boolean[rowSize][colSize];
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                if (board[i][j] == chars[0] && dfs(i, j, rowSize, colSize, 0, chars, moved, board)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int rowI, int colI, int rowSize, int colSize, int index, char[] chars,
                        boolean[][] moved, char[][] board) {
        if (rowI < 0 || rowI >= rowSize || colI < 0 || colI >= colSize || moved[rowI][colI] || chars[index] != board[rowI][colI]) {
            return false;
        }
        moved[rowI][colI] = true;

        Boolean ans = dfs(rowI + MOVE[0][0], colI + MOVE[0][1], rowSize, colSize, index + 1, chars, moved, board)
                || dfs(rowI + MOVE[1][0], colI + MOVE[1][1], rowSize, colSize, index + 1, chars, moved, board)
                || dfs(rowI + MOVE[2][0], colI + MOVE[2][1], rowSize, colSize, index + 1, chars, moved, board)
                || dfs(rowI + MOVE[3][0], colI + MOVE[3][1], rowSize, colSize, index + 1, chars, moved, board);

        moved[rowI][colI] = false;
        return ans;
    }
}
