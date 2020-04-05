package sward;

import java.util.ArrayList;

/**
 * @author Brilliant James
 * @date 2020-03-30 14:53
 **/
public class Problem_062 {

    public int lastRemaining(int n, int m) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int size = n;
        int cur = (m - 1) % size;
        for (int i = 0; i <= n - 2; i++) {
            list.remove(cur);
            size--;
            cur = (cur + m - 1) % size;
        }
        return list.get(0);
    }

    public int lastRemaining_01(int n, int m) {
        int last = 0;
        for (int i = 2; i <= n; i++) {
            last = (last + m) % i;
        }
        return last;
    }
}
