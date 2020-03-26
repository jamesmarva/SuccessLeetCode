package gold;

import utils.TreeNode;

/**
 * https://leetcode-cn.com/problems/check-subtree-lcci/
 * 面试题 04.10. 检查子树
 * @author Brilliant James
 * @date 2020-03-26 19:02
 **/
public class Pro_04_10 {

    StringBuilder s1 = new StringBuilder();
    StringBuilder s2 = new StringBuilder();

    /**
     * 利用StringBuilder + indexOf 进行匹配。
     * @param t1
     * @param t2
     * @return
     */
    public boolean checkSubTree(TreeNode t1, TreeNode t2) {
        preOrder1(t1);
        preOrder2(t2);
        int index = s1.toString().indexOf(s2.toString());
        if (index == -1) {
            return false;
        } else {
            return true;
        }
    }

    private void preOrder1(TreeNode node ) {
        if (node == null) {
            s1.append("null,");
            return;
        }
        s1.append("" + node.val).append(",");
        preOrder1(node.left);
        preOrder1(node.right);
    }

    private void preOrder2(TreeNode node) {
        if (node == null) {
            s2.append("null,");
            return;
        }
        s2.append("" + node.val).append(",");
        preOrder2(node.left);
        preOrder2(node.right);
    }


    /**
     * 递归求解
     * @param t1
     * @param t2
     * @return
     */
    private boolean res = false;
    public boolean checkSubTree1(TreeNode t1, TreeNode t2) {
        if (t2== null) {
            return true;
        }
        preOrder(t1, t2);
        return res;
    }

    public void preOrder(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return;
        }
        if (res) {
            return;
        }
        if (t1.val == t2.val) {
            if (treeMatch(t1, t2)) {
                res = true;
            }
        }
        preOrder(t1.left, t2);
        preOrder(t1.right, t2);
    }
    private boolean treeMatch(TreeNode t1, TreeNode t2) {
        if (t2 == null) {
            return true;
        } else if (t1 == null) {
            return false;
        } else if (t1.val != t2.val) {
            return true;
        }
        return treeMatch(t1.left, t2.left) && treeMatch(t1.right, t2.right);
    }
}
