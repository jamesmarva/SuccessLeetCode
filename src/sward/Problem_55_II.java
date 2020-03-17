package sward;

import utils.TreeNode;

/**
 *
 * https://leetcode-cn.com/problems/ping-heng-er-cha-shu-lcof/submissions/
 *
 *
 * @author Brilliant James
 * @date 2020-03-16 10:14
 **/
public class Problem_55_II {


    private boolean ans = true;
    public boolean isBalanced(TreeNode root) {
        dfs(root);
        return ans;
    }

    private int dfs(TreeNode node) {
        if (node == null){
            return 0;
        }
        int left = dfs(node.left);
        if (!ans) {
            return 0;
        }
        int right = dfs(node.right);
        if (!ans){
            return 0;
        }
        if (Math.abs(left - right) > 1) {
            ans = false;
        }
        return Math.max(left,right) + 1;
    }
}
