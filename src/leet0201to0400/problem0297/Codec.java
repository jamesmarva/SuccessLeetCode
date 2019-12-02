package leet0201to0400.problem0297;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        dfs(root, sb);
        return sb.toString();
    }
    private void dfs(TreeNode node, StringBuilder sb ) {
        if (node == null) {
            sb.append("null,");
        }
        sb.append(node.val + ",");
        dfs(node.left, sb);
        dfs(node.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        LinkedList<String> list = new LinkedList<>();
        String[] arr = data.split(",");
        for (String item : arr) {
            list.add(item);
        }
        return rebuild(list);
    }

    private TreeNode rebuild(LinkedList<String> list) {
        if (list.isEmpty()) {
            return null;
        }
        String num = list.removeFirst();
        TreeNode node = null;
        if ("null".equals(num)) {
            return node;
        } else {
            node = new TreeNode(Integer.parseInt(num));
        }
        node.left = rebuild(list);
        node.right = rebuild(list);
        return node;
    }
}