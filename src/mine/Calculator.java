package mine;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * 实现计算器的逻辑
 *
 * @author 王涵威
 * @date 20.10.26 20:34
 */
public class Calculator {


//    ＋、-、×、÷
//
    private final static char LEFT_BRACKET = '(';

    private final static char RIGHT_BRACKET = ')';

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        String exp = "(8 + 8 + ( 0 + 9)";
        System.out.println(calculator.checkBrackets(exp));
    }


    /**
     * 确定括号是否成双
     * @param exp
     * @return
     */
    private boolean checkBrackets(String exp) {
        if (exp == null || exp.isEmpty()) {
            throw new IllegalArgumentException("the expression is null or empty");
        }
        Deque<Character> stack = new ArrayDeque<>();
        char[] chars = exp.toCharArray();
        for (char tmp : chars) {
            if (LEFT_BRACKET == tmp) {
                stack.push(tmp);
            } else if (RIGHT_BRACKET == tmp) {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();
    }

    /**
     * 去除空格
     * @param exp
     * @return
     */
    private String removeSpace(String exp) {
        return exp != null ? exp.replaceAll(" ", "") : "";
    }

}
