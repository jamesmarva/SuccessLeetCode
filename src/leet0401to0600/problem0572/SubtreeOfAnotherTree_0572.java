package leet0401to0600.problem0572;

import com.sun.source.tree.Tree;
import utils.TreeNode;

/**
 * @author James
 * @date 2019-12-05 01:29
 **/
public class SubtreeOfAnotherTree_0572 {


    private boolean ans = false;

    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (t == null) {
            return true;
        }
        dfs(s, t);
        return ans;
    }

    private void dfs(TreeNode s, TreeNode t) {
        if (ans) {
            return;
        }
        if (s == null) {
            return;
        }

        dfs(s.left, t);
        if (s.val == t.val) {
            ans = match(s, t);
        }
        match(s, t);
    }
    private boolean match(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        } else if (s == null || t == null) {
            return false;
        } else if (s.val != t.val) {
            return false;
        }
        boolean leftResult = match(s.left, t.left);
        boolean rightResult = match(s.right, t.right);
        return leftResult && rightResult;
    }


}
