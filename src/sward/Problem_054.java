package sward;

import utils.TreeNode;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof/
 * 面试题54. 二叉搜索树的第k大节点
 * @author Brilliant James
 * @date 2020-03-26 19:14
 **/
public class Problem_054 {


    public int kthLargest(TreeNode root, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        preOrder(root, minHeap, k);
        return minHeap.poll();
    }
    private void preOrder(TreeNode t, PriorityQueue<Integer> q, int k) {
        if (t == null) {
            return;
        }
        q.offer(t.val);
        if (q.size() > k) {
            q.poll();
        }
        preOrder(t.left, q, k);
        preOrder(t.right, q, k);
    }

    LinkedList<Integer> list = new LinkedList<>();

    /**
     * 构造排好序的数组，然后倒数第k数。
     * 时间复杂度；O(n)
     * 空间复杂度：O(n)
     * @param root
     * @param k
     * @return
     */
    public int kthLargest1(TreeNode root, int k) {
        inOrder(root);
        if (list.size() < k) {
            throw new IllegalArgumentException("k is too large.");
        }
        return list.get(list.size() - k);
    }

    private void inOrder(TreeNode t) {
        if (t == null) {
            return;
        }
        inOrder(t.left);
        list.add(t.val);
        inOrder(t.right);
    }

    public static void main(String[] args) {
        PriorityQueue<Integer> min = new PriorityQueue<>();
        min.offer(10000);
        min.offer(11);
        min.offer(1111);
        while (min.size() > 0) {
            System.out.println(min.poll());
        }
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((o1, o2)->{
            return o2-o1;
        });

        minHeap.offer(10000);
        minHeap.offer(11);
        minHeap.offer(1111);
        while (minHeap.size() > 0) {
            System.out.println(minHeap.poll());
        }
    }
}
