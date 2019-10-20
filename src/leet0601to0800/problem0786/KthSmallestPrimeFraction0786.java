package leet0601to0800.problem0786;

import leet0601to0800.problem0719.FindKthSmallestPairDistance0719;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author James
 * https://leetcode-cn.com/problems/k-th-smallest-prime-fraction/
 * @date 2019-10-20 13:47
 **/
public class KthSmallestPrimeFraction0786 {

    /**
     * 堆思想试试
     *    5   3   2   1
     * 1  1/5 3/5 2/5
     * 2  2/5 2/3
     * 3  3/5
     * 5
     */
    public int[] kthSmallestPrimeFraction(int[] A, int K) {
        PriorityQueue<TwoNumNode> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1.getDivisor(A) > o2.getDivisor(A)) {
                return 1;
            } else if (o1.getDivisor(A) < o2.getDivisor(A)) {
                return -1;
            } else {
                return 0;
            }
        });
        int len = A.length;
        for (int i = 0; i <= len - 2; ++i) {
            pq.offer(new TwoNumNode(i, len - 1));
        }
        int[] ans = new int[2];
        while (K > 0 && pq.size() > 0) {
            TwoNumNode temp = pq.poll();
            ans[0] =A[temp.first];
            ans[1] = A[temp.second];
            if (temp.second - 1 > temp.first) {
                pq.offer(new TwoNumNode(temp.first, temp.second - 1));
            }
            K--;
        }
        return ans;
    }

    class TwoNumNode {
        int first;
        int second;
        TwoNumNode(int first, int second) {
            this.first = first;
            this.second = second;
        }
        double getDivisor(int[] arr) {
            return (arr[first] * 1.0) / (arr[second] * 1.0);
        }
    }

    /**
     * 我自己实现的二分法解决题目
     */
    public int[] kthSmallestPrimeFraction1(int[] A, int K) {
        double low = 0, high = 1, mid;
        int[] tempAns = new int[3];
        int[] ans = new int[2];
        while (high - low > 1e-9) {
            mid = low + (high - low) / 2.0;
            tempAns = findCountOfLessThanTarget(A, mid);
            if (tempAns[2] < K) {
                low = mid;
            } else {
                high = mid;
                ans[0] = tempAns[0];
                ans[1] = tempAns[1];
            }
//            else if (tempAns[2] < K) {
//                low = mid;
//            } else {
//                break;
//            }
        }
        return ans;

    }
    /**
     * 二分思想
     *    5   3   2   1
     * 1  1/5 3/5 2/5
     * 2  2/5 2/3
     * 3  3/5
     * 5
     */
    private int[] findCountOfLessThanTarget(int[] arr, double target) {
        int len = arr.length, rowIndex = len - 2, top = 0, bottom = 1;
        int[] ans = new int[3];
//        while (rowIndex >= 0 && columnIndex <= len - 2) {
//            if (arr[rowIndex] * 1.0 / arr[columnIndex] * 1.0 < target) {
//                ans[2] += rowIndex + 1;
//                rowIndex--;
//                columnIndex--;
//            } else {
//                rowIndex--;
//            }
//        }
        for (int i = 0; i <= len - 2 && rowIndex >= 0; ++i) {
            while (rowIndex >= 0 && (arr[rowIndex] * 1.0) / (arr[len - 1 - i] * 1.0) > target) {
                rowIndex--;
            }
            ans[2] += rowIndex + 1;
            if (rowIndex >= 0 && (arr[rowIndex] * 1.0) / (arr[len - 1 - i] * 1.0) <= target
                    && arr[top] * 1.0 / arr[bottom] * 1.0 <= (arr[rowIndex] * 1.0) / (arr[len - 1 - i] * 1.0)) {
                top = rowIndex;
                bottom = len - 1 - i;
            }
            rowIndex--;
        }
        ans[0] = top;
        ans[1] = bottom;
        return ans;
    }

    public static void main(String[] args) {
        int[] test = {1,2,3,5};
//        [1,2,3,5]
        int test1=3;
        KthSmallestPrimeFraction0786 kthSmallestPrimeFraction0786 = new KthSmallestPrimeFraction0786();
        int[] result = kthSmallestPrimeFraction0786.kthSmallestPrimeFraction1(test,3);
        System.out.println(Arrays.toString(result));
    }

    /**
     *
     */
    public int[] kthSmallestPrimeFraction2(int[] A, int K) {
        // 因为分数是在(0,1)范围内，所以在此范围使用二分查找
        double lo = 0, hi = 1, mid;
        int p = 0, q = 1;
        int i, j;
        int count;
        // 因为是在小数内使用二分查找，无法像在整数范围内那样通过 mid+1和边界判断来终止循环
        // 所以此处根据count来结束循环
        while (true) {
            mid = (lo + hi) / 2;
            count = 0;
            p = 0;
            for (i = 0; i < A.length; i++) {
                j = 0;
                while (j < A.length-1-i && mid >= (double) A[i]/A[A.length-1-j]) {
                    j++;
                }
                count += j;
                // 重点：每次都记录 p/q是比 mid小的数中的最大值(所有行)
                if (j > 0 && ((double)p/q) < ((double)A[i]/A[A.length-j])) {
                    p = A[i];
                    q = A[A.length-j];
                }
            }
            if (count > K) {
                hi = mid;
            } else if (count < K) {
                lo = mid;
            } else {
                return new int[]{p, q};
            }
        }
    }

    public int[] kthSmallestPrimeFraction3(int[] A, int K) {
        double left = 0, right = 1, mid;
        int top = 0, bottom = 1, n = A.length, number;
        while (true) {
            mid = (left + right) / 2.0;
            number = 0;
            top = 0;
            for (int i = 0, j = 1; i < n; i++) {
                while (j < n && A[i] > mid * A[j]) {
                    j++;
                }
                number += n - j;
                if (number > K) {
                    break;
                }
                // 以A[i]为分子，比mid小的分数个数
                if (j < n && top / bottom < A[i] / A[j]) {
                    top = A[i];
                    bottom = A[j];
                }
            }
            if (number == K) {
                int[] temp = {top, bottom};
                return temp;
            }
            if (number < K) {
                left = mid;
            } else {
                right = mid;
            }
        }
    }

    public int[] kthSmallestPrimeFraction4(int[] A, int K) {
        double lo = 0.0, hi = 1.0;
        int[] ans = {-1, -1};
        while (hi-lo > 1e-9) {
            // 一直压缩精确度到1e-9
            double mid = lo + (hi - lo) / 2.0;
            int[] res = under(A, mid);
            if (res[2] < K) {
                lo = mid;
            } else {
                hi = mid;
                ans[0] = res[0];
                ans[1] = res[1];
            }
        }
        return ans;
    }

    private int[] under(int[] A, double bound) {
        // 计算有多少数小于bound
        int mol = 0, deno = 1, count = 0, i = -1;
        for (int j = 1; j < A.length; j++) {
            while (A[i + 1] < bound * A[j]) {
                i++;
            }
            count += i + 1;
            if (i >= 0 && mol * A[j] < deno * A[i]) {
                mol = A[i];
                deno = A[j];
            }
        }
        return new int[]{mol, deno, count};
    }

    /**
     * 方法一：TopN问题，最笨的方法，两层for循环遍历出所有的组合，然后用堆排序
     * 思路：创建一个类Data存放每个组合的分子、分母、小数，两层for循环遍历组合x，放入最大堆
     * 如果x<堆中最大的数heap[0],证明heap[0]不是第K个最小的分数，所以替换
     * 无难点，把堆排序中的data替换成Data即可
     * 693ms击败18%，156.3MB击败47.06%
     *
     * 方法二：二分查找，利用本题规律，已经有序，真分数
     * 思路参考：https://blog.csdn.net/q839219286/article/details/92777482
     * 代码参考：https://blog.csdn.net/qq_41855420/article/details/90136985
     * 例子：1 2 3 4 5 6
     * 1/2   1/3   1/4   1/5   1/6
     * 2/3   2/4   2/5   2/6
     * 3/4   3/5   3/6
     * 4/5   4/6
     * 5/6
     * 基本上还是要遍历所有的组合，但是又不用全部遍历，有规律
     * 以0，1为开始，以0.5分界，
     * 如果找到的小于0.5的数number>K证明范围大了，则以0.25分界范围寻找
     * 同理若number<K则以0.75分界寻找
     * 如果number==K证明刚好找到了，  最大  的那个数就是最小的第K个数
     * 记住！！！我们一直都是找分界线左边的数量number，所以左边最大的数就是最小的第K个数
     *
     * 分子i和分母j从0和1开始遍历，i不变时j增大分子不变分母变大分数x↓，在j不变时i增大则分母不变分子增大分数x↑
     * 步骤一：以分子递增外循环，分母递增内循环，一旦内循环出现分数x<=mid则后面的数全都x<=mid所以break内循环
     * 步骤二：外循环分子增大后，分母不变所以分数x增大，比上一层的终点还要大，所以同理只需要往后找到步骤一的条件继续break
     * 记录每层<mid的数number，
     * 并且每层的终点是最大的数，判断是否是最大的分数然后替换
     * 8ms击败98%，39MB击败76.47%
     *
     * 此方法是i和j从小到大，i和j从大到小也可以完成
     *
     * 细节（全是方法二）
     * 细节一：mid只是为了分界不断的变化，所以最外层有个while(true)一直重新遍历i和j
     * 细节二：用top和bottom记录找到的最大的分数，每层终点比较并且替换，因为每层的终点不一定是最大的分数
     * 细节三：例子1/2  1/3  1/4  1/5  1/6找到1/3<0.5所以是终点，
     * 所以1/3  1/4  1/5  1/6都满足，所以符合的个数是n-j
     * 细节四：判断a/b<c/d可以直接转化为a*d<b*c，这样就不需要转换为double可以直接计算
     * 细节五：每次新的分界点就把数量number归0，记录的最大的分数的top归0即默认分数为0
     * 细节六：如果中途找到number>K证明肯定范围大了，直接退出i循环重新调整分界
     * @author ASUS
     *
     */
}
