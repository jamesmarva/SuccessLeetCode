package sward;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Brilliant James
 * @date 2020-03-07 00:43
 **/
public class Problem_059_II {

    private Queue<Integer> queue;
    private LinkedList<Integer> maxQueue;

    public Problem_059_II() {
        queue = new LinkedList<>();
        maxQueue = new LinkedList<>();
    }

    public int max_value() {
        if (maxQueue.isEmpty()) {
            return -1;
        }
        return maxQueue.getFirst();
    }

    public void push_back(int value) {
        queue.add(value);
        if (maxQueue.isEmpty() || value > maxQueue.getFirst()) {
            maxQueue.clear();
            maxQueue.offer(value);
        } else {
            while (value > maxQueue.getLast()) {
                maxQueue.removeLast();
            }
            maxQueue.add(value);
        }
    }

    public int pop_front() {
        if (queue.isEmpty()) {
            return -1;
        }
        int res = queue.poll();
        if (res == maxQueue.getFirst()){
            maxQueue.removeFirst();
        }
        return res;
    }
}
