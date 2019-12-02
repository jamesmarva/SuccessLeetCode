package leet0001to0200.problem0133;

import java.util.*;

/**
 * @author James
 * @date 2019-11-29 04:41
 **/
public class CloneGraph_0133 {

    private class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {}

        public Node(int _val,List<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        HashMap<Node, Node> map = new HashMap<>();
        HashSet<Node> set = new HashSet<>();
        while (queue.size() > 0) {
            int count = queue.size();
            while (count > 0) {
                Node temp = queue.poll();
                set.add(temp);
                map.put(temp, new Node(temp.val, new ArrayList<>()));
                for (Node item : temp.neighbors) {
                    if (set.contains(item)) {
                        queue.offer(item);
                    }
                }
                count--;
            }
        }
        for (Node key : map.keySet()) {
            List<Node> list = key.neighbors;
            Node newNode = map.get(key);
            List<Node> newList = newNode.neighbors;
            for (Node oldNode : list) {
                newList.add(map.get(oldNode));
            }
        }
        return map.get(node);
    }

}
