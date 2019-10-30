package leet1001to1200.problem1161;

import utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author James
 * https://leetcode-cn.com/problems/maximum-level-sum-of-a-binary-tree/
 * @date 2019-10-30 13:21
 **/
public class MaxLevelSumOfBT1161 {

    /**
     * 层序遍历
     */
    public int maxLevelSum(TreeNode root) {
        if (root == null) {
            return 1;
        }
        int maxSum = 0;
        int maxIndex = 0;
        int level = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (queue.size() > 0) {
            int countOfNodeInLevel = queue.size();
            int tempLevelSum = 0;
            level++;
            while (countOfNodeInLevel > 0) {
                TreeNode tempTreeNode = queue.poll();
                tempLevelSum += tempTreeNode.val;
                if (tempTreeNode.left != null) {
                    queue.offer(tempTreeNode.left);
                }
                if (tempTreeNode.right != null) {
                    queue.offer(tempTreeNode.right);
                }
                countOfNodeInLevel--;
            }
            if (tempLevelSum > maxSum) {
                maxIndex = level;
                maxSum = tempLevelSum;
            }
        }
        return maxIndex;
    }
}
