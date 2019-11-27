package leet0001to0200.problem0004;

/**
 * 4. 寻找两个有序数组的中位数
 * https://leetcode-cn.com/problems/median-of-two-sorted-arrays/
 * @author James
 * @date 2019-11-25 21:19
 **/
public class MedianOfTwoSortedArrays_0004 {
    /**
     * 并操作，吧两个
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return 0;
        }
        int len1 = nums1.length;
        int len2 = nums2.length;
        int lenAll = len1 + len2;
        int[] newArr = new int[lenAll];
        int index1 = 0;
        int index2 = 0;
        int j = 0;
        while (index1 < len1 && index2 < len2) {
            if (nums1[index1] < nums2[index2]) {
                newArr[j] = nums1[index1];
                index1++;
            } else {
                newArr[j] = nums2[index2];
                index2++;
            }
            j++;
        }
        while (index1 < len1) {
            newArr[j] = nums1[index1];
            index1++;
            j++;
        }
        while (index2 < len2) {
            newArr[j] = nums2[index2];
            index2++;
            j++;
        }
        int half = lenAll / 2;
        if (lenAll % 2 == 1) {
            return newArr[half + 1];
        } else {
            return (newArr[half] + newArr[half + 1]) / 2.0;
        }
    }

    public double findMedianSortedArrays_1(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return 0.0;
        }
        int len1 = nums1.length;
        int len2 = nums2.length;
        if (len1 > len2) {
            return findMedianSortedArrays_1(nums2, nums1);
        }
        int low = 0;
        int high = len1;
        while (low <= high) {
            int i = low + ((high - low) >> 1);
            int j = (len1 + len2 + 1) / 2 - i;
            if (i > 0 && j < len2 && nums1[i - 1] > nums2[j]) {
                high = i - 1;
            } else if (j > 0 && i < len1 && nums1[i] < nums2[j - 1]) {
                low = i + 1;
//          nums[i - 1] < nums[j] && nums[i] > nums[j - 1]
            } else {
                int leftMax= 0;
                if (i == 0) {
                    leftMax = nums2[j - 1];
                } else if (j == 0) {
                    leftMax = nums1[i - 1];
                } else {
                    leftMax = Math.max(nums1[i - 1], nums2[j - 1]);
                }
                if ((len1 + len2) % 2 == 1) {
                    return leftMax;
                }

                int rightMax = 0;
                if (i == len1) {
                    rightMax = nums2[j];
                } else if (j == len2) {
                    rightMax = nums1[i];
                } else {
                    rightMax = Math.min(nums1[i], nums2[j]);
                }
                return (leftMax + rightMax) / 2.0;
            }
        }
        return 0.0;
    }

    public static void main(String[] args) {
        int[] num1 = {2};
        int[] num2 = {1, 3};
        MedianOfTwoSortedArrays_0004 medianOfTwoSortedArrays_0004 = new MedianOfTwoSortedArrays_0004();
        medianOfTwoSortedArrays_0004.findMedianSortedArrays_1(num1, num2);

    }
}
