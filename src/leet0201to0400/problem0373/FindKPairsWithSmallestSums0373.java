package leet0201to0400.problem0373;

import leet0601to0800.problem0719.FindKthSmallestPairDistance0719;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author James
 * @program SuccessLeetCode
 * @description
 * @date 2019-10-19 17:33
 **/
public class FindKPairsWithSmallestSums0373 {

    /**
     * 最小堆 的思想
     * @param nums1
     * @param nums2
     * @param k
     * @return
     */
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
//        PriorityQueue<TwoNumNode> priorityQueue = new PriorityQueue<>((o1, o2) -> {
//            if (o1.getSum() < o2.getSum()) {
//                return -1;
//            } else if (o1.getSum() > o2.getSum()) {
//                return 1;
//            } else {
//                return 0;
//            }
//        });

        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0 ) {
            return new ArrayList<>();
        }
        PriorityQueue<TwoNumNode> priorityQueue = new PriorityQueue<>((o1, o2) -> o1.getSum() - o2.getSum());
        for (int i = 0, len = nums1.length; i < len; ++i) {
            for (int j = 0, len2 = nums2.length; j < len2; ++j) {
                priorityQueue.add(new TwoNumNode(nums1[i], nums2[j]));
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        while (k > 0 && priorityQueue.size() > 0) {
            TwoNumNode temp = priorityQueue.poll();
            ans.add(Arrays.asList(temp.num1, temp.num2));
        }
        return ans;
    }

    class TwoNumNode {
        int num1;
        int num2;
        TwoNumNode(int num1, int num2) {
            this.num1 = num1;
            this.num2 = num2;
        }
        int getSum() {
            return num1 + num2;
        }

    }

    class TwoIndexNode {
        int index1;
        int index2;
        TwoIndexNode(int index1, int index2) {
            this.index1 = index1;
            this.index2 = index2;
        }
        int getSum(int nums1[], int nums2[]) {
            return  nums1[index1] + nums2[index2];
        }
    }

    /**
     * 多路归并的思想
     * @param nums1
     * @param nums2
     * @param k
     * @return
     */
    public List<List<Integer>> kSmallestPairsBetter(int[] nums1, int[] nums2, int k) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new ArrayList<>();
        }
        int numsLength = nums2.length;
        PriorityQueue<TwoIndexNode> priorityQueue = new PriorityQueue<>(
                (o1, o2) -> o1.getSum(nums1, nums2) - o2.getSum(nums1, nums2));
        for (int i = 0, len = nums1.length; i < len; i++) {
            priorityQueue.add(new TwoIndexNode(i, 0));
        }
        List<List<Integer>> ans = new ArrayList<>();
        while (k > 0 && priorityQueue.size() > 0) {
            TwoIndexNode temp = priorityQueue.poll();
            ans.add(Arrays.asList(nums1[temp.index1], nums2[temp.index2]));
            if (temp.index2 + 1 < numsLength) {
                priorityQueue.offer(new TwoIndexNode(temp.index1, temp.index2 + 1));
            }
            k--;
        }
        return ans;
    }
}
