package gold;

/**
 * 面试题 16.07. 最大数值
 * https://leetcode-cn.com/problems/maximum-lcci/
 * @author Brilliant James
 * @date 2020-05-14 20:19
 **/
public class Pro_16_07 {
    public int maximum(int first, int second) {
        // 如果 a >= b 的话，那么 isFirstBig 就是 0
        // 如果 a < b 的话，那么 isFirstBig 就是 1
        long isFirstBig = (((long) first - (long)second) >> 63) & 1;
        return second * (int)isFirstBig + first * ((int)isFirstBig ^ 1);
    }
}
