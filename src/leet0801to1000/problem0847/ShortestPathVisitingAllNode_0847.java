package leet0801to1000.problem0847;

import leet0601to0800.problem0763.PartitionLabels0763;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 *示例 1：
 *
 * 输入：[[1,2,3],[0],[0],[0]]
 * 输出：4
 * 解释：一个可能的路径为 [1,0,2,0,3]
 *
 * 示例 2：
 *
 * 输入：[[1],[0,2,4],[1,3,4],[2],[1,2]]
 * 输出：4
 * 解释：一个可能的路径为 [0,1,4,2,3]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shortest-path-visiting-all-nodes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * https://leetcode-cn.com/problems/shortest-path-visiting-all-nodes/
 * @author James
 * @date 2019-10-31 15:35
 **/
public class ShortestPathVisitingAllNode_0847 {

//    public int shortestPathLength(int[][] graph) {
//        if (graph == null || graph.length == 0 || graph[0].length == 0) {
//            return 0;
//        }
//        Queue<Integer> queue = new LinkedList<>();
//        HashMap<Integer, Pair> pathsMap = new HashMap<>();
//        int len = graph.length;
//        int step = 0;
//        for (int i = 0; i < len; ++i) {
//            queue.offer(i);
//        }
//        while (queue.size() > 0) {
//            for (int i = queue.size(); i > 0; --i) {
//                int tempFromNode = queue.poll();
//                Pair pair = pathsMap.get(tempFromNode);
//                HashSet<Integer> tempVisitedNode = pair.visited;
//                HashSet<String> tempHasWentPath = pair.paths;
//                if (tempVisitedNode.size() == len) {
//                    return step;
//                }
//                int[] toNodes = graph[tempFromNode];
//                for (int item : toNodes) {
//                    if (!tempHasWentPath.contains(tempFromNode + " " + item)) {
//                        queue.
//                    }
//                }
//                pathsMap.get()
//            }
//            step++;
//        }
//        return 0;
//    }


    public int shortestPathLength(int[][] graph) {
        if (graph == null || graph.length == 0 || graph[0].length == 0) {
            return 0;
        }
        int len = graph.length;
        int[][] fromAndState = new int[len][1 << len];
        int allVisitedState = (1 << len) - 1;
        Queue<Pair> queue = new LinkedList<>();
        for (int i = 0; i < len; ++i) {
            queue.offer(new Pair(i, 1<<i));
        }
        int step = 0;
        while (queue.size() > 0) {
            for (int i = queue.size(); i > 0; --i) {
                Pair tempPair = queue.poll();
                int fromNode = tempPair.from;
                int tempState = tempPair.state;
                if (tempState == allVisitedState) {
                    return step;
                }
                // has visited.
                if (fromAndState[fromNode][tempState] == 1) {
                    continue;
                }
                fromAndState[fromNode][tempState] = 1;
                int[] toNodes = graph[fromNode];
                for (int item : toNodes) {
                    queue.offer(new Pair(item, tempState | (1 << item)));
                }
            }
            step++;
        }
        return step;
    }

    class Pair {
        int from;
        int state;
        Pair(int from, int state) {
            this.from = from;
            this.state = state;
        }
    }


    public static void main(String[] args) {
        System.out.println(1<<0);
        System.out.println(1<<1);
        System.out.println(1<<2);
        System.out.println(1<<3);
    }
//    class Pair {
//        HashSet<String> paths;
//        HashSet<Integer> visited;
//        Pair() {
//
//        }
//    }


//    class Pair {
//        int from;
//        int to;
//        Pair(int from, int to) {
//            this.from = from;
//            this.to = to;
//        }
//    }

}
