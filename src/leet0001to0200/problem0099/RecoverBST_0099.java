package leet0001to0200.problem0099;

import utils.TreeNode;

/**
 * @author Brilliant James
 * @date 2020-03-16 14:43
 **/
public class RecoverBST_0099 {
    TreeNode x = null, y = null, pred = null;

    public void recoverTree(TreeNode root) {
        if (root == null) {
            return;
        }
        recoverTree(root.left);
        if (pred != null && root.val < pred.val) {
            y = root;
            if (x == null) {
                x = pred;
            } else {
                return;
            }
        }
        pred = root;
        recoverTree(root.right);
    }
}
