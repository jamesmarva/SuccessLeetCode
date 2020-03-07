package sward;

/**
 *
 * https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof/submissions/
 * @author Brilliant James
 * @date 2020-03-07 17:35
 **/
public class Problem_010_I {

    /**
     *
     * @param n
     * @return
     */
    public int fib(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }
        int first = 0;
        int second = 1;
        int ans = 0;
        for (int i = 2; i <= n; i++) {
            ans = (first + second) % 1000000007;
            if (i % 2 == 0) {
                first = ans;
            } else {
                second = ans;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Problem_010_I p = new Problem_010_I();
        System.out.println(p.fib(5));
        System.out.println(p.fib(6));
        System.out.println(p.fib(7));
        System.out.println(p.fib(8));
        System.out.println(p.fib(9));
        System.out.println(p.fib(10));
    }
}
