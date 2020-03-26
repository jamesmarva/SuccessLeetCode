package sward;

import java.util.Stack;

/**
 * @author Brilliant James
 * @date 2020-03-25 23:35
 **/
public class Problem_031 {

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        if (popped.length != pushed.length) {
            return false;
        }
        int len = pushed.length;
        int popIndex = 0;
        int i = 0;
        for (; i < len; i++) {
            stack.push(pushed[i]);
            while (stack.size() > 0 && stack.peek() == popped[popIndex]) {
                stack.pop();
                popIndex++;
            }
        }
        return i == popIndex;
    }
}
