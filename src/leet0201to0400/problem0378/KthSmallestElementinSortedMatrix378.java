package leet0201to0400.problem0378;

import leet.code2019.august.ArrayNesting565;

import java.util.PriorityQueue;

/**
 * @author James
 * @program SuccessLeetCode
 * @description https://leetcode-cn.com/problems/kth-smallest-element-in-a-sorted-matrix/
 * @date 2019-10-19 16:04
 **/
public class KthSmallestElementinSortedMatrix378 {

    public static int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(k);
        int res = 0;
        for (int i = 0, len = matrix.length; i < len; ++i) {
            for (int j = 0, lenSec =matrix[0].length; j < lenSec; ++j) {
                queue.add(matrix[i][j]);
                if (queue.size() > k)  {
                    queue.poll();
                }
            }
        }
        res = queue.poll();
        return res;
    }

    public int kthSmallestBetter(int[][] matrix, int k) {
        int rowLen = matrix.length;
        int columnLen = matrix[0].length;
        int low = matrix[0][0], high = matrix[rowLen -  1][columnLen - 1];
        while (low < high) {
            int mid = low + ((high - low) >> 1);
            int count = findCountOfLessThanValue(matrix, mid, rowLen, columnLen);
            if (count < k) {
                low = mid + 1;
            } else if (count >= k) {
                high = mid;
            }
        }
        return high;
    }

    private int findCountOfLessThanValue(int[][] matrix, int value, int row, int column) {
        int i = 0, j = column - 1, ans = 0;
        while (i <= row - 1 && j >= 0) {
            if (matrix[i][j] <= value) {
                ans += j+1;
                i++;
            } else {
                j--;
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        int[][] matrix = { { 1,  5,  9}, {10, 11, 13}, {12, 13, 15}};
        KthSmallestElementinSortedMatrix378 kthSmallestElementinSortedMatrix378 = new KthSmallestElementinSortedMatrix378();
        kthSmallestElementinSortedMatrix378.kthSmallestBetter(matrix, 8);
//        kthSmallest(matrix, 8);
    }

    class Solution {
        public int kthSmallest(int[][] matrix, int k) {
            int n = matrix.length;
            int m = matrix[0].length;
            int low = matrix[0][0], high = matrix[n -  1][m - 1];
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (lessNum(matrix, mid) >= k) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            return low;
        }

        private int lessNum(int[][] matrix, int val) {
            int n = matrix.length;
            int m = matrix[0].length;
            int p = 0;
            int ans = 0;
            for (int i = n - 1; i >= 0; -- i) {
                while (p < m && matrix[i][p] <= val) {
                    p ++ ;
                }
                ans += p;
            }
            return ans;
        }
    }
}
