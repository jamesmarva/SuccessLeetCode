package leet0201to0400.problem0382;

import utils.ListNode;

import java.util.Random;

/**
 * @author Brilliant James
 * @date 2020-03-19 13:22
 **/
public class LinkedListRandomNode_0382_II {

    private ListNode head;

    private Random ran;

    /** @param head The linked list's head.
    Note that the head is guaranteed to be not null, so it contains at least one node. */
    public LinkedListRandomNode_0382_II(ListNode head) {
        this.head = head;
        ran = new Random();
    }

    /**
     * 诶了节省空间，只要牺牲时间了。
     * Returns a random node's value.
     */
    public int getRandom() {
        ListNode index = head;
        int res = 0;
        int count = 0;
        while (index != null) {
            if (ran.nextInt(++count) == 0) {
                res = index.val;
            }
            index = index.next;
        }
        return res;
    }

    /**
     * 返回 k 个值
     * https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&mid=2247484974&idx=1&sn=795a33c338d4a5bd8d265bc7f9f63c03&chksm=9bd7f826aca07130e303d3d6f5c901b8aa00f9c3d02ffc26d45b56f1d36b538990c9eebd06a8&scene=21
     * @param k
     * @return
     */
    public int[] getRandom(int k) {
        ListNode index = head;
        int[] res = new int[k];
        int i = 0;
        for (; i < k; i++) {
            res[i] = index.val;
        }

        while (index != null) {
            int temp = ran.nextInt(i);
            if (ran.nextInt(i) < k) {
                res[temp] = index.val;
            }
            index = index.next;
        }
        return res;
    }

    public static void main(String[] args) {
        Random ran = new Random();
        for (int i = 0; i < 100; i++) {
            System.out.println(ran.nextInt( 100));
        }
    }
}
