package leet1001to1200.problem1093;

public class StatisticsFromLargeSample_1093 {


     public double[] sampleStats(int[] count) {
        int[] map = new int[256];
        int min = 256;
        int max = 0;
        int len = count.length;
        for (int i : count) {   
            map[i] ++;
        }
        int midIndex = len / 2;
        boolean isOdd = false;
        if ((len & 1) != 1) {
            isOdd = true;
        }
        for (int i = 0; i < 256; i++) {
            if (map[i] > 0) {
                if (min > i ) {
                    min = i;
                } else if (max < map[i]) {
                    max = i;
                }
            }
        }        
        
    }
}