package mine;

import utils.FileUtils;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.MathContext;
import java.text.DecimalFormat;
import java.util.*;

/**
 * 实现计算器的逻辑
 *
 * @author 王涵威
 * @date 20.10.26 20:34
 */
public class Calculator {

    private final static char LEFT_BRACKET = '(';

    private final static char RIGHT_BRACKET = ')';

    private final static char LEFT_SQUARE_BRACKET = '[';

    private final static char RIGHT_SQUARE_BRACKET = ']';

    private final static char LEFT_BRACE = '{';

    private final static char RIGHT_BRACE = '}';

    private final static char SPACING = ' ';

    private final static char MULTIPLE = '*';

    private final static char DIVISION ='/';

    private final static char PLUS = '+';

    private final static char MINUS = '-';

    private final static char POW = '^';

    private final static char EQUAL = '=';

    private final static int SCALA = 2;

    private final static Map<Character, Integer> CHAR_PRIORITY = new HashMap<>();

    private final static String RIGHT = "right";

    private final static String LEFT = "left";

    private final static String TIMES = "times";

    private final static String DIV = "div";

    private final static String FRAC = "frac";

    private final static Map<String, Character> WORD_TO_CHAR = new HashMap<>();

    private static CalculatorTireNode root;

    static {
        CHAR_PRIORITY.put(LEFT_BRACKET, 6);
        CHAR_PRIORITY.put(LEFT_SQUARE_BRACKET, 5);
        CHAR_PRIORITY.put(POW, 4);
        CHAR_PRIORITY.put(MULTIPLE, 3);
        CHAR_PRIORITY.put(DIVISION, 3);
        CHAR_PRIORITY.put(PLUS, 2);
        CHAR_PRIORITY.put(MINUS, 2);
        CHAR_PRIORITY.put(RIGHT_BRACKET, 1);
        CHAR_PRIORITY.put(RIGHT_SQUARE_BRACKET, 1);
        CHAR_PRIORITY.put(EQUAL, 0);

        root = new CalculatorTireNode(' ');
        root.insert(RIGHT);
        root.insert(LEFT);
        root.insert(TIMES);
        root.insert(DIV);
        root.insert(FRAC);

        WORD_TO_CHAR.put(TIMES, '*');
        WORD_TO_CHAR.put(DIV, '/');
    }

    /**
     * 不带精度的，默认用的 SCALA
     * @param exp 算式表达式
     * @return 计算结果
     */
    public BigDecimal calculate(String exp) {
        return calculate(exp, SCALA);
    }

