package leet0201to0400.problem0232;

import java.util.Stack;

/**
 * 232. 用栈实现队列
 * https://leetcode-cn.com/problems/implement-queue-using-stacks/
 * @author James
 * @date 2019-11-25 17:19
 **/
public class ImplementQueueUsingStacks_0232 {


    Stack<Integer> pushStack;
    Stack<Integer> popStack;

    /** Initialize your data structure here. */
    public ImplementQueueUsingStacks_0232() {
        pushStack = new Stack<>();
        popStack = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        pushStack.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (empty()) {
            throw new IllegalArgumentException("Empty !!!");
        }
        moveToPopStack();
        return popStack.pop();
    }

    /** Get the front element. */
    public int peek() {
        if (empty()) {
            throw new IllegalArgumentException("Empty !!!");
        }
        moveToPopStack();
        return popStack.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return popStack.isEmpty() && pushStack.isEmpty();
    }

    private void moveToPopStack() {
        if (popStack.isEmpty()) {
            while (pushStack.size() > 0) {
                popStack.push(pushStack.pop());
            }
        }
    }
}
