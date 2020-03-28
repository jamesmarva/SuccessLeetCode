package sward;

import java.util.PriorityQueue;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * @author Brilliant James
 * @date 2020-03-27 22:39
 **/
public class Problem_041 {


    private PriorityQueue<Integer> minHeap;

    private PriorityQueue<Integer> maxHeap;

    private int size;
    /** initialize your data structure here. */
    public Problem_041() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        size = 0;
    }

    public void addNum(int num) {
        if (size % 2 == 0){
            maxHeap.offer(num);
        } else {
            minHeap.offer(num);
            minHeap.offer(maxHeap.poll());
        }
        size++;
    }

    public double findMedian() {
        if (maxHeap.isEmpty()) {
            throw new IllegalArgumentException("MedianFinder is empty.");
        }
        if (size % 2 == 0) {
            return (minHeap.peek() + maxHeap.peek()) / 2.0;
        } else {
            return (double) maxHeap.peek();
        }
    }
}
