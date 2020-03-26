package sward;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/bao-han-minhan-shu-de-zhan-lcof/
 * @author Brilliant James
 * @date 2020-03-25 23:34
 **/
public class Problem_030 {

    private Stack<Integer> stack;
    private Stack<Integer> min;
    /** initialize your data structure here. */
    public Problem_030() {
        stack = new Stack<>();
        min = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (min.isEmpty()) {
            min.push(x);
        } else if (min.peek() >= x) {
            min.push(x);
        }
    }

    public void pop() {
        int res = stack.pop();
        if (res == min.peek()) {
            min.pop();
        }
        return;
    }

    public int top() {
        if (stack.isEmpty()) {
            throw new IllegalArgumentException("minStack is empty.");
        }
        return stack.peek();
    }

    public int min() {
        return min.peek();
    }

}
