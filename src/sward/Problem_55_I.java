package sward;

import utils.TreeNode;

/**
 * https://leetcode-cn.com/problems/er-cha-shu-de-shen-du-lcof/
 * 未提交
 * @author Brilliant James
 * @date 2020-03-16 12:53
 **/
public class Problem_55_I {


    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftMax = maxDepth(root.left);
        int rightMax = maxDepth(root.right);
        return Math.max(leftMax, rightMax) + 1;
    }


}
