package classification.linked.pro0023;

import utils.ListNode;

/**
 *
 * https://leetcode-cn.com/problems/merge-k-sorted-lists/
 *
 * @author Brilliant James
 * @date 2020-04-24 22:23
 **/
public class Pro0023_MergeSortedLists {

    /**
     * 主要是根据归并思想，对数组里的链表进行归并。
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        } else if (lists.length == 1) {
            return lists[0];
        }
        return merge(lists, 0, lists.length - 1);
    }

    private ListNode merge(ListNode[] arr, int start, int end) {
        if (start >= end) {
            return arr[start];
        }
        int mid = start + ((end - start) >> 1);
        ListNode left = merge(arr, start, mid);
        ListNode right = merge(arr, mid + 1, end);
        return mergeCore(left, right);
    }

    private ListNode mergeCore(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode index = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                index.next = l1;
                l1 = l1.next;
            } else {
                index.next = l2;
                l2 = l2.next;
            }
            index = index.next;
        }
        while (l1 != null) {
            index.next = l1;
            l1 = l1.next;
            index = index.next;
        }
        while (l2 != null) {
            index.next = l2;
            l2 = l2.next;
            index =index.next;
        }
        return dummy.next;
    }
}
