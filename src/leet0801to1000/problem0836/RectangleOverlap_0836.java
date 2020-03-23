package leet0801to1000.problem0836;

/**
 * @author Brilliant James
 * @date 2020-03-18 00:35
 **/
public class RectangleOverlap_0836 {


    /**
     * 来打卡啦~矩形如果不重叠，在x轴和y轴上看，中间两条线段肯定是不相交的，也就是说左边的矩形的最右边小于右边矩形的最左边，
     * @param rec1
     * @param rec2
     * @return
     */
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        int x1 = rec1[0];
        int y1 = rec1[1];
        int x2 = rec1[2];
        int y2 = rec1[3];

        int a1 = rec2[0];
        int b1 = rec2[1];
        int a2 = rec2[2];
        int b2 = rec2[3];

       if (y1 >= b2 || b1 >= y2) {
           return false;
       }

       if (x2 <= a1 || a2 <= x1) {
           return false;
       }
       return true;
    }
}
