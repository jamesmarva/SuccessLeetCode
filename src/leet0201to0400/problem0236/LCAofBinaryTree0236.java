package leet0201to0400.problem0236;

import com.sun.source.tree.Tree;
import utils.TreeNode;

import java.util.*;

/**
 * @author James
 * @program SuccessLeetCode
 * @description https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
 * @date 2019-10-10 23:23
 **/
public class LCAofBinaryTree0236 {


    List<TreeNode> list = new ArrayList<>();
    Set<TreeNode> pathP = new HashSet<TreeNode>();
    TreeNode result = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        allPath(root);
        searchP(p);
        searchQ(q);
        return result;
    }

    public void searchP(TreeNode p) {
        int indexP = list.indexOf(p);
        TreeNode preNode = p;
        pathP.add(p);
        for (int i = indexP; i >= 0; --i) {
            TreeNode tempNode = list.get(i);
            if (tempNode.left == preNode || tempNode.right == preNode) {
                pathP.add(tempNode);
                preNode = tempNode;
            }
        }
    }

    public void searchQ(TreeNode q) {
        int indexQ = list.indexOf(q);
        TreeNode preNode = q;
        for (int i = indexQ; i >= 0; --i) {
            TreeNode tempNode = list.get(i);
            if (tempNode == preNode || tempNode.left == preNode || tempNode.right == preNode) {
                if (pathP.contains(tempNode)) {
                    result = tempNode;
                    return;
                }
                preNode = tempNode;
            }
        }
        result = q;
    }

    public void allPath(TreeNode node) {
        if (node == null) {
            return;
        }
        list.add(node);
        allPath(node.left);
        allPath(node.right);
    }

    public static TreeNode lowestCommonAncestorByFatherMap(TreeNode root, TreeNode p, TreeNode q)  {
        if (root == null || p == root || q == root) {
            return root;
        }
        if (p == null) {
            return q;
        }
        if (q == null) {
            return p;
        }
        Map<TreeNode, TreeNode> fatherMap = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (queue.size() > 0) {
            int count = queue.size();
            while (count > 0) {
                TreeNode temp = queue.poll();
                if (temp.left != null) {
                    fatherMap.put(temp.left, temp);
                    queue.offer(temp.left);
                }
                if (temp.right != null){
                    fatherMap.put(temp.right, temp);
                    queue.offer(temp.right);
                }
                count--;
            }
        }
        HashSet<TreeNode> paths = new HashSet<>();
        while (p != null) {
            paths.add(p);
            p = fatherMap.get(p);
        }
        TreeNode ans = null;
        while (q != null ){
            if (paths.contains(q)) {
                ans = q;
            }
            q = fatherMap.get(q);
        }
        return ans;
    }

    public TreeNode betterLowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == root || q == root) {
            return root;
        }
        TreeNode left = betterLowestCommonAncestor(root.left, p, q);
        TreeNode right = betterLowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        if (left != null) {
            return left;
        }
        if (right != null) {
            return right;
        }
        return null;
    }
}
