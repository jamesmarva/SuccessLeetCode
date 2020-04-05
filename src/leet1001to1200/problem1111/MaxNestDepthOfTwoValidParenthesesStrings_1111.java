package leet1001to1200.problem1111;

import java.sql.PreparedStatement;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/maximum-nesting-depth-of-two-valid-parentheses-strings/solution/java-yi-ge-zhan-jie-fa-by-huangzhouwu/
 * @author Brilliant James
 * @date 2020-04-01 03:44
 **/
public class MaxNestDepthOfTwoValidParenthesesStrings_1111 {

    public int[] maxDepthAfterSplit(String seq) {
        int[] ans = {};
        if (seq == null || seq.length() == 0) {
            return ans;
        }
        char[] chars = seq.toCharArray();
        int len = chars.length;
        ans = new int[len];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            if (chars[i] == '(') {
                stack.push(i);
            } else {
                int depth = stack.size();
                int l = stack.pop();
                if (depth % 2 == 0) {
                    ans[l] = 1;
                    ans[i] = 1;
                } else {
                    ans[l] = 0;
                    ans[i] = 0;
                }
            }
        }
        return ans;
    }
}
