package leet0201to0400.problem0201;

/**
 *
 * https://leetcode-cn.com/problems/bitwise-and-of-numbers-range/
 * 201. 数字范围按位与
 * @author Brilliant James Jamesmarva1993@gmail.com 2020-08-23 21:51
 **/
public class BitwiseANDNumbers_0201_v1 {

    /**
     * 找两个边界的数字的 最左的前缀的问题。
     *
     * @param m
     * @param n
     * @return
     */
    public int rangeBitwiseAnd(int m, int n) {
        int shiftCount = 0;
        while (m != n) {
            m >>= 1;
            n >>= 1;
            shiftCount++;
        }
        return m << shiftCount;
    }
}
