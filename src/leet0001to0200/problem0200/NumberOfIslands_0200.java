package leet0001to0200.problem0200;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Stack;

/**
 * @author James
 * @date 2019-11-26 22:58
 **/
public class NumberOfIslands_0200 {


    class Node {
        private int x;
        private int y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    HashMap<String, String> father = new HashMap<>();
    HashMap<String, Integer> rankMap = new HashMap<>();

    public int numIslands(char[][] grid) {
        int lenY = grid.length;
        int res = 0;
        if (lenY == 0){
            return res;
        }
        int lenX = grid[0].length;
        HashSet<String> set = new LinkedHashSet<>();
        for (int i = 0; i < lenY; ++i) {
            for (int j = 0; j < lenX; ++j) {
                if (grid[i][j] == '1') {
                    String temp  = i + "#" + j;
                    father.put(temp, temp);
                    set.add(temp);
                    rankMap.put(temp , 1);
                }
            }
        }

        for (String item : set) {
            String tempFather = father.get(item);
            String[] tempArr = tempFather.split("#");
            int y = Integer.parseInt(tempArr[0]);
            int x = Integer.parseInt(tempArr[1]);
            if (y > 0) {
                String tempPoint = (y - 1) + "#" + x;
                if (set.contains(tempPoint)) {
                    union (tempPoint, tempFather);
                }
            }
            if (x > 0) {
                String tempPoint = y + "#" + (x - 1);
                if (set.contains(tempPoint)) {
                    union(tempPoint, tempFather);
                }
            }
        }
        return rankMap.size();
    }

    public String findHead(String node) {
        Stack<String> path = new Stack<>();
        while (!node.equals(father.get(node))) {
            node = father.get(node);
        }
        while (!path.isEmpty()) {
            father.put(path.pop(), node);
        }
        return node;
    }

    public void union(String node1, String node2) {
        String father1 = findHead(node1);
        String father2 = findHead(node2);
        if  (!father1.equals(father2)) {
            String big = father1;
            if (rankMap.get(father1) < rankMap.get(father2)) {
                big = father2;
            }

            String small = father2;
            if (big.equals(father2)) {
                small = father1;
            }
            father.put(small, big);
            rankMap.put(big, rankMap.get(big) + rankMap.get(small));
            rankMap.remove(small);
        }
    }

    private char[][] gridGlobal;

    /**
     * 深度优先搜索
     * @param grid
     * @return
     */
    public int numIslands_1(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length ==0) {
            return 0;
        }
        int rowSize = grid.length;
        int columnSize = grid[0].length;
        gridGlobal = grid;
        int count = 0;
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < columnSize; j++) {
                if (gridGlobal[i][j] == '1') {
                    count++;
                    dfs(i, j, rowSize, columnSize);
                }

            }
        }
        return count;
    }

    private void dfs(int rowIndex, int columnIndex, int rowSize, int columnSize) {
        if (rowIndex < 0 || rowIndex >= rowSize || columnIndex < 0 || columnIndex >= columnSize
                || gridGlobal[rowIndex][columnIndex] == '0') {
            return;
        }
        gridGlobal[rowIndex][columnIndex] = '0';
        dfs(rowIndex + 1, columnIndex, rowSize, columnSize);
        dfs(rowIndex, columnIndex + 1, rowSize, columnSize);
        dfs(rowIndex - 1, columnIndex, rowSize, columnSize);
        dfs(rowIndex, columnIndex - 1, rowSize, columnSize);
    }

    public static void main(String[] args) {
        char[][] test= {{'1','0','1','1','1'},
                {'1','0','1','0','1'},
                {'1','1','1','0','1'}};
//        NumberOfIslands200 numberOfIslands200 = new  NumberOfIslands200();
//        numberOfIslands200.numIslands(test);
    }
}
