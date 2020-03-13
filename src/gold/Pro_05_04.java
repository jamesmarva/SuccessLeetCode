package gold;

import java.util.Arrays;

/**
 *
 * https://leetcode-cn.com/problems/closed-number-lcci/
 * 面试题 05.04. 下一个数
 * 下一个数。给定一个正整数，找出与其二进制表达式中1的个数相同且大小最接近的那两个数（一个略大，一个略小）。
 *
 * 示例1:
 *  输入：num = 2（或者0b10）
 *  输出：[4, 1] 或者（[0b100, 0b1]）
 *
 * 示例2:
 *  输入：num = 1
 *  输出：[2, -1]
 *
 * 提示:
 * num的范围在[1, 2147483647]之间；
 * 如果找不到前一个或者后一个满足条件的正数，那么输出 -1。
 * @author Brilliant James
 * @date 2020-03-12 07:59
 **/
public class Pro_05_04 {

    /**
     * 暴力破解
     * @param num
     * @return
     */
    public int[] findClosedNumbers(int num) {
        int [] res = new int[2];
        Arrays.fill(res, -1);
        int ones = numOfOne(num);
        // find bigger
        for (int i = num + 1; i <= 2147483647; i++) {
            if (ones == numOfOne(i)) {
                res[1] = i;
                break;
            }
            if (i == 2147483647) {
                break;
            }
        }
        // find smaller
        for (int i = num - 1; i >= 1; i--) {
            if (ones == numOfOne(i) ) {
                res[0] = i;
                break;
            }
        }
        return res;
    }

    private int numOfOne(int tar) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            if ((tar & (1 << i)) > 0) {
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(2147483647);
        System.out.println(Integer.MAX_VALUE);
    }
}
