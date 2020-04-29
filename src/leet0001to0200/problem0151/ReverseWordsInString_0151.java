package leet0001to0200.problem0151;

import java.sql.Array;
import java.util.Arrays;
import java.util.Stack;

/**
 * @author Brilliant James
 * @date 2020-04-10 01:50
 **/
public class ReverseWordsInString_0151 {

    public String reverseWords(String s) {
        char[] chars = s.toCharArray();
        int len = chars.length;
        int left = 0;
        int right = 0;
        Stack<String> stack = new Stack();
        while (left < len) {
            if (chars[left] == ' ') {
                left++;
            } else {
                right = left;
                StringBuilder tempSb = new StringBuilder();
                while (right < len && chars[right] != ' ') {
                    tempSb.append(chars[right]);
                    right++;
                }
                stack.push(tempSb.toString());
                left = right;
            }
        }
        StringBuilder ans = new StringBuilder();
        while (stack.size() > 0) {
            if (stack.size() == 1) {
                ans.append(stack.pop());
            } else {
                ans.append(stack.pop()).append(" ");
            }
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        String t = "  hello   world!  ";
        System.out.println(Arrays.toString(t.split(" ")));
    }
}
