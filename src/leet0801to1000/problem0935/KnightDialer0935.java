package leet0801to1000.problem0935;

/**
 * @program: SuccessLeetCode
 * @description: https://leetcode-cn.com/problems/knight-dialer/
 * @author: James
 * @create: 2019-09-13 02:36
 **/
public class KnightDialer0935 {

    public int knightDialer(int N) {

        int mod = 1000000007;
        N = N - 1;
        long num_0 = 1, num_1 = 1, num_2 = 1, num_3 = 1, num_4 = 1, num_5 = 1, num_6 = 1, num_7 = 1, num_8 = 1, num_9 = 1;
        for (int i = 0; i < N; i++) {
            long num_0_vice = (num_4 + num_6)  % mod;
            long num_1_vice = (num_6 + num_8)  % mod;
            long num_2_vice = (num_7 + num_9)  % mod;
            long num_3_vice = (num_4 + num_8)  % mod;
            long num_4_vice = (num_3 + num_9 + num_0)  % mod;
            long num_6_vice = (num_1 + num_7 + num_0)  % mod;
            long num_7_vice = (num_2 + num_6)  % mod;
            long num_8_vice = (num_1 + num_3)  % mod;
            long num_9_vice = (num_4 + num_2)  % mod;
            num_0 = num_0_vice % mod;
            num_1 = num_1_vice % mod;
            num_2 = num_2_vice % mod;
            num_3 = num_3_vice % mod;
            num_4 = num_4_vice % mod;
            num_6 = num_6_vice % mod;
            num_7 = num_7_vice % mod;
            num_8 = num_8_vice % mod;
            num_9 = num_9_vice % mod;
        }

        int result = 0;
        if (N > 0) {
            result =  (int) (result + num_0) % mod;
            result =  (int) (result + num_1) % mod;
            result =  (int) (result + num_2) % mod;
            result =  (int) (result + num_3) % mod;
            result =  (int) (result + num_4) % mod;
            result =  (int) (result + num_6) % mod;
            result =  (int) (result + num_7) % mod;
            result =  (int) (result + num_8) % mod;
            result =  (int) (result + num_9) % mod;
        } else {
            result = (int) (num_0 + num_1 + num_2 + num_3 + num_4 + num_5 + num_6 + num_7 + num_8 + num_9) % mod;
        }

        return result;
    }
}
