package leet0401to0600.problem0529;

import java.awt.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

/**
 * <功能描述><br>
 *
 * @author Brilliant James Jamesmarva1993@gmail.com 2020-08-20 02:21
 **/
public class MineSweeper_0529_v0 {

    private final static int[][] move = {
            {1, 0}, {-1, 0}, {0, 1}, {0, -1},
            {1, 1}, {1, -1}, {-1, -1}, {-1, 1}};


    public char[][] updateBoard(char[][] board, int[] click) {
        if (board.length == 0 || board[0].length == 0) {
            return board;
        }

        int rowLen = board.length;
        int colLen = board[0].length;
        int row = click[0];
        int col = click[1];

        if (board[row][col] == 'M') {
            board[row][col] = 'X';
        }

        Queue<Point> queue = new ArrayDeque<>();
        queue.offer(new Point(row, col));
        while (queue.size() > 0) {
            Point tmp = queue.poll();
            int rowIdx =tmp.row;
            int colIdx = tmp.col;
            int mineCount = 0;
            for (int i = move.length; i > 0; i--) {
                if (rowIdx  + move[i][0]
            }
        }
    }


    private class Point {
        public int row;
        public int col;

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }


}
