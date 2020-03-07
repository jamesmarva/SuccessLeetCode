package sward;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Brilliant James
 * @date 2020-03-06 11:21
 **/
public class Problem_032_III {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Stack<TreeNode> leftStack = new Stack<>();
        Stack<TreeNode> rightStack = new Stack<>();
        leftStack.push(root);
        while (leftStack.size() > 0 || rightStack.size() > 0) {
            List<Integer> tempList = new ArrayList<>();
            if (!leftStack.isEmpty()) {
                while (!leftStack.isEmpty()) {
                    TreeNode tempNode = leftStack.pop();
                    tempList.add(tempNode.val);
                    if (tempNode.left != null) {
                        rightStack.push(tempNode.left);
                    }
                    if (tempNode.right != null) {
                        rightStack.push(tempNode.right);
                    }
                }
            } else {
                while (!rightStack.isEmpty()) {
                    TreeNode tempNode = rightStack.pop();
                    tempList.add(tempNode.val);
                    if (tempNode.right != null) {
                        leftStack.push(tempNode.right);
                    }
                    if (tempNode.left != null) {
                        leftStack.push(tempNode.left);
                    }

                }
            }
            ans.add(tempList);
        }
        return ans;
    }


    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> levelOrder_1(TreeNode root) {
        helper(root, 0);
        return res;
    }

    private void helper(TreeNode root, int level) {
        if (root == null) {
            return;
        }
        if (res.size() == level) {
            res.add(new ArrayList<>());
        }
        if (level % 2 == 0) {
            res.get(level).add(root.val);

        } else {
            res.get(level).add(0, root.val);
        }
        helper(root.left, level + 1);
        helper(root.right, level + 1);
    }
}


