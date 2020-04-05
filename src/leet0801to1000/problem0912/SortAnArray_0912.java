package leet0801to1000.problem0912;

import javax.print.DocFlavor;
import java.util.Arrays;

/**
 * @author Brilliant James
 * @date 2020-03-31 00:38
 **/
public class SortAnArray_0912 {

    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void quickSort(int[] a, int start, int end) {
        if (start >= end) {
            return;
        }
        int i = partitionThreeWay(a, start, end);
        quickSort(a, start, i - 1);
        quickSort(a, i + 1, end);
    }

    private int partitionTwoWay(int[] a, int start, int end) {
        int left = start;
        int val = a[start];
        int right = end + 1;
        while (true) {
            while (a[--left] < val) {
                if (left == end) {
                    break;
                }
            }
            while (a[++right] > val) {
                if (right == start) {
                    break;
                }
            }
            if (left >= right) {
                break;
            }
            swap(a, left, right);
        }
        swap(a, right, start);
        return right;
    }

    private int partitionThreeWay(int[] a, int start, int end) {
        int value = a[start];
        int index = start + 1;
        int left = start;
        int right = end + 1;
        while (index < right) {
            if (a[index] == value) {
                index++;
            } else if (a[index] < value) {
                left++;
                swap(a, index, left);
                index++;
            } else if (a[index] > value) {
                right--;
                swap(a, index, right);
            }
        }
        swap(a, start, left);
        return left;
    }

    private void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args) {
        int[] t = {5,2,3,1};
        SortAnArray_0912 s = new SortAnArray_0912();
        s.sortArray(t);
        System.out.println(Arrays.toString(t));
    }
}
