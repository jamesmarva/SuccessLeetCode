package leet0801to1000.problem0817;

import utils.ListNode;

import java.util.HashSet;

/**
 * @author James
 * @date 2019-11-24 17:58
 **/
public class LinkedListComponents_0817 {

    public int numComponents(ListNode head, int[] G) {

        if (head == null) {
            return 0;
        }
        HashSet<Integer> set =new HashSet<>();
        for (int item : G) {
            set.add(item);
        }
        ListNode dummy = new ListNode(-1);
        ListNode index = head;
        ListNode pre = dummy;
        int ans = 0;
        while (index != null) {
            if (!set.contains(pre.val) && set.contains(index.val)) {
                ans++;
            }
            index = index.next;
            pre = index;
        }
        return ans;
    }
}
