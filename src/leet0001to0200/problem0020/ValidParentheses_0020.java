package leet0001to0200.problem0020;

import java.util.Stack;

/**
 * @author James
 * @date 2019-11-28 15:09
 **/
public class ValidParentheses_0020 {


    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        Stack<Character> stack = new Stack<>();
        char[] arr = s.toCharArray();

        for (int i = 0, len = arr.length; i < len; ++i) {
            char tempChar = arr[i];
            if (stack.isEmpty()) {
                stack.push(tempChar);
                continue;
            }
            if (tempChar =='{' || tempChar == '[' || tempChar == '(') {
                stack.push(tempChar);
            } else if (tempChar == ')') {
                if (stack.peek() == '(') {
                    stack.pop();
                } else {
                    stack.push(tempChar);
                }
            } else if (tempChar == ']') {
                if (stack.peek() == '[') {
                    stack.pop();
                } else {
                    stack.push(tempChar);
                }
            } else if (tempChar == '}') {
                if (stack.peek() == '{') {
                    stack.pop();
                } else {
                    stack.push(tempChar);
                }
            }
        }
        return stack.isEmpty();
    }
}
