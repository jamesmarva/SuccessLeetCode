package leet0801to1000.problem0907;

import java.util.ArrayList;
import java.util.LinkedList;
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


    /**
     * 比如有个元素有左边有3个元素连续比它大，右边有连续3个元素比他大，那么就有多少子数组是包含这个元素的，这个元素就要出现几次。
     * 问题是到底出现几次, 出现了了: (3+1)*(3+1)
     *
     * @param A
     * @return
     */
    public static int sumSubarrayMinsNew(int[] A) {
        final int MOD = 1_000_000_000 + 7;
        int n = A.length;
        long ans = 0;
        for (int i = 0; i < n; i++) {
            int left= 0, right = 0;
            // 记录左边连续的，大于等于当前元素的元素的个数。
            for (int j = i - 1; j >= 0; j--) {
                if (A[j] >= A[i]) {
                    left++;
                } else {
                    break;
                }
            }
            //找右边的 连续的 大于当前元素的元素的个数
            for (int j = i + 1; j < n; j++) {
                if (A[j] > A[i]) {
                    right++;
                } else {
                    break;
                }
            }
            long temp = A[i] * (right + 1) * (1 + left);
            temp %= MOD;
            ans += temp;
            ans %= MOD;
        }
        ans %= MOD;
        return (int) ans;
    }


    public static int sumSubarrayMinsNewStack(int[] A) {
        final int MOD = 1_000_000_000 + 7;
        Stack<Integer> stack = new Stack<>();
        int len = A.length;
        int[] next = new int[len];
        int[] pre = new int[len];
//        找左边第一个比i小的元素的位置,维护一个单调递减栈，这样存
        for (int i = 0; i < len; ++i) {
//            单调递减栈
            if (stack.isEmpty()) {
                pre[i] = 0;
//           第一个小于i的点
            } else if (A[stack.peek()] < A[i]) {
                pre[i] = i - stack.peek() - 1;
            } else {
//                第一个小于i的点
                while (stack.size() > 0 && A[stack.peek()] >= A[i]) {
                    stack.pop();
                }
                if (stack.size() > 0) {
                    pre[i] = i - stack.peek() - 1;
                } else {
                    pre[i] = i;
                }
            }
            stack.push(i);
        }

        stack.clear();
//         找右边第一个比i小的元素的位置。依然维护一个单调递减栈，只不过方向是从尾到头
        for (int i = len - 1; i >= 0; --i) {
            if (stack.isEmpty()) {
                next[i] = 0;
            } else if (A[stack.peek()] < A[i]){
                next[i] = stack.peek() - i  - 1;
            } else if (A[stack.peek()] >= A[i]) {
                while (stack.size() > 0 && A[stack.peek()] > A[i]) {
                    stack.pop();
                }
                if (stack.size() > 0) {
                    next[i] = stack.peek() - i  - 1;
                } else {
                    next[i] = len - 1 - i;
                }
            }
            stack.push(i);
        }
        int ans = 0;
        for (int i = 0; i < len; ++i) {
            ans += (A[i] * (pre[i] + 1) * (next[i] + 1)) % MOD;
        }
        return ans;
    }
    public static void main(String[] args) {
//        int[] test = {85};
//        System.out.println(sumSubarrayMins(test));
//        System.out.println(Math.pow(10, 9) + 7);
//        int [] test = {3,1,2,4};
        int[] test = {59,91};
        System.out.println(sumSubarrayMinsNewStack(test));
    }
}
