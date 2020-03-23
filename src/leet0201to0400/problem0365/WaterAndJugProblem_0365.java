package leet0201to0400.problem0365;

import javax.management.StandardEmitterMBean;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/water-and-jug-problem/
 * 365. 水壶问题
 *
 * 1 每一步只能对一个水壶针对一个操作
 * 2 一个水壶如果是空的，那么剩下只有一个操作，就是灌满
 *
 * @author Brilliant James
 * @date 2020-03-21 11:49
 **/
public class WaterAndJugProblem_0365 {

    public boolean canMeasureWater(int x, int y, int z) {
        HashSet<Pair> visited = new HashSet<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(0, 0));
        while (queue.size() > 0) {
            Pair tmp = queue.poll();
            if (tmp.x == z || tmp.y == z || (tmp.sum() == z)) {
                return true;
            }
            if (tmp.x == 0) {
                // 灌满 x
                Pair pair = new Pair(x, tmp.y);
                addPair(pair, queue, visited);
            }
            if (tmp.y == 0) {
                // 灌满 y
                Pair pair = new Pair(tmp.x, y);
                addPair(pair, queue, visited);
            }
            if (tmp.x > 0) {
                // 清空 x
                Pair pair = new Pair(0, tmp.y);
                addPair(pair, queue, visited);
                // 灌满 x
                pair = new Pair(x, tmp.y);
                addPair(pair, queue, visited);

                // 往另一个瓶里倒
                int yLeft = y - tmp.y;
                if (yLeft > tmp.x) {
                    pair = new Pair(0, tmp.y + tmp.x);
                } else {
                    pair = new Pair(tmp.x - yLeft, y);
                }
                addPair(pair, queue, visited);
            }
            if (tmp.y > 0) {
                // 清空 y
                Pair pair = new Pair(tmp.x, 0);
                addPair(pair, queue, visited);
                // 灌满 y
                pair = new Pair(tmp.x, y);
                addPair(pair, queue, visited);

                // 往另一个瓶里倒
                int xLeft = x - tmp.x;
                if (xLeft > tmp.y) {
                    pair = new Pair(tmp.x + tmp.y, 0);
                } else {
                    pair = new Pair(x, tmp.y - xLeft);
                }
                addPair(pair, queue, visited);
            }
        }
        return false;
    }

    private void addPair(Pair pair, Queue<Pair> q, HashSet<Pair> s) {
        if (s.add(pair)) {
            q.offer(pair);
        }
    }

    private class Pair {
        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int sum() {
            return this.x + this.y;
        }
        @Override
        public int hashCode() {
            return x * 10 + y;
        }

        @Override
        public boolean equals(Object o) {
            if (o instanceof Pair) {
                Pair tmp = (Pair) o;
                if (tmp.x == this.x && tmp.y == this.y) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
    }


    /**
     * 找到x,y的最大公约数能否z被整除
     *
     */
    public boolean canMeasureWater_01(int x, int y, int z) {
        if (z == 0) {
            return true;
        }
        if (x + y < z) {
            return false;
        }
        int small = x;
        int big = y;
        if (x > y) {
            small = y;
            big = x;
        }
        if (small == 0) {
            return big == z;
        }

        while (big % small != 0) {
            int tempSmall = big % small;
            big = small;
            small = tempSmall;
        }
        return z % small == 0;
    }
}
