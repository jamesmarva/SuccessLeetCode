package leet.pro5080;

import utils.TreeNode;

import java.util.ArrayList;

/**
 * @author James
 * @program SuccessLeetCode
 * @description
 * @date 2019-10-05 22:43
 **/
public class TwoSumBSTs {

    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        if (root1 == null || root2 == null) {
            return false;
        }
        ArrayList<Integer> first = new ArrayList<>();
        inOrder(root1, first);
        ArrayList<Integer> second = new ArrayList<>();
        inOrder(root2, second);
        int firstLen = first.size();
        int secondLen = second.size();
        int left = 0;
        int right = secondLen - 1;
        while (left < firstLen && right >= 0) {
            int temp = first.get(left) + second.get(right);
            if (temp == target){
                return true;
            } else if (temp > target) {
                right--;
            } else if (temp < target) {
                left++;
            }
        }

//        left = 0;
//        right = first.size() - 1;
//        while (left <= right) {
//            int temp = second.get(left) + first.get(right);
//            if (temp == target){
//                return true;
//            } else if (temp > target) {
//                right--;
//            } else if (temp < target) {
//                left++;
//            }
//        }
        return false;
    }

    private void inOrder(TreeNode node, ArrayList<Integer> list) {
        if (node == null) {
            return;
        }
        inOrder(node.left, list);
        list.add(node.val);
        inOrder(node.right, list);
    }

    public static void main(String[] args) {
        TreeNode roo1 = new TreeNode(2);
        roo1.left = new TreeNode(1);
        roo1.right = new TreeNode(4);

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(0);
        root2.right = new TreeNode(3);
        TwoSumBSTs twoSumBSTs11 = new TwoSumBSTs();
        twoSumBSTs11.twoSumBSTs(roo1, root2, 5);

    }
}
