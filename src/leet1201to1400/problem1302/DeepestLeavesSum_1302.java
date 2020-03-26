package leet1201to1400.problem1302;

import utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/deepest-leaves-sum/
 *
 * @author Brilliant James
 * @date 2020-03-26 18:32
 **/
public class DeepestLeavesSum_1302 {

    public int deepestLeavesSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int ans = 0;
        while (queue.size() > 0) {
            int count = queue.size();
            ans = 0;
            while (count > 0) {
                TreeNode temp = queue.poll();
                ans += temp.val;
                if (temp.left != null) {
                    queue.offer(temp.left);
                }
                if (temp.right != null) {
                    queue.offer(temp.right);
                }
                count--;
            }
        }
        return ans;
    }

}
