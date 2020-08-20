package sward;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Brilliant James
 * @date 2020-04-08 04:00
 **/
public class Problem_013 {
    private static final int[][] move = {{1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}};
    boolean[][] visited;
    public int movingCount(int m, int n, int k) {
         visited = new boolean[m][n];
         return dfs(0, 0, m, n, k);
    }

    private int dfs(int m, int n, int M, int N, int k) {
        if (m < 0 && n < 0 && m >= M && n >= N) {
            return 0;
        }
        if (getSum(m, n) > k) {
            return 0;
        }
        if (visited[m][n]) {
            return 0;
        }
        int ans = 0;
        visited[m][n] = true;
        for (int i = 0; i < 4; i++) {
            ans += dfs(m + move[i][0], n + move[i][1], M, N, k);
        }
        return ans + 1;
    }

    public int movingCount_BFS(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        Queue<Cell> queue = new LinkedList<>();
        queue.offer(new Cell(0, 0));
        int ans = 0;
        while (queue.size() > 0) {
            Cell temp = queue.poll();
            if (visited[temp.x][temp.y]) {
                continue;
            }
            visited[temp.x][temp.y] = true;
            if (getSum(temp.x, temp.y) > k) {
                continue;
            }
            ans++;
            if (temp.x + 1 < m && !visited[temp.x + 1][temp.y]) {
                queue.offer(new Cell(temp.x + 1, temp.y));
            }
            if (temp.y + 1 < n && !visited[temp.x][temp.y + 1]) {
                queue.offer(new Cell(temp.x, temp.y + 1));
            }
        }
        return ans;
    }

    private class Cell {
        int x;
        int y;
        Cell(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private int getSum(int m, int n) {
        char[] c1 = (m + "" + n).toCharArray();
        int ans = 0;
        for (char c : c1) {
            ans += c - '0';
        }
        return ans;
    }


}
