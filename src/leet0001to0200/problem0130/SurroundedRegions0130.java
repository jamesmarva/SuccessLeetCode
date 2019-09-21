package leet0001to0200.problem0130;

import java.util.*;

/**
 * @program: SuccessLeetCode
 * @description: https://leetcode-cn.com/problems/surrounded-regions/
 * @author: James
 * @create: 2019-09-11 23:14
 **/
public class SurroundedRegions0130 {

    Map<String, String> fatherMap = new HashMap<String, String>();
    Map<String, Integer> rankMap = new  HashMap<String, Integer>();
    public void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }

        int rowLen = board.length;
        int colLen = board[0].length;
        Set<String> realO = new HashSet<>();
        int[][] four = {{0, 1},
                {0, -1},
                {1, 0},
                {-1, 0}};
        for (int i = 0; i < rowLen; ++i) {
            for (int j = 0; j < colLen; ++j) {
                fatherMap.put(i + "_" + j, i + "_" + j);
                rankMap.put(i + "_" + j, 1);
            }
        }
        for (int i = 0; i < rowLen; ++i) {
            for (int j = 0; j < colLen;++j) {
                String valueString = i+"_"+j;
                if (board[i][j] == 'O') {
                    if (i == 0 || j == 0 || i == rowLen - 1 || j == colLen - 1) {
                        realO.add(valueString);
                    }
                    for (int k = 0; k < 4; ++k) {
                        int newI = i + four[k][0];
                        int newJ = j + four[k][1];
                        if (newI >= 0 && newI < rowLen && newJ >= 0 && newJ < colLen && board[newI][newJ] == 'O') {
                            union(valueString, newI + "_" + newJ);
                        }
                    }
                }
            }
        }
        Set<String> headSet = new HashSet<>();
        for (String item : realO) {
            headSet.add(findHead(item));
        }
        System.out.println(headSet);
        for (int i = 0; i < rowLen; ++i) {
            for (int j = 0; j < colLen; ++j) {
                if (headSet.contains(findHead(i + "_" + j))) {
                    board[i][j] = 'O';
                } else {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private boolean isConnected(String a, String b) {
        return  findHead(a).equals(findHead(b));
    }

    private String findHead(String a) {
        Stack<String> path = new Stack<>();
        while (!a.equals(fatherMap.get(a))) {
            path.push(a);
            a = fatherMap.get(a);
        }
        while (!path.isEmpty()) {
            fatherMap.put(path.pop(), a);
        }
        return a;
    }

    private void union(String a, String b) {
        String aFather = findHead(a);
        String bFather = findHead(b);
        if (aFather.equals(bFather)) {
            return ;
        }
        String big = aFather;
        String small = bFather;
        if (rankMap.get(aFather) < rankMap.get(bFather)) {
            big = bFather;
            small = aFather;
        }
        fatherMap.put(small, big);
        rankMap.put(big, rankMap.get(big) + rankMap.get(small));
        rankMap.remove(small);
    }

    public static void main(String[] args) {
        char[][] test = {{'X','X','X','X','O','O','X','X','O'},
                {'O','O','O','O','X','X','O','O','X'},
                {'X','O','X','O','O','X','X','O','X'},
                {'O','O','X','X','X','O','O','O','O'},
                {'X','O','O','X','X','X','X','X','O'},
                {'O','O','X','O','X','O','X','O','X'},
                {'O','O','O','X','X','O','X','O','X'},
                {'O','O','O','X','O','O','O','X','O'},
                {'O','X','O','O','O','X','O','X','O'}};

        char[][] test1 = {{'X','X','X','X'},
                            {'X','O','O','X'},
                            {'X','X','O','X'},
                            {'X','O','X','X'}};

        char[][] test2 ={{'X','X','O','X','X','X'},
                        {'X','X','X','O','O','X'},
                        {'O','O','X','O','O','X'},
                        {'O','O','X','O','X','O'},
                        {'X','O','O','O','O','O'},
                        {'O','X','X','O','O','O'}};

        SurroundedRegions0130 surroundedRegions0130 = new SurroundedRegions0130();
        surroundedRegions0130.solve(test2);
    }
}
