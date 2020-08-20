package leet0401to0600.problem0529;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/minesweeper/
 * 529. 扫雷游戏
 * @author Brilliant James Jamesmarva1993@gmail.com 2020-08-20 02:21
 **/
public class MineSweeper_0529_v0 {

    private final static int[][] MOVE = {
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
            return board;
        }

        Queue<Point> queue = new ArrayDeque<>();
        Set<Point> visited = new HashSet<>();
        Point begin = new Point(row, col);
        queue.offer(begin);
        visited.add(begin);
        while (queue.size() > 0) {
            Point tmp = queue.poll();
            int rowIdx = 0;
            int colIdx = 0;
            int mineCount = 0;
            List<Point> tmpList = new ArrayList<>();
            for (int i = MOVE.length - 1; i >= 0; i--) {
                rowIdx = tmp.row + MOVE[i][0];
                colIdx = tmp.col + MOVE[i][1];
                if (rowIdx < 0 || rowIdx >= rowLen || colIdx < 0 || colIdx >= colLen) {
                    continue;
                }
                if (board[rowIdx][colIdx] == 'M') {
                    mineCount++;
                } else if (board[rowIdx][colIdx] == 'E') {
                    Point newPoint = new Point(rowIdx, colIdx);
                    if (!visited.contains(newPoint)) {
                        tmpList.add(newPoint);
                    }
                }
            }
            if (mineCount > 0) {
                board[tmp.row][tmp.col] = (char) ('0' + mineCount);
            } else {
                board[tmp.row][tmp.col] = 'B';
                queue.addAll(tmpList);
                visited.addAll(tmpList);
                tmpList = null;
            }
        }
        return board;
    }


    private class Point {
        public int row;
        public int col;

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public String toString() {
            return row + "_" + col;
        }

        @Override
        public int hashCode() {
            return toString().hashCode();
        }

        @Override
        public boolean equals(Object o) {
            if (o == null) {
                return false;
            }
            if (o instanceof Point) {
                Point other = (Point) o;
                return other.toString().equals(this.toString());
            }
            return false;
        }
    }


    public static void main(String[] args) {
        char[][] board = {
                {'E','E','E','E','E'},
                {'E','E','M','E','E'},
                {'E','E','E','E','E'},
                {'E','E','E','E','E'}};

        MineSweeper_0529_v0 v0 = new MineSweeper_0529_v0();
        char[][] boardBack = v0.updateBoard(board, new int[]{3, 0});
        for (int i = 0, len = boardBack.length; i < len; i++) {
            System.out.println(Arrays.toString(boardBack[i]));
        }

    }
}
