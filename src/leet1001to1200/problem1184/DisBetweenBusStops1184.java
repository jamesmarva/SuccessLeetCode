package leet1001to1200.problem1184;

/**
 * @author James
 * @program SuccessLeetCode
 * @description
 * @date 2019-10-05 08:22
 **/
public class DisBetweenBusStops1184 {

    public static  int distanceBetweenBusStops(int[] distance, int start, int destination) {
        if (distance == null || distance.length == 0 || start == destination) {
            return 0;
        }
        int len = distance.length;
        int ans = 0;
        for (int i = start; i % len != destination; ++i) {
                ans += distance[i % len];
        }
        int ans2 = 0;
        for (int i = destination; i % len != start; ++i) {
            ans2 += distance[i % len];
        }
        return Math.min(ans, ans2);
    }

    public static void main(String[] args) {
        int tes = -5;

        System.out.println(tes % 10);

        int[] test = {3,6,7,2,9,10,7,16,11};
//                   [0,1,2,3,4, 5,6, 7, 8]
//6
//2

        System.out.println(distanceBetweenBusStops(test, 6, 2));
    }
}
