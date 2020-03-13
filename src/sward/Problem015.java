package sward;

/**
 *
 * https://leetcode-cn.com/problems/er-jin-zhi-zhong-1de-ge-shu-lcof/
 * 面试题15. 二进制中1的个数
 * @author Brilliant James
 * @date 2020-03-11 13:15
 **/
public class Problem015 {

    // you need to treat n as an unsigned value

    /**
     * 我还是个无符号位 的 数字
     * @param n
     * @return
     */
    public int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            if ((n & 1) == 1) {
                res ++;
            }
            n >>>= 1;
        }
        return res;
    }

    public static void main(String[] args) {
        int test = -3;
        test >>= 1;
        String[] arr = {"0", "1"};
        StringBuilder res = new StringBuilder();
        while (test != 0) {
            res.append(arr[test & 1]);
            test >>>= 1;
        }
        System.out.println(res.reverse().toString());
    }
}
