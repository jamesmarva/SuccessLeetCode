package sward;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Brilliant James
 * @date 2020-03-06 11:11
 **/



public class Problem_032_I {


    public int[] levelOrder(TreeNode root) {
        int[] ans = {};
        if (root == null) {
            return ans;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        ArrayList<Integer> tempAns = new ArrayList<>(1000);
        while (!queue.isEmpty()) {
            int count = queue.size();
            for (int i = 0; i < count; i++) {
                TreeNode tempNode = queue.poll();
                tempAns.add(tempNode.val);
                if (tempNode.left != null) {
                    queue.add(tempNode.left);
                }
                if (tempNode.right != null) {
                    queue.add(tempNode.right);
                }
            }
        }
        int len = tempAns.size();
        ans = new int[len];
        for (int i = 0; i < len; i++) {
            ans[i] = tempAns.get(i);
        }
        return ans;
    }
}
