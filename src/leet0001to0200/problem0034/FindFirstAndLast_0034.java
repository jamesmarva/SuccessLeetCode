package leet0001to0200.problem0034;

/**
 * @author James
 * @date 2019-12-03 21:26
 **/
public class FindFirstAndLast_0034 {

    public int[] searchRange(int[] nums, int target) {
        int[] ans = {-1, -1};
        if (nums == null || nums.length == 0) {
            return ans;
        }
        int firstPosition  = getFirstTarget(nums, target, nums.length);
        int lastPosition = getLastTarget(nums, target, nums.length);
            if (firstPosition == -1 && lastPosition == -1){
            return ans;
        } else if (firstPosition == -1) {
            ans[0] = lastPosition;
            ans[1] = lastPosition;
            return ans;
        } else if (lastPosition == -1){
            ans[0] = firstPosition;
            ans[1] = firstPosition;
        } else if (firstPosition != -1 && lastPosition != -1){
            ans[0] = firstPosition;
            ans[1] = lastPosition;
            return ans;
        }
        return ans;
}

    private int getFirstTarget(int[] arr, int target, int len) {
        int low = 0;
        int high = len - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (arr[mid] == target) {
                if (mid == 0 || (mid > 0 && arr[mid - 1] != target)) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            } else if (arr[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    private int getLastTarget(int[] arr, int target, int len) {
        int low = 0;
        int high = len;
        while (low < high) {
            int mid = low + ((high - low) >> 1);
            if (arr[mid] == target) {
                if (mid == len - 1 || (mid < len - 1 && arr[mid] != arr[mid + 1])) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            } else if (arr[mid] > target) {
                high = mid;
            } else if (arr[mid] < target) {
                low =  mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int target = 5;
        int[] arr = {5, 5,5, 6, 7, 8};
    }
}
