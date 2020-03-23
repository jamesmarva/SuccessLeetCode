package leet0201to0400.problem0398;

import java.util.Random;

/**
 * https://leetcode-cn.com/problems/random-pick-index/
 * 398. 随机数索引
 * 蓄水池抽样
 * @author Brilliant James
 * @date 2020-03-19 14:41
 **/
public class RandomPickIndex_0398_I {

    private int[] arr;

    private Random random;
    public RandomPickIndex_0398_I(int[] nums) {
        arr = nums;
        random = new Random();
    }

    /** Returns a random node's value. */
    public int pick(int target) {
        int count = 0;
        int res = 0;
        for (int i = 0, len = arr.length; i < len; ++i) {
            if (arr[i] == target) {
                if (random.nextInt(++count) == 0) {
                    res = i;
                }
            }
        }
        return res;
    }
}
