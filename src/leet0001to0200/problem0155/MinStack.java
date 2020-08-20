package leet0001to0200.problem0155;

import java.util.Stack;

/**
 * @author Brilliant James
 * @date 2020-05-12 21:15
 **/
public class MinStack {


    Stack<Integer> stack;
    Stack<Integer> min;

    /** initialize your data structure here. */
    public MinStack() {
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
        if (stack.isEmpty()) {
            throw new IllegalArgumentException("stack is empty.");
        }
        int ans = stack.pop();
        if (ans == min.peek()) {
            min.pop();
        }
    }

    public int top() {
        if (stack.isEmpty()) {
            throw new IllegalArgumentException("stack is empty.");
        }
        return stack.peek();
    }

    public int getMin() {
        if (stack.isEmpty()) {
            throw new IllegalArgumentException("stack is empty.");
        }
        return min.peek();
    }
}
