package leet0001to0200.problem0173;

import com.sun.source.tree.Tree;
import utils.TreeNode;

import java.util.LinkedList;

/**
 * @author James
 * @date 2019-12-03 21:04
 **/
public class BSTIterator {

    private LinkedList<TreeNode> list;

    public BSTIterator(TreeNode root) {
        list = new LinkedList<>();
        inOrder(root, list);
    }

    /** @return the next smallest number */
    public int next() {
        return list.removeFirst().val;
    }

    private void inOrder(TreeNode node, LinkedList<TreeNode> list) {
        if (node == null) {
            return;
        }
        inOrder(node.left, list);
        list.add(node);
        inOrder(node.right, list);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !list.isEmpty();
    }
}
