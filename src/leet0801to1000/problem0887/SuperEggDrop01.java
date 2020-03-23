package leet0801to1000.problem0887;

import java.util.HashMap;

/**
 * @author Brilliant James
 * @date 2020-03-21 15:55
 **/
public class SuperEggDrop01 {

    private HashMap<String, Integer> map = new HashMap<>();

    public int superEggDrop(int K, int N) {
        if (K == 1) {
            return N;
        }
        if (N == 0) {
            return 0;
        }
        String state = K + " " + N;
        if (map.containsKey(state)) {
            return map.get(state);
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i <= N; ++i) {
            //
            //
            int temp = Math.max(superEggDrop(K, N - i), superEggDrop(K - 1, i - 1)) + 1;
            ans = Math.min(ans ,temp);
        }
        map.put(state, ans);
        return ans;
    }

}
