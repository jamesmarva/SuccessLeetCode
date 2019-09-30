package leet0201to0400.problem0315;

import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;

/**
 * @author James
 * @program SuccessLeetCode
 * @description
 * https://leetcode-cn.com/problems/super-ugly-number/
 * @date 2019-09-29 18:09
 **/
public class SuperUglyNumber0313 {

    public int nthSuperUglyNumber(int n, int[] primes) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        HashSet<Integer> set = new HashSet<>();
        pq.offer(1);
        for (int i = 0; i < n; ++i) {
            int temp = pq.poll();
            System.out.println(temp);
            if (i == n - 1) {
                return temp;
            }
            for (int j = 0, len = primes.length; j < len; ++j) {
                if (!set.contains(primes[j] * temp)) {
                    pq.offer(primes[j] * temp);
                    set.add(primes[j] * temp);
                }
            }
        }
        return 0;
    }

    public int nthSuperUglyNumberMine(int n, int[] primes) {
        int k = primes.length;
        int[] indexs = new int[k];
        int[] memory =  new int[n];
        memory[0] = 1;
        int ans = memory[0];
        for(int i = 1; i < n; ++i) {
            int min = memory[indexs[0]] * primes[0];
            int minIndex = 0;
            for (int j = 1; j < k; ++j) {
                if (min > memory[indexs[j]] * primes[j]) {
                    min = memory[indexs[j]] * primes[j];
                    minIndex = j;
                }
            }
            if (min > memory[i - 1]) {
                memory[i] = min;
            } else {
                i--;
            }
            indexs[minIndex] ++;
        }
        return  memory[n - 1];
    }

    public static void main(String[] args) {
        int[] test = {2,7,13,19};
        int k = 12;
        SuperUglyNumber0313  superUglyNumber0313 = new SuperUglyNumber0313();
        int res = superUglyNumber0313.nthSuperUglyNumberMine(k, test);
        System.out.println(res);
    }
}
