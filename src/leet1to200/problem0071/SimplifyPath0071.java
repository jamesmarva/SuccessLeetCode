package leet1to200.problem0071;

import java.util.*;

/**
 * @program SuccessLeetCode
 * @description https://leetcode-cn.com/problems/simplify-path/
 * @author James
 * @create 2019-09-20 05:49
 **/
public class SimplifyPath0071 {

    /*
     * right answer
     * @description  执行用时 :  6 ms, 在所有 Java 提交中击败了98.78%的用户
     * @param  path
     * @return
     */
    public String simplifyPathBetter(String path) {
        if (path == null || path.length() == 0) {
            return "";
        }
        String[] arr = path.split("/");
        LinkedList<String> list = new LinkedList<>();
        for (String item : arr) {
            if ("..".equals(item) && list.size() > 0) {
                list.removeLast();
            } else if (!".".equals(item) && !"".equals(item) && !"..".equals(item)) {
                list.add(item);
            }
        }
        StringBuilder res = new StringBuilder();
        res.append("/");
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            res.append(iterator.next());
            if (iterator.hasNext()) {
                res.append("/");
            }
        }
        return res.toString();
    }

    /**
     * 错误答案
     * @param path
     * @return
     */
    public String simplifyPath(String path) {
        Stack<Character> stack = new Stack<>();
        char[] chars = path.toCharArray();
        for (int i = 0, len = chars.length; i < len; ++i) {
            if (stack.isEmpty() && chars[i] != '.') {
                stack.push(chars[i]);
                continue;
            } else if (stack.isEmpty() && chars[i] == '.') {
                continue;
            }

            if (chars[i] == '.') {
                int dotCount = 1;
                while (chars[i - dotCount] != '/') {
                    dotCount++;
                }
                if (dotCount <= 2) {
                    if (stack.peek() == '.') {
                        int count = 1;
                        while (count <= 2) {
                            if (stack.size() == 0) {
                                break;
                            } else if (stack.pop() == '/') {
                                count++;
                            }
                        }
                    } else if (i != len - 1) {
                        stack.push(chars[i]);
                    }
                } else {
                    stack.push(chars[i]);
                }
            } else if (chars[i] == '/') {
                if (stack.peek() == '.') {
                    stack.pop();
                }
                if (stack.peek() == '/') {
                    stack.pop();
                }

                if (i < len - 1 || stack.isEmpty()) {
                    stack.push(chars[i]);
                }

            } else {
                stack.push(chars[i]);
            }
        }
        StringBuilder res = new StringBuilder();
        while (stack.size() > 0) {
            res.insert(0, stack.pop());
        }
        if (res.length() == 0) {
            return "/";
        }
        return res.toString();
    }


    public static void main(String[] args) {
        String test = "/a/d/b/....//.///../c/";
        SimplifyPath0071 simplifyPath0071 = new SimplifyPath0071();
        simplifyPath0071.simplifyPath(test);
        System.out.println(Arrays.toString(test.split("/")));
        for (String item : test.split("/")) {
            System.out.println(item);
        }
    }
}