    /**
     * 带精度的计算
     * @param exp 算式表达式
     * @return 计算结果
     */
    public BigDecimal calculate(String exp, int scala) {
        String newExp = replaceFormulaFromBaidu(exp);
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
                        case PLUS:
                            numStack.addLast(pre.add(post));
                            break;
                        case MINUS:
                            numStack.addLast(pre.subtract(post));
                            break;
                        case MULTIPLE:
                            numStack.addLast(pre.multiply(post));
                            break;
                        case DIVISION:
                            try {
                                numStack.addLast(pre.divide(post));
                            } catch (ArithmeticException e) {
                                numStack.addLast(pre.divide(post, scala, BigDecimal.ROUND_HALF_UP));
                            }
                            break;
                        case POW:
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
                } else if (EQUAL == curChar) {
                    break;
                } else {
                    charStack.addLast(curChar);
                }
            }
        }
        return numStack.removeLast();
    }

    /**
     * 根据表达式和精度值来确定数据
     * @param exp 算式表达式
     * @return 正确的结果集
     */
    public Set<String> calculateWithFormula(String exp, Integer scala) {
        Fraction fractionResult = calculateFraction(exp);
        BigDecimal numerator = new BigDecimal(fractionResult.numerator);
        BigDecimal denominator = new BigDecimal(fractionResult.denominator);
        BigDecimal decimalResult = new BigDecimal("0");
        try {
            decimalResult = numerator.divide(denominator);
        } catch (ArithmeticException e) {
            decimalResult = numerator.divide(denominator, null == scala ? SCALA : scala, BigDecimal.ROUND_HALF_UP);
        }
        Set<String> result = new HashSet<>(){{
            add(fractionResult.toString());
        }};
        result.add(decimalResult.toString());
        return result;
    }

    /**
     *
     * @param exp 算式表达式
     * @return 分数的结果
     */
    public Fraction calculateFraction(String exp) {
        String newExp = replaceFormulaFromBaidu(exp);
        Deque<Fraction> numStack = new ArrayDeque<>();
        Deque<Character> charStack = new ArrayDeque<>();
        char[] expChars = newExp.toCharArray();
        for (int i = 0, l = expChars.length; i < l; i++) {
            char curChar = expChars[i];
            if (('0' <= curChar && curChar <= '9') || '.' == curChar) {
                StringBuilder numTmp = new StringBuilder();
                int dotIdx = -1;
                while (i < l && (((curChar = expChars[i]) >= '0' && curChar <= '9') || '.' == curChar)) {
                    if ('.' == curChar) {
                        dotIdx = i;
                    } else {
                        numTmp.append(curChar);
                    }
                    i++;
                }
                int denominator = 1;
                if (dotIdx != -1) {
                    denominator = (int) Math.pow(10, i - dotIdx - 1);
                }
                Fraction f = new Fraction(Integer.parseInt(numTmp.toString()), denominator);
                numStack.addLast(f);
                i--;
            } else if (curChar == '\\') {
                StringBuilder tmpFrac = new StringBuilder();
                i++;
                for (int j = 0; j < 4; i++, j++) {
                    tmpFrac.append(expChars[i]);
                    if (j == 3) {
                        break;
                    }
                }
                if (FRAC.equals(tmpFrac.toString())) {
                    StringBuilder numerator = new StringBuilder();
                    StringBuilder denominator = new StringBuilder();
                    List<Character> braceList = new ArrayList<>();
                    while (++i < l) {
                        curChar = expChars[i];
                        if (curChar == LEFT_BRACE) {
                            braceList.add(curChar);
                        } else if (curChar == RIGHT_BRACE) {
                            if (braceList.size() == 3) {
                                break;
                            }
                            braceList.add(curChar);
                        } else if (curChar >= '0' && curChar <= '9') {
                            if (braceList.size() <= 2 && braceList.size() >= 1) {
                                numerator.append(curChar);
                            } else {
                                denominator.append(curChar);
                            }
                        }
                    }
                    numStack.addLast(new Fraction(Integer.parseInt(numerator.toString()),
                            Integer.parseInt(denominator.toString())));
                } else {
                    throw new IllegalArgumentException("the expression is illegal.");
                }
            } else {
                while (charStack.size() > 0 && checkOperatorPriority(curChar, charStack)) {
                    char preOperator = charStack.removeLast();
                    Fraction post = numStack.removeLast();
                    Fraction pre = numStack.removeLast();
                    switch (preOperator) {
                        case PLUS:
                            numStack.addLast(Fraction.plus(pre, post));
                            break;
                        case MINUS:
                            numStack.addLast(Fraction.minus(pre, post));
                            break;
                        case MULTIPLE:
                            numStack.addLast(Fraction.multiple(pre, post));
                            break;
                        case DIVISION:
                            numStack.addLast(Fraction.divide(pre, post));
                            break;
                        case POW:
                            numStack.addLast(Fraction.pow(pre,
                                    Double.parseDouble(new DecimalFormat("0.00")
                                            .format((double) post.numerator/post.denominator))));
                            break;
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
                } else if (EQUAL == curChar) {
                    break;
                } else {
                    charStack.addLast(curChar);
                }
            }
        }
        return numStack.removeLast();
    }

    /**
     * 百度的去公式
     * @param exp 算式表达式
     */
    private String replaceFormulaFromBaidu(String exp) {
        Deque<Character> stack = new ArrayDeque<>();
        char[] chars = exp.toCharArray();
        StringBuilder res = new StringBuilder();
        for (int i = 0, l = chars.length; i < l; i++) {
            char tmp = chars[i];
            if (tmp == '\\') {
                CalculatorTireNode idx = root;
//                to be continued ... 待验证 ++i 的逻辑是否正确
                while (++i < l
                        && ((tmp = chars[i]) == '\\' || (tmp >= 'a' && tmp <= 'z'))) {
                    idx = idx.find(tmp);
                    if (null != idx && idx.isWord()) {
                        if (null != WORD_TO_CHAR.get(idx.getWord())) {
                            res.append(WORD_TO_CHAR.get(idx.getWord()));
                        } else if (FRAC.equals(idx.getWord())){
                            res.append("\\" + FRAC);
                        }
                    } else if (null == idx) {
                        throw new IllegalArgumentException("the expression is illegal.");
                    }
                }
            }

            if (tmp == POW) {
                res.append(tmp);
                Deque<Character> braceStack = new ArrayDeque<>();
                while (++i < l) {
                    tmp = chars[i];
                    if (tmp == LEFT_BRACE) {
                        //
                        if (braceStack.size() > 0) {
                            res.append(tmp);
                        }
                        braceStack.addLast(tmp);
                    } else if (tmp == RIGHT_BRACE) {
                        if (braceStack.size() > 0) {
                            braceStack.removeLast();
                        }
                        if (braceStack.isEmpty()) {
                            break;
                        }
                    } else if (SPACING != tmp){
                        res.append(tmp);
                    }
                }
                tmp = chars[++i];
            }

            if (LEFT_BRACKET == tmp || LEFT_SQUARE_BRACKET == tmp) {
                stack.addLast(tmp);
            } else if (RIGHT_BRACKET == tmp) {
                if (stack.isEmpty() || LEFT_BRACKET != stack.getLast()) {
                    throw new IllegalArgumentException("check expression brackets failing.");
                } else if (stack.getLast() == LEFT_BRACKET) {
                    stack.removeLast();
                }
            } else if (RIGHT_SQUARE_BRACKET == tmp) {
                if (stack.isEmpty() || LEFT_SQUARE_BRACKET != stack.getLast()) {
                    throw new IllegalArgumentException("check expression square brackets failing.");
                } else if (LEFT_SQUARE_BRACKET == stack.getLast()) {
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

    private void checkExpressionIsNullOrEmpty(String exp) {
        if (exp == null || exp.isEmpty()) {
            throw new IllegalArgumentException("the expression is null or empty");
        }
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
     * @param exp 算式表达式
     * @return 去除空格会后的字符串
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
                stack.addLast(tmp);
            } else if (RIGHT_BRACKET == tmp) {
                if (stack.isEmpty() || LEFT_BRACKET != stack.getLast()) {
                    throw new IllegalArgumentException("check expression brackets failing.");
                } else if (stack.getLast() == LEFT_BRACKET) {
                    stack.removeLast();
                }
            } else if (RIGHT_SQUARE_BRACKET == tmp) {
                if (stack.isEmpty() || LEFT_SQUARE_BRACKET != stack.getLast()) {
                    throw new IllegalArgumentException("check expression square brackets failing.");
                } else if (LEFT_SQUARE_BRACKET == stack.getLast()) {
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

    private int findInChars(char[] chars, char key) {
        if (chars == null || chars.length == 0) {
            throw new IllegalArgumentException("the array is null.");
        }
        for (int i = 0, l = chars.length; i < l; i++) {
            if (chars[i] == '.') {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        Calculator calculator = new Calculator();
        String epx = " ( \\frac { 3 } { 4 } - \\frac { 1 } { 8 } ) \\div \\frac { 5 } { 8 }";

//        String exp = "[(11 + 1)] * [(12 + 1) + 1] / 9 =";
//        calculator.checkBracketsAndRemoveSpace(exp);
//        System.out.println(calculator.calculate(exp));
//        String fiePath = "D:\\MyWork\\homework_correction\\Test\\test_expression.txt";
//        List<String> exps = FileUtils.getListOfStringBufferedStreamReadFile(fiePath);
//        for (String e : exps) {
//            System.out.println("expression is: " + e + "; \t result is: " + calculator.calculate(e));
//        }
//        BigDecimal pre = new BigDecimal("64");
//        BigDecimal post = new BigDecimal("9");
//        System.out.println(pre.divide(post, SCALA, BigDecimal.ROUND_HALF_UP));
    }

}
