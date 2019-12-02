package leet0401to0600.problem0560;

import java.util.HashMap;

/**
 * @author James
 * @date 2019-11-28 23:34
 **/
public class SubarraySumEqualsK_0560 {


    /**
     *
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {
        if (nums == null || (nums.length == 0 && k == 0)) {
            return 0;
        }
        int  sum = 0;
        int len = nums.length;
        int ans = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                sum += nums[j];
                if (sum == k) {
                    ans++;
                }
            }
            sum = 0;
        }
        return ans;
    }


    public int subarraySum_1(int[] nums, int k) {
        if (nums == null || (nums.length == 0 && k == 0)) {
            return 0;
        }
        int  sum = 0;
        int len = nums.length;
        int ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < len; i++) {
            sum = nums[i];
            if (map.containsKey(sum - k)) {
                ans+=map.get(sum-k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[]  test =  {1,2,1,2,1};
        int target = 3;
        SubarraySumEqualsK_0560 ss = new SubarraySumEqualsK_0560();
        ss.subarraySum(test, target);
    }
}
