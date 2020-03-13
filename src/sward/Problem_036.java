package sward;

import utils.Node;

/**
 * @author Brilliant James
 * @date 2020-03-08 17:00
 **/
public class Problem_036 {

    private Node pre = null;

    public Node treeToDoublyList(Node root) {
        if(root == null) {
            return root;
        }
        Node head = root;
        Node tail = root;
        while (head.left != null) {
            head = head.left;
        }
        while (tail.right != null) {
            tail = tail.right;
        }
        inOrder(root);
        head.left = tail;
        tail.right = head;
        return head;
    }

    private void inOrder(Node current) {
        if (current == null) {
            return;
        }
        inOrder(current.left);
        current.left = pre;
        if (pre != null) {
            pre.right = current;
        }
        pre = current;
        inOrder(current.right);
    }
}
