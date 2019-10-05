package leet0801to1000.problem0907;

import java.util.Stack;

/**
 * @author James
 * @program SuccessLeetCode
 * @description https://leetcode-cn.com/problems/sum-of-subarray-minimums/
 * @date 2019-10-05 16:38
 **/
public class SumOfSubMin0907 {

    public static int sumSubarrayMins(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int ans = 0;
        for (int i = 0, len = A.length; i < len; ++i) {
            int minTemp = A[i];
            for (int j = i; j < len; ++j) {
                minTemp = Math.min(minTemp, A[j]);
                ans = (ans + minTemp) % ((int) Math.pow(10, 9) + 7);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] test = {85};
        System.out.println(sumSubarrayMins(test));
        System.out.println(Math.pow(10, 9) + 7);
    }
}
