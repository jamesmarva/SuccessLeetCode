package leet0001to0200.problem0117;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author James
 * @date 2019-11-11 15:14
 **/
public class PopulatingNextRightPointersInEachNodeII_0117 {

    /**
     * 不是常数空间复杂度
     * @param root
     * @return
     */
    public Node connect1(Node root) {
        if (root == null ) {
            return root;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (queue.size() > 0) {
            Node indexNode = queue.peek();
            for (int i = 0, size = queue.size(); i < size; i++) {
                Node tempNode = queue.poll();
                if (tempNode.left != null) {
                    queue.offer(tempNode.left);
                }
                if (tempNode.right != null) {
                    queue.offer(tempNode.right);
                }
                if (i > 0) {
                    indexNode.next = tempNode;
                    indexNode = indexNode.next;
                }
            }
        }
        return root;
    }


    /**
     *
     */
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        Node worker = null, cursor = root;
        while (cursor != null) {
            Node dummy = new Node();
            worker = dummy;
            while (cursor != null) {
                if (cursor.left != null) {
                    worker.next = cursor.left;
                    worker = worker.next;
                }
                if (cursor.right != null) {
                    worker.next = cursor.right;
                    worker = worker.next;
                }
                cursor = cursor.next;
            }
            cursor = dummy.next;
        }
        return root;
    }



    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}
