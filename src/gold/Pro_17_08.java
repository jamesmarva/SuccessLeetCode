package gold;


import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;


public class Pro_17_08 {

    public static void main(String[] args) {
        Pro_17_08 p = new Pro_17_08();
        // int[] h = {65,70,56,75,60,68};
        // int[] w = {100,150,90,190,95,110};

        int[] h = {120,110,90,60};
        int[] w = {41,43,40,38};
        System.out.println(p.bestSeqAtIndex(h, w));
    }
    

    public int bestSeqAtIndex(int[] height, int[] weight) {
        if (height.length != weight.length) {
            return 0;
        }

        List<Pair> list = new ArrayList<>();
        for (int i = 0, l = height.length; i < l; i++) {
            Pair p = new Pair(height[i], weight[i]);
            list.add(p);
        }

        list.sort((a, b) -> {
            if (b.getHeight() - a.getHeight() == 0) {
                return b.getWeight() - a.getWeight();
            } else {
                return b.getHeight() - a.getHeight();
            }
        });
        int[] dp = new int[list.size()];
        dp[0] = 1;
        int rst = 1;
        for (int i = 1, l = list.size(); i < l; i++) {
            int max = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (list.get(j).getHeight() > list.get(i).getHeight() && list.get(j).getWeight() > list.get(i).getWeight()) {
                    max = Math.max(max, dp[j] + 1);
                }
            }
            dp[i] = max;
            rst = Math.max(dp[i], rst);
        }
        return rst;
    }

    class Pair {
        int height;
        int weight;

        public Pair(int h, int w) {
            this.height = h;
            this.weight = w;
        }
        public int getHeight(){
            return this.height;
        }

        public int getWeight() {
            return this.weight;
        }

        @Override
        public String toString() {
            return "[h: " + height + ", w: " + weight + "]";
        }
    }

    public int bestSeqAtIndex1(int[] height, int[] weight) {
        int len = height.length;
        int[][] person = new int[len][2];
        for (int i = 0; i < len; ++i)
            person[i] = new int[]{height[i], weight[i]};

        Arrays.sort(person, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int[] dp = new int[len];
        int res = 0;
        for (int[] pair : person) {
            int i = Arrays.binarySearch(dp, 0, res, pair[1]);
            if (i < 0)
                i = -(i + 1);
            dp[i] = pair[1];
            if (i == res)
                ++res;
        }
        return res;
    }

}
