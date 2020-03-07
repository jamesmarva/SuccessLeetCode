package leet;

import utils.TreeNode;

import java.util.HashSet;

/**
 * @author James
 * @date 2019-11-17 10:53
 **/
public class FindElements_5264 {

    private HashSet<Integer> set =new HashSet<>();

    public FindElements_5264(TreeNode root) {
        root.val = 0;
        dfs(root);
    }

    private void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        if (node.left != null) {
            node.left.val = node.val * 2 + 1;
            set.add(node.val * 2 + 1);
        }
        if (node.right != null) {
            node.right.val = node.val * 2 + 2;
            set.add(node.val * 2 + 2);
        }
        dfs(node.left);
        dfs(node.right);
    }

    public boolean find(int target) {
        return set.contains(target);
    }
}
