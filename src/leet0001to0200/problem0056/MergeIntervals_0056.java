package leet0001to0200.problem0056;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * @author Brilliant James
 * @date 2020-03-24 23:12
 **/
public class MergeIntervals_0056 {

    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0 || intervals[0].length == 0) {
            return new int[0][0];
        }
        int len = intervals.length;
        Pair[] arr = new Pair[len];
        for (int i = 0; i < len; i++) {
            Pair temp = new Pair(intervals[i][0], intervals[i][1]);
            arr[i] = temp;
        }
        Arrays.sort(arr, (o1, o2) -> {
            return o1.a - o2.a;
        });
        int count = 1;
        Pair pair = arr[0];
        ArrayList<Pair> ans = new ArrayList<>();
        while (count < len) {
            Pair temp = arr[count];
            if (temp.a <= pair.b) {
                pair.b = Math.max(pair.b, temp.b);
            } else {
                ans.add(new Pair(pair.a, pair.b));
                pair = new Pair(temp.a, temp.b);
            }
            count++;
        }
        ans.add(new Pair(pair.a, pair.b));
        int size = ans.size();
        int[][] res = new int[size][2];
        for (int i = 0; i < size; i++) {
            int[] temp = {ans.get(i).a, ans.get(i).b};
            res[i] = temp;
        }
        return res;
    }
    public int[][] merge2(int[][] intervals) {
        if (intervals.length == 0 || intervals[0].length == 0) {
            return intervals;
        }
        Arrays.sort(intervals, (o1, o2) ->  {
            return o1[0] - o2[0];
        });
        int len = intervals.length;
        LinkedList<int[]> list = new LinkedList<>();
        int[] index = intervals[0];
        for (int i = 1; i < len; i++) {
            int[] temp = intervals[i];
            if (temp[0] <= index[0]) {
                index[1] = Math.max(temp[1], index[1]);
            } else {
                int[] arr = {index[0], index[1]};
                list.add(arr);
                index[0] = temp[0];
                index[1] = temp[1];
            }
        }
        int[] arr = {index[0], index[1]};
        list.add(arr);
        int[][] res = new int[list.size()][2];
        for (int i = 0, size = list.size(); i < size; ++i) {
            res[i] = list.get(i);
        }
        return res;
    }



    public int[][] merge1(int[][] intervals) {
        if (intervals.length == 0 || intervals[0].length == 0) {
            return intervals;
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        LinkedList<int[]> list = new LinkedList<>();
        list.add(intervals[0]);
        for (int i = 1, len = intervals.length; i < len; ++i) {
            int[] temp = new int[2];
            int[] first = list.removeLast();
            int[] second = intervals[i];
            if (first[1] < second[0]) {
                list.addLast(first);
                list.addLast(second);
            } else {
                if (first[1] <= second[1]) {
                    temp[0] = first[0];
                    temp[1] = second[1];
                    list.addLast(temp);
                } else {
                    list.addLast(first);
                }
            }
        }
        int[][] res = new int[list.size()][2];
        for (int i = 0, len = list.size(); i < len; ++i) {
            res[i] = list.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 3}, {2, 6}, {8, 10}, {15, 18}, {0, 1}, {2, 4}, {3, 10}, {5, 15}};
        MergeIntervals_0056 m = new MergeIntervals_0056();
        m.merge(arr);
    }

    private class Pair {
        int a;
        int b;
        Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "a=" + a +
                    ", b=" + b +
                    '}';
        }
    }


}
