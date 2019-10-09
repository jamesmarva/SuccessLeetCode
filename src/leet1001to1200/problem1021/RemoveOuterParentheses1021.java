package leet1001to1200.problem1021;

import java.util.Stack;

/**
 * @author James
 * @program SuccessLeetCode
 * @description https://leetcode-cn.com/problems/remove-outermost-parentheses/
 * @date 2019-10-09 20:46
 **/
public class RemoveOuterParentheses1021 {


    /**
     * accept
     */
    public static String removeOuterParentheses(String S) {
        if (S == null || S.length() == 0) {
            return "";
        }
        char[] sChars = S.toCharArray();
        Stack<Character> stack = new Stack<>();
        StringBuilder ans = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        for (char item : sChars) {
            if (item == ')') {
                stack.pop();
            } else {
                stack.push(item);
            }
            if (stack.isEmpty()) {
                ans.append(temp.substring(1));
                temp = new StringBuilder();
            } else {
                temp.append(item + "");
            }
        }
        return ans.toString();
    }


    public String removeOuterParenthesesBetter(String S) {
        StringBuffer sb = new StringBuffer();
        int length = S.length();
        int leftCount = 0, rightCount = 0;
        for(int i = 0; i < length; i++){
            if(S.charAt(i) == '('){
                leftCount++;
            }else if(S.charAt(i) == ')'){
                rightCount++;
            }
            if(leftCount == rightCount){
                sb.append(S.substring(i - leftCount * 2 + 2 , i));
                leftCount = 0;
                rightCount = 0;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "(()())(())(()(()))";
        System.out.println(removeOuterParentheses(s));
    }

}
