package leet0401to0600.problem0450;

import utils.TreeNode;

/**
 * @author Brilliant James
 * @date 2020-03-26 01:45
 **/
public class DeleteNodeInBST_450 {

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        TreeNode pre = null;
        TreeNode index = root;
        while (index != null) {
            if (index.val == key) {
                break;
            } else if (index.val < key) {
                pre = index;
                index = index.right;
            } else if (index.val > key) {
                pre = index;
                index = index.left;
            }
        }
        if (index == null) {
            return root;
        }
        if (index.left != null && index.right != null) {
            // find  max in right
            TreeNode maxPre = index;
            TreeNode max = index.right;
            while (max.left != null) {
                maxPre = max;
                max = max.left;
            }
            index.val = max.val;
            pre = maxPre;
            index = max;

        }

        TreeNode child = null;
        if (index.right != null) {
            child = index.right;
        } else if (index.left != null) {
            child = index.left;
        }
        // if pre == null, mean delete root.
        if (pre == null) {
            // make root = child;
            root = child;
        } else if (pre.left == index) {
            pre.left = child;
        } else if (pre.right == index) {
            pre.right = child;
        }
        return root;
    }


}
