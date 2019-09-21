package leet0201to0400.problem0309;

/**
 * @program: myleetcode
 * @description: https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
 * @author: James
 * @create: 2019-05-18 15:59
 **/
public class BestTimeToStockWithCooldown309 {


	/**
	 *
	 */
	public int maxProfit(int[] prices) {
		int len = prices.length;
		if (len == 0) {
			return 0;
		}
		int[][] maxProfit = new int[len][2];
		maxProfit[0][1] = -prices[0];
		boolean isCool = false;
		for (int i = 1; i < len; ++i) {
			if (isCool) {
				maxProfit[i][1] = maxProfit[i - 1][1];
				maxProfit[i][0] = maxProfit[i - 1][0];
				isCool = false;
			} else {
				if ((i < len - 1 && (prices[i] > prices[i + 1])) || i == len - 1) {
					maxProfit[i][0] = Math.max(maxProfit[i - 1][0], maxProfit[i - 1][1] + prices[i]);
				} else {
					maxProfit[i][0] = maxProfit[i - 1][0];
				}
				maxProfit[i][1] = Math.max(maxProfit[i - 1][1], maxProfit[i][0] - prices[i]);
			}
			if (maxProfit[i][0] == (maxProfit[i - 1][1] + prices[i])) {
				isCool=true;
			}
		}
		return Math.max(maxProfit[len - 1][0], maxProfit[len - 1][1]);
	}


	/**
	 * 这个思路不好理解啊，就是说你要用前两天的状态，那个状态肯定不是冷冻期的，来进行状态推导。
	 * @param prices
	 * @return
	 */
	public int maxProfitBetter(int[] prices) {
		int len = prices.length;
		if (len == 0) {
			return 0;
		}
		int[][] maxProfit = new int[len][2];
		maxProfit[0][1] = -prices[0];
		for (int i = 1; i < len; ++i) {
			maxProfit[i][0] = Math.max(maxProfit[i - 1][0], maxProfit[i - 1][1] + prices[i]);
			if (i > 1) {
				maxProfit[i][1] = Math.max(maxProfit[i - 1][1], maxProfit[i - 2][0] - prices[i]);
			} else {
				maxProfit[i][1] = Math.max(maxProfit[i - 1][1], maxProfit[0][0] - prices[i]);
			}
		}
		return Math.max(maxProfit[len - 1][0], maxProfit[len - 1][1]);
	}
}
