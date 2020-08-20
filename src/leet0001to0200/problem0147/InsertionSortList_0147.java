package leet0001to0200.problem0147;

import utils.ListNode;

/**
 * @author Brilliant James
 * @date 2020-04-08 01:53
 **/
public class InsertionSortList_0147 {

    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode index = dummy;
        while (index.next != null) {
            int value = index.next.val;
            ListNode t = dummy;
            while (t.next != index.next && t.next.val <= value) {
                t = t.next;
            }
            if (t.next != index.next) {
                ListNode tempNext = index.next;
                index.next = index.next.next;
                tempNext.next = t.next;
                t.next = tempNext;
            } else {
                index = index.next;
            }

        }
        return dummy.next;
    }

    /**
     * [4,2,1,6,5,3]
     * @param args
     */
    public static void main(String[] args) {
        ListNode d = new ListNode(0);
        ListNode i = d;
        i.next = new ListNode(4);
        i = i.next;
        i.next = new ListNode(2);
        i = i.next;
        i.next = new ListNode(1);
        i = i.next;
        i.next = new ListNode(6);
        i = i.next;
        i.next = new ListNode(5);
        i = i.next;
        i.next = new ListNode(3);
        InsertionSortList_0147 insertionSortList_0147 = new InsertionSortList_0147();
        insertionSortList_0147.insertionSortList(d.next);
    }
}
