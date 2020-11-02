package mine;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.*;

/**
 * 实现计算器的逻辑
 *
 * @author 王涵威
 * @date 20.10.26 20:34
 */
public class Calculator {

//    ＋、-、×、÷
    private final static char LEFT_BRACKET = '(';

    private final static char RIGHT_BRACKET = ')';

    private final static char LEFT_SQUARE_BRACKET = '[';

    private final static char RIGHT_SQUARE_BRACKET = ']';

    private final static char SPACING = ' ';



    private final static char MULTIPLE_CHAR = '*';

    private final static char EQUAL_CHAR = '=';

    private final static int SCALA = 2;

    private final static Map<Character, Integer> CHAR_PRIORITY = new HashMap<>();

    static {
        CHAR_PRIORITY.put('(', 6);
        CHAR_PRIORITY.put('[', 5);
        CHAR_PRIORITY.put('^', 4);
        CHAR_PRIORITY.put('*', 3);
        CHAR_PRIORITY.put('/', 3);
        CHAR_PRIORITY.put('+', 2);
        CHAR_PRIORITY.put('-', 2);
        CHAR_PRIORITY.put(')', 1);
        CHAR_PRIORITY.put(']', 1);
        CHAR_PRIORITY.put('=', 0);
    }


    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        String exp = "(11 + 1) * (12 + 1) / 9 =";

        calculator.checkBracketsAndRemoveSpace(exp);
        System.out.println(calculator.calculate(exp));

//        BigDecimal pre = new BigDecimal("64");
//        BigDecimal post = new BigDecimal("9");
//        System.out.println(pre.divide(post, SCALA, BigDecimal.ROUND_HALF_UP));
    }

    /**
     *
     * @param exp
     * @return
     */
    public BigDecimal calculate(String exp) {
        String newExp = checkBracketsAndRemoveSpace(exp);
        Deque<BigDecimal> numStack = new ArrayDeque<>();
        Deque<Character> charStack = new ArrayDeque<>();
        char[] expChars = newExp.toCharArray();
        StringBuilder tmpNumStr = new StringBuilder();
        for (char curChar : expChars){
            if (('0' <= curChar && curChar <= '9') || '.' == curChar) {
                tmpNumStr.append(curChar);
            } else {
                if (!tmpNumStr.toString().isEmpty()) {
                    BigDecimal tmpNum = new BigDecimal(tmpNumStr.toString());
                    numStack.addLast(tmpNum);
                    tmpNumStr = new StringBuilder();
                }
                while (charStack.size() > 0 && checkOperatorPriority(curChar, charStack)) {
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
                        case '^':
                            try {
                                numStack.addLast(pre.pow(post.intValue()));
                            } catch (ArithmeticException e) {
                                numStack.addLast(pre.pow(post.intValue(), MathContext.DECIMAL64));
                            }
                        default:
                            break;
                    }
                }
                if (RIGHT_BRACKET == curChar && charStack.size() > 0
                        && LEFT_BRACKET == charStack.getLast()) {
                    charStack.removeLast();
                } else if (RIGHT_SQUARE_BRACKET == curChar && charStack.size() > 0
                        && LEFT_SQUARE_BRACKET == charStack.getLast()) {
                    charStack.removeLast();
                } else if (EQUAL_CHAR == curChar) {
                    break;
                } else {
                    charStack.addLast(curChar);
                }
            }
        }
        return numStack.removeLast();
    }

    private boolean checkOperatorPriority(char curChar, Deque<Character> charStack) {
        if (charStack.size() > 0) {
            char beforeChar = charStack.getLast();
            if (LEFT_BRACKET == curChar || LEFT_BRACKET == beforeChar || LEFT_SQUARE_BRACKET == beforeChar) {
                return false;
            }

            int currentPriority = CHAR_PRIORITY.get(curChar);
            int beforePriority = CHAR_PRIORITY.get(beforeChar);
            return currentPriority <= beforePriority;
        }
        throw new IllegalArgumentException("the charStack is empty");
    }

    /**
     * 确定括号是否成双，以及去除空格
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
            if (LEFT_BRACKET == tmp || LEFT_SQUARE_BRACKET == tmp) {
                stack.push(tmp);
            } else if (RIGHT_BRACKET == tmp) {
                if (stack.isEmpty() || LEFT_BRACKET != stack.getLast()) {
                    throw new IllegalArgumentException("check expression brackets failing.");
                } else if (stack.getLast() == LEFT_BRACKET) {
                    stack.removeLast();
                }
            } else if (RIGHT_SQUARE_BRACKET == tmp) {
                if (stack.isEmpty() || LEFT_BRACKET != stack.getLast()) {
                    throw new IllegalArgumentException("check expression square brackets failing.");
                } else if (stack.getLast() == RIGHT_SQUARE_BRACKET) {
                    stack.removeLast();
                }
            }
            if (SPACING != tmp) {
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

    private void checkIsValidChar() {
        
    }
}
