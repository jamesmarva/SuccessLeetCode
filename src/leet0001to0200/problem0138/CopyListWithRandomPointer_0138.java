package leet0001to0200.problem0138;

import java.util.HashMap;

/**
 *
 *
 * @author James
 * @date 2019-11-29 03:51
 **/
public class CopyListWithRandomPointer_0138 {

    private class Node {
        public int val;
        public Node next;
        public Node random;

        public Node() {}

        public Node(int _val,Node _next,Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    }

    /**
     *
     */
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        HashMap<Node, Node> map = new HashMap<>();
        Node dummy = new Node();
        Node newIndex = dummy;
        Node index = head;
        while (index != null) {
            newIndex.next = new Node(index.val, null, null);
            newIndex = newIndex.next;

            map.put(index, newIndex);
            index = index.next;
        }

        for (Node key : map.keySet()) {
            Node oldRandom = key.random;
            Node newNode = map.get(key);
            newNode.random = map.get(oldRandom);
        }
        return dummy.next;
    }

}
