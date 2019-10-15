package leet0601to0800.problem0797;

import java.util.*;

/**
 * @author James
 * @program SuccessLeetCode
 * @description https://leetcode-cn.com/problems/all-paths-from-source-to-target/
 * @date 2019-10-13 21:11
 **/
public class AllPathsFromSourceToTarget0797 {

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        if (graph == null || graph.length == 0 || graph[0].length == 0) {
            return null;
        }
        Map<Integer, HashSet<Integer>> fathersMap = new HashMap<>();
        int len = graph.length;
        for (int i = 0; i < len - 1; ++i) {
            int[] tempArray = graph[i];
            for (int item : tempArray) {
                HashSet<Integer> set = fathersMap.getOrDefault(item, new HashSet<>());
                set.add(i);
                fathersMap.put(item, set);
            }
        }
        dfs(len - 1, new ArrayList<>(), fathersMap, len);
//        Stack<Integer> stack = new Stack<>();
//        stack.push(len - 1);
//        while (stack.size() > 0) {
//            int temp  = stack.pop();
//            stack.push(fathersMap.get());
//        }
        return ans;
    }
    ArrayList<List<Integer>> ans = new ArrayList<>();
    private void dfs(int index, ArrayList<Integer> tempList, Map<Integer, HashSet<Integer>> fathersMap, int len) {
        tempList.add(index);
        if (index == 0) {
            ArrayList<Integer> ansTempList = new ArrayList<>(tempList.size());
            for (int i = tempList.size() - 1; i >= 0; --i){
                ansTempList.add(tempList.get(i));
            }
            ans.add(ansTempList);
            return;
        }
        HashSet<Integer> set = fathersMap.get(index);
        for (int item : set) {
            dfs(item, tempList, fathersMap, len);
            tempList.remove(tempList.size() - 1);
        }
    }

    public static void main(String[] args) {
//        int[][] test = {{1,2},{3},{3},{}};
        int[][] test = {{4,3,1},{3,2,4},{3},{4},{}};
        AllPathsFromSourceToTarget0797 allPathsFromSourceToTarget0797 = new AllPathsFromSourceToTarget0797();

        System.out.println(allPathsFromSourceToTarget0797.allPathsSourceTarget(test));
    }
}
