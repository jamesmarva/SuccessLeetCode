package leet0001to0200.problem0057;

import java.util.LinkedList;

/**
 * 〈功能概述〉<br>
 *
 * @author 王涵威
 * @date 2020/7/15 18:46
 */
public class InsertInterval_0057 {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        int len = intervals.length;
        //
        int start = newInterval[0];

        int startIdx = 0;
        int indexInStartIdx = 0;
        int[] newArr = new int[2];
        int[][] tmpAns = new int[intervals.length][2];
        for (int i = 0; i < len; i++) {
            int tmpStart = intervals[i][0];
            int tmpEnd =  intervals[i][1];
            if (tmpStart > start) {
                newArr[0] = start;
                indexInStartIdx = 0;
                startIdx = i;
                break;
            } else if (tmpEnd >= start && tmpStart <= start) {
                newArr[0] = tmpStart;
                indexInStartIdx = 1;
                startIdx = i;
                break;
            }
        }
        int end = newInterval[1];
        int endIdx = 0;
        int indexInEndIdx = 0;
        for (int i = startIdx; i < len; i++) {
            int tmpStart = intervals[i][0];
            int tmpEnd =  intervals[i][1];
            if (tmpStart > end) {
                newArr[1] = end;
                endIdx = i;
                indexInEndIdx = 0;
                break;
            } else if (tmpEnd >= end && tmpStart <= end) {
                newArr[1] = tmpEnd;
                endIdx = i;
                indexInEndIdx = 1;
                break;
            }
        }
        LinkedList<int[]> list = new LinkedList<>();

        for (int i = 0; i < start - 1; i++) {
            list.add(intervals[i]);
        }
        list.add(newArr);

        //
        if (indexInStartIdx == 0 && indexInEndIdx == 0) {
            for (int i = endIdx; i < len; i++) {
                list.add(intervals[i]);
            }

        } else if (indexInStartIdx == 0 && indexInEndIdx == 1) {
            for (int i = endIdx + 1; i < len; i++) {
                list.add(intervals[i]);
            }
        } else if (indexInStartIdx == 1 && indexInEndIdx == 0) {
            for (int i = endIdx; i < len; i++) {
                list.add(intervals[i]);
            }

        } else if (indexInStartIdx == 1 && indexInEndIdx == 1) {
            for (int i = endIdx + 1; i < len; i++) {
                list.add(intervals[i]);
            }
        }
        int[][] ans = new int[list.size()][2];
        for (int i = 0, size = list.size(); i < size; i ++) {
            ans[i] = list.get(i);
        }
        return ans;
    }

    /**
     * [[1,3],[6,9]]
     * [2,5]
     * @param args
     */
    public static void main(String[] args) {
        InsertInterval_0057 insert = new InsertInterval_0057();
        int[][] demo = {{1,3}, {6,9}};
        int[] dd = {2, 5};
        insert.insert(demo, dd);
    }
}

