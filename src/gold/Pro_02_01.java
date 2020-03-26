package gold;

import utils.ListNode;

import java.util.HashSet;

/**
 * https://leetcode-cn.com/problems/remove-duplicate-node-lcci/
 * 面试题 02.01. 移除重复节点
 * @author Brilliant James
 * @date 2020-03-24 01:45
 **/
public class Pro_02_01 {

    public ListNode removeDuplicateNodes(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        HashSet<Integer> set = new HashSet<Integer>();
        ListNode index = head;
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;
        ListNode pre = sentinel;
        while(index != null) {
            if (set.add(index.val)) {
                pre = index;
                index = index.next;
            } else {
                ListNode after = index.next;
                pre.next = after;
                index = after;
            }
        }
        return sentinel.next;
    }
}
