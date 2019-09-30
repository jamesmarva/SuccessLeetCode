package leet1001to1200.problem1046;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author James
 * @program SuccessLeetCode
 * @description https://leetcode-cn.com/problems/last-stone-weight/
 * @date 2019-09-29 17:18
 **/
public class LastStoneWeight1046 {

    public int lastStoneWeight(int[] stones) {
        if (stones == null ||stones.length == 0) {
            return 0;
        }
        if (stones.length == 1) {
            return stones[0];
        }
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o2, o1) -> o1 - o2);
        for (int i = 0, len = stones.length; i < len; ++i) {
            priorityQueue.add(stones[i]);
        }

        while (priorityQueue.size() > 0) {
            int first = priorityQueue.poll();
            if (priorityQueue.size() > 0) {
                int second = priorityQueue.poll();
                if (first > second) {
                    priorityQueue.add(first - second);
                }
            } else {
                return first;
            }
        }
        return 0;
    }
}
