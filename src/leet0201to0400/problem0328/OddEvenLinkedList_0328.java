package leet0201to0400.problem0328;

import utils.ListNode;

import java.util.List;

/**
 * https://leetcode-cn.com/problems/odd-even-linked-list/
 * 328. Odd Even Linked List
 * @author James
 * @date 2019-12-04 15:50
 **/
public class OddEvenLinkedList_0328 {


    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode odd = head;
        ListNode even = head.next;
        ListNode dummy = new ListNode(0);
        dummy.next = even;
        ListNode evenInex = dummy.next;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even = odd.next;
            evenInex.next = even;
            evenInex = evenInex.next;

        }
        odd.next = dummy.next;
        return head;
    }

    public ListNode oddEvenList_1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode oddHead = head;
        ListNode evenHead = head.next;
        ListNode oddNode = oddHead;
        ListNode evenNode = evenHead;
        while (oddNode.next != null && evenNode.next != null) {
            oddNode.next = evenNode.next;
            oddNode = oddNode.next;
            if (oddNode.next != null) {
                evenNode.next = oddNode.next;
                evenNode = evenNode.next;
            } else {
                evenNode.next = null;
            }
        }
        oddNode.next = evenHead;
        return oddHead;
    }
}
