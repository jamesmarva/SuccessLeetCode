package sward;

import utils.TreeNode;

import java.sql.PreparedStatement;

/**
 *
 * https://leetcode-cn.com/problems/dui-cheng-de-er-cha-shu-lcof/
 *
 * @author Brilliant James
 * @date 2020-03-16 12:38
 **/
public class Problem_28 {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return dfs(root.left, root.right);
    }


    private boolean dfs(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        } else if (node1 == null || node2 == null) {
            return false;
        }
        if (node1.val != node2.val) {
            return false;
        }
        boolean left = dfs(node1.left, node2.right);
        boolean right = dfs(node1.right, node2.left);
        return left && right;
    }
}
