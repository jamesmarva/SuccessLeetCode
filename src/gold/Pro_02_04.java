package gold;

import utils.ListNode;

/**
 * https://leetcode-cn.com/problems/partition-list-lcci/
 * 面试题 02.04. 分割链表
 * @author Brilliant James
 * @date 2020-03-23 02:43
 **/
public class Pro_02_04 {



    public ListNode partition(ListNode head, int x) {
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;
        ListNode index = head;
        ListNode pre = sentinel;
        while (index != null) {
            if (index.val < x && pre != sentinel) {
                ListNode after = index.next;
                pre.next = after;
                index.next = sentinel.next;
                sentinel.next = index;
                index = after;
            } else {
                pre = index;
                index = index.next;
            }
        }
        return sentinel.next;
    }
}
