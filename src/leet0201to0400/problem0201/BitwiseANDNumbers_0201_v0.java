package leet0201to0400.problem0201;

/**
 * https://leetcode-cn.com/problems/bitwise-and-of-numbers-range/
 * 201. 数字范围按位与
 * @author Brilliant James Jamesmarva1993@gmail.com 2020-08-23 21:09
 **/
public class BitwiseANDNumbers_0201_v0 {

    public int rangeBitwiseAnd(int m, int n) {
        int res = m;
        for (int i = m; i <= n; i++) {
            res = res & i;
        }
        return res;
    }
}
