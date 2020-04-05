package sward;

/**
 * https://leetcode-cn.com/problems/gu-piao-de-zui-da-li-run-lcof/
 * 面试题63. 股票的最大利润
 * @author Brilliant James
 * @date 2020-03-31 02:08
 **/
public class Problem_063 {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int min = prices[0];
        int ans = 0;
        for (int i = 1, len = prices.length; i < len; i++) {
            if (prices[i] > min) {
                ans = Math.max(ans, prices[i] - min);
            } else {
                min = prices[i];
            }
        }
        return ans;
    }
}
