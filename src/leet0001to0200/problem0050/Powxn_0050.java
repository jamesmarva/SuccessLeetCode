package leet0001to0200.problem0050;

import java.util.Stack;

/**
 *  https://leetcode-cn.com/problems/powx-n/
 * 描述:
 *  * https://leetcode-cn.com/problems/powx-n/
 *  *   50. Pow(x, n)
 *  *   实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 *      示例 1:
 *      输入: 2.00000, 10
 *      输出: 1024.00000
 *
 *      示例 2:
 *      输入: 2.10000, 3
 *      输出: 9.26100
 *
 *      示例 3:
 *      输入: 2.00000, -2
 *      输出: 0.25000
 *      解释: 2-2 = 1/ (2*2) = 1/4 = 0.25
 *
 *      说明:
 *      -100.0 < x < 100.0
 *      n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。
 *
 *     使用折半计算，每次把n缩小一半，这样n最终会缩小到0，任何数的0次方都为1，
 *     这时候我们再往回乘，如果此时n是偶数，直接把上次递归得到的值算个平方返回即可，
 *     如果是奇数，则还需要乘上个x的值。还有一点需要引起我们的注意的是n有可能为负数，
 *     对于n是负数的情况，我们可以先用其绝对值计算出一个结果再取其倒数即可。
 *     我们让i初始化为n，然后看i是否是2的倍数，
 *     是的话x乘以自己，否则res乘以x，i每次循环缩小一半，直到为0停止循环。
 *     最后看n的正负，如果为负，返回其倒数。
 *  * @author James
 * @author James
 * @date 2019-09-11 01:35
 **/
public class Powxn_0050 {

    public double myPow(double base, int exponent) {
        if (base == 0) {
            return 0;
        }
        if (exponent == 0) {
            return 1;
        }
        if (exponent == 1) {
            return base;
        }
        if (exponent == -1) {
            return 1.0 / base;
        }

        double result = 1.0d;
        result = myPow(base, exponent / 2);
        if (exponent % 2 == 1) {
            result *= result * base;
        } else if (exponent % 2 == 0) {
            result *= result;
        } else if (exponent % 2 == -1) {
            result *= result * 1.0 / base;
        }
        return result;
    }


    public double myPow_1(double x, int n) {
        if (n == 1) {
            return 1.0;
        }
        int newN = Math.abs(n);
        double[] dp = new double[n];
        Stack<Integer> stack = new Stack<>();
        while (newN > 0) {
            stack.push(newN );
            newN = newN / 2;
        }
        double ans = 1.0;
        while (stack.size() > 0) {
            int temp = stack.pop();
            if (temp == 1) {
                dp[temp] = x;
            } else {
                if (temp % 2 == 1) {
                    dp[temp] = dp[temp/2] * dp[temp/2] * x;
                } else {
                    dp[temp] = dp[temp/2] * dp[temp/2];
                }
            }
        }
        if (n > 0) {
            return dp[n];
        } else {
            return 1 / dp[n];
        }
    }


    /**
     * accept
     * 执行用时 :1 ms, 在所有 java 提交中击败了99.95%的用户
     * 内存消耗 :33.5 MB, 在所有 java 提交中击败了73.69%的用户
     */
    public double myPow_2(double x, int n) {
        if (n == 0) {
            return 1.0;
        }
        double ans = myPow_2Core(x, n);
        return ans;
    }

    public double myPow_2Core(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        if (n == -1) {
            return 1/x;
        }
        double ans = myPow_2Core(x, n / 2);
        if (n % 2 == 1) {
            ans = ans *ans * x;
        } else if (n % 2 == 0) {
            ans =  ans * ans;
        } else if (n % 2 == -1) {
            ans =  ans * ans * (1/x);
        }
        return ans;
    }

    /**
     * 迭代的解法
     */
    public double myPow_3(double x, int n) {
        if (n == 0) {
            return 1.0;
        }
        double ans = 1.0;
        double current = x;
        for (; n != 0; n /= 2) {
            if ((n % 2) == 1) {
                ans = ans * current;
            } else if ((n % 2) == -1) {
                ans = ans * (1/current);
            }
            current = current * current;
        }
        return ans;
    }

    public static void main(String[] args) {
//        System.out.println(-3 % 2);
        double test = 2.0;
        int test1 = 10;
        Powxn_0050 powxn_0050 = new Powxn_0050();
        System.out.println(powxn_0050.myPow_3(test, test1));
        System.out.println(-1/2);
    }



}

