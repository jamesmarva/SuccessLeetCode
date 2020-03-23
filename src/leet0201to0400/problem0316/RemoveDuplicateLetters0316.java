package leet0201to0400.problem0316;

import java.util.Stack;

/**
 * @author Brilliant James
 * @date 2020-03-21 18:57
 **/
public class RemoveDuplicateLetters0316 {

    public String removeDuplicateLetters(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        char[] arr = s.toCharArray();
        int[] map = new int[26];
        for (char c : arr) {
            map[c - 'a'] ++;
        }
        Stack<Character> stack = new Stack<>();
        for (char c : arr) {
            if (stack.isEmpty()) {
                stack.push(c);
            } else {
                while (stack.size() > 0 && stack.peek() > c && map[stack.peek() - 'a'] > 1 && !stack.contains(c)) {
                    map[stack.peek() - 'a']--;
                    stack.pop();

                }
                if (stack.isEmpty() || !stack.contains(c)) {
                    stack.push(c);
                } else {
                    map[c - 'a']--;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while (stack.size() > 0) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String s = "bddbccd";
        RemoveDuplicateLetters0316 r = new RemoveDuplicateLetters0316();
        String t = r.removeDuplicateLetters(s);
        System.out.println(t);

    }
}
