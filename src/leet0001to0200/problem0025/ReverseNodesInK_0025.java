package leet0001to0200.problem0025;

import utils.ListNode;

import java.util.ArrayList;

/**
 * https://leetcode-cn.com/problems/reverse-nodes-in-k-group/
 * 25. K 个一组翻转链表
 *
 * @author James
 * @date 2019-12-02 12:00
 **/
public class ReverseNodesInK_0025 {

    public ListNode reverseKGroup(ListNode head, int k ) {
//        for (String word: words) {
//            buckets.computeIfAbsent(word.length(), x -> new ArrayList()).add(word);
//        }
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy= new ListNode(0);
        ListNode pre = dummy;
        ListNode cur = head;
        pre.next = cur;
        ListNode start = null;
        ListNode end = null;
        ListNode after = null;
        while (cur != null) {
            boolean isEnd = false;
            start = cur;
            for (int i = 0; i < k - 1; i++) {
                if (cur == null) {
                    isEnd = true;
                    break;
                }
                cur = cur.next;
            }
            if (isEnd || cur == null) {
                break;
            }
            end = cur;
            after = cur.next;
            pre.next = reserve(start, end);
            start.next = after;
            pre = start;
            cur = after;
        }
        return dummy.next;
    }

    private ListNode reserve(ListNode start, ListNode end) {
        ListNode pre = null;
        ListNode current = start;
        ListNode after = null;
        while (pre != end && current != null) {
            after = current.next;
            current.next = pre;
            pre = current;
            current = after;
        }
        return end;
    }

    public static void main(String[] args) {
        ListNode dummy = new ListNode(0);
        ListNode index = dummy;
        for (int i = 1; i <= 5; i++) {
            index.next = new ListNode(i);
            index = index.next;
        }
        ReverseNodesInK_0025 rr = new ReverseNodesInK_0025();
        rr.reverseKGroup(dummy.next, 2);
    }
}
