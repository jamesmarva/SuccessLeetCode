package leet;

/**
 * @author James
 * @date 2019-11-17 10:59
 **/
public class MaxSumDivThree_5265 {
    public int maxSumDivThree(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        dfs(0, 0, nums);
        return max;
    }

    private static int max = 0;
    private void dfs(int index, int temp, int[] nums) {
        if (index == nums.length) {
            if (temp % 3 == 0) {
                max = Math.max(temp, max);
            }
            return;
        }
        dfs(index + 1, temp, nums);
        dfs(index + 1, temp + nums[index], nums);
    }

    public int maxSumDivThree1(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        int sum = 0;
        int len = nums.length;
        for (int i = 0;i < len; i++) {
            sum += nums[i];
        }

        boolean[][] state = new boolean[len][sum + 1];
        dfs1(0, 0, nums, state);
        return max;
    }

    private void dfs1(int index, int temp, int[] nums, boolean[][] memory) {
        if (index == nums.length) {
            if (temp % 3 == 0) {

                max = Math.max(temp, max);
            }
            return;
        }
        if (memory[index][temp]) {
            return;
        }
        memory[index][temp] = true;
        dfs(index + 1, temp, nums);
        dfs(index + 1, temp + nums[index], nums);
    }


    public int maxSumDivThree2(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        int sum = 0;
        int len = nums.length;
        for (int i = 0;i < len; i++) {
            sum += nums[i];
        }

        boolean[][] states = new boolean[len][sum + 1];
        if (nums[0] % 3 == 0) {
            states[0][nums[0]] = true;
        }


        for (int i = 1; i < len; ++i) { // 动态规划状态转移
            for (int j = 0; j <= sum; j += 3) {// 不把第i个物品放入背包
                if (states[i-1][j] == true) {
                    states[i][j] = states[i-1][j];
                }
            }
            for (int j = 0; j <= sum - nums[i]; ++j) {//把第i个物品放入背包
                if (states[i-1][j]==true) {
                    states[i][j+nums[i]] = true;
                }
            }
        }
        for (int i = sum; i >= 0; --i) { // 输出结果
            if (states[len - 1][i] == true) {
                max = i;
                break;
            }
        }
        return max;
    }


    public static int maxSumDivThree3(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        int sum = 0;
        int len = nums.length;
        for (int i = 0;i < len; i++) {
            sum += nums[i];
        }

        boolean[] states = new boolean[sum + 1]; // 默认值false
        states[0] = true;  // 第一行的数据要特殊处理，可以利用哨兵优化
//        if (nums[0] <= sum) {
//            states[nums[0]] = true;
//        }
//
        for (int i = 0; i < len; ++i) { // 动态规划
            for (int j = sum - nums[i]; j >= 0; --j) {//把第i个物品放入背包
                if (states[j]) {
                    states[j + nums[i]] = true;
                }
            }
        }
        for (int i = sum; i >= 0; --i) { // 输出结果
            if (states[i] && i % 3 == 0) {
                max = i;
                break;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] test = {3,6,5,1,8};
        maxSumDivThree3(test);



    }

}
