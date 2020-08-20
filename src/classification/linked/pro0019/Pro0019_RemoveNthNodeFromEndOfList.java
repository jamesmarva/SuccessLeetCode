package classification.linked.pro0019;

import utils.ListNode;

import java.util.ServiceLoader;

/**
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 * 19. 删除链表的倒数第N个节点
 *
 * @author Brilliant James
 * @date 2020-04-25 02:47
 **/
public class Pro0019_RemoveNthNodeFromEndOfList {

    /**
     * 利用哨兵 + 前置聊表点删除的方式
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = head;
        while (n > 0) {
            fast = fast.next;
            n--;
        }
        ListNode pre = dummy;
        ListNode slow = head;
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
            pre = pre.next;
        }
        pre.next = slow.next;
        return dummy.next;
    }
}
