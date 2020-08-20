package gold;

import leet0801to1000.problem0941.ValidMountainArray941;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Brilliant James
 * @date 2020-04-23 16:24
 **/
public class Pro_08_11 {

    public int waysToChange_ring(int n) {
        int[][] dp = new int[4][n + 1];
        int[] allCoins = {1, 5, 10, 25};
        Arrays.fill(dp[0], 1);
        for ( int i = 1; i < 4; i++) {
            int currentCoin = allCoins[i];
            for (int j = 1; j <= n; j++) {
                if (n - currentCoin >= 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - currentCoin];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[3][n];
    }


    public int waysToChange_wrong(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        int[] allCoins = {1, 5, 10, 25};
        for (int i = 1; i <= n; i++) {
            for (int item : allCoins) {
                if (i - item >= 0) {
                    dp[i] = (dp[i] + dp[i - item]) % 1_000_000_007;
                } else {
                    break;
                }
            }
        }
        return dp[n];
    }

    public int waysToChangeWrong1(int n) {
        return 0;
//        return dfs(0, n);
    }

    private int ans = 0;
    private int[] allCoins = {1, 5, 10, 25};

    private void dfs(int index, int temp, int n) {
        if (temp == n) {
            ans++;
//            memory
            return;
        }
        if (temp > n) {
            return ;
        }
        for (int i = index; i < 4; i++) {
            dfs(i, temp + allCoins[i], n);
        }
    }
    private int[] allCoinsNew = {25, 10, 5, 1};
    private Map<String, Integer> memory = new HashMap<>();
    private int dfs_wrong(int index, int tempSum) {
        if (index >= 3)  {
            return 1;
        }
        String key = index + " " + tempSum;
        if (memory.containsKey(key)) {
            return memory.get(key);
        }
        int curCoin = allCoinsNew[index];
        int way = 0;
        for (int i = 0; i * curCoin <= tempSum; i++) {
            int remain = tempSum - i * curCoin;
        }
        memory.put(key, way);
        return way;
    }

    public static void main(String[] args) {
        Pro_08_11 pro = new Pro_08_11();
        int tt = pro.waysToChangeWrong1(10);
        System.out.println(tt);
    }
}
