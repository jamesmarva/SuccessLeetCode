package leet1001to1200.problem1095;

/**
 * @author Brilliant James
 * @date 2020-04-29 22:09
 **/

public class Solution1095 {
    /**
     * // This is MountainArray's API interface.
     * // You should not implement it, or speculate about its implementation
     * interface MountainArray {
     *     public int get(int index) {}
     *     public int length() {}
     * }
     */
    public static int findInMountainArray(int target, MountainArray arr) {
        int len = arr.length();
        int lo = 0, hi = len - 1;
        int mid = hi >> 1;
        int peekIndex = 0;
        // find peek-index in arr.
        while (lo <= hi) {
            mid = lo + ((hi - lo) >> 1);
            int val = arr.get(mid);
            int rightVal = 0;
            int leftVal = 0;
            if (mid + 1 < len && (rightVal = arr.get(mid + 1)) > val) {
                lo = mid + 1;
            } else if (mid - 1 >= 0 && (leftVal = arr.get(mid - 1)) > val) {
                hi = mid - 1;
            } else if (val > rightVal && val > leftVal) {
                peekIndex = mid;
                break;
            }
        }
        // find in left.
        lo = 0;
        hi = peekIndex;
        while (lo <= hi) {
            mid = lo + ((hi - lo) >> 1);
            int tempVal = arr.get(mid);
            if (tempVal == target) {
                return mid;
            } else if (tempVal > target) {
                hi = mid - 1;
            } else if (tempVal < target) {
                lo = mid + 1;
            }
        }
        // find in right.
        lo = peekIndex;
        hi = len - 1;
        while (lo <= hi) {
            mid = lo + ((hi - lo) >> 1);
            int tempVal = arr.get(mid);
            if (tempVal == target) {
                return mid;
            } else if (tempVal > target) {
                lo = mid + 1;
            } else if (tempVal < target) {
                hi = mid - 1;
            }
        }
        return -1;
    }


    private int findInLeft(int target, int lo, int hi, MountainArray arr) {
        while (lo <= hi) {
            int mid = lo + ((hi - lo) >> 1);
            int val = arr.get(mid);
            if (val == target) {
                return mid;
            } else if (val > target) {
                hi = mid - 1;
            } else if (val < target) {
                lo = mid + 1;
            }
        }
        return -1;
    }

    /**
     * [3,5,3,2,0]
     * 5
     * @param args
     */
    public static void main(String[] args) {
        int[] tt = {3,5,3,2,0};
        MountainArray arr = new MountainArray() {

            @Override
            public int get(int index) {
                return tt[index];
            }

            @Override
            public int length() {
                return tt.length;
            }
        };
        System.out.println(findInMountainArray(5, arr));
    }

}
interface MountainArray {
    public int get(int index);
    public int length();
}