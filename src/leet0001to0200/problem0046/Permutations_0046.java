package leet0001to0200.problem0046;

import java.util.ArrayList;
import java.util.List;

/**
 * @author James
 * @date 2019-12-01 13:30
 **/
public class Permutations_0046 {

    /**
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        ArrayList<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return ans;
        }
        dfs(0, nums, nums.length, ans);
        return ans;
    }

    private void dfs(int index,int[] nums, int len, List<List<Integer>> ans) {
        if (index == len) {
            ArrayList<Integer> list = new ArrayList<>(len);
            for (int i = 0; i < len; i++) {
                list.add(nums[i]);
            }
            ans.add(list);
        }
        for (int i = index; i < len; ++i) {
            swap(nums, index, i);
            dfs(index + 1, nums, len, ans);
            swap(nums, index, i);
        }
    }

    private void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

}
