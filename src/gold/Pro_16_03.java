package gold;

/**
 * @author Brilliant James
 * @date 2020-04-12 02:10
 **/
public class Pro_16_03 {


    /**
     * [0,0]
     * [0,1]
     * [1,0]
     * [1,1]
     *
     *
     * [0,0]
     * [0,1]
     * [0,2]
     * [0,3]
     *
     * [1,1]
     * [-1,1]
     * [1,0]
     * [-3,2]
     * @param start1
     * @param end1
     * @param start2
     * @param end2
     * @return
     */
    public double[] intersection(int[] start1, int[] end1, int[] start2, int[] end2) {
        double[] ans = {};
        if (start1[0] > end1[0]) {
            int[] temp = start1;
            start1 = end1;
            end1 = temp;
        }
        if (start2[0] > end2[0]) {
            int[] temp = start2;
            start2 = end2;
            end2 = temp;
        }

        Double a1 = null;
        double b1 = 0;
        if (start1[0] - end1[0] != 0) {
            a1 = (double) (start1[1] - end1[1]) / (start1[0] - end1[0]);
            b1 = start1[1] - a1 *  start1[0];
        } else {
            b1 = start1[0];
        }

        Double a2 = null;
        double b2 = 0;
        if (start2[0] - end2[0] != 0) {
            a2 = (double) (start2[1] - end2[1]) / (start2[0] - end2[0]);
            b2 = start2[1] - a2 *  start2[0];
        } else {
            b2 = start2[0];
        }

        if (a1 == null && a2 == null)  {
            return compareYAndReturn(b1, b2, ans, start1, end1, start2, end2);
        }
        if (a1 == null) {
            double posX = b1;
            double posY = a2 * b1 + b2;
            return compareAndReturn(posX, posY, ans, start1, end1);
        }
        if (a2 == null) {
            double posX = b2;
            double posY = a1 * b2 + b1;
            return compareAndReturn(posX, posY, ans, start1, end1);
        }

        if (a1.equals(a2)) {
            return compareXAndReturn(b1, b2, ans, start1, end1, start2, end2);
        }

        double posX = (b2 - b1) / (a1 - a2);
        double posY = a1 * posX + b1;
        if (posX <= end1[0] && posX >= start1[0] && posX <= end2[0] && posX >= start2[0] ) {
            ans = new double[]{posX, posY};
            return ans;
        }
        return ans;
    }

    private double[] compareXAndReturn(double b1, double b2, double[] ans, int[] start1, int[] end1, int[] start2, int[] end2) {
        if (b1 == b2) {
            if (start1[0] <= start2[0] && start2[0] <= end1[0]) {
                ans = new double[]{start2[0], start2[1]};
            } else if (start2[0] <= start1[0] && start1[0] <= end2[0]) {
                ans = new double[]{start1[0], start1[1]};
            }
        }
        return ans;
    }

    private double[] compareYAndReturn(double b1, double b2, double[] ans, int[] start1, int[] end1, int[] start2, int[] end2) {
        if (b1 == b2) {
            if (start1[1] <= start2[1] && start2[1] <= end1[1]) {
                ans = new double[]{start2[0], start2[1]};
            } else if (start2[1] <= start1[10] && start1[1] <= end2[1]) {
                ans = new double[]{start1[0], start1[1]};
            }
        }
        return ans;
    }

    private double[] compareAndReturn(double posX, double posY, double[] ans, int[] start1, int[] end1) {
        if (posX <= end1[0] && posX >= start1[0] && posY <= end1[1] && posY >= start1[1]) {
            ans = new double[]{posX, posY};
            return ans;
        }
        return ans;
    }

    /**
     * [-54,26]
     * [8,-6]
     * [12,46]
     * [-44,-7]
     *
     * [-10,48]
     * [-43,46]
     * [-16,59]
     * [-1,85]
     * @param args
     */
    public static void main(String[] args) {
        double d = 1.5;
        int[] start1 = {-10, 48};
        int[] end1 = {-43, 46};
        int[] start2 = {-16, 59};
        int[] end2 = {-1, 85};
        Pro_16_03 p = new Pro_16_03();
        p.intersection(start1, end1, start2, end2);
        int i = 1;
        if (d > i) {
            System.out.println(d);
        }
    }
}
