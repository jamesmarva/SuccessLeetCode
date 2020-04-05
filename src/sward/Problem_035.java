package sward;

import java.util.HashMap;

/**
 * @author Brilliant James
 * @date 2020-04-05 06:00
 **/
public class Problem_035 {


    public Node copyRandomList(Node head) {
        Node sentinel = new Node(0);
        Node index = head;
        Node newIndex = sentinel;
        HashMap<Node, Node> oldToNew = new HashMap<>();
        while (index != null) {
            newIndex.next = new Node(index.val);
            oldToNew.put(index, newIndex.next);
            newIndex = newIndex.next;
            index = index.next;
        }
        index = head;
        while (index != null) {
            Node oldRandomNode = index.random;
            Node newRandomNode = oldToNew.get(oldRandomNode);
            Node newNode = oldToNew.get(index);
            newNode.random = newRandomNode;
            index = index.next;
        }
        return sentinel.next;
    }

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

}
