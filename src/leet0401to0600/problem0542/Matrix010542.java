package leet0401to0600.problem0542;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author James
 * @program SuccessLeetCode
 * @description https://leetcode-cn.com/problems/01-matrix/
 * @date 2019-11-01 15:10
 **/
public class Matrix010542 {

    /**
     * 广度优先搜索的思想：
     * 这个重点就在与不能用正向思维，用位置上1的点去进行广度优先搜索，以为那样每次有限遍历只能得到一个为1的点答案。
     * 但是如果是从0的点开始，那么每次起码可以取人0的周围的几个点的值。
     * 先把为0的点给放入队列，然后把没有遍历的再放入队列中，如何确认是否需要放入队列？就是原来被设置成MAX的那些点。
     * 条件：distance[newRowIndex][newColumnIndex] > distance[temp[0]][temp[1]] + 1
     * 这是个很关键的判断，就是这个用来判断是否需要放入队列中。因为周边的曾进入过队列的点，肯定被设置过只比当前的点大1。
     * distance[newRowIndex][newColumnIndex] = distance[temp[0]][temp[1]] + 1
     * 所以设置完值，仍然吧点给放入队列中，下一次继续遍历。
     *
     *
     * 0 1 1 1
     * 0 0 0 1
     *
     * 0 m m m
     * 0 0 0 m
     *
     */
    public int[][] updateMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0][0];
        }
        int rowSize = matrix.length;
        int columnSize = matrix[0].length;
        int[][] distance = new int[rowSize][columnSize];
        for (int i = rowSize - 1; i >= 0; --i) {
            Arrays.fill(distance[i], Integer.MAX_VALUE);
        }
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < rowSize; ++i) {
            for (int j = 0; j < columnSize; ++j) {
                if (matrix[i][j] == 0) {
                    distance[i][j] = 0;
                    int[] temp = {i, j};
                    queue.offer(temp);
                }
            }
        }
        int[][] move = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (queue.size() > 0) {
            int[] temp = queue.poll();
            for (int i = 0; i < 4; ++i) {
                int newRowIndex = temp[0] + move[i][0];
                int newColumnIndex =temp[1] + move[i][1];
                if (newRowIndex >= 0 && newRowIndex < rowSize && newColumnIndex >= 0 && newColumnIndex < columnSize) {
                    if (matrix[newRowIndex][newColumnIndex] == 1
                            && distance[newRowIndex][newColumnIndex] > distance[temp[0]][temp[1]] + 1) {
                        distance[newRowIndex][newColumnIndex] = distance[temp[0]][temp[1]] + 1;
                        int[] tempNode = {newRowIndex, newColumnIndex};
                        queue.offer(tempNode);
                    }
                }
            }
        }
        return distance;
    }

    /**
     *
     * 动态规划
     * 从左上（↖）开始遍历。逐行遍历
     * 从 右下（↘）开始遍历，逐行遍历
     */
    public int[][] updateMatrix1(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0][0];
        }
        int rowSize = matrix.length;
        int columnSize = matrix[0].length;
        int[][] distance = new int[rowSize][columnSize];
        for (int i = rowSize - 1; i >= 0; --i) {
            Arrays.fill(distance[i], Integer.MAX_VALUE);
        }
        for (int i = 0; i < rowSize; ++i) {
            for (int j = 0; j < columnSize; ++j) {
                if (matrix[i][j] == 0) {
                    distance[i][j] = 0;
                } else {
                    if ( i > 0) {
                        distance[i][j] = Math.min(distance[i][j], distance[i-1][j] + 1);
                    }
                    if (j > 0) {
                        distance[i][j] = Math.min(distance[i][j], distance[i][j-1] + 1);
                    }
                }
            }
        }

        for (int i = rowSize - 1; i >= 0; --i) {
            for (int j = columnSize - 1; j >= 0; --j) {
                if (matrix[i][j] == 1) {
                    if ( i < rowSize - 1) {
                        distance[i][j] = Math.min(distance[i][j], distance[i+1][j] + 1);
                    }
                    if (j < columnSize - 1) {
                        distance[i][j] = Math.min(distance[i][j], distance[i][j+1] + 1);
                    }
                }
            }
        }
        return distance;
    }

    public static void main(String[] args) {

    }
}
