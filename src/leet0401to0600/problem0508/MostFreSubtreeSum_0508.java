package leet0401to0600.problem0508;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author James
 * @date 2019-12-05 02:15
 **/
public class MostFreSubtreeSum_0508{

    private Map<Integer, Integer> map = new HashMap<>();

    public int[] findFrequentTreeSum(TreeNode root) {
        if (root == null ) {
            return new int[0];
        }
        dfs(root);
//        ArrayList<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
//        list.sort((o1, o2)-> {
//            return o2.getValue() - o1.getValue();
//        });
        int max = 0;
        ArrayList<Integer> list = new ArrayList<>();
        for (Integer item : map.keySet()){
            if (max < map.get(item)) {
                list.clear();
                list.add(item);
            } else if (max == map.get(item)) {
                list.add(item);
            }
        }
        int len = list.size();
        int[] ans = new int[len];
        for (int i = 0; i <len ; i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }
    private int dfs(TreeNode node) {
        if (node == null){
            return 0;
        }
        int leftAns = dfs(node.left);
        int rightAns = dfs(node.right);
        int ans = leftAns + rightAns + node.val;
        map.put(ans, map.getOrDefault(ans, 0)  + 1);
        return leftAns + rightAns + node.val;
    }
}
