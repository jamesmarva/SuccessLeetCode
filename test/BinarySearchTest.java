import java.util.Arrays;

/**
 * 〈功能概述〉<br>
 *
 * @author 王涵威
 * @date 21.5.20 17:08
 */
public class BinarySearchTest {


    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11, 0, 0, 0, 0};
//        System.out.println(Arrays.binarySearch(arr, 0, 5, 10));
//        System.out.println(binarySearch(arr, 0, 5, 10));
//
//        System.out.println(Arrays.binarySearch(arr, 0, 5, 0));
//        System.out.println(binarySearch(arr, 0, 5, 0));

        int[] test = {-2, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 23};
        for (int i : test) {
            if (Arrays.binarySearch(arr, 0, 5, i) != binarySearch(arr, 0, 5, i)) {
                System.out.println(i);
                System.out.println(Arrays.binarySearch(arr, 0, 5, i));
                System.out.println(binarySearch(arr, 0, 5, i));
                System.out.println("------------------------------------------");
            }
        }

        // 4    8   11
//        binarySearch(arr, 0, 5, 4);
    }

    public static int binarySearch(int[] arr, int l, int r, int tar) {
        int m = 0;
        while (l <= r) {
            m = l + ((r - l) >> 1);
            if (arr[m] == tar) {
                return m;
            } else if (m <= r && arr[m] < tar && arr[m + 1] > tar) {
                return -(m + 1 + 1);
            } else if (arr[m] > tar) {
                r = m - 1;
            } else if (arr[m] < tar) {
                l = m + 1;
            }
        }
        if (m == r) {
            return -(m + 1);
        } else {
            return -1;
        }
    }
}
