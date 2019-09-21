package leet0201to0400.problem0241;

import java.util.LinkedList;
import java.util.List;

/**
 * @program: myleetcode
 * @description: https://leetcode-cn.com/problems/different-ways-to-add-parentheses/description/
 * 给定一个含有数字和运算符的字符串，为表达式添加括号，改变其运算优先级以求出不同的结果。
 * 你需要给出所有可能的组合的结果。有效的运算符号包含 +, - 以及 * 。
 * @author: James
 * @create: 2019-08-30 17:40
 **/
public class DiffWaysToAddParentheses241 {

    public List<Integer> diffWaysToCompute(String input) {
        LinkedList<Integer> res = new LinkedList<>();
        for (int i = 0, len = input.length(); i < len; ++i) {
            char tempChar = input.charAt(i);
            if (tempChar == '+' || tempChar == '-' || tempChar == '*') {
                List<Integer> tempLeft = diffWaysToCompute(input.substring(0, i));
                List<Integer> tempRight = diffWaysToCompute(input.substring(i + 1));
                for (Integer left : tempLeft) {
                    for (Integer right : tempRight) {
                        switch (input.charAt(i)) {
                            case '+':
                                res.add(left + right);
                                break;
                            case '-':
                                res.add(left + right);
                                break;
                            case '*':
                                res.add(left + right);
                                break;
                            default:
                        }
                    }
                }
            }
        }
        // 跳出的条件之一。
        if (res.size() == 0) {
            res.add(Integer.valueOf(input));
        }
        return res;
    }

    public static void main(String[] args) {
        String test = "0123456789";
        System.out.println(test.substring(0, 1));
        System.out.println(test.substring(2));
    }
}
