package leet0401to0600.problem0543;

import utils.TreeNode;

/**
 * @author Brilliant James
 * @date 2020-03-10 19:05
 **/
public class DiameterOfBinaryTree_0543 {

    private int maxDis = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return maxDis;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftLen = dfs(root.left);
        int rightLen = dfs(root.right);
        maxDis = Math.max(maxDis, leftLen + rightLen);
        return 1 + Math.max(leftLen,rightLen);
    }
}
