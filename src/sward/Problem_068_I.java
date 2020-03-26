package sward;

import utils.TreeNode;

/**
 * @author Brilliant James
 * @date 2020-03-25 23:54
 **/
public class Problem_068_I {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return root;
        }
        int small = p.val;
        int big = q.val;
        if (p.val > q.val) {
            small = q.val;
            big = p.val;
        }
        return dfs(root, small, big);
    }
    private TreeNode dfs(TreeNode node, int small, int big) {
        if (node.val >= small && node.val <= big) {
            return node;
        }
        if (node.val > small && node.val > big) {
            return dfs(node.left, small, big);

        }
        if (node.val < small && node.val < big) {
            return dfs(node.right, small, big);
        }
        return null;
    }
}
