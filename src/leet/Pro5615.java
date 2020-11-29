package leet;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/minimum-moves-to-make-array-complementary/
 *
 * 给你一个长度为 偶数 n 的整数数组 nums 和一个整数 limit 。
 * 每一次操作，你可以将 nums 中的任何整数替换为 1 到 limit 之间的另一个整数。
 *
 * 如果对于所有下标 i（下标从 0 开始），nums[i] + nums[n - 1 - i] 都等于同一个数，则数组 nums 是 互补的 。
 * 例如，数组 [1,2,3,4] 是互补的，因为对于所有下标 i ，nums[i] + nums[n - 1 - i] = 5 。
 *
 * 返回使数组 互补 的 最少 操作次数。
 * @author 王涵威
 * @date 20.11.29 11:28
 */
public class Pro5615 {

    public int minMoves(int[] nums, int limit) {
        int[] diff = new int[limit * 2 + 2];
        int len = nums.length;
        for (int i  = 0; i < len / 2; i++) {
            int a  = nums[i], b = nums[len - 1 - i];

            int l = 2, r = 2 * limit;
            diff[l] += 2;
            diff[r + 1] -= 2;

            l = 1 + Math.min(a, b);
            r = limit + Math.max(a, b);
            diff[l] += -1;
            diff[r + 1] -= -1;

            l = a + b;
            r = a + b;
            diff[l] += -1;
            diff[r + 1] -= -1;
        }

        int res = len, sum = 0;
        for (int i = 2; i <= 2 * limit; i++) {
            sum += diff[i];
            res = Math.min(res, sum);
        }
        return res;
    }


    /**
     * https://www.cnblogs.com/xenny/p/9739600.html
     *
     * @param nums
     * @param limit
     * @return
     */
    public int minMoves_1(int[] nums, int limit) {
        Bit bit  = new Bit();
        int len = nums.length;
        for (int i = 0; i < len / 2; i++) {
            int min = Math.min(nums[i], nums[len - 1 - i]);
            int max = Math.max(nums[i], nums[len - 1 -1 ]);
            bit.update(1, min, 2);
            bit.update(max + limit + 1, 2 * 10000, 2);


        }
        return 0;
    }

    class Bit {
        int n, m;
        List<Integer> a;
        List<Integer> c;

        Bit() {
            a = new ArrayList<>();
            c = new ArrayList<>();
        }

        int lowbit(int x) {
            return x & (-x);
        }

        void d(int i, int k) {
            while (i <= n) {
                c.set(i, c.get(i) + k);
                i += lowbit(i);
            }
        }

        int getSum(int i) {
            int res = 0;
            while (i > 0) {
                res += c.get(i);
                i -= lowbit(i);
            }
            return res;
        }

        void update(int x, int y, int k) {
            d(x, k);
            d(y + 1, -k);
        }
    }


}
