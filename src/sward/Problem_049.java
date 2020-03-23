package sward;

/**
 * @author Brilliant James
 * @date 2020-03-22 14:04
 **/
public class Problem_049 {

    public int nthUglyNumber(int n) {
        int index2 = 0;
        int index3 = 0;
        int index5 = 0;
        int count = 1;
        int[] arr = new int[n ];
        while (count < n) {
            arr[count] = Math.min(Math.min(arr[index2] * 2, arr[index3] * 3), arr[index5] * 5);
            if (arr[count] == arr[index2] * 2) {
                index2++;
            }

            if (arr[count] == arr[index3] * 3) {
                index3++;
            }

            if (arr[count] == arr[index5] * 5) {
                index5++;
            }
        }
        return arr[n - 1];
    }
}
