package ebay;

/**
 * @author Brilliant James
 * @date 2020-04-22 06:27
 **/
public class Pro_0004 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 ==null || nums1.length == 0 || nums2.length == 0) {
            return 0.0;
        }
        int len1 = nums1.length;
        int len2 = nums2.length;
        if (len1 > len2) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
            len1 = nums1.length;
            len2 = nums2.length;
        }
        int lo = 0;
        int hi = len1;
        //
        int mid1, mid2;
        int leftSize = (len1 + len2 + 1) / 2;
        while (lo < hi) {
            mid1 = lo + ((hi - lo) >> 1);
            mid2 = leftSize - mid1;
            if (nums1[mid1] < nums2[mid2 - 1]) {
                lo = mid1 + 1;
            } else {
                hi = mid1;
            }
        }
        mid1 = lo;
        mid2 = leftSize - mid1;
        int num1Small = Integer.MIN_VALUE;
        int num1Big = Integer.MAX_VALUE;
        int num2Small = Integer.MIN_VALUE;
        int num2Big = Integer.MAX_VALUE;
        if (mid1 != 0) {
            num1Small = nums1[mid1 - 1];
        }
        if (mid1 != len1) {
            num1Big = nums1[mid1];
        }
        if (mid2 != 0) {
            num2Small = nums2[mid2 - 1];
        }
        if (mid2 != len2) {
            num2Big = nums2[mid2];
        }
        if (((len1 + len2)  & 1) != 0) {
            return Math.max(num1Small, num2Small);
        } else {
            return (double) (Math.min(num1Big, num2Big) + Math.max(num2Small, num1Small)) / 2.0;
        }
    }

    public static double findMedianSortedArrays_01(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 ==null) {
            return 0.0;
        }
        int len1 = nums1.length;
        int len2 = nums2.length;
        if (len1 > len2) {
            return findMedianSortedArrays_01(nums2, nums1);
        }
        int lo = 0;
        int hi = len1;
        //
        int mid1, mid2;
        int leftSize = (len1 + len2 + 1) / 2;
        while (lo < hi) {
            mid1 = lo + ((hi - lo) >> 1);
            mid2 = leftSize - mid1;
            if (nums1[mid1] < nums2[mid2 - 1]) {
                lo = mid1 + 1;
            } else {
                hi = mid1;
            }
        }
        mid1 = lo;
        mid2 = leftSize - mid1;
        // (leftmax + rightmin)/2.0
        //
        int leftMax;
        if (mid1 == 0) {
            leftMax = nums2[mid2 - 1];
        } else if (mid2 == 0) {
            leftMax = nums1[mid1 - 1];
        } else {
            leftMax = Math.max(nums1[mid1 - 1], nums2[mid2 - 1]);
        }
        if (((len1 + len2) & 1) != 0) {
            return leftMax;
        }
        int rightMin;
        if (mid1 == len1) {
            rightMin = nums2[mid2];
        } else if (mid2 == len2) {
            rightMin = nums1[mid1];
        } else {
            rightMin = Math.min(nums1[mid1], nums2[mid2]);
        }
        return (double) (leftMax + rightMin) / 2.0;
    }


    public static void main(String[] args) {
        int[] t1 = {1, 3};
        int[] t2 = {2};
        findMedianSortedArrays_01(t1, t2);
    }

}
