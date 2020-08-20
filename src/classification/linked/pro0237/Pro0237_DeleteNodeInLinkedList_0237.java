package classification.linked.pro0237;

import utils.ListNode;

/**
 * @author Brilliant James
 * @date 2020-04-25 06:10
 **/
public class Pro0237_DeleteNodeInLinkedList_0237 {

    public void deleteNode(ListNode node) {
        if (node.next == null) {
            throw new IllegalArgumentException("node is last node.");
        }
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
