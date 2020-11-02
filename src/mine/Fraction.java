package mine;

/**
 * 〈功能概述〉<br>
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
     * @param f
     * @return
     */
    public static Fraction reduceFraction(Fraction f) {
        int gcd = f.getGreatestCommonDivisor();
        f.numerator /= gcd;
        f.denominator /= gcd;
        return f;
    }


    public static void main(String[] args) {
        System.out.println( 21 % 3);
        System.out.println( 3 % 21);
    }
}
