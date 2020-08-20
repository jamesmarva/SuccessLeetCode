package leet0001to0200.problem0136;

/**
 * @author Brilliant James
 * @date 2020-05-14 16:55
 **/
public class SingleNumber_0136 {

    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int i : nums) {
            ans ^= i;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(1 << 32);
    }
}
