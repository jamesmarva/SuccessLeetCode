package leet.lcp;

/**
 * @author Brilliant James
 * @date 2020-04-18 15:59
 **/
public class Pro_001 {

    public int minCount(int[] coins) {
        if (coins == null || coins.length == 0) {
            return 0;
        }
        int ans = 0;
        for (int i = 0, len = coins.length; i < len; i ++) {
            if (coins[i] % 2 != 0) {
                ans += coins[i] / 2  + 1;
            } else {
                ans += coins[i] / 2;
            }
        }
        return ans;
    }
}
