package leet0801to1000.problem0973;

import java.util.PriorityQueue;

/**
 * @author James
 * @program SuccessLeetCode
 * @description
 * https://leetcode-cn.com/problems/k-closest-points-to-origin/
 * @date 2019-09-30 01:43
 **/
public class KClosestPointsToOrigin0973 {

    class Position implements Comparable<Position> {
        int first;
        int second;

        Position(int first, int second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public int compareTo(Position o) {
            double theOther = Math.pow(o.first, 2) + Math.pow(o.second, 2);
            double theThis = Math.pow(this.first, 2) + Math.pow(this.second, 2);
            if (theOther > theThis ) {
                return 1;
            } else if (theOther < theThis) {
                return -1;
            } else {
                return 0;
            }
        }
    }
    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<Position> priorityQueue = new PriorityQueue<>();
        for (int[] item : points){
            priorityQueue.offer(new Position(item[0], item[1]));
        }
        int[][] ans = new int[K][2];
        for (int i = 0; i < K; ++i) {
            Position temp = priorityQueue.poll();
            ans[i][0] = temp.first;
            ans[i][1] = temp.second;
        }
        return ans;
    }

}
