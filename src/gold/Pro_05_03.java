package gold;

/**
 *
 * https://leetcode-cn.com/problems/reverse-bits-lcci/
 * 面试题 05.03. 翻转数位
 * @author Brilliant James
 * @date 2020-03-13 17:09
 **/
public class Pro_05_03 {

    /**
     *
     * @param num
     * @return
     */
    public int reverseBits(int num) {
        if (~num == 0) {
            return 32;
        }
        int pre = 0;
        int cur = 0;
        int res = 1;
        while (num != 0) {
            int temp = num & 1;
            if (temp == 1) {
                cur++;
            } else if (temp == 0) {
                if ((num & 2) == 0) {
                    pre = 0;
                } else if ((num & 2) == 2) {
                    pre = cur;
                }
                cur = 0;
            }
            res = Math.max(res, cur + pre + 1);
            num >>>= 1;
        }
        return Math.max(res, pre + cur + 1);
    }
    // 1111111111111111111101111111110
    //10101110011011011000110000

    private String twoBit(int num) {
        StringBuilder sb = new StringBuilder();
        while (num != 0) {
            sb.append(num & 1);
            num >>>= 1;
        }
        return sb.reverse().toString();
    }
    public static void main(String[] args) {
        Pro_05_03 p = new Pro_05_03();
        int test  = p.reverseBits(2147482622);
        System.out.println(test);
        System.out.println(p.twoBit(2147482622));
        System.out.println(1 << 31);
    }
}
