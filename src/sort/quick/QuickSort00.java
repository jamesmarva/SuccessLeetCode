package sort.quick;

import java.util.Arrays;
import java.util.List;

/**
 * <功能描述><br>
 *
 * @author Brilliant James Jamesmarva1993@gmail.com 2021-06-05 12:31
 **/
public class QuickSort00 {


    public static void main(String[] args) {
        QuickSort00 quickSort00 = new QuickSort00();

        int[] t1 = {21,12};
        quickSort00.quick(t1);
        System.out.println(Arrays.toString(t1));

        int[] t2 = {121};
        quickSort00.quick(t2);
        System.out.println(Arrays.toString(t2));

        int[] t3 = {12,1,12,1,2,12,11,2,3,23,23,2,3,34,34,5,4,5,4,5,45,4,45,45,4545,4,5,45,4,5,456567};
        quickSort00.quick(t3);
        System.out.println(Arrays.toString(t3));

        int[] t4 = {21, 21,21,21};
        quickSort00.quick(t4);
        System.out.println(Arrays.toString(t4));
    }


    public void quick(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    /**
     *
     * @param arr
     * @param s
     * @param e
     */
    public void quickSort(int[] arr, int s, int e) {
        if (s >= e) {
            return;
        }

        int pivotIdx = partition(arr, s, e);
        quickSort(arr, s, pivotIdx - 1);
        quickSort(arr, pivotIdx + 1, e);

    }

    public int partition(int[] arr, int lo, int hi) {
        int pivotVal = arr[hi];
        int left = lo - 1;
        int right = hi;
        while (true) {
            while (arr[++left] < pivotVal && left < right) {}
            while (arr[--right] > pivotVal && left < right) {}
            if (left < right) {
                swap(arr, left, right);
            } else {
                break;
            }
        }
        swap(arr, left, hi);
        return left;
    }

    public void swap(int[] arr, int a, int b) {
        int t = arr[a];
        arr[a] = arr[b];
        arr[b] = t;
    }
}
