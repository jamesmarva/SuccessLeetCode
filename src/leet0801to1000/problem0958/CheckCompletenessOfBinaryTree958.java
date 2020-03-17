package leet0801to1000.problem0958;

import utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/check-completeness-of-a-binary-tree/
 * 958. 二叉树的完全性检验
 * @author Brilliant James
 * @date 2020-03-16 13:27
 **/
public class CheckCompletenessOfBinaryTree958 {

    public boolean isCompleteTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean lastLevel = false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (queue.size() > 0) {
            TreeNode temp = queue.poll();
            TreeNode left = temp.left;
            TreeNode right = temp.right;
            if (lastLevel && (left != null || right != null)) {
                return false;
            }

            if (left == null && right != null) {
                return false;
            }
            if (left == null &&  right == null){
                lastLevel = true;
            }
            if (left != null) {
                queue.offer(left);
            }
            if (right != null) {
                queue.offer(right);
            }
        }
        return true;
    }

}
