package leet0401to0600.problem0523;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @program SuccessLeetCode
 * @description https://leetcode-cn.com/problems/continuous-subarray-sum/
 * @author James
 * @date 2019-09-21 13:23
 **/
public class ContinuousSubarraySum0523 {

    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums == null || nums.length < 2) {
            return false;
        }
        for (int i = 0, len = nums.length; i < len - 1; ++i) {
            int sumTemp = nums[i];
            for (int j = i + 1; j < len; ++j) {
                sumTemp += nums[j];
                if (k != 0 && sumTemp % k == 0 ) {
                    return true;
                } else if (k == 0 && sumTemp == 0) {
                    return true;
                }
            }
        }
        return false;
    }


    public static boolean checkSubarraySumBest(int[] nums, int k) {
        if (nums == null || nums.length < 2) {
            return false;
        }
        if (k == 0) {
            for (int i = 0, len = nums.length; i < len - 1; ++i) {
                if (nums[i] == 0 && nums[i + 1] == 0) {
                    return true;
                }
            }
            return false;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        for (int i = 0, len = nums.length; i < len; ++i) {
            sum += nums[i];
            int temp = sum % k;
            if (map.containsKey(temp) && map.get(temp) - i > 1) {
                return true;
            } else {
                map.put(temp, i);
            }
        }
        return false;
    }



    public boolean checkSubarraySumBestR(int[] nums, int k) {
        int sum = 0;
        HashMap < Integer, Integer > map = new HashMap < > ();
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (k != 0) {
                sum = sum % k;
            }
            if (map.containsKey(sum)) {
                if (i - map.get(sum) > 1) {
                    return true;
                }
            } else {
                map.put(sum, i);
            }
        }
        return false;
    }


    /**
     *  https://leetcode-cn.com/problems/continuous-subarray-sum/solution/lian-xu-de-zi-shu-zu-qiu-he-by-lenn123/
     *  在方法一中我们利用前缀和数组来求解问题，对于子数组 nums[i:j]nums[i:j] (不包含下标 j )，其区间和为 sum[j] - sum[i]sum[j]−sum[i] (其中 sum 为预处理得到的前缀和数组)，
     *
     * 我们要判断的是 (sum[j] - sum[i])\%k(sum[j]−sum[i])%k 是否等于 0。
     * 根据 modmod 运算的性质，我们知道 (sum[j] - sum[i])\%k = sum[j]\%k - sum[i]\%k(sum[j]−sum[i])%k=sum[j]%k−sum[i]%k。
     * 故若想 (sum[j] - sum[i])\%k = 0(sum[j]−sum[i])%k=0，则必有 sum[j]\%k = sum[i]\%ksum[j]%k=sum[i]%k。
     *
     * 作者：LENN123
     * 链接：https://leetcode-cn.com/problems/continuous-subarray-sum/solution/lian-xu-de-zi-shu-zu-qiu-he-by-lenn123/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     */
    public boolean checkSubarraySumbBetter(int[] nums, int k) {
        int N = nums.length;
        int cache = 0;
        int[] sum = new int[N+1];
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            sum[i+1] = sum[i] + nums[i];
            int res = sum[i+1];
            if (k != 0) {
                res = sum[i+1] % k;
            }
            if (set.contains(res)) {
                return true;
            }
            set.add(cache);
            cache = res;
        }

        return false;
    }

    public static void main(String[] args) {
//        int[] test = {23,2,4,6,7};
        int[] test = {0, 1, 0};
//        [23,2,4,6,7]

        int test1 = 0;
//        checkSubarraySumBest(test, test1);
        System.out.println( 0 % -1);
    }
}
