package leet1to200.problem0050;

/**
 * @program: SuccessLeetCode
 * @description: https://leetcode-cn.com/problems/powx-n/
 * @author: James
 * @create: 2019-09-11 01:35
 **/
public class Powxn0050 {

    public double myPow1(double base, int exponent) {
        boolean isNegative = false;
        if (exponent < 0) {
           exponent = -exponent;
           isNegative = true;
        }
        double res = powCore(base, exponent);
        if (isNegative) {
           return  1.0 / res;
        } else {
           return res;
        }
    }

    public double powCore(double base, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        if (exponent == 1) {
            return base;
        }
        double result = 1.0d;
        result = powCore(base, exponent / 2);
        if (exponent % 2 == 1) {
            result *= result;
        } else {
            result *= result*base;
        }
        return result;
    }

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

    public static void main(String[] args) {
        System.out.println(-3 % 2);
    }



}
