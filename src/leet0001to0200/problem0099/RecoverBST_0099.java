package leet0001to0200.problem0099;

import utils.TreeNode;

import java.util.TreeMap;

/**
 * @author Brilliant James
 * @date 2020-03-16 14:43
 **/
public class RecoverBST_0099 {
    TreeNode x = null, y = null, pred = null;

//    public void recoverTree(TreeNode root) {
//        if (root == null) {
//            return;
//        }
//        recoverTree(root.left);
//        if (pred != null && root.val < pred.val) {
//            y = root;
//            if (x == null) {
//                x = pred;
//            } else {
//                return;
//            }
//        }
//        pred = root;
//        recoverTree(root.right);
//    }

    TreeNode first = null;
    TreeNode second = null;
    TreeNode pre = null;

    public void recoverTree(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    private void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        recoverTree(node.left);
        if (pre != null) {
            if (pre.val > node.val && first == null) {
                first = pre;
            }
            if (pre.val > node.val) {
                second = node;
            }
        }
        pre = node;
        recoverTree(node.right);
    }
}
