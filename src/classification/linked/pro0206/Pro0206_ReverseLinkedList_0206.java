package classification.linked.pro0206;

import utils.ListNode;

/**
 * @author Brilliant James
 * @date 2020-04-25 05:56
 **/
public class Pro0206_ReverseLinkedList_0206 {

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = null;
        ListNode index = head;
        ListNode after = null;
        while (index != null) {
            after = index.next;
            index.next = pre;
            pre = index;
            index = after;
        }
        return pre;
    }
}
