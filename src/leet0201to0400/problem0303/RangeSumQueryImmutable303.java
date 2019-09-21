package leet0201to0400.problem0303;

import java.util.ArrayList;
import java.util.Map;

/**
 * @program: SuccessLeetCode
 * @description: https://leetcode-cn.com/problems/range-sum-query-immutable/
 * @author: James
 * @create: 2019-09-20 07:52
 **/
public class RangeSumQueryImmutable303 {

    /**
     * 无语了，这个空间生下来了，的那是时间超时了鄂
     */
    ArrayList<ArrayList<Integer>> res = null;
//    public RangeSumQueryImmutable3031(int[] nums) {
//        if (nums == null || nums.length == 0) {
//            return;
//        }
//        int len = nums.length;
//        res = new ArrayList<ArrayList<Integer>>(len);
//        for (int i = 0; i < len; ++i) {
//            ArrayList<Integer> temp = new ArrayList<>();
//            for (int j = i; j < len; ++j) {
//                if (j == i) {
//                    temp.add(nums[j]);
//                } else {
//                    temp.add(temp.get(temp.size() - 1) + nums[j]);
//                }
//            }
//            res.add(temp);
//        }
////        Pair.create()
//    }

    Map<String, Integer> map;
//    private Map<Pair<Integer, Integer>, Integer> map = new HashMap<>();

    /**
     * 按照解题的思路来说，这个应该是可以跑通的额。。。
     * @param nums
     */
//    public RangeSumQueryImmutable303(int[] nums) {
//        if (nums == null || nums.length == 0) {
//            return;
//        }
//        int len = nums.length;
//        map = new HashMap<>(len);
//        for (int i = 0; i < len; ++i) {
//            int sum = 0;
//            for (int j = i; j < len; ++j) {
//                sum += nums[j];
//                map.put(i + " " + j, sum);
//            }
//        }
//    }

    private int[] dp;
    public RangeSumQueryImmutable303(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int len = nums.length;
        dp = new int[len + 1];
        for (int i = 0; i < len; ++i) {
            dp[i + 1] = dp[i] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        return dp[j+1] - dp[i];
    }
}
