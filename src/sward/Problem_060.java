package sward;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Brilliant James
 * @date 2020-03-30 16:46
 **/
public class Problem_060 {

    Map<String, Integer> memory = new HashMap<>();

    public double[] twoSum(int n) {
        int len = (n * 6 - n) + 1;
        int[] count = new int[(n * 6 - n) + 1];
        for (int i = n ; i <= 6 * n; i++) {
            count[i - n] = getCount(n, i);
        }
        double[] ans = new double[len];

        double all = Math.pow(6, n);
        for (int i = 0; i < len; i++) {
            ans[i] = count[i] / all;
        }
        return ans;
    }

    private int getCount(int n, int sum) {
        if (n == 1) {
            return 1;
        }
        String key = n + " " + sum;
        if (memory.containsKey(key)) {
            return memory.get(key);
        }
        int ans = 0;
        for (int i = 1; i <= 6; i++) {
            int temp = sum - i;
            if (temp >= n - 1 && temp <= 6 * (n - 1)) {
                ans += getCount(n - 1, temp);
            }
        }
        memory.put(key, ans);
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Math.pow(6, 3));
        Problem_060 p = new Problem_060();
        double[] ans = p.twoSum(2);
        System.out.println(Arrays.toString(ans));
    }
}