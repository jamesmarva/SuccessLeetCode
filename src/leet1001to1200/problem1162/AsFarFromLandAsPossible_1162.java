package leet1001to1200.problem1162;

import java.util.*;

/**
 * @author Brilliant James
 * @date 2020-03-29 02:10
 **/
public class AsFarFromLandAsPossible_1162 {

    private final static int[][] MOVE = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int maxDistance(int[][] grid) {
        HashSet<String> visited = new HashSet<>();
        int rowSize = grid.length;
        int colSize = grid[0].length;
        int ans = -1;
        Queue<Pair> queue = new LinkedList<>();
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                if (grid[i][j] != 0) {
                    continue;
                }
                visited.clear();
                queue.clear();
                queue.offer(new Pair(i, j));
                String pos = i + " " + j;
                visited.add(pos);
                while (queue.size() > 0) {
                    Pair temp = queue.poll();
                    if (grid[temp.row][temp.col] == 1) {
                        ans = Math.max(ans, Math.abs(i - temp.row) + Math.abs(j - temp.col));
                        break;
                    } else {
                        for (int[] item : MOVE) {
                            int newI = temp.row + item[0];
                            int newJ = temp.col + item[1];
                            if (newI >= 0 && newJ >= 0 && newI < rowSize && newJ < colSize
                                    && visited.add(newI + " " + newJ)) {
                                queue.offer(new Pair(newI, newJ));
                            }
                        }
                    }
                }
            }
        }
        return ans;
    }

    private class Pair {
        public int row;
        public int col;
        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}
