package leet601to800.problem0739;

import java.util.Stack;

/**
 * @program: SuccessLeetCode
 * @description: https://leetcode-cn.com/problems/daily-temperatures/
 * @author: James
 * @create: 2019-09-09 07:32
 **/
public class DailyTemperatures0739 {


    /**
     * 单调栈的思想
     * @param T
     * @return
     */
    public int[] dailyTemperatures(int[] T) {
        Stack<Integer> stack = new Stack<Integer>();
        int length = T.length;
        int[] resultArray = new int[length];
        for (int i = 0; i < length; i++) {
            while (!stack.isEmpty() && T[stack.peek()] < T[i]) {
                int top = stack.pop();
                resultArray[top] = i - top;
            }
            stack.push(i);
        }
        return resultArray;
    }
}
