package leet0201to0400.problem0321;

import java.util.Arrays;

/**
 * @program: SuccessLeetCode
 * @description: https://leetcode-cn.com/problems/create-maximum-number/
 *
 * 不理解啊。。我操。。。。
 * @author: James
 * @create: 2019-09-17 20:39
 **/
public class CreateMaxNumber0321 {

    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int len1= nums1.length;
        int len2 = nums2.length;
        int index1 = 0;
        int index2 = 0;
        int[] res = new int[k];
        for (int i = 0; i < k; ++i) {
            int count = k - i;
            int maxIndex1 = len1 - Math.max(1, count - (len2 - index2)) + 1;
            int tempIndex1 = index1;
            boolean isOne = false;
            int maxValue = -1;
            for (int j = 0; index1 + j < maxIndex1; ++j) {
                if (maxValue < nums1[index1 + j]) {
                    tempIndex1 = index1 + j;
                    isOne = true;
                    maxValue = nums1[index1 + j];
                }
            }
            int maxIndex2 = len2 - Math.max(1, count - (len1 - index1)) + 1;
            int tempIndex2 = index2;
            for (int j = 0; index2 + j < maxIndex2; ++j) {
                if (maxValue < nums2[index2 + j]) {
                    tempIndex2 = index2 + j;
                    isOne = false;
                    maxValue = nums2[index2+ j];
                }
            }
            if (isOne) {
                res[i] = maxValue;
                index1 = tempIndex1 + 1;
            } else {
                res[i] = maxValue;
                index2 = tempIndex2 + 1;
            }
        }
        return res;
    }


    public int[] maxNumberBetter(int[] nums1, int[] nums2, int k) {
        int[] max = null;
        for(int i = Math.max(k - nums2.length, 0); i <= Math.min(nums1.length, k); i++) {

            int[] merged = merge(max(nums1, i), max(nums2, k - i));
            if (max == null || greater(merged, 0, max, 0)) {
                max = merged;
            }
        }
        return max;
    }

    private int[] max(int[] nums, int k) {
        int[] max = new int[k];

        for(int i=0, j=0; i < nums.length; i++) {

            while (j>0 && k-j < nums.length - i && max[j-1] < nums[i]) {
                j--;
            }

            if (j<k) {
                max[j++] = nums[i];
            }
        }
        return max;
    }

    private int[] merge(int[] nums1, int[] nums2) {
        int[] merged = new int[nums1.length + nums2.length];
        for(int i=0, j=0, m=0; m<merged.length; m++) {
            merged[m] = greater(nums1, i, nums2, j) ? nums1[i++] : nums2[j++];
        }
        return merged;
    }

    //
    private boolean greater(int[] nums1, int i, int[] nums2, int j) {
        while (i < nums1.length && j < nums2.length && nums1[i] == nums2[j]) {
            i++;
            j++;
        }
        // 要么相等，要么就是nums1 大于 nums2
        if (j == nums2.length || (i < nums1.length && nums1[i] > nums2[j])) {
            return true;
        }
        return false;
    }


    public static void main(String[] args) {
        int[]  test = {3,4,6,5};
        int[] test1=  {9,1,2,5,8,3};
        CreateMaxNumber0321 createMaxNumber0321 = new CreateMaxNumber0321();
        int[] res = createMaxNumber0321.maxNumber(test, test1, 5);
        System.out.println(Arrays.toString(res));
    }

}
