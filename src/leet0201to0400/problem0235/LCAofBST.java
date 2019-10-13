package leet0201to0400.problem0235;

import utils.TreeNode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @author James
 * @program SuccessLeetCode
 * @description
 * @date 2019-10-10 23:24
 **/
public class LCAofBST {

    Queue<TreeNode> queueFirst = new LinkedList<>();
    Queue<TreeNode> queueSecond = new LinkedList<>();
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        TreeNode nodeFirst = root;
        TreeNode nodeSecond = root;
        while (nodeFirst != null || nodeSecond != null) {
            if (p.val == nodeFirst.val) {
                queueFirst.offer(nodeFirst);
            } else if (p.val > nodeFirst.val) {
                queueFirst.offer(nodeFirst);
                nodeFirst = nodeFirst.right;
            } else {
                queueFirst.offer(nodeFirst);
                nodeFirst = nodeFirst.left;
            }

            if (q.val == nodeSecond.val) {
                queueSecond.offer(nodeSecond);
            } else if (q.val > nodeSecond.val) {
                queueSecond.offer(nodeSecond);
                nodeSecond = nodeSecond.right;
            } else {
                queueSecond.offer(nodeSecond);
                nodeSecond = nodeSecond.left;
            }
            if (p.val == nodeFirst.val && q.val == nodeSecond.val) {
                break;
            }
        }
        TreeNode res = new TreeNode(0);
        while (queueFirst.size() > 0 && queueSecond.size() > 0) {
            TreeNode tempFirst = queueFirst.poll();
            TreeNode tempSecond = queueSecond.poll();
            if (tempFirst.val == tempSecond.val) {
                res = tempFirst;
            } else {
                break;
            }
        }
        return res;
    }

    //    看到一个通用的解法：
    Set<TreeNode> pathP=new HashSet<TreeNode>();
    TreeNode result=null;

    public void searchP(TreeNode t,TreeNode p){
        if(t==p){
            pathP.add(t);
            return;
        }else{
            pathP.add(t);
            if(p.val<t.val){
                searchP(t.left,p);
            }else if(p.val>t.val){
                searchP(t.right,p);
            }
        }
    }
    public void searchQ(TreeNode t,TreeNode q){
        if(t==q){
            if(pathP.contains(t)){
                result=t;
            }
            return;
        }else{
            if(pathP.contains(t)){
                result=t;
            }
            if(q.val<t.val){
                searchQ(t.left,q);
            }else if(q.val>t.val){
                searchQ(t.right,q);
            }
        }
    }
    public TreeNode commondLowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        searchP(root,p);
        searchQ(root,q);
        return result;
    }


    /**
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode bestlowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p.val <= root.val && q.val >= root.val) {
            return root;
        }else if(p.val >= root.val && q.val <= root.val) {
            return root;
        }else if(p.val <= root.val && q.val <= root.val) {
            return lowestCommonAncestor(root.left, p, q);
        }else {
            return lowestCommonAncestor(root.right, p, q);
        }
    }
}
