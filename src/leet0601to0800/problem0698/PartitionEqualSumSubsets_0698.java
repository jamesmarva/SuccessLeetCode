package leet0601to0800.problem0698;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author James
 * @date 2019-12-04 18:53
 **/
public class PartitionEqualSumSubsets_0698 {

    /**
     *  输入： nums = [4, 3, 2, 3, 5, 2, 1], k = 4
     *  输出： True
     *  说明： 有可能将其分成 4 个子集（5），（1,4），（2,3），（2,3）等于总和。
     */
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int len = nums.length;
        Arrays.sort(nums);
        int sum = Arrays.stream(nums).sum();
        int target = sum / k;
        if (sum % k > 0 || nums[len - 1] > target) {
            return false;
        }
        boolean[] visited = new boolean[len];
        dfs(visited, 0, 0, k, target, nums, len);
        return ans;
    }

    private boolean ans = false;
    private void dfs(boolean[] visited, int index, int temp, int k, int target, int[] nums, int len) {
        if (ans) {
            return;
        }
        if (k == 0) {
            ans = true;
            for (boolean item : visited){
                if(!item) {
                    ans =false;
                    return;
                }
            }
            return;
        }
        if (temp == target) {
            k--;
            dfs(visited, 0, 0, k, target,nums,len);
            return;
        }

        for (int i = index; i < len; i++) {
            if (visited[i]) {
                continue;
            }
            if (temp + nums[i] < target) {
                visited[i] = true;
                dfs(visited, index + 1, temp + nums[i], k, target, nums, len);
                visited[i] = false;
            }
        }
    }

}
