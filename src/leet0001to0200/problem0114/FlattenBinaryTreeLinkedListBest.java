package leet0001to0200.problem0114;

import utils.TreeNode;

/**
 * @author Brilliant James Jamesmarva1993@gmail.com 2021-12-07 01:22
 **/
public class FlattenBinaryTreeLinkedListBest {

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode idx = root;
        while (idx != null) {
            if (idx.left != null) {
                TreeNode tmp = idx.left;
                while (tmp.right != null) {
                    tmp = tmp.right;
                }
//                把 右子节点 设置成 左子树的最右的节点
                tmp.right = idx.right;
                // 把 右 设置成 左
                idx.right = idx.left;
                idx.left = null;
            }
            idx = idx.right;
        }
    }



}
