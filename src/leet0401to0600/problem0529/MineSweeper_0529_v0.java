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

        Queue<Pair> queue = new ArrayDeque<>();
        Set<Pair> visited = new HashSet<>();
        Pair begin = new Pair(row, col);
        queue.offer(begin);
        visited.add(begin);
        while (queue.size() > 0) {
            Pair tmp = queue.poll();
            int rowIdx = 0;
            int colIdx = 0;
            int mineCount = 0;
            List<Pair> tmpList = new ArrayList<Pair>();
            for (int i = MOVE.length - 1; i >= 0; i--) {
                rowIdx = tmp.row + MOVE[i][0];
                colIdx = tmp.col + MOVE[i][1];
                if (rowIdx < 0 || rowIdx >= rowLen || colIdx < 0 || colIdx >= colLen) {
                    continue;
                }
                if (board[rowIdx][colIdx] == 'M') {
                    mineCount++;
                } else if (board[rowIdx][colIdx] == 'E') {
                    Pair newPoint = new Pair(rowIdx, colIdx);
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


    private class Pair {
        public int row;
        public int col;

        public Pair(int row, int col) {
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
            if (o instanceof Pair) {
                Pair other = (Pair) o;
                return other.toString().equals(this.toString());
            }
            return false;
        }
    }
}
