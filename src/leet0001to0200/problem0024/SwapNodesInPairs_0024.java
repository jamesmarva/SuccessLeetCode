package leet0001to0200.problem0024;

import utils.ListNode;

/**
 * @author James
 * @date 2019-12-01 22:04
 **/
public class SwapNodesInPairs_0024 {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;
        ListNode index = head;
        ListNode after = null;
        while (index != null && index.next != null) {
            after = index.next;
            pre.next = after;
            index.next = after.next;
            after.next = index;
            pre = index;
            index = index.next;
        }
        return dummy.next;
    }
}


