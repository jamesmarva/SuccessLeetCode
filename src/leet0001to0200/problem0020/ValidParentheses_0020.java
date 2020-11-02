package leet0001to0200.problem0020;

import java.util.ArrayDeque;
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
        ArrayDeque<Character> stack = new ArrayDeque<>();
        char[] arr = s.toCharArray();
        for (char tempChar : arr) {
            if (tempChar == '{' || tempChar == '[' || tempChar == '(') {
                stack.push(tempChar);
            } else if (stack.isEmpty()) {
                return false;
            } else if (tempChar == ')') {
                if (stack.peek() == '(') {
                    stack.pop();
                } else {
                    return false;
                }
            } else if (tempChar == ']') {
                if (stack.peek() == '[') {
                    stack.pop();
                } else {
                    return false;
                }
            } else if (tempChar == '}') {
                if (stack.peek() == '{') {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }


    /**
     * 最好的解法，一次遍历
     * @param s
     * @return
     */
    public boolean isValidBest(String s) {
        if(s.isEmpty()) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()) {
            if(c == '[') {
                stack.push(']');
            } else if(c == '{') {
                stack.push('}');
            }else if(c == '(') {
                stack.push(')');
            } else if(stack.isEmpty() || c != stack.pop()) {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
