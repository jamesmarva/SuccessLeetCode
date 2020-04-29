package gold;

/**
 * @author Brilliant James
 * @date 2020-04-07 06:22
 **/
public class Pro_10_01 {

    public void merge(int[] A, int m, int[] B, int n) {
        int len = A.length;
        int index = len - 1;
        while(m >= 0 && n >= 0) {
            if (A[m] > B[n]) {
                A[index] = A[m];
                m--;
            } else {
                A[index] = B[n];
                n--;
            }
            index--;
        }
        while (m >= 0) {
            A[index] = A[m];
            m--;
            index--;
        }
        while (n >= 0) {
            A[index] = B[n];
            n--;
            index--;
        }
    }

    public static void main(String[] args) {
//        System.out.println((1000 / 16));
//
//        System.out.println((1000 >> 4));
//
//
//        System.out.println((666 / 16));
//        System.out.println((666 >> 4));
//
//        System.out.println((666 >> 4));


        System.out.println((125 % 16));
        System.out.println((125 & 15));
        System.out.println((126 % 16));
        System.out.println((126 & 15));
        System.out.println((127 % 16));
        System.out.println((127 & 15));


    }
}
