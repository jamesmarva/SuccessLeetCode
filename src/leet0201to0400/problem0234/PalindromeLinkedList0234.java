package leet0201to0400.problem0234;

import utils.ListNode;

import java.util.ArrayList;

/**
 * @program: SuccessLeetCode
 * @description: https://leetcode-cn.com/problems/palindrome-linked-list/
 * @author: James
 * @create: 2019-09-13 07:41
 **/
public class PalindromeLinkedList0234 {


    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode quick = head.next;
        ListNode pre = head;
        ListNode now = head.next;
        head.next = null;

        while (quick.next != null) {
            quick = quick.next.next;
            ListNode nowNext = now.next;
            now.next = pre;
            pre = now;
            now = nowNext;
        }
        while (now.next != null && pre.next != null && pre.val == now.val) {
            now = now.next;
            pre = pre.next;
        }
        return now == null;
    }

    /**
     * 好的解法是用双指针确定的中点的位置，然后再进行前后的点的比较
     * 慢指针进行倒转的链表的方向，知道中点的位置后进行前半条链和后半条链的比较。
     *
     * @param head
     * @return
     */
    public boolean goodSolution(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode quick = head.next;
        ListNode pre = head;
        ListNode now = head.next;
        head.next = null;

        while (quick.next != null) {
            quick = quick.next.next;
            ListNode nowNext = now.next;
            now.next = pre;
            pre = now;
            now = nowNext;
//            ListNode temp = low;
//            low = low.next;
//            low.next = temp;
        }
//        ListNode mid = low.next;
        while (now.next != null && pre.next != null && pre.val == now.val) {
            now = now.next;
            pre = pre.next;
        }
        return true;
    }

    private ListNode findMiddle(ListNode head) {
        if (head == null) {
            return null;
        }
        // 快慢指针
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;

        while (head != null) {
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }

        return prev;
    }

    public boolean mySolution(ListNode head) {
        if (head == null) {
            return true;
        }
        ListNode nextNode = head.next;
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(head.val);
        while (nextNode != null) {
            list.add(nextNode.val);
            nextNode = nextNode.next;
        }

        int length = list.size();
        for (int i = 0; i < length / 2; i++) {
            int before = list.get(i);
            int after = list.get(length - i -1);
            if (before != after) {
                return false;
            }
        }
        return true;
    }
}
