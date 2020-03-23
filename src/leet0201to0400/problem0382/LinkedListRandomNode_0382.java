package leet0201to0400.problem0382;

import utils.ListNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Random;

/**
 *
 * https://leetcode-cn.com/problems/linked-list-random-node/
 * 382. 链表随机节点
 * 水塘抽样算法（Reservoir Sampling）
 * @author Brilliant James
 * @date 2020-03-19 12:39
 **/
public class LinkedListRandomNode_0382 {

    private Map<Integer, Integer> map;
    private int count = 0;
    private Random random = new Random(47);

    /** @param head The linked list's head.
    Note that the head is guaranteed to be not null, so it contains at least one node. */
    public LinkedListRandomNode_0382(ListNode head) {
        map = new HashMap<>();
        ListNode index = head;
        while (index != null) {
            map.put(count, index.val);
            index = index.next;
            count++;
        }
    }

    /** Returns a random node's value. */
    public int getRandom() {
        return map.get(random.nextInt(count));
    }




    public static void main(String[] args) {
        System.out.println(new Random(47).nextInt(100));
        System.out.println(new Random(47).nextInt(100));
        System.out.println(new Random(47).nextInt(100));
        System.out.println(new Random(47).nextInt(100));
        System.out.println(new Random(47).nextInt(100));
        System.out.println(new Random(47).nextInt(100));
        System.out.println(new Random(47).nextInt(100));
    }
}
