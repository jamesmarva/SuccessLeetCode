package leet0001to0200.problem0149;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/max-points-on-a-line/
 * @author 王涵威
 * @date 21.6.24 11:03
 */
public class MaxPointsOnLine {

    public static void main(String[] args) {
        int[][] ps = {{7,3},{19,19},{-16,3},{13,17},{-18,1},{-18,-17},{13,-3},{3,7},{-11,12},{7,19},{19,-12},{20,-18},{-16,-15},{-10,-15},{-16,-18},{-14,-1},{18,10},{-13,8},{7,-5},{-4,-9},{-11,2},{-9,-9},{-5,-16},{10,14},{-3,4},{1,-20},{2,16},{0,14},{-14,5},{15,-11},{3,11},{11,-10},{-1,-7},{16,7},{1,-11},{-8,-3},{1,-6},{19,7},{3,6},{-1,-2},{7,-3},{-6,-8},{7,1},{-15,12},{-17,9},{19,-9},{1,0},{9,-10},{6,20},{-12,-4},{-16,-17},{14,3},{0,-1},{-18,9},{-15,15},{-3,-15},{-5,20},{15,-14},{9,-17},{10,-14},{-7,-11},{14,9},{1,-1},{15,12},{-5,-1},{-17,-5},{15,-2},{-12,11},{19,-18},{8,7},{-5,-3},{-17,-1},{-18,13},{15,-3},{4,18},{-14,-15},{15,8},{-18,-12},{-15,19},{-9,16},{-9,14},{-12,-14},{-2,-20},{-3,-13},{10,-7},{-2,-10},{9,10},{-1,7},{-17,-6},{-15,20},{5,-17},{6,-6},{-11,-8}};
        MaxPointsOnLine m = new MaxPointsOnLine();
        System.out.println(m.maxPoints(ps));
    }


    public int maxPoints(int[][] points) {
        int len = points.length;
        if (len <= 2) {
            return len;
        }
        Map<Pair, Set<String>> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            int[] p1 = points[i];
            int x1 = p1[0];
            int y1 = p1[1];
            for (int j = i + 1; j < len; j++) {
                int[] p2 = points[j];
                int x2 = p2[0];
                int y2 = p2[1];
                if (x1 == x2) {
                    Pair t = new Pair(null, null, x1);
                    map.computeIfAbsent(t, k -> new HashSet<>()).add(x1 + " " + y1);
                    map.get(t).add(x2 + " " + y2);
                    continue;
                }
                double a = getA(x1, y1, x2, y2);
                double b = getB(x1, y1, a);
                Pair t = new Pair(a, b);
                map.computeIfAbsent(t, k -> new HashSet<>()).add(x1 + " " + y1);
                map.get(t).add(x2 + " " + y2);
            }
        }
        int rst = 0;
        for (Map.Entry<Pair, Set<String>> entry : map.entrySet()) {
            Set<String> s = entry.getValue();
            System.out.println(entry.getKey());
            System.out.println(Arrays.toString(s.toArray()));
            rst = Math.max(entry.getValue().size(), rst);
            System.out.println("------------------------------");
        }
        return rst;
    }

    class Pair {
        Double a;
        Double b;
        int constX = 0;
        Pair(double a, double b) {
            this.a = a;
            this.b = b;
        }

        Pair(Double a, Double b, int constX) {
            this.a = a;
            this.b = b;
            this.constX = constX;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "a=" + a +
                    ", b=" + b +
                    '}';
        }


        @Override
        public boolean equals(Object o) {
            if (this == o) { return true; }
            if (!(o instanceof Pair)) { return false; }
            Pair pair = (Pair) o;
            return constX == pair.constX &&
                    Objects.equals(a, pair.a) &&
                    Objects.equals(b, pair.b);
        }

        @Override
        public int hashCode() {
            return Objects.hash(a, b, constX);
        }
    }

    /**
     *
     */
    double getA(int x1, int y1, int x2, int y2) {
        if (y1 == y2) {
            return 0;
        }
        return  ((y1 - y2) * 1.0) / (x1  - x2);
    }

    double getB(int x1, int y1, double a) {
        return y1 - (a * x1);
    }

}
