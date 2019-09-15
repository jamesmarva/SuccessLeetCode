package leet601to800.problem0785;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: SuccessLeetCode
 * @description:
 * https://leetcode-cn.com/problems/is-graph-bipartite/
 *
 * @author: James
 * @create: 2019-09-15 16:16
 **/
public class IsGraphBipartite0785 {

    public boolean isBipartite(int[][] graph) {
        if (graph == null || graph.length == 0) {
            return false;
        }
        char[] color = new char[graph.length];
        Arrays.fill(color, 'w');
        int len = graph.length;
        for (int i = 0; i < len; ++i) {
            char tempColor = 'r';
            if (color[i] == 'w') {
                color[i] = 'r';
            } else {
                tempColor = color[i];
            }
            for (int item : graph[i]) {
                if (color[item] == tempColor) {
                    return false;
                } else if (color[item] == 'w'){
                    if (tempColor == 'r') {
                        color[item] = 'b';
                    } else {
                        color[item] = 'r';
                    }
                }
            }
        }
        return true;
    }

    public boolean isBipartiteNew(int[][] graph) {
        if (graph == null || graph.length == 0) {
            return false;
        }
        char[] color = new char[graph.length];
        Arrays.fill(color, 'w');
        for (int i = 0, len = graph.length; i < len; ++i){
            if (color[i] != 'w') {
                continue;
            }
            color[i] = 'r';
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(i);
            while (queue.size() > 0) {
                Integer current = queue.poll();
                for(int item : graph[current]) {
                    if (color[item] == 'w') {
                        color[item] = color[current] == 'r' ? 'b' : 'r';
                        queue.offer(item);
                    } else if (color[item] == color[current]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        Integer[][] test = new Integer[2][2];
//        Integer[] test1 = test[0];
//        Arrays.asList(test1);
        int[][] test2 = {{1,3},{0,2},{1,3},{0,2}};
        IsGraphBipartite0785 isGraphBipartite0785 = new IsGraphBipartite0785();
        isGraphBipartite0785.isBipartite(test2);

//        Queue<Integer> queue = new LinkedList<>( Arrays.asList(test1));
    }
}
