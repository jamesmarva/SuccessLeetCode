package gold;

import utils.ListNode;

/**
 * @author Brilliant James
 * @date 2020-03-23 02:53
 **/
public class Pro_02_03 {
    public void deleteNode(ListNode node) {
        if (node.next == null) {
            throw new IllegalArgumentException("node is last.");
        }
        ListNode after = node.next;
        node.val = after.val;
        node.next = after.next;
    }
}
