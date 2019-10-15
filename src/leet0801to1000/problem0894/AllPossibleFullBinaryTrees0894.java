package leet0801to1000.problem0894;

import com.sun.source.tree.Tree;
import utils.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author James
 * @program SuccessLeetCode
 * @description https://leetcode-cn.com/problems/all-possible-full-binary-trees/
 *
 * @date 2019-10-13 19:14
 **/
public class AllPossibleFullBinaryTrees0894 {

    public List<TreeNode> allPossibleFBT(int N) {
        List<TreeNode> list = new ArrayList<TreeNode>();
        //节点数为1时，直接返回根节点
        if (N == 1) {
            list.add(new TreeNode(0));
            return list;
        }
        for(int i = 1; i < N; i+=2) {
            // 左节点数为i的所有满二叉树组合
            List<TreeNode> lefts = allPossibleFBT(i);
            // 右节点数为N-i-1的所有满二叉树组合
            List<TreeNode> rights = allPossibleFBT(N - i - 1);
            for(TreeNode l : lefts) {
                for(TreeNode r : rights) {
                    //遍历左右子树的组合，排列出所有树
                    TreeNode root = new TreeNode(0);
                    root.left = l;
                    root.right = r;
                    list.add(root);
                }
            }
        }
        return list;
    }

    Map<Integer, List<TreeNode>> memory = new HashMap<>();

    /**
     * FBT(i) = FBT(0, ..., i - 1) + FBT(N - i - 1);
     * @param N
     * @return
     */
    public List<TreeNode> allPossibleFBTBetter(int N) {
        if (memory.get(N) != null) {
            return memory.get(N);
        }
        ArrayList<TreeNode> ans = new ArrayList<>();
        if (N == 1) {
            ans.add(new TreeNode(0));
            return ans;
        }
        for (int i = 1; i < N; i += 2) {
            List<TreeNode> leftNodes = allPossibleFBTBetter(i);
            List<TreeNode> rightNodes = allPossibleFBTBetter(N - i - 1);
            for (TreeNode leftItem : leftNodes) {
                for (TreeNode rightItem : rightNodes) {
                    TreeNode root = new TreeNode(0);
                    root.left = leftItem;
                    root.right = rightItem;
                    ans.add(root);
                }
            }
        }
        memory.put(N, ans);
        return ans;
    }

    public List<TreeNode> allPossibleFBTMine(int N) {
        ArrayList<TreeNode> ans = new ArrayList<>();
        if (N == 1) {
            ans.add(new TreeNode(0));
            return ans;
        }
        for (int i = 1; i < N; i += 2) {
            List<TreeNode> leftNodes = allPossibleFBTMine(i);
            List<TreeNode> rightNodes = allPossibleFBTMine(N - i - 1);
            for (TreeNode leftItem : leftNodes) {
                for (TreeNode rightItem : rightNodes) {
                    TreeNode rootTemp = new TreeNode(0);
                    rootTemp.left = leftItem;
                    rootTemp.right = rightItem;
                    ans.add(rootTemp);
                }
            }
        }
        return ans;
    }
}
