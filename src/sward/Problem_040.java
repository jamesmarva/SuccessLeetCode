package sward;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/
 * 最小的k个数
 * @author Brilliant James
 * @date 2020-03-11 02:42
 **/
public class Problem_040 {

    public int[] getLeastNumbers(int[] arr, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> {
            return o2 - o1;
        });
        for (int item : arr) {
            queue.offer(item);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        int[] res = new int[k];
        while (queue.size() > 0) {
            k--;
            res[k] = queue.poll();
        }
        return res;
    }


    private void sortCore(int[] arr, int begin, int end) {
        if (begin >= end) {
            return;
        }
        int piovt = partition(arr, begin, end);
        sortCore(arr, begin, piovt - 1);
        sortCore(arr, piovt + 1, end);
    }

    public int[] getLeastNumbers_01(int[] arr, int k) {
        if (arr == null || arr.length < k){
            return arr;
        }
        int start = 0;
        int end = arr.length - 1;
        int pivot = partition(arr, start, end);
        while (pivot != k - 1) {
            if (pivot > k - 1) {
                end = pivot - 1;
                pivot = partition(arr, start, end);
            } else if (pivot <= k - 1) {
                start = pivot + 1;
                pivot = partition(arr, start, end);
            }
        }
        int[] res = new int[k];
        for (int i = 0; i < k; ++i) {
            res[i] = arr[i];
        }
        return arr;
    }

    private int partition(int[] arr, int begin, int end) {
        int index = begin;
        int value = arr[end];
        for (int i = begin; i < end; i++) {
            if (arr[i] < value) {
                if (i == index) {
                    index++;
                } else {
                    swap(arr, i, index);
                    index++;
                }
            }
        }
        swap(arr, index, end);
        return index;
    }
    private void swap(int[] arr, int a, int b) {
        int temp =arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }


    public static void main(String[] args) {
        int[] test = {3,2,1};
        Problem_040 p = new Problem_040();
        int[] res = p.getLeastNumbers(test,2);
        System.out.printf(Arrays.toString(res));

    }
}
