package leet0001to0200.problem0103;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author James
 * https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/
 * @date 2019-10-26 00:33
 **/
public class BinaryTreeLevelOrderTraversal0103 {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root);
        boolean isLeft = true;
        while (stack1.size() > 0 || stack2.size() > 0) {
            ArrayList<Integer> tempList = new ArrayList<>();
            if (isLeft) {
                while (stack1.size() > 0) {
                    TreeNode tempTreeNode = stack1.pop();
                    tempList.add(tempTreeNode.val);
                    if (tempTreeNode.left != null) {
                        stack2.push(tempTreeNode.left);
                    }
                    if (tempTreeNode.right != null) {
                        stack2.push(tempTreeNode.right);
                    }
                }
                isLeft = false;
            } else {
                while (stack2.size() > 0) {
                    TreeNode tempTreeNode = stack2.pop();
                    tempList.add(tempTreeNode.val);
                    if (tempTreeNode.right != null) {
                        stack1.push(tempTreeNode.right);
                    }
                    if (tempTreeNode.left != null) {
                        stack1.push(tempTreeNode.left);
                    }
                    isLeft = true;
                }
            }
            ans.add(tempList);
        }
        return ans;
    }
}
