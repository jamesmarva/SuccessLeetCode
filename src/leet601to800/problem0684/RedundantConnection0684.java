package leet601to800.problem0684;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @program: SuccessLeetCode
 * @description: https://leetcode-cn.com/problems/redundant-connection/
 * @author: James
 * @create: 2019-09-15 14:34
 **/
public class RedundantConnection0684 {

    private Map<Integer, Integer> fatherMap = new HashMap<>();

    private Map<Integer, Integer> rankMap = new HashMap<>();

    public int[] findRedundantConnection(int[][] edges) {
        if (edges == null || edges.length == 0) {
            return null;
        }
        int[] res = new int[2];
        for (int i = 0, len = edges.length; i < len; ++i) {
            fatherMap.put(edges[i][0], edges[i][0]);
            rankMap.put(edges[i][0], 1);
            fatherMap.put(edges[i][1], edges[i][1]);
            rankMap.put(edges[i][1], 1);
        }
        for (int i = 0, len = edges.length; i < len; ++i) {
            if (isConnected(edges[i][0], edges[i][1])) {
                res[0] = edges[i][0];
                res[1] = edges[i][1];
            } else {
                union(edges[i][0], edges[i][1]);
            }
        }
        return res;
    }

    public boolean isConnected(Integer a, Integer b) {
        Integer aHead = findHead(a);
        Integer bHead = findHead(b);
        if (aHead == null || bHead == null) {
            return false;
        }

        if (aHead.equals(bHead)){
            return true;
        } else {
            return false;
        }
    }

    private Integer findHead(Integer node) {
        Stack<Integer> path = new Stack<>();
        if (fatherMap.get(node) == null) {
            return null;
        }
        while (!node.equals(fatherMap.get(node))) {
            path.push(node);
            node = fatherMap.get(node);
        }
        while (!path.isEmpty()) {
            fatherMap.put(path.pop(), node);
        }
        return node;
    }

    private void union(Integer a, Integer b) {
        Integer aHead = findHead(a);
        Integer bHead = findHead(b);
        if (aHead.equals(bHead)) {
            return;
        }
        Integer big = aHead;
        Integer small = bHead;
        if (rankMap.get(aHead) < rankMap.get(bHead)) {
            big = bHead;
            small = aHead;
        }
        fatherMap.put(small, big);
        rankMap.put(big, rankMap.get(small) + rankMap.get(big));
        rankMap.remove(small);
    }

    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        System.out.println(map.get(0) == null);
    }
}
