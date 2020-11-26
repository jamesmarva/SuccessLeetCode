package leet0001to0200.problem0148;

import utils.ListNode;

/**
 * <功能描述><br>
 *
 * @author Brilliant James Jamesmarva1993@gmail.com 2020-11-21 09:00
 **/
public class SortList_148 {


    /**
     * 归并：先递归，再合并
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {
        if (null == head || null == head.next) {
            return head;
        }
        ListNode mid = findMidNode(head);
        ListNode secondStart = mid.next;
        mid.next = null;
        sortList(head);
        sortList(secondStart);
        return merge(head, secondStart);

    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode sentinel = new ListNode(0);
        ListNode idx = sentinel;
        while (null != l1.next && null != l2.next) {
            if (l1.val <= l2.val) {
                idx.next = l1;
                l1 = l1.next;
            } else {
                idx.next = l2;
                l2 = l2.next;
            }
            idx = idx.next;
        }
        while (null != l1.next) {
            idx.next = l1;
            l1 = l1.next;
            idx = idx.next;
        }

        while (null != l2.next) {
            idx.next = l2;
            l2 = l2.next;
            idx = idx.next;
        }
        return sentinel.next;
    }
    

    public ListNode findMidNode(ListNode h) {
        ListNode sentinel = new ListNode(0);
        sentinel.next = h;
        ListNode fast = sentinel;
        ListNode slow = sentinel;
        while (null != fast.next && null != fast.next.next) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }





}
