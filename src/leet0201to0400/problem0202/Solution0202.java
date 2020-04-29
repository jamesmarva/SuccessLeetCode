package leet0201to0400.problem0202;

import java.util.HashMap;
import java.util.HashSet;

/**
 *
 * https://leetcode-cn.com/problems/happy-number/
 *
 * @author Brilliant James
 * @date 2020-04-30 03:31
 **/
public class Solution0202 {


    /**
     *  集合思想
     * @param n
     * @return
     */
    public static boolean isHappy(int n) {
        int newNum = 0;
        HashSet<Integer> set = new HashSet<>();
        set.add(n);
        while (n != 1 && set.add(newNum)) {
            newNum = 0;
            while (n > 0) {
                newNum += Math.pow(n % 10, 2);
                n /= 10;
            }
            n = newNum;
        }
        return n == 1;
    }

    /**
     * 快慢指针
     * @param n
     * @return
     */
    public static boolean isHappy_right(int n) {
        int slow = n;
        int fast = n;
        do {
            slow = nextNum(slow);
            fast = nextNum(fast);
            fast = nextNum(fast);
        } while (slow != fast);
        return slow == 1;
    }


    private static int nextNum(int n) {
        int ans = 0;
        while (n > 0) {
            ans += Math.pow(n % 10, 2);
            n /= 10;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(isHappy(19));
    }
}
