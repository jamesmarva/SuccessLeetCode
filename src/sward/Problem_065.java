package sward;

/**
 * @author Brilliant James
 * @date 2020-03-28 03:53
 **/
public class Problem_065 {

    public int add(int a, int b) {
        for (int i = 0; i < 32; i++) {
            int tempSum = a ^ b;
            int carrySum = (a & b) << 1;
            a = tempSum;
            b = carrySum;
        }
        return a;
    }

    public static void main(String[] args) {
        int a = (11 ^ 11) + (11 & 11) << 1;
        System.out.println(a);

        Problem_065 p = new Problem_065();
        int temp = p.add(11, 12);
        System.out.println(temp);
    }
}
