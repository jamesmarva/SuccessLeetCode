package leet1201to1400.problem1367;


import utils.ListNode;
import utils.TreeNode;

/**
 * https://leetcode-cn.com/problems/linked-list-in-binary-tree/
 */
public class LinkedListInBinaryTree_1367  {

    public boolean isSubPath(ListNode head, TreeNode root) {
        if (head == null) {
            return false;
        }
        dfs(root, head);
        return res;
    }
    private boolean res = false;

    private void dfs(TreeNode node, ListNode head) {
        if (res) {
            return;
        }
        if (head == null) {
            return;
        }
        if (node.val == head.val) {
            if (match(node, head)) {
                res = true;
                return;
            }
        }
        dfs(node.left, head);
        dfs(node.right, head);
    }

    private boolean match(TreeNode t, ListNode l) {
        if (l == null) {
            return true;
        }
        if (t == null) {
            return false;
        }
        if (t.val == l.val) {
            return match(t.left, l.next) || match(t.right, l.next);
        } else {
            return false;
        }
    }
}
