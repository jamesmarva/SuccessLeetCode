package leet1201to1400.problem1373;

import utils.TreeNode;

/**
 * @author Brilliant James
 * @date 2020-03-15 22:55
 **/
public class MaxSumBSTinBT_1373 {


    private int max  = 0;
    public int maxSumBST(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root);
        return max;
    }
    private IsBSTAndValue dfs(TreeNode node) {
        if (node == null) {
            return new IsBSTAndValue(true, 0);
        }
        IsBSTAndValue left = dfs(node.left);
        IsBSTAndValue right = dfs(node.right);
        if (left.is && right.is) {
            int tempSum = 0;
            if (node.left != null) {
                if (node.left.val < node.val) {
                    tempSum += left.sum;
                } else {
                    return new IsBSTAndValue(false, 0);
                }
            }
            if (node.right != null) {
                if (node.right.val > node.val) {
                    tempSum += right.sum;
                } else {
                    return new IsBSTAndValue(false, 0);
                }
            }
            max = Math.max(max, tempSum + node.val);
            return new IsBSTAndValue(true, tempSum + node.val);
        } else {
            return new IsBSTAndValue(false, 0);
        }
    }

    private class IsBSTAndValue{
        boolean is;
        int sum;
        IsBSTAndValue(boolean isBST, int sum) {
            this.is = isBST;
            this.sum = sum;
        }
    }
}
