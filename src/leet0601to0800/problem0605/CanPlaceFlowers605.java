package leet0601to0800.problem0605;

/**
 * https://leetcode-cn.com/problems/can-place-flowers/
 * 605. 种花问题
 * @author James
 * @date 2019-12-01 16:46
 **/
public class CanPlaceFlowers605 {

    /**
     * 贪心算法
     * @param flowerbed
     * @param n
     * @return
     */
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (flowerbed.length == 1) {
            if (flowerbed[0] == 1) {
                return n == 0;
            } else {
                return n <= 1;
            }
        }
        int count = 0;
        for (int i = 0, len = flowerbed.length; i < len; i++) {
            if ((i == 0 && flowerbed[i + 1] == 0)
                || (i > 0 && flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0)
                || (i == len -1 && flowerbed[i - 1] == 0)) {
                count++;
                flowerbed[i] = 1;
            }
        }
        return count >= n;
    }
}
