package leet0401to0600.problem0502;

import java.net.CookieHandler;
import java.util.*;

/**
 * @author James
 * @program SuccessLeetCode
 * @description https://leetcode-cn.com/problems/ipo/
 * @date 2019-09-30 10:52
 **/
public class IPO502 {

//    public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
//        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
//        ArrayList<Integer> allCapital = new ArrayList<>();
//        for (int i = 0, len = Capital.length; i < len; ++i) {
//            if (map.get(Capital[i]) == null) {
//                ArrayList<Integer> temp = new ArrayList<>();
//                temp.add(Profits[i]);
//                map.put(Capital[i], temp);
//            } else {
//                ArrayList<Integer> temp = map.get(Capital[i]);
//                temp.add(Profits[i]);
//            }
//            if (!allCapital.contains(Capital[i])) {
//                allCapital.add(Capital[i]);
//            }
//        }
//        for (Integer key : map.keySet()) {
//            Collections.sort(map.get(key), new Comparator<Integer>() {
//                @Override
//                public int compare(Integer o1, Integer o2) {
//                    return o2 - o1;
//                }
//            });
//        }
//        Collections.sort(allCapital);
//        for (int i = 0; i < k; ++i) {
////            while (allCapital.indexOf())
//
//        }
//        int res = 0;
//
//        return 0;
//    }

    public int findMaximizedCapitalNew(int k, int W, int[] Profits, int[] Capital) {
        if (k == 0 || Profits == null || Capital == null || Profits.length == 0) {
            return 0;
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(((o1, o2) -> o2 - o1));
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0, len = Capital.length; i < len; ++i) {
            if (map.get(Capital[i]) == null) {
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(Profits[i]);
                map.put(Capital[i], temp);
                minHeap.offer(Capital[i]);
            } else {
                ArrayList<Integer> temp = map.get(Capital[i]);
                temp.add(Profits[i]);
            }
        }
        for (int i = 0; i < k; ++i) {
            while (minHeap.size() > 0 && W >= minHeap.peek()) {
                int capital = minHeap.poll();
                maxHeap.addAll(map.get(capital));
            }
            if (maxHeap.size() > 0) {
                W += maxHeap.poll();
            } else {
                break;
            }
        }
        return W;


    }

    /**
     * 非常不错的答案。
     */
    //定义项目的节点类型
    public static class Node{
        public int p;
        public int c;
        public Node(int p,int c){//相应的构造函数
            this.p=p;
            this.c=c;
        }
    }
    public static class minCostComparator implements Comparator<Node>{//节点类型的比较器
        @Override
        public int compare(Node o1,Node o2){
            return o1.c-o2.c;//按照升序排序
        }
    }
    public static class maxProfitComparator implements Comparator<Node>{
        @Override
        public int compare(Node o1,Node o2){
            return o2.p-o1.p;//按照p降序排序
        }
    }
    public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital){
        Node[] nodes=new Node[Profits.length];//定义一个节点类型的数组存放项目
        for(int i=0;i<Profits.length;i++){
            nodes[i]=new Node(Profits[i],Capital[i]);//存放一个项目的花费和收益
        }
        //构造一个花费的小根堆和一个收益的大根堆需要用到比较器，堆结构实际上就是优先级队列结构
        PriorityQueue<Node> minCost=new PriorityQueue<>(new minCostComparator());
        PriorityQueue<Node> maxProfit=new PriorityQueue<>(new maxProfitComparator());
        for(int i=0;i<nodes.length;i++){
            minCost.add(nodes[i]);
        }
        for(int i=0;i<k;i++){
            while(!minCost.isEmpty()&&minCost.peek().c<=W){
                maxProfit.add(minCost.poll());
            }
            if(maxProfit.isEmpty()){
                return W;
            }
            W+=maxProfit.poll().p;
        }
        return W;
    }

    public static void main(String[] args) {
        ArrayList<Integer> test = new ArrayList<>(){{
            add(10);
            add(11);
            add(12);
            add(9);
            add(8);
            add(1);
            add(2);
        }};
        Collections.sort(test, ((o1, o2) -> o2 - o1));
        System.out.println(test);


        IPO502 ipo502 = new IPO502();
        int[] test1 = {1, 2, 3};
        int[] test2 = {0, 1, 1};
        ipo502.findMaximizedCapitalNew(2, 0, test1, test2);
    }
}
