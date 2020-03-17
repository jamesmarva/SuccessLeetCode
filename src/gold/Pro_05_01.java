package gold;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Brilliant James
 * @date 2020-03-13 09:23
 **/
public class Pro_05_01 {

    /**
     * 错误的答案
     * @param N
     * @param M
     * @param i
     * @param j
     * @return
     */
    public int insertBits_wrong(int N, int M, int i, int j) {
        Set<Integer> set = new HashSet<>();
        for (int k = 0; k < 32; ++k) {
            if ((M & (1 << k)) != 0) {
                set.add(k);
            }
        }
        for (int item : set) {
            int tmp = 1 << (i + item);
            if ((N & tmp) == 0) {
                N &= tmp;
            }
        }
        return N;
    }

    /**
     * 1 清空 N的 i~j 位置的0；
     * 2 对 M 执行移位操作，与 j 和 i 之间的位对齐。
     * 3 合并 M 与 N。
     * @param N
     * @param M
     * @param i
     * @param j
     * @return
     */
    public int insertBits(int N, int M, int i, int j) {
        int allOne = ~0;
        //
        int left = allOne << (j + 1);
        int right = (1 << i) - 1;

        // 构造 mask ，用于方便 N 在i 和 j的之间清零
        int mask = left | right;

        // 1 清空 N的 i~j 位置的0；
        int nAfterClear = N & mask;

        // 2 移动 m
        int mAfterShift = M << i;

        // 3 合并 N 和 M
        return nAfterClear | mAfterShift;
    }


    public static void main(String[] args) {
        int allOne = ~0;
        int j = 31;
        System.out.println(allOne);
        System.out.println(allOne << (j + 1));
        System.out.println(allOne << j << 1);
    }
}
