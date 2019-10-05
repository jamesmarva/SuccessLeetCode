package leet1001to1200.problem1123;

import utils.TreeNode;

import java.util.*;

/**
 * @author James
 * @program SuccessLeetCode
 * @description https://leetcode-cn.com/problems/lowest-common-ancestor-of-deepest-leaves/
 *
 * @date 2019-10-05 09:45
 **/
public class LCAofDeepestLeaves1123 {



    public static TreeNode lcaDeepestLeaves(TreeNode root) {
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        ArrayList<TreeNode> lastNodes = new ArrayList<>();
        while (queue.size() > 0) {
            int count = queue.size();
            ArrayList<TreeNode> tempLastNode = new ArrayList<>();
            while (count > 0) {
                TreeNode temp = queue.poll();
                tempLastNode.add(temp);
                if (temp.left != null) {
                    parentMap.put(temp.left, temp);
                    queue.offer(temp.left);
                }
                if (temp.right != null ){
                    parentMap.put(temp.right, temp);
                    queue.offer(temp.right);
                }
                count--;
            }
            if (queue.size() == 0) {
                lastNodes = tempLastNode;
            }
        }

        if (lastNodes.size() == 1) {
            return lastNodes.get(0);
        }
        HashSet<TreeNode> paths = new HashSet<>();
        TreeNode node = lastNodes.remove(0);
        while (node != null) {
            paths.add(node);
            node = parentMap.get(node);
        }
        TreeNode ans = null;
        for (int i = 0, len = lastNodes.size(); i < len; ++i){
            TreeNode temp = lastNodes.get(i);
            while (temp != null ){
                if (paths.contains(temp)) {
                    ans = temp;
                }
                temp = parentMap.get(temp);
            }
        }
        return ans;
    }

    private TreeNode dfs(TreeNode node) {
        if (node == null) {
            return null;
        }

        TreeNode lefChild = dfs(node.left);
        TreeNode rightChild = dfs(node.right);
//        if (lefChild == )
        return null;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        lcaDeepestLeaves(root);
    }
}
