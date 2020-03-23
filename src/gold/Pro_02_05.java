package gold;

import utils.ListNode;

/**
 * https://leetcode-cn.com/problems/sum-lists-lcci/
 * 面试题 02.05. 链表求和
 * @author Brilliant James
 * @date 2020-03-23 02:40
 **/
public class Pro_02_05 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sentinel = new ListNode(0);
        ListNode index = sentinel;
        boolean addOne = false;
        while(l1 != null && l2 != null) {
            int tempSum = l1.val + l2.val;
            if (addOne) {
                tempSum += 1;
                if (tempSum > 9) {
                    tempSum -= 10;
                } else {
                    addOne = false;
                }
            } else {
                if (tempSum > 9) {
                    addOne = true;
                    tempSum -= 10;
                }
            }
            index.next = new ListNode(tempSum);
            index = index.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            int tempSum = l1.val;
            if (addOne) {
                tempSum += 1;
                if (tempSum > 9) {
                    tempSum -= 10;
                } else {
                    addOne = false;
                }
            }
            index.next = new ListNode(tempSum);
            index = index.next;
            l1 = l1.next;
        }

        while (l2 != null) {
            int tempSum = l2.val;
            if (addOne) {
                tempSum += 1;
                if (tempSum > 9) {
                    tempSum -= 10;
                } else {
                    addOne = false;
                }
            }
            index.next = new ListNode(tempSum);
            index = index.next;
            l2 = l2.next;
        }
        if (addOne) {
            index.next = new ListNode(1);
        }
        return sentinel.next;
    }
}
