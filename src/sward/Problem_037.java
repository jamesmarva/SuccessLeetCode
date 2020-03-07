package sward;

import utils.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author Brilliant James
 * @date 2020-03-06 19:31
 **/
public class Problem_037 {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "null;";
        }
        StringBuilder ans = new StringBuilder();
        ans.append(root.val).append(";");
        ans.append(serialize(root.left));
        ans.append(serialize(root.right));
        return ans.toString();
    }


//    private String
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] arr = data.split(";");
        LinkedList<String> list = new LinkedList<String>(Arrays.asList(arr));
        return dfs(list);
    }

    private TreeNode dfs(LinkedList<String> list) {
        if (list.isEmpty()) {
            return null;
        }
        String node = list.removeFirst();
        if ("null".equals(node)) {
            return null;
        }
        TreeNode treeNode = new TreeNode(Integer.valueOf(node));
        treeNode.left = dfs(list);
        treeNode.right = dfs(list);
        return treeNode;
    }
}
