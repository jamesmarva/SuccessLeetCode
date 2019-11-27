package leet0001to0200.problem0088;

/**
 * @author James
 * @date 2019-11-28 00:54
 **/
public class MergeSortedArray_0088 {


    /**
     * 归并思想
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] tempNums = new int[m];
        for (int i = 0; i < m; i++) {
            tempNums[i] = nums1[i];
        }
        int index1 = 0;
        int index2 = 0;
        int index = 0;
        while (index1 < m && index2 < n) {
            if (tempNums[index1] < nums2[index2]) {
                nums1[index] = tempNums[index1];
                index1++;
            } else {
                nums1[index] = nums2[index2];
                index2++;
            }
            index++;
        }
        while (index1 < m) {
            nums1[index] = tempNums[index1];
            index1++;
            index++;
        }
        while (index2 < n) {
            nums1[index] = nums2[index2];
            index2++;
            index++;
        }
    }



    public void merge_1(int[] nums1, int m, int[] nums2, int n) {
        int index = m + n - 1;
        int index1 = m - 1;
        int index2= n - 1;
        while (index1 >= 0 && index2 >= 0) {
            if (nums1[index1] < nums2[index2]) {
                nums1[index] = nums2[index2];
                index2--;
            } else {
                nums1[index] = nums1[index1];
                index1--;
            }
            index--;
        }
        while (index1 >= 0) {
            nums1[index] = nums1[index1];
            index1--;
            index--;
        }
        while (index2 >= 0) {
            nums1[index] = nums2[index2];
            index2--;
            index--;
        }
    }
}
