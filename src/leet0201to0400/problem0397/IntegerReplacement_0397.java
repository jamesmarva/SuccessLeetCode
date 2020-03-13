package leet0201to0400.problem0397;

/**
 * https://leetcode-cn.com/problems/integer-replacement/submissions/
 * 397. 整数替换
 * @author Brilliant James
 * @date 2020-03-11 20:08
 **/
public class IntegerReplacement_0397 {

    public int integerReplacement(int n) {
        if (n <= 1) {
            return 0;
        }
        int res = 0;
        while (n != 1) {
            if ((n & 1) == 0) {
                n >>>= 1;
            } else if ((n & 1) == 1) {
                if ((n & 2) == 0) {
                    n -= 1;
                } else if ((n & 2) == 2) {
                    if (n == 3) {
                        n -= 1;
                    } else {
                        n += 1;
                    }
                }
            }
            res++;
        }
        return res;
    }
}
