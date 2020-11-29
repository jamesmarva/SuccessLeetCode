package leet;

/**
 * https://leetcode-cn.com/contest/weekly-contest-217/problems/richest-customer-wealth/
 *
 *
 * @author 王涵威
 * @date 20.11.29 10:30
 */
public class Pro5613 {

    public int maximumWealth(int[][] accounts) {
        if (accounts == null || accounts.length == 0 || accounts[0].length == 0) {
            return 0;
        }
        int result = 0;
        for (int r = 0; r < accounts.length; r++) {
            int tmpMax = 0;
            for (int c = 0; c < accounts[r].length; c++) {
                tmpMax += accounts[r][c];
            }
            result = Math.max(result, tmpMax);
        }
        return result;
    }
}
