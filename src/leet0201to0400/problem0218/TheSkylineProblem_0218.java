package leet0201to0400.problem0218;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author James
 * @date 2019-11-12 20:35
 **/
public class TheSkylineProblem_0218 {


    public List<List<Integer>> getSkyline(int[][] buildings) {
        ArrayList<List<Integer>> ans = new ArrayList<>();
        if (buildings == null || buildings.length == 0 || buildings[0].length == 0) {
            return ans;
        }
        int len = buildings.length;
        ArrayList<TempClass> list = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            list.add(new TempClass(buildings[i][0], buildings[i][2], true));
            list.add(new TempClass(buildings[i][1], buildings[i][2], false));
        }
        Collections.sort(list, ((o1, o2) -> o1.x - o2.x));
        for (int i = 1, size = list.size(); i < size; i++) {
            TempClass first = list.get(i - 1);
            TempClass second = list.get(i - 1);
        }
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        priorityQueue.offer(0);
        int maxHeight = 0;
        int lastMaxHeight = 0;
        for (TempClass item : list) {
            if (item.isStarted) {
                priorityQueue.offer(item.y);
            } else {
                priorityQueue.remove((Integer)item.y);
            }
            maxHeight = priorityQueue.peek();
            if (lastMaxHeight != maxHeight) {
                ArrayList<Integer> tempList = new ArrayList<Integer>(){{
                    add(item.x);
                    add(priorityQueue.peek());
                }};
                ans.add(tempList);
                lastMaxHeight = maxHeight;
            }
        }
        return ans;
    }


    /**
     * 最难就是[[0,2,3],[2,5,3]]
     * [[0,3],[2,3],[2,3],[5,3]]
     * [[0,3],[2,0],[2,3],[5,0]]
     * @param buildings
     * @return
     */
    public List<List<Integer>> getSkyline1(int[][] buildings) {
        ArrayList<List<Integer>> ans = new ArrayList<>();
        if (buildings == null || buildings.length == 0 || buildings[0].length == 0) {
            return ans;
        }
        int len = buildings.length;
        ArrayList<TempClass> list = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            list.add(new TempClass(buildings[i][0], buildings[i][2], true));
            list.add(new TempClass(buildings[i][1], buildings[i][2], false));
        }
        Collections.sort(list, ((o1, o2) -> o1.x - o2.x));

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        priorityQueue.offer(0);
        int lastMaxHeight = 0;
        // 这个
        for (int i = 0, size = list.size(); i < size;) {
            int currentX = list.get(i).x;
            // 如果两个
            while (i < size && list.get(i).x == currentX) {
                if (list.get(i).isStarted) {
                    priorityQueue.offer(list.get(i).y);
                } else {
                    priorityQueue.remove((Integer) list.get(i).y);
                }
                i++;
            }

            if (lastMaxHeight != priorityQueue.peek()) {
                ArrayList<Integer> tempList = new ArrayList<Integer>(){{
                    add(currentX);
                    add(priorityQueue.peek());
                }};
                ans.add(tempList);
                lastMaxHeight = priorityQueue.peek();
            }
        }
        return ans;
    }

    class TempClass {
        int x;
        int y;
        boolean isStarted;

        TempClass(int x, int y, boolean isStarted) {
            this.x = x;
            this.y = y;
            this.isStarted = isStarted;
        }
    }


    public static void main(String[] args) {
//        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
//        priorityQueue.remove();
//        ArrayList<Integer> list = new ArrayList<>(){{
//            add(1);
//            add(3);
//            add(5);
//            add(7);
//            add(9);
//            add(11);
//            add(15);
//
//        }};
//        Collections.sort(list, ((o1, o2) -> o2 - o1));
//        System.out.println(list.toString());
        int[][] test = { {2, 9, 10}, {3, 7, 15}, {5, 12, 12}, {15, 20, 10}, {19, 24, 8} };
        TheSkylineProblem_0218 theSkylineProblem_0218 = new TheSkylineProblem_0218();
        theSkylineProblem_0218.getSkyline1(test);
    }


}
