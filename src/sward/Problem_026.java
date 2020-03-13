package sward;

import utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

/**
 * @author Brilliant James
 * @date 2020-03-12 15:31
 **/
public class Problem_026 {

    public boolean isSubStructure_01(TreeNode A, TreeNode B) {
        if (A == null) {
            return false;
        }
        if (A.val == B.val) {
            if (isSame(A, B)) {
                return true;
            }
        }
        isSubStructure_01(A.left, B);
        isSubStructure_01(A.right, B);
        return false;
    }

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null){
            return false;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(A);
        while (queue.size() > 0) {
            int count = queue.size();
            while (count > 0) {
                TreeNode tmp = queue.poll();
                if (tmp.val == B.val && isSame(tmp, B)) {
                    return true;
                }
                if (tmp.left != null) {
                    queue.offer(tmp.left);
                }
                if (tmp.right != null) {
                    queue.offer(tmp.right);
                }
                count--;
            }
        }
        return false;
    }
    private boolean isSame(TreeNode a, TreeNode b) {
        if ( a == null && b != null) {
            return false;
        } else if ( b == null) {
            return true;
        }
        if (a.val != b.val) {
            return false;
        }
        return isSame(a.left, b.left) && isSame(a.right, b.right);
    }


}
