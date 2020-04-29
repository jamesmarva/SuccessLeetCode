package classification.linked.pro0143;

import utils.ListNode;

import java.sql.PreparedStatement;

/**
 * @author Brilliant James
 * @date 2020-04-25 04:10
 **/
public class Pro0143_ReorderList_0143 {

    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        //
        ListNode index = slow.next;
        slow.next = null;

        //
        ListNode pre = null;
        ListNode after = null;
        while (index != null) {
            after = index.next;
            index.next = pre;
            pre = index;
            index = after;
        }
        ListNode l1 = head;
        ListNode l2 = pre;
        while (l1 != null && l2 != null) {
            ListNode l1After = l1.next;
            ListNode l2After = l2.next;
            l2.next = l1.next;
            l1.next = l2;
            l1 = l1After;
            l2 = l2After;
        }
    }
}
