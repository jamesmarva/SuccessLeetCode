package sward;

import utils.TreeNode;

/**
 * https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof/
 * @author Brilliant James
 * @date 2020-05-02 05:25
 **/
public class Problem_007 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildNode(0, preorder.length - 1, 0, inorder.length - 1, preorder, inorder);
    }

    public TreeNode buildNode(int preStart, int preEnd, int inStart, int inEnd, int[] preArr, int[] inArr) {
        if (preStart > preEnd) {
            return null;
        }
        int rootVal = preArr[preStart];
        TreeNode root = new TreeNode(rootVal);
        int inIndex = inStart;
        for (; inIndex <= inEnd; inIndex++) {
            if (inArr[inIndex] == rootVal) {
                break;
            }
        }
        int leftChildTreeSize = inIndex - inStart;
        root.left = buildNode(preStart + 1, preStart + leftChildTreeSize, inStart, inIndex - 1, preArr, inArr);
        root.right = buildNode(preStart + leftChildTreeSize + 1, preEnd, inIndex + 1, inEnd, preArr, inArr);
        return root;
    }
}
