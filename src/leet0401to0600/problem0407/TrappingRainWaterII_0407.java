package leet0401to0600.problem0407;

import java.security.cert.Certificate;
import java.util.PriorityQueue;

/**
 * https://leetcode-cn.com/problems/trapping-rain-water-ii/solution/java-you-xian-dui-lie-bfs-by-jachindu2018/
 * https://www.youtube.com/watch?v=cJayBq38VYw
 *
 * 先将最外围四周看作第一层围栏，矩阵的元素看作节点，将其添加到优先队列中；
 * 依次出队，并进行bfs，过程中维护一个“当前边界最小值”，该值为所有出队的高度中的最大值；
 * 在bfs过程中，即访问出队节点的邻居时，若邻居高度小于“当前边界最小值”，则该邻居节点可储水(“当前边界最小值” - 邻居节点高度)
 * 需要一个visited矩阵，记录bfs遍历过的节点
 *
 * 作者：JachinDu2018
 * 链接：https://leetcode-cn.com/problems/trapping-rain-water-ii/solution/java-you-xian-dui-lie-bfs-by-jachindu2018/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * @author Brilliant James
 * @date 2020-04-05 05:17
 **/
public class TrappingRainWaterII_0407 {

    private final static int[][] move = {{1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}};
    public int trapRainWater(int[][] heightMap) {
        if (heightMap == null || heightMap.length <= 2 || heightMap[0].length <= 2) {
            return 0;
        }
        int rowSize = heightMap.length;
        int colSize = heightMap[0].length;
        boolean[][] visited = new boolean[rowSize][colSize];
        PriorityQueue<Cell> q = new PriorityQueue<>((o1, o2) -> o1.h - o2.h);
        for (int i = 0; i < rowSize; i++) {
            visited[i][0] = visited[i][colSize - 1] = true;
            q.offer(new Cell(heightMap[i][0], i, 0));
            q.offer(new Cell(heightMap[i][colSize - 1], i, colSize - 1));
        }
        for (int i = 1; i < colSize - 1; i++) {
            visited[0][i] = visited[rowSize - 1][i] = true;
            q.offer(new Cell(heightMap[0][i], 0, i));
            q.offer(new Cell(heightMap[rowSize - 1][i], rowSize - 1, i));
        }
        int ans = 0;
        while (q.size() > 0) {
            Cell temp = q.poll();
            for (int[] item : move) {
                int newRow = temp.row + item[0];
                int newCol = temp.col + item[1];
                if (newRow >= 0 && newRow < rowSize && newCol >= 0 && newCol < colSize && !visited[newRow][newCol]) {
                    ans += Math.max(0, temp.h - heightMap[newRow][newCol]);
                    visited[newRow][newCol] = true;
                    q.offer(new Cell(Math.max(temp.h, heightMap[newRow][newCol]), newRow, newCol));
                }
            }
        }
        return ans;

    }

    private class Cell {
        int h;
        int row;
        int col;
        public Cell(int h, int row, int col) {
            this.h = h;
            this.row = row;
            this.col = col;
        }
    }
}
