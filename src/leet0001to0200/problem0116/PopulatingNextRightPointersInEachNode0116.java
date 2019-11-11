package leet0001to0200.problem0116;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node/
 * @author James
 * @date 2019-11-11 13:33
 **/
public class PopulatingNextRightPointersInEachNode0116 {

    public Node connect(Node root) {
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
     * 哨兵链表法
     * @param root
     * @return
     */
    public Node connect5(Node root) {
        if(root == null) {
            return root;
        }
        Node cursor = root, worker = null;
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


    /**
     *  作者：zoharyips
     *     链接：https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node/solution/mei-guan-yi-dong-de-java-xie-fa-by-zoharyips/
     *     来源：力扣（LeetCode）
     *     著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param root
     * @return
     */
    public Node connect1(Node root) {
        if (root == null) {
            return null;
        }
        Node level = root, worker = level;
        while(level.left != null) {
            worker.left.next = worker.right;
            if (worker.next == null) {
                level = level.left;
                worker = level;
            } else {
                worker.right.next = level.next.left;
                worker = worker.next;
            }
        }
        return root;
    }

    /**
     *
     * @param root
     * @return
     */
    public Node connect2(Node root) {
        if (root == null) {
            return null;
        }
        Node level = root, worker = level, temp = level;
        while(level.left != null) {
            worker.left.next = worker.right;
            if (worker.next == null) {
                level = level.left;
                worker = level;
                temp = level;
            } else {
                worker.right.next = temp.next.left;
                worker = worker.next;
                temp = temp.next;
            }
        }
        return root;
    }


    public Node connect3(Node root) {
        if (root == null) {
            return null;
        }
        Node level = root, worker = level, temp = level;
        while (level.left != null) {
            worker.left.next = worker.right;
            if (worker.next == null) {
                level = level.left;
                worker = level;
                temp = level;
            } else {
                worker.right.next = temp.next.left;
                worker = worker.next;
                temp =temp.next;
            }
        }
        return root;
    }


    /**
     * 作者：sorcerer
     *         链接：https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node/solution/la-la-lian-jie-fa-by-sorcerer/
     *         来源：力扣（LeetCode）
     *         著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param root
     * @return
     */
    public Node connect4(Node root) {
        if (root == null) {
            return root;
        }
        Node left = root.left;
        Node right = root.right;
        while(left != null) {
            left.next = right;
            left = left.right;
            right = right.left;
        }
        connect(root.left);
        connect(root.right);
        return root;
    }


    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val,Node _left,Node _right,Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };
}
