package leet0001to0200.problem0148;

import utils.ListNode;

/**
 * @author Brilliant James
 * @date 2020-04-07 22:58
 **/
public class SortList_0148 {

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        return mergeSort(head);
    }

    private ListNode mergeSort(ListNode head) {
        if (head.next == null) {
            return head;
        }
        // find mid ListNode.
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode next = slow.next;
        slow.next = null;
        return merge(mergeSort(head), mergeSort(next));
    }

    private ListNode merge(ListNode i1, ListNode i2) {
        ListNode dummy = new ListNode(0);
        ListNode i = dummy;
        while (i1 != null && i2 != null) {
            if (i1.val < i2.val) {
                i.next = i1;
                i1 =i1.next;
            } else {
                i.next= i2;
                i2 = i2.next;
            }
            i = i.next;
        }
        if (i1 != null) {
            i.next = i1;
        }
        if (i2 != null) {
            i.next = i2;
        }
        return dummy.next;
    }
}
