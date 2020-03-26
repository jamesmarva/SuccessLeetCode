package gold;

import utils.ListNode;

/**
 * @author Brilliant James
 * @date 2020-03-24 01:44
 **/
public class Pro_02_06 {

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        int count = 0;
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;
        ListNode fast = sentinel;
        ListNode slow = sentinel;
        while (fast != null && fast.next != null) {
            fast =fast.next.next;
            slow = slow.next;
            count++;
        }
        ListNode pre = slow;
        slow = slow.next;
        while (slow != null) {
            ListNode after = slow.next;
            slow.next = pre;
            pre = slow;
            slow = after;
        }
        ListNode start = head;
        ListNode end = pre;
        while (count > 0) {
            if (start.val != end.val) {
                return false;
            }
            start = start.next;
            end = end.next;
            count--;
        }
        return true;
    }
}
