package gold;

import utils.ListNode;

/**
 * https://leetcode-cn.com/problems/kth-node-from-end-of-list-lcci/
 * 面试题 02.02. 返回倒数第 k 个节点
 *
 * @author Brilliant James
 * @date 2020-03-24 01:45
 **/
public class Pro_02_02 {

    public int kthToLast(ListNode head, int k) {
        ListNode fast = head;
        while (k > 0) {
            if (fast == null) {
                throw new IllegalArgumentException("k is wrong.");
            }
            fast = fast.next;
            k--;
        }
        ListNode slow = head;
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow.val;
    }
}
