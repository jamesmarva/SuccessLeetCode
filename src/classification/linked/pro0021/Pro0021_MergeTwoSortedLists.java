package classification.linked.pro0021;

import utils.ListNode;

/**
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/
 * 21. 合并两个有序链表
 *
 * @author Brilliant James
 * @date 2020-04-25 03:11
 **/
public class Pro0021_MergeTwoSortedLists {


    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }
        ListNode dummy = new ListNode(0);
        ListNode i = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                i.next = l1;
                l1 = l1.next;
            } else {
                i.next = l2;
                l2 = l2.next;
            }
            i = i.next;
        }
        while (l1 != null) {
            i.next = l1;
            l1 = l1.next;
            i = i.next;
        }
        while (l2 != null) {
            i.next = l2;
            l2 = l2.next;
            i = i.next;
        }
        return dummy.next;
    }
}
