package leet1001to1200.problem1190;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @program: SuccessLeetCode
 * @description: https://leetcode-cn.com/problems/reverse-substrings-between-each-pair-of-parentheses/
 *
 * 示例 1：
 * 输入：s = "(abcd)"
 * 输出："dcba"
 *
 * 示例 2：
 * 输入：s = "(u(love)i)"
 * 输出："iloveu"
 *
 * 示例 3：
 * 输入：s = "(ed(et(oc))el)"
 * 输出："leetcode"

 * 示例 4：
 * 输入：s = "a(bcdefghijkl(mno)p)q"
 * 输出："apmnolkjihgfedcbq"
 *  
 *
 * 提示：
 * 0 <= s.length <= 2000
 * s 中只有小写英文字母和括号
 * 我们确保所有括号都是成对出现的
 *
 * @author: James
 * @create: 2019-09-16 21:04
 **/
public class ReverseParentheses1190 {

    public String reverseParentheses(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        char[] chars = s.toCharArray();
        LinkedList<Character> stack = new LinkedList<>();
        for (int i = 0, len = chars.length; i <= len - 1; ++i) {
            if (chars[i] == ')') {
                LinkedList<Character> tempList = new LinkedList<>();
                while (stack.getLast() != '(') {
                    tempList.add(stack.removeLast());
                }
                stack.removeLast();
                if (stack.isEmpty() && i == len - 1) {
                    return listCharToString(tempList);
                } else {
                    stack.addAll(tempList);
                }
            } else {
                stack.add(chars[i]);
            }
        }
        return listCharToString(stack);
    }

    private String listCharToString(LinkedList<Character> list) {
        StringBuilder sb = new StringBuilder();
        for (Character item : list) {
            sb.append(item);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.insert(0, 'a');
        sb.insert(0, 'b');
        sb.insert(0, 'c');
        sb.insert(0, "ddd");
        System.out.println(sb.toString());

    }
}
