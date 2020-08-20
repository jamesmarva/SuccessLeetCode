package sward;

import java.util.ArrayList;

/**
 * 约瑟夫环
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

    /**
     * 每次删除的时间复杂度是 O(n)O(n)，删除了 n-1n−1 次，所以整体时间复杂度是 O(n^2)。
     * leetcode 上该方法勉强可以通过，大概是 1s 多一点。
     * 所以基于 ArrayList 的模拟链表实现代码如下:
     * @param n
     * @param m
     * @return
     */
    public int lastRemaining00(int n, int m) {
        ArrayList<Integer> list = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int idx = 0;
        while (n > 1) {
            idx = (idx + m - 1) % n;
            list.remove(idx);
            n--;
        }
        return list.get(0);
    }

    public int lastRemaining01(int n, int m) {
        int ans = 0;
        // 最后一轮剩下2个人，所以从2开始反推
        for (int i = 2; i <= n; i++) {
            ans = (ans + m) % i;
        }
        return ans;
    }

}
