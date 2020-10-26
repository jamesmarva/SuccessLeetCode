package mine;

import java.awt.image.AreaAveragingScaleFilter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

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

    private final static int SCALA = 2;

    private final static Map<Character, Integer> CHAR_PRIORITY = new HashMap<>();

    static {
        CHAR_PRIORITY.put('(', 4);
        CHAR_PRIORITY.put('*', 3);
        CHAR_PRIORITY.put('/', 3);
        CHAR_PRIORITY.put('+', 2);
        CHAR_PRIORITY.put('-', 2);
        CHAR_PRIORITY.put(')', 1);
        CHAR_PRIORITY.put('=', 0);
    }


    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        String exp = "(8 + 1) * (8 + 1) / 9 =";

        calculator.checkBracketsAndRemoveSpace(exp);
        System.out.println(calculator.caculate(exp));

//        BigDecimal pre = new BigDecimal("64");
//        BigDecimal post = new BigDecimal("9");
//        System.out.println(pre.divide(post, SCALA, BigDecimal.ROUND_HALF_UP));
    }

    /**
     *
     * @param exp
     * @return
     */
    public BigDecimal caculate(String exp) {
        String newExp = checkBracketsAndRemoveSpace(exp);
        Deque<BigDecimal> numStack = new ArrayDeque<>();
        Deque<Character> charStack = new ArrayDeque<>();
        char[] expChars = newExp.toCharArray();
        StringBuilder tmpNumStr = new StringBuilder();
        for (char c : expChars){
            if (('0' <= c && c <= '9') || '.' == c) {
                tmpNumStr.append(c);
            } else {
                if (!tmpNumStr.toString().isEmpty()) {
                    BigDecimal tmpNum = new BigDecimal(tmpNumStr.toString());
                    numStack.addLast(tmpNum);
                    tmpNumStr = new StringBuilder();
                }
                while (charStack.size() > 0 && checkOperatorPriority(c, charStack)) {
                    char op = charStack.removeLast();
                    BigDecimal post= numStack.removeLast();
                    BigDecimal pre = numStack.removeLast();
                    switch (op) {
                        case '+':
                            numStack.addLast(pre.add(post));
                            break;
                        case '-':
                            numStack.addLast(pre.subtract(post));
                            break;
                        case '*':
                            numStack.addLast(pre.multiply(post));
                            break;
                        case '/':
                            try {
                                numStack.addLast(pre.divide(post));
                            } catch (ArithmeticException e) {
                                numStack.addLast(pre.divide(post, SCALA, BigDecimal.ROUND_HALF_UP));
                            }
                            break;
                        default:
                            break;
                    }
                }
                if (c != '=') {
                    if (c == ')') {
                        charStack.removeLast();
                    } else {
                        charStack.addLast(c);
                    }
                }
            }
        }
        return numStack.removeLast();
    }

    private boolean checkOperatorPriority(char op, Deque<Character> charStack) {
        if (charStack.size() > 0) {
            char tmpChar = charStack.getLast();
            if (LEFT_BRACKET == op || LEFT_BRACKET == tmpChar) {
                return false;
            }
            int op1Priority = CHAR_PRIORITY.get(op);
            int op2Priority = CHAR_PRIORITY.get(tmpChar);
            if (op1Priority <= op2Priority) {
                return true;
            } else {
                return false;
            }
        }
        throw new IllegalArgumentException("the charStack is empty");
    }

    /**
     * 确定括号是否成双
     * @param exp
     * @return
     */
    private String checkBracketsAndRemoveSpace(String exp) {
        if (exp == null || exp.isEmpty()) {
            throw new IllegalArgumentException("the expression is null or empty");
        }
        Deque<Character> stack = new ArrayDeque<>();
        char[] chars = exp.toCharArray();
        StringBuilder res = new StringBuilder();
        for (char tmp : chars) {
            if (LEFT_BRACKET == tmp) {
                stack.push(tmp);
            } else if (RIGHT_BRACKET == tmp) {
                if (stack.isEmpty()) {
                    throw new IllegalArgumentException("check expression brackets failing.");
                } else {
                    stack.pop();
                }
            }
            if (' ' == tmp) {
                continue;
            } else {
                res.append(tmp);
            }
        }
        if (!stack.isEmpty()) {
            throw new IllegalArgumentException("check expression brackets failing.");
        }
        return res.toString();
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
