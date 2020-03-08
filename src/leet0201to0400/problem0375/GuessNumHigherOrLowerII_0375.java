package leet0201to0400.problem0375;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/guess-number-higher-or-lower-ii/
 * @author Brilliant James
 * @date 2020-03-08 03:08
 **/
public class GuessNumHigherOrLowerII_0375 {


    /**
     * 在最坏的情况下，至少需要多少的钱才能完成？
     * 如果 第一 i 那么后面都是 min(res, max
     * @param n
     * @return
     */
    public int getMoneyAmount(int n) {
//        if (n == 1) {
//            return 0;
//        }
//        int[] dp = new int[n + 1];
//        int res = Integer.MAX_VALUE;
//        for (int i = 2; i <= n; ++i) {
//            int temp = 0;
//            for (int j = i; j < 2; ++i) {
//                temp = Math.max(dp[i], )
//            }
//            dp[i] = Math.min(res, Math.max(dp[i - 1], dp[n - i]) + i);
//        }
//        return res;
        return getNum(1, n);
    }
    private Map<String, Integer> map = new HashMap<>();
    public int getNum(int low, int high ) {
        if (low > high) {
            return 0;
        }
        String key = low + " " + high;
        if (map.containsKey(key)) {
            return map.get(key);
        }
        int res = Integer.MAX_VALUE;
        for (int i = low; i <= high; i++) {
            int tmp = i + Math.max(getNum(low, i - 1), getNum(i + 1, high));
            res = Math.min(res, tmp);
        }
        map.put(key, res);
        return res;
    }



}
