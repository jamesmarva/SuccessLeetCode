package leet201to400.problem0338;

/**
 * @program: SuccessLeetCode
 * @description: https://leetcode-cn.com/problems/counting-bits/
 * 给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
 *
 * 示例 1:
 *
 * 输入: 2
 * 输出: [0,1,1]
 * 示例 2:
 *
 * 输入: 5
 * 输出: [0,1,1,2,1,2]
 * 进阶:
 *
 * 给出时间复杂度为O(n*sizeof(integer))的解答非常容易。但你可以在线性时间O(n)内用一趟扫描做到吗？
 * 要求算法的空间复杂度为O(n)。
 * 你能进一步完善解法吗？要求在C++或任何其他语言中不使用任何内置函数（如 C++ 中的 __builtin_popcount）来执行此操作。
 *
 * @author: James
 * @create: 2019-09-09 07:28
 **/
public class CountingBits0338 {


    /**
     * 这是我的解法，就是根据一个数算二进制的基本的算术方法。
     * @param num
     * @return
     */
    public int[] countBits(int num) {
        int[] result = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            int temp = 0;
            int tempNum = i;
            while(tempNum > 0) {
                temp = temp + tempNum % 2;
                tempNum = tempNum/2;
            }
            result[i] = temp;
        }
        return result;
    }

    /**
     * 1ms 的例子代码
     * @param num
     * @return
     */
    public int[] countBits1ms(int num) {
        int[] res = new int[num+1];
        res[0] = 0;
        //先将所有的num转化为偶数处理，因为没有都是处理两个数
        /**
         2：递推关系式　　　　
         a[n] = a[n/2]     　　　　　n为偶数
         a[n] = a[n-1] +1　　　　　　 n为奇数

         3：初始化：a[0] = 0
         **/

        int n = num%2 != 0 ? num - 1:num;
        for(int i = 1; i <= n;i++) {
            res[i] = res[i-1]+1;//奇数
            i++;
            res[i] = res[i/2];//偶数
        }
        //最后有个奇数没有处理
        if(num % 2 != 0) {
            res[num] = res[n] + 1;
        }
        return res;
    }

    /**
     * 2ms的例子
     * @param num
     * @return
     */
    public int[] countBits2ms(int num) {
        int [] res  = new int[num + 1];
        for(int i = 0; i <= num; i++){
            int count = 0, interim = i;
            while (interim != 0) {
                interim = interim & (interim - 1);
                count++;
            }
            res[i]=count;
        }
        return res;
    }
}
