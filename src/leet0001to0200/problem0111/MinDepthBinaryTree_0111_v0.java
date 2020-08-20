package leet0001to0200.problem0111;

import utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
 * 111. 二叉树的最小深度
 *
 * @author Brilliant James Jamesmarva1993@gmail.com 2020-08-21 01:49
 **/
public class MinDepthBinaryTree_0111_v0 {

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int result = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (queue.size() > 0) {
            int count = queue.size();
            result++;
            while (count > 0) {
                TreeNode tmp = queue.poll();
                count--;
                if (tmp.left == null && tmp.right == null ) {
                    return result;
                }
                if (tmp.left != null) {
                    queue.offer(tmp.left);
                }
                if (tmp.right != null) {
                    queue.offer(tmp.right);
                }
            }
        }
        return result;
    }
}
