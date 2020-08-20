package other;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author Brilliant James
 * @date 2020-05-12 18:47
 **/
public class TopN {

    /**
     *
     */
    public int[] getTopN(int[] arr, int M) {
        if (arr == null || arr.length == 0 || M < 1) {
            throw new IllegalArgumentException("arr is null, or M is under zero.");
        }
        int pivot = 0;
        int left = 0;
        int right = arr.length - 1;
        while (pivot != M) {
            pivot = partition(arr, left, right);
            if (pivot > M) {
                right = pivot - 1;
            } else if (pivot < M) {
                left = pivot + 1;
            } else if (pivot == M) {
                break;
            }
        }
        int[] ans = new int[M];
        for (int i = 0; i < M; i++) {
            ans[i] = arr[i];
        }
        return ans;
    }

    private int partition(int[] arr, int start, int end) {
        int val = arr[end];
        int left = start;
        int right = end;
        while (left < right) {
            while (left < right && arr[left] > val) {
                left++;
            }
            while (left < right && arr[right] <= val) {
                right--;
            }
            if (left < right) {
                swap(arr, left, right);
            }
        }
        swap(arr, right, end);
        return right;
    }

    private void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public int[] quickSort(int[] arr) {
        quickSortCore(arr, 0, arr.length - 1);
        return arr;
    }
    public void quickSortCore(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int pivot = partition(arr, start, end);
        quickSortCore(arr, start, pivot - 1);
        quickSortCore(arr, pivot + 1, end);
    }

    public static void main(String[] args) {
        TopN topN = new TopN();
        //int[] test = {11, 121, 21, 3, 5, 6, 8, 9, 0, 2};
        int[] test = {11, 21, 3, 5, 121, 8, 99, 0, 2, 11, 21, 3, 5, 121, 8, 99, 0, 2, 33, 44, 556, 77, 88, 99, 27};
//        topN.quickSort(test);
        System.out.println(Arrays.toString(test));
        System.out.println(Arrays.toString(topN.getTopN( test, 10)));
    }

}
