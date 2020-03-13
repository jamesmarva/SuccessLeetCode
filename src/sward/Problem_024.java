package sward;

import utils.ListNode;

/**
 * @author Brilliant James
 * @date 2020-03-08 17:26
 **/
public class Problem_024 {


    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode current = head;
        ListNode pre = null;
        ListNode temp = null;
        while (current != null) {
            temp = current.next;
            current.next = pre;
            pre = current;
            current = temp;
        }
        return pre;
    }
}
