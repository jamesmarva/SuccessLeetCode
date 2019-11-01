package leet0801to1000.problem0934;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/shortest-bridge/
 * @author James
 * @date 2019-11-01 10:10
 **/
public class ShortestBridge0934 {


    /**
     * 先深度，加上双向广搜
     * 执行用时 :38 ms, 在所有 java 提交中击败了54.17%的用户
     * 内存消耗 :40.9 MB, 在所有 java 提交中击败了96.15%的用户
     */
    private int[][] move = {{1, 0},{-1, 0},{0, 1},{0, -1}};
    public int shortestBridge(int[][] A) {
        if (A == null || A.length == 0 || A[0].length == 0) {
            return 0;
        }
        int rowSize = A.length;
        int columnSize = A[0].length;
        firstLoop(rowSize, columnSize, A);
        HashSet<BridgeNode> positive = new HashSet<>();
        HashSet<BridgeNode> negative = new HashSet<>();
        HashSet<BridgeNode> tempNewSet = new HashSet<>();
        for (int i = 0; i < rowSize; ++i) {
            for (int j = 0; j < columnSize; ++j) {
                if (A[i][j] == -1) {
                    positive.add(new BridgeNode(i, j));
                } else if (A[i][j] == 1) {
                    negative.add(new BridgeNode(i, j));
                }
            }
        }
        int step = 0;
        while (positive.size() > 0 && negative.size() > 0) {
            if (positive.size() > negative.size()) {
                HashSet<BridgeNode> temp = new HashSet<>(positive);
                positive = new HashSet<>(negative);
                negative = temp;
            }
            for (BridgeNode item : positive) {
                int oldValue = A[item.row][item.column];
                for (int i = 0; i < 4; ++i) {
                    int newRowIndex = item.row + move[i][0];
                    int newColumnIndex = item.column + move[i][1];
                    if (newRowIndex < rowSize && newColumnIndex < columnSize && newRowIndex >= 0 && newColumnIndex >= 0) {
                        if (A[newRowIndex][newColumnIndex] == 0) {
                            A[newRowIndex][newColumnIndex] = oldValue;
                            tempNewSet.add(new BridgeNode(newRowIndex, newColumnIndex));
                        } else if (A[newRowIndex][newColumnIndex] == -oldValue) {
                            return step;
                        } else if  (A[newRowIndex][newColumnIndex] == oldValue) {
                            continue;
                        }
                    }
                }
            }
            positive = new HashSet<>(tempNewSet);
            tempNewSet.clear();
            step++;
        }
        return 0;

    }

    private void dfs(int rowIndex, int columnIndex, int rowSize, int columnSize, int[][] arr) {
        if (rowIndex >= rowSize || columnIndex >= columnSize || rowIndex < 0 || columnIndex < 0
                || arr[rowIndex][columnIndex] != 1) {
            return;
        }
        arr[rowIndex][columnIndex] = -1;
        dfs(rowIndex + 1, columnIndex, rowSize, columnSize, arr);
        dfs(rowIndex - 1, columnIndex, rowSize, columnSize, arr);
        dfs(rowIndex, columnIndex + 1, rowSize, columnSize, arr);
        dfs(rowIndex, columnIndex - 1, rowSize, columnSize, arr);
    }
    public void firstLoop(int rowSize, int columnSize, int[][] arr) {
        for (int i = 0; i < rowSize; ++i) {
            for (int j = 0; j < columnSize; ++j) {
                if (arr[i][j] == 1) {
                    dfs(i, j, rowSize, columnSize, arr);
                    return;
                }
            }
        }
    }

    public class BridgeNode {
        int row;
        int column;
        public BridgeNode(int row, int column) {
            this.row = row;
            this.column = column;
        }

        @Override
        public boolean equals(Object anObject) {
            if (this == anObject) {
                return true;
            }
            if (anObject instanceof BridgeNode) {
                BridgeNode a = (BridgeNode) anObject;
                return this.row == a.row && this.column == a.column;
            }
            return false;
        }

        @Override
        public int hashCode() {
            return (row + " " + column).hashCode();
        }
    }


    /**
     * 官方题解
     * @param A
     * @return
     */
    public int shortestBridge1(int[][] A) {
        int R = A.length, C = A[0].length;
        int[][] colors = getComponents(A);

        Queue<Node> queue = new LinkedList<>();
        Set<Integer> target = new HashSet<>();

        for (int r = 0; r < R; ++r) {
            for (int c = 0; c < C; ++c) {
                if (colors[r][c] == 1) {
                    queue.add(new Node(r, c, 0));
                } else if (colors[r][c] == 2) {
                    target.add(r * C + c);
                }
            }
        }


        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (target.contains(node.r * C + node.c)) {
                return node.depth - 1;
            }

            for (int nei: neighbors(A, node.r, node.c)) {
                int nr = nei / C, nc = nei % C;
                if (colors[nr][nc] != 1) {
                    queue.add(new Node(nr, nc, node.depth + 1));
                    colors[nr][nc] = 1;
                }
            }
        }

        throw null;
    }

    public int[][] getComponents(int[][] A) {
        int R = A.length, C = A[0].length;
        int[][] colors = new int[R][C];
        int t = 0;

        for (int r0 = 0; r0 < R; ++r0) {
            for (int c0 = 0; c0 < C; ++c0) {
                if (colors[r0][c0] == 0 && A[r0][c0] == 1) {
                    // Start dfs
                    Stack<Integer> stack = new Stack();
                    stack.push(r0 * C + c0);
                    colors[r0][c0] = ++t;

                    while (!stack.isEmpty()) {
                        int node = stack.pop();
                        int r = node / C, c = node % C;
                        for (int nei: neighbors(A, r, c)) {
                            int nr = nei / C, nc = nei % C;
                            if (A[nr][nc] == 1 && colors[nr][nc] == 0) {
                                colors[nr][nc] = t;
                                stack.push(nr * C + nc);
                            }
                        }
                    }
                }
            }
        }
        return colors;
    }

    public List<Integer> neighbors(int[][] A, int r, int c) {
        int R = A.length, C = A[0].length;
        List<Integer> ans = new ArrayList();
        if (0 <= r-1) {
            ans.add((r - 1) * R + c);
        }
        if (0 <= c-1) {
            ans.add(r * R + (c - 1));
        }
        if (r+1 < R) {
            ans.add((r + 1) * R + c);
        }
        if (c+1 < C) {
            ans.add(r * R + (c + 1));
        }
        return ans;
    }


    class Node {
        int r, c, depth;
        Node(int r, int c, int d) {
            this.r = r;
            this.c = c;
            depth = d;
        }
    }


    public static void main(String[] args) {
        int[][] test = {{0, 1}, {1, 0}};
        ShortestBridge0934 shortestBridge0934 = new ShortestBridge0934();
        shortestBridge0934.shortestBridge(test);
    }

}
