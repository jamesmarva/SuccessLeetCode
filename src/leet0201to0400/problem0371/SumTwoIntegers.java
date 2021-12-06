package leet0201to0400.problem0371;

/**
 * 〈功能概述〉<br>
 *
 * @author 王涵威
 * @date 21.9.26 19:20
 */
public class SumTwoIntegers {

    public static void main(String[] args) {

    }

    public int getSum(int a, int b) {
        while (b != 0) {
            int tmp = a ^ b;
            int carry = (a & b) << 1;
            a = tmp;
            b = carry;
        }
        return a;
    }
}
