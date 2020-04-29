package sward;

/**
 *
 * https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-lcof/
 *
 * @author Brilliant James
 * @date 2020-04-29 19:52
 **/
public class Problem_056_I {

    /**
     * a ^ b = c
     * 1 全部异或
     * @param nums
     * @return
     */
    public int[] singleNumbers(int[] nums) {
        if (nums == null || nums.length < 2) {
            return null;
        }
        int x = 0;
        for (int i : nums) {
            x ^= i;
        }
        int move = 0;
        for (int i = 0; i < 32; i++) {
            if ((x & (1 << i)) != 0) {
                move = 1 << i;
                break;
            }
        }
        int fir = 0;
        int sec = 0;
        for (int i : nums) {
            if ((i & move) == 0) {
                fir ^= i;
            } else {
                sec ^= i;
            }
        }
        int[] res = new int[2];
        res[0] = fir;
        res[1] = sec;
        return res;
    }

    public static void main(String[] args) {

    }
}
