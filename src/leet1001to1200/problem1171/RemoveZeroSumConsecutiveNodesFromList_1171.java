package leet1001to1200.problem1171;

import utils.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1171. 从链表中删去总和值为零的连续节点
 * https://leetcode-cn.com/problems/remove-zero-sum-consecutive-nodes-from-linked-list/
 * @author James
 * @date 2019-11-24 15:36
 **/
public class RemoveZeroSumConsecutiveNodesFromList_1171 {

    public ListNode removeZeroSumSublists(ListNode head) {
        if (head == null || (head.next == null && head.val == 0)) {
            return null;
        }
        ArrayList<Integer> list = new ArrayList<>();
        ListNode index = head;
        while (index != null) {
            list.add(index.val);
            index = index.next;
        }
        int cursor = 0;
        while (cursor < list.size()) {
            int sum = 0;
            int newCursor = cursor;
            while (newCursor < list.size()) {
                sum += list.get(newCursor);
                if (sum == 0) {
                    int count = newCursor - cursor + 1;
                    while (count > 0) {
                        list.remove(cursor);
                        count--;
                    }
                    cursor = -1;
                    break;
                }
                newCursor++;
            }
            cursor++;
        }
        ListNode dummy = new ListNode(0);
        ListNode node = dummy;
        for (Integer item : list) {
            node.next = new ListNode(item);
            node =node.next;
        }
        return  dummy.next;
    }


    /**
     * 执行用时: 6 ms, 在所有 java 提交中击败了 78.71%的用户
     * 内存消耗: 39 MB, 在所有 java 提交中击败了100.00%的用户
     * @param head
     * @return
     */
    public ListNode removeZeroSumSublists_1(ListNode head) {
        if (head == null || (head.next == null && head.val == 0)) {
            return null;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next  = head;
        ListNode index = dummy;
        boolean changed = false;
        while (index.next != null) {
            int tempSum = 0;
            ListNode newCursor = index.next;
            changed =false;
            while (newCursor != null) {
                tempSum += newCursor.val;
                if (tempSum == 0) {
                    index.next = newCursor.next;
                    newCursor.next = null;
                    index = dummy;
                    changed = true;
                    break;
                }
                newCursor = newCursor.next;
            }
            if (!changed) {
                index = index.next;
            }
        }
        return dummy.next;
    }



    public static void main(String[] args) {
        int[] test = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
//                    0  1  2  3  4  5  6  7  8  9   10  11  12  13  14
        int len = test.length;

        System.arraycopy(test, 8, test, 5, 7);
        System.out.println(Arrays.toString(test));
//        System.arraycopy
//        public static native void arraycopy(Object src,  int  srcPos,
//                            Object dest, int destPos,
//                            int length);
    }
}
