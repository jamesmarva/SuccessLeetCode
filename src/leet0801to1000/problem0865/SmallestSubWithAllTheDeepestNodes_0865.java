package leet0801to1000.problem0865;

import utils.TreeNode;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/smallest-subtree-with-all-the-deepest-nodes/
 * 865. 具有所有最深结点的最小子树
 *
 * @author Brilliant James
 * @date 2020-03-28 12:49
 **/
public class SmallestSubWithAllTheDeepestNodes_0865 {

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        if (root == null) {
            return root;
        }
        Map<TreeNode, TreeNode> fatherMap = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        LinkedList<TreeNode> lastLevelNodes = new LinkedList<>();
        queue.offer(root);
        while (queue.size() > 0) {
            int count = queue.size();
            lastLevelNodes.clear();
            while (count > 0) {
                TreeNode t = queue.poll();
                lastLevelNodes.add(t);
                if (t.left != null) {
                    queue.offer(t.left);
                    fatherMap.put(t.left, t);
                }
                if (t.right != null) {
                    queue.offer(t.right);
                    fatherMap.put(t.right, t);
                }
                count--;
            }
        }
        if (lastLevelNodes.size() == 1) {
            return lastLevelNodes.removeFirst();
        }
        Set<TreeNode> set = new HashSet<>();
        TreeNode first = lastLevelNodes.removeFirst();
        while (first != null) {
            set.add(first);
            first = fatherMap.get(first);
        }
        TreeNode res = root;
        while (lastLevelNodes.size() > 0) {
            TreeNode t = lastLevelNodes.removeFirst();
            while (t != null) {
                if (set.contains(t)) {
                    res = t;
                    break;
                }
                t =  fatherMap.get(t);
            }
        }
        return res;
    }
}
