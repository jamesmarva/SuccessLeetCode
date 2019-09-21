package leet0801to1000.problem0852;

/**
 * @program: SuccessLeetCode
 * @description: https://leetcode-cn.com/problems/peak-index-in-a-mountain-array/
 * @author: James
 * @create: 2019-09-15 14:05
 **/
public class PeakIndexInMountainArray0852 {

    public int peakIndexInMountainArray(int[] A) {
        int length = A.length;
        int maxIndex = 0;
        for (int i = 0; i < length; i++) {
            if (i == length - 1) {
                return i;
            }
            if (A[i] < A[i + 1]) {
                continue;
            } else {
                maxIndex = i;
                break;
            }
        }

        return maxIndex;

    }
}
