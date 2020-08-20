package other;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author Brilliant James
 * @date 2020-04-23 19:33
 **/
public class CloudmallInterview1 {

public static int[] cloudmallInterview1(int[] Numbers) {
    if (Numbers == null) {
        throw new IllegalArgumentException("numbers is null.");
    }
    int left = -1;
    int right = Numbers.length;
    int i = 0;
    while (i < right && left < right) {
        if (Numbers[i] == 0) {
            i++;
        } else if (Numbers[i] < 0) {
            left++;
            swap(Numbers, i, left);
            i++;
        } else if (Numbers[i] > 0) {
            right--;
            swap(Numbers, i, right);
        }
    }
    return Numbers;
}

    private static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    public static void main(String[] args) {
        int[] numbers = {6, 4, -3, 0, 5, -2, -1, 0, 1, -9};
        cloudmallInterview1(numbers);
        System.out.println(Arrays.toString(numbers));
    }
}
