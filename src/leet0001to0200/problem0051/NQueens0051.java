package leet0001to0200.problem0051;

import java.util.LinkedList;
import java.util.List;

/**
 * @author James
 */
public class NQueens0051 {


    class Solution {

        List<List<String>> resultList = new LinkedList<List<String>>();
        public List<List<String>> solveNQueens(int n) {
            int[] res = new int[n];
            getQueen(0, n, res);
            return resultList;
        }

        public void getQueen(int row, int length, int[] array) {
            if (row == length) {
                setList(array);
            }
            for (int i = 0; i < length; i++) {
                if (!canFight(array, row, i)) {
                    array[row] = i;
                    getQueen(row + 1, length, array);
                }
            }
        }

        public boolean canFight(int[] array, int row, int column) {
            for (int i = row - 1; i >= 0; i--) {
                if (array[i] == column) { // 是否同列
                    return true;
                }
                if (Math.abs(row - i) == Math.abs(column - array[i])) {//是否在一条斜线上
                    return true;
                }
            }
            return false;
        }

        public void setList(int[] array) {
            int len = array.length;
            List<String> list = new LinkedList<>();
            for (int i = 0; i < len; i++) {
                String temp = "";
                for (int j = 0; j < len; j++) {
                    if (j == array[i]) {
                        temp += "Q";
                    } else {
                        temp += ".";
                    }
                }
                list.add(temp);
            }
            resultList.add(list);
        }
    }


    public void test() {
        int[] queensArray = new int[8];
    }

    private void printQueens(int[] result) { // 打印出一个二维矩阵
        for (int row = 0; row < 8; ++row) {
            for (int column = 0; column < 8; ++column) {
                if (result[row] == column){
                    System.out.print("Q ");

                } else {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    static  int countQueen = 0;
    public int[] getQueens(int row, int[] queensArray) {
        if (row == 8) {
            printQueens(queensArray);
            countQueen++;
            System.out.println(countQueen);
            return queensArray;
        }
        for (int i = 0; i < 8; i++) {
            if (!canFight(queensArray, row, i, 8)) {
                queensArray[row] = i;
                getQueens(row + 1, queensArray);
            }
        }
        return queensArray;
    }

    //有个更加便捷的判断方法，所在的点的行互减得绝对值等于列互减的绝对值
    public boolean canFight(int[] array, int row, int column, int length) {
        int leftUp = column - 1;
        int rightUp = column + 1;
        for (int i = row - 1; i >= 0; i--) {
            if (array[i] == column) { // 是否同列
                return true;
            }
//            if (leftUp >= 0 && array[i] == leftUp ) { // 是否在左上的斜线
//                return true;
//            }
//            if (rightUp < length && array[i] == rightUp ) { // 是否在右上的斜线
//                return true;
//            }
//
//            leftUp --;
//            rightUp ++;
            if (Math.abs(row - i) == Math.abs(column - array[i])) {
                return true;
            }
        }
        return false;
    }

    class GeekTime {

        int[] result = new int[8];// 全局或成员变量, 下标表示行, 值表示 queen 存储在哪一列
        int count = 0;

        public void cal8queens(int row) { // 调用方式：cal8queens(0);
            if (row == 8) { // 8 个棋子都放置好了，打印结果
                printQueens(result);
                count++;
                System.out.println(count);
                return; // 8 行棋子都放好了，已经没法再往下递归了，所以就 return
            }

            for (int column = 0; column < 8; ++column) { // 每一行都有 8 中放法
                if (isOk(row, column)) { // 有些放法不满足要求
                    result[row] = column; // 第 row 行的棋子放到了 column 列
                    cal8queens(row+1); // 考察下一行
                }
            }
        }

        private boolean isOk(int row, int column) {// 判断 row 行 column 列放置是否合适
            int leftup = column - 1, rightup = column + 1;
            for (int i = row-1; i >= 0; --i) { // 逐行往上考察每一行
                if (result[i] == column) {
                    return false; // 第 i 行的 column 列有棋子吗？
                }

                if (leftup >= 0) { // 考察左上对角线：第 i 行 leftup 列有棋子吗？
                    if (result[i] == leftup)
                        return false;
                }
                if (rightup < 8) { // 考察右上对角线：第 i 行 rightup 列有棋子吗？
                    if (result[i] == rightup)
                        return false;
                }
                --leftup; ++rightup;
            }
            return true;
        }

        private void printQueens(int[] result) { // 打印出一个二维矩阵
            for (int row = 0; row < 8; ++row) {
                for (int column = 0; column < 8; ++column) {
                    if (result[row] == column) System.out.print("Q ");
                    else System.out.print("* ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
//        NQueens51 nQueens51 = new NQueens51();
//        NQueens51.GeekTime geekTime = new NQueens51().new GeekTime();
//        geekTime.cal8queens(0);
        NQueens0051 nQueens51 = new NQueens0051();
        nQueens51.getQueens(0, new int[8]);
    }

}
