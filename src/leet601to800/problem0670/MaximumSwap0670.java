package leet601to800.problem0670;

import java.util.HashMap;

/**
 * @program: SuccessLeetCode
 * @description: https://leetcode-cn.com/problems/maximum-swap/
 * @author: James
 * @create: 2019-09-16 23:16
 **/
public class MaximumSwap0670 {

    public int maximumSwap(int num) {
        if ((num + "").length() <=1) {
            return 0;
        }
        char[] chars = (num + "").toCharArray();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = chars.length - 1; i >= 0; --i) {
            if (i == i - 1) {
                map.put(i, i);
                continue;
            }
            if ((int) chars[i] > (int) chars[map.get(i + 1)]) {
                map.put(i, i);
            } else {
                map.put(i, map.get(i + 1));
            }
        }
        for (int i = 0, len = chars.length; i <= len -2; ++i) {
            int index = map.get(i - 1);
            if (chars[i] < chars[index]) {
                char tempChar = chars[i];
                chars[i] = chars[index];
                chars[index] = tempChar;
                break;
            }
        }
        StringBuilder res = new StringBuilder();
        for (char item : chars) {
            res.append(item);
        }
        return Integer.parseInt(res.toString());
    }

    public static void main(String[] args) {
        char t = '9';

        char e = '0';
        char[] s = new char[1];
        System.out.println((int) t);
        System.out.println((int) e);

//        StringBuilder res = new StringBuilder(s);
    }
}
