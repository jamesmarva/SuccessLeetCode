package leet1201to1400.problem1248;

import java.util.HashMap;

/**
 *
 *
 *
 * 给你一个整数数组 nums 和一个整数 k。
 *
 * 如果某个 连续 子数组中恰好有 k 个奇数数字，我们就认为这个子数组是「优美子数组」。
 *
 * 请返回这个数组中「优美子数组」的数目。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-number-of-nice-subarrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Brilliant James
 * @date 2020-04-21 22:08
 **/
public class CountNumOfNiceSubarrays_1248 {

    /**
     *
     * @param nums
     * @param k
     * @return
     */
    public int numberOfSubarrays(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int left = 0, right = 0, len = nums.length;
        int ans = 0;
        int temp = 0;
        while (left < len) {
            if (temp == k) {
                ans++;
            }
            boolean isOdd = false;
            if (right >= len || ((isOdd = ((nums[right] & 1) == 1))) && temp == k) {
                left++;
                right = left;
                temp=0;
                continue;
            }
            if (isOdd && temp < k) {
                temp++;
            }
            right++;
        }
        return ans;
    }


    /**
     * 2,2,2,1, 2,2, 1, 2,2,2
     *   3        2        3
     * k=2: 4 * 4 = 16
     * k=1: 4 * 3 + 3 * 4 =  17
     * count[i] - count[i-1]
     * count[i]
     * @param nums
     * @param k
     * @return
     */
    public int numberOfSubarrays_mine(int[] nums, int k) {
        int n = nums.length;
        int ans = 0;
        int count = 0;
        int[] odd =new int[n + 2];
        for (int i = 0; i < n; ++i) {
            if ((nums[i] & 1) == 1) {
                count++;
                odd[count] = i;
            }
        }
        odd[0] = -1;
        count++;
        odd[count] = n;
        for (int i = 1; i + k <= count; i++) {
            ans += (odd[i] - odd[i - 1]) * (odd[i + k] - odd[i + k - 1]);
        }
        return ans;
    }


    /**
     *
     * @param nums
     * @param k
     * @return
     */
    public int numberOfSubarrays_right(int[] nums, int k) {
        int n = nums.length, ans = 0, cnt = 0;
        int[] odd =new int[n + 2];
        for (int i = 0; i < n; ++i) {
            if ((nums[i] & 1) == 1) {
                odd[++cnt] = i;
            }
        }
        odd[0] = -1;
        odd[++cnt] = n;
        for (int i = 1; i + k <= cnt; ++i) {
            ans += (odd[i] - odd[i - 1]) * (odd[i + k] - odd[i + k - 1]);
        }
        return ans;
    }
        //            if (isOdd && temp == k) {
//                left++;
//                right = left;
//                temp=0;
//            } else
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();

        int[] test = {1,1,2,1,1};
        int k = 3;

        CountNumOfNiceSubarrays_1248 cc = new CountNumOfNiceSubarrays_1248();
        cc.numberOfSubarrays(test, k);
    }
}
