package leet0001to0200.problem0033;

/**
 * @author James
 * @date 2019-11-28 19:43
 **/
public class SearchInRotatedSortedArray_0033 {

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int len = nums.length;
        int low = 0;
        int high = len - 1;
        int mid = 0;
        //
        while (low <= high) {
            mid = low + ((high - low) >> 1);
            if (nums[mid] == target) {
                return mid;
            // 旋转点在右边
            } else if (nums[low] <= nums[mid] && target < nums[mid] && target >= nums[low]) {
                high = mid-1;
            } else if (nums[low] <= nums[mid]) {
                low = mid+1;
            // 旋转点在左边
            } else if (nums[low] >= nums[mid] && target > nums[mid] && target <= nums[high]) {
                low = mid + 1;
            } else if (nums[low] >= nums[mid]) {
                high = mid - 1;
            }
        }
        return -1;
    }


    public int search_1(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int len = nums.length;
        int low = 0;
        int high = len - 1;
        int mid = 0;
        //
        while (low <= high) {
            mid = low + ((high - low) >> 1);
            if (nums[mid] == target) {
                return mid;
            // 旋转点在右边,
            } else if (nums[low] <= nums[mid]) {
                // 左边都是递增的，在递增序列中。
                if (target >= nums[low] && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            // 旋转点在左边
            } else if (nums[low] > nums[mid]) {
                // 右边都是递增的，在递增序列中
                if (target <= nums[high] && target > nums[mid]) {
                    low = mid + 1;
                } else {
                   high = mid - 1;
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
//        int[] test = {7,0,1,2,4,5,6};
//        int target = 0;
//        int[] test = {1};
//        int target = 1;

        int[] test = {3,1};
        int target = 1;
        SearchInRotatedSortedArray_0033 ss = new SearchInRotatedSortedArray_0033();
        System.out.println(ss.search_1(test, target));

    }
}
