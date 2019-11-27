package leet0201to0400.problem0225;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author James
 * @date 2019-11-25 17:55
 **/
public class ImplementStackUsingQueues_0225 {


    private Queue<Integer> queue;
    private int topElement;
    private int size;
    /** Initialize your data structure here. */
    public ImplementStackUsingQueues_0225() {
        queue = new LinkedList<>();
        size = 0;
    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue.offer(x);
        topElement = x;
        size++;
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if (size==0) {
            throw new IllegalArgumentException("stack id empty...");
        }
        for (int i = 0; i < size-1; i++) {
            if (i == size -1){
                topElement = queue.peek();
            }
            queue.offer(queue.poll());
        }
        size--;
        return queue.poll();
    }

    /** Get the top element. */
    public int top() {
        if (size == 0) {
            throw new IllegalArgumentException("stack id empty...");
        }
        return topElement;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }
}
