package sward;

import utils.TreeNode;

/**
 * https://leetcode-cn.com/problems/er-cha-shu-de-jing-xiang-lcof/
 * w未提交
 * @author Brilliant James
 * @date 2020-03-16 12:48
 **/
public class Problem_27 {

    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        convert(root);
        return root;
    }

    private void convert(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        convert(root.left);
        convert(root.right);
    }
}
