package classification.linked.pro0148;

import utils.ListNode;

/**
 * @author Brilliant James
 * @date 2020-04-25 06:15
 **/
public class Pro0148_SortList {

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        return mergeSort(head);
    }

    public ListNode mergeSort(ListNode start) {
        if (start.next == null) {
            return start;
        }
        // find mid node.
        ListNode fast = start.next;
        ListNode slow = start;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        // 截断中点之后的点，不然就会出现循环节点的情况
        ListNode second = slow.next;
        slow.next = null;

        ListNode left = mergeSort(start);
        ListNode right = mergeSort(second);
        return mergeCore(left, right);
    }

    private ListNode mergeCore(ListNode l1, ListNode l2) {
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
