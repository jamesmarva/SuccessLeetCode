package leet0001to0200.problem0023;

import utils.ListNode;

import java.util.List;
import java.util.PriorityQueue;

/**
 * https://leetcode-cn.com/problems/merge-k-sorted-lists/
 * 23. 合并K个排序链表
 * @author James
 * @date 2019-11-28 16:30
 **/
public class MergeSortedLists_0023 {

    /**
     * 这种写法非常的节省空间
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        int len = 0;
        if (lists == null || (len = lists.length) == 0) {
            return null;
        }
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(len, ((o1, o2) -> o1.val - o2.val));
        for (ListNode item : lists) {
            if (item != null) {
                priorityQueue.offer(item);
            }
        }
        ListNode dummy  = new ListNode(0);
        ListNode index = dummy;
        while (priorityQueue.size() > 0) {
            ListNode temp = priorityQueue.poll();
            index.next = temp;
            index = index.next;
            if (temp.next != null) {
                priorityQueue.offer(temp.next);
            }
        }
        return dummy.next;
    }


    public ListNode mergeKLists_1(ListNode[] lists) {
        int len = 0;
        if (lists == null || (len = lists.length) == 0) {
            return null;
        }
        return merge(lists, 0, len - 1);

    }


    public ListNode merge(ListNode[] arr, int start, int end) {
        if (start >= end) {
            return arr[start];
        }
        int mid = start + ((end - start) >> 1);
        ListNode leftNode = merge(arr, start, mid);
        ListNode rightNode = merge(arr, mid + 1, end);

        return mergeCore(leftNode, rightNode);
    }

    public ListNode mergeCore(ListNode first, ListNode second) {
        ListNode dummy = new ListNode(0);
        ListNode index = dummy;
        while (first != null && second != null) {
            if (first.val < second.val) {
                index.next = first;
                first = first.next;
            } else {
                index.next = second;
                second = second.next;
            }
            index = index.next;
        }
        while (first != null) {
            index.next = first;
            first = first.next;
            index = index.next;
        }
        while (second != null){
            index.next = second;
            second =second.next;
            index = index.next;
        }
        return dummy.next;
    }


    public static void main(String[] args) {
        int test = 1000;
        int test3 = 2000;
        int ans = test + ((test3 - test) >> 1);
        System.out.println(ans);
    }
}
