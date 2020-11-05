package mine;

/**
 *
 *
 * @author 王涵威
 * @date 20.11.2 21:01
 */
public class Fraction {

    /* 分子 */
    public int numerator;

    /* 分母 */
    public int denominator;

    Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    /**
     * 寻找最大的公约数
     * @return 最大这个分数的最大公约数
     */
    public int getGreatestCommonDivisor(){
        int small = numerator;
        int big = denominator;
        if (numerator > denominator) {
            small = denominator;
            big = numerator;
        }
        int tmp;
        while (small != 0) {
            tmp = big % small;
            big = small;
            small = tmp;
        }
        return big;
    }

    /**
     * 化简的逻辑就是把两个数的同时除以最大公约数(GreatestCommonDivisor)
     */
    public static Fraction reduceFraction(Fraction f) {
        int gcd = f.getGreatestCommonDivisor();
        f.numerator /= gcd;
        f.denominator /= gcd;
        return f;
    }

    /**
     *
     * @param pre 加数
     * @param post  加数
     * @return 和
     */
    public static Fraction plus(Fraction pre, Fraction post) {
        int preNumerator = pre.numerator * post.denominator;
        int postNumerator = post.numerator * pre.denominator;

        int commonDenominator = pre.denominator * post.denominator;
        Fraction sum = new Fraction(preNumerator + postNumerator, commonDenominator);
        return reduceFraction(sum);
    }

    /**
     *
     * @param pre 被减数
     * @param post 减数
     * @return 差
     */
    public static Fraction minus(Fraction pre, Fraction post) {
        int preNumerator = pre.numerator * post.denominator;
        int postNumerator = post.numerator * pre.denominator;

        int commonDenominator = pre.denominator * post.denominator;
        Fraction difference = new Fraction(preNumerator - postNumerator, commonDenominator);
        return reduceFraction(difference);
    }

    /**
     *
     * @param pre 乘数
     * @param post 乘数
     * @return 积
     */
    public static Fraction multiple(Fraction pre, Fraction post) {
        Fraction product = new Fraction(
                pre.numerator * post.numerator,
                pre.denominator * post.denominator
        );
        return reduceFraction(product);
    }


    /**
     *
     * @param pre 被除数
     * @param post 除数
     * @return 商
     */
    public static Fraction divide(Fraction pre, Fraction post) {
        Fraction divisor = new Fraction(
                pre.numerator * post.denominator,
                pre.denominator * post.numerator
        );
        return reduceFraction(divisor);
    }

    @Override
    public String toString() {
        return "\\frac{" + this.numerator  + "}{" + this.denominator + "}";
    }

    /**
     *
     * @param pre
     * @param count
     * @return
     */
    public static Fraction pow(Fraction pre, Double count) {
        Fraction divisor = new Fraction(
                (int) Math.pow(pre.numerator, count),
                (int) Math.pow(pre.denominator, count)
        );
        return reduceFraction(divisor);
    }


    public static void main(String[] args) {
//        Fraction pre = new Fraction(18, 1);
//        Fraction post = new Fraction(4, 9);
//        System.out.println(Fraction.multiple(pre, post));

        Fraction pre = new Fraction(1, 3);
        Fraction post = new Fraction(1, 4);
        System.out.println(Fraction.plus(pre, post));
        System.out.println(Fraction.minus(pre, post));
        System.out.println(Fraction.multiple(pre, post));
        System.out.println(Fraction.divide(pre, post));

        Fraction tmp = Fraction.minus(pre, post);
        System.out.println(Fraction.multiple(new Fraction(12, 1), tmp));

    }
}
