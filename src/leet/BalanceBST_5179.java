package leet;

import utils.TreeNode;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.TreeMap;

/**
 * @author Brilliant James
 * @date 2020-03-15 20:16
 **/
public class BalanceBST_5179 {

    private ArrayList<Integer> list = new ArrayList<>();

    public TreeNode balanceBST(TreeNode root) {
        if (root == null) {
            return root;
        }
        inOrder(root);
        return buildBST(0, list.size() - 1);
    }

    private void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        list.add(node.val);
        inOrder(node.right);
    }

    private TreeNode buildBST(int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = start + ((end - start) >> 1);
        TreeNode res = new TreeNode(list.get(mid));
        res.left = buildBST(start, mid - 1);
        res.right = buildBST(mid + 1, end);
        return res;
    }
}
