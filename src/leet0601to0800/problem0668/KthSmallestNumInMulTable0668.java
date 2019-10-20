package leet0601to0800.problem0668;

import leet0601to0800.problem0719.FindKthSmallestPairDistance0719;

import java.util.PriorityQueue;

/**
 * @author James
 * https://leetcode-cn.com/problems/kth-smallest-number-in-multiplication-table/
 * @date 2019-10-20 12:52
 **/
public class KthSmallestNumInMulTable0668 {


    /**
     * 最小堆，多路归并的思想
     * 超出时间限制
     */
    public int findKthNumber(int m, int n, int k) {
        if (n == 0 || m == 0) {
            return 0;
        }
        int rowSize = m;
        int columnSize = n;
        int ans = 0;
        PriorityQueue<TwoNumNode> pq = new PriorityQueue<>((o1, o2) -> o1.getProduct() - o2.getProduct());
        for (int i = 1; i <= rowSize; ++i) {
            pq.add(new TwoNumNode(i, 1));
        }
        while (k > 0 && pq.size() > 0) {
            TwoNumNode temp = pq.poll();
            ans = temp.getProduct();
            if (temp.columNum < columnSize) {
                pq.offer(new TwoNumNode(temp.rowNum, temp.columNum + 1));
            }
            k--;
        }
        return ans;
    }
    class TwoNumNode {
        int rowNum;
        int columNum;
        TwoNumNode(int rowNum, int columNum) {
            this.rowNum = rowNum;
            this.columNum = columNum;
        }
        int getProduct() {
            return rowNum * columNum;
        }
    }

    /**
     * 二分思想
     */
    public int findKthNumber1(int m, int n, int k) {
        if (n == 0 || m == 0) {
            return 0;
        }
        int rowSize = m, columnSize = n, low = 1, high = m * n;
        while (low < high) {
            int mid = low + ((high - low) >> 1);
            int count = getCountOfLessThanTarget(rowSize, columnSize, mid);
            if (count > k) {
                high = mid;
            } else if (count < k) {
                low = mid + 1;
            }
        }
        return high;
    }


    /**
     * 1    2    3    4
     * 2    4    6    8
     * 3    6    9    12
     * 4    8    12   16
     *
     */
    private int getCountOfLessThanTarget(int rowSize, int columnSize, int target) {
        int rowIndex = rowSize;
        int columnIndex = 1;
        int ans = 0;
        while (rowIndex >= 1 && columnIndex <= columnSize) {
            if (rowIndex * columnIndex <= target) {
                ans += rowIndex;
                columnIndex++;
            } else {
                rowIndex--;
            }
        }
        return ans;
    }

}
