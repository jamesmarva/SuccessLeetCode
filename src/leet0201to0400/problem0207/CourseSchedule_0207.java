package leet0201to0400.problem0207;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author James
 * @date 2019-12-04 03:27
 **/
public class CourseSchedule_0207 {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses == 0 && prerequisites.length == 0) {
            return true;
        }
        LinkedList<Integer>[] adj = new LinkedList[numCourses];
//        用这种方法来填充才不会出现问题
        for (int i = 0; i < numCourses; ++i){
            adj[i] = new LinkedList<>();
        }
//        这里一定要注意，如果用这种方法阿来填充会出现问题
//        Arrays.fill(adj, new LinkedList<>());
        int len = prerequisites.length;
        int[] inDegree = new int[numCourses];
        for (int i = 0; i < len; i++) {
            int[] temp = prerequisites[i];
            inDegree[temp[1]] ++;
            int index = temp[0];
            int value = temp[1];
            adj[index].add(value);
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int temp = queue.poll();
            for (int item : adj[temp]){
                inDegree[item]--;
                if (inDegree[item] == 0) {
                    queue.add(item);
                }
            }
        }

        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] test = {{1, 0}};
        int test1 = 2;
        CourseSchedule_0207 courseSchedule_0207 = new CourseSchedule_0207();
        courseSchedule_0207.canFinish(2, test);
    }
}
