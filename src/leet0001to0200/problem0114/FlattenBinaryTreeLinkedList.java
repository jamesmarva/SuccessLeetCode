package leet0001to0200.problem0114;

import utils.TreeNode;

/**
 *
 * @author Brilliant James Jamesmarva1993@gmail.com 2021-12-06 20:58
 **/
public class FlattenBinaryTreeLinkedList {

    public void flatten(TreeNode root) {
        root = deal(root);
    }

    /**
     * 这个解法是最接近我的思路的
     * 0. 把 左子点 和 右子点 分别存入临时节点
     * 1. 把 右子节点 等于 处理左子节点的结果
     * 2. 然后把左子点设为 null
     * 3. 遍历到最右的子节点，然后把最右的子节点的设置成 处理临时右子节点的结果
     */
    public TreeNode deal(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode tmpRight = root.right;
        TreeNode tmpLeft = root.left;
        root.left = null;
        root.right = deal(tmpLeft);

        TreeNode idx = root;

        while(idx.right!=null){
            idx = idx.right;
        }
        idx.right = deal(tmpRight);
        return root;
    }


    public TreeNode transver(TreeNode root){
        if(root == null){
            return null;
        }
        TreeNode left = root.left;

        TreeNode right = root.right;

        root.left = null;

        root.right=transver(left);

        TreeNode next = root;

        while(next.right!=null){
            next=next.right;
        }
        next.right=transver(right);
        return root;
    }
}
