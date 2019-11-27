package leet0001to0200.problem0002;

import utils.ListNode;

/**
 * @author James
 * @date 2019-11-25 21:20
 **/
public class AddTwoNumbers_0002 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }
        boolean addOne = false;
        int tempSum = 0;
        ListNode dummy = new ListNode(0);
        ListNode ans = dummy;
        while (l1 != null || l2 != null) {
            if (l1 != null) {
                tempSum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                tempSum += l2.val;
                l2 = l2.next;
            }
            if (addOne) {
                tempSum += 1;
            }
            if (tempSum >= 10) {
                addOne = true;
                tempSum -= 10;
            } else {
                addOne = false;
            }
            ans.next = new ListNode(tempSum);
            ans = ans.next;
            tempSum = 0;
        }
        if (addOne) {
            ans.next = new ListNode(1);
        }
        return dummy.next;
    }
}
