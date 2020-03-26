package leet0801to1000.problem0999;

import javax.crypto.spec.PSource;

/**
 * @author Brilliant James
 * @date 2020-03-26 00:34
 **/
public class AvailableCapturesForRook_0999 {

    private final static char P = 'p';
    private final static char R = 'R';
    private final static char B = 'B';

    public int numRookCaptures(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return 0;
        }
        int rowSize = board.length;
        int colSize = board[0].length;
        int x = 0;
        int y = 0;
        boolean exist = false;
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                if (board[i][j] == R) {
                    exist = true;
                    x = i;
                    y = j;
                }
            }
            if (exist) {
                break;
            }
        }
        if (!exist) {
            return 0;
        }
        int ans = 0;

        // left
        int left = y;
        while (left >= 0) {
            char temp = board[x][left];
            if (temp == P) {
                ans++;
                break;
            } else if (temp == B) {
                break;
            }
            left--;
        }
        // right
        int right = y;
        while (right < colSize) {
            char temp = board[x][right];
            if (temp == P) {
                ans++;
                break;
            } else if (temp == B) {
                break;
            }
            right++;
        }
        // up
        int up = x;
        while (up >= 0){
            char temp = board[up][y];
            if (temp == P) {
                ans++;
                break;
            } else if (temp == B) {
                break;
            }
            up--;
        }
        // down
        int down = x;
        while (down < rowSize){
            char temp = board[down][y];
            if (temp == P) {
                ans++;
                break;
            } else if (temp == B) {
                break;
            }
            down++;
        }
        return ans;
    }

    public static void main(String[] args) {
        AvailableCapturesForRook_0999 a = new AvailableCapturesForRook_0999();
        char[][] t = {
                {'.','.','.','.','.','.','.','.'},
                {'.','.','.','p','.','.','.','.'},
                {'.','.','.','R','.','.','.','p'},
                {'.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.'},
                {'.','.','.','p','.','.','.','.'},
                {'.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.'}};
        System.out.println(a.numRookCaptures(t));
    }
}
