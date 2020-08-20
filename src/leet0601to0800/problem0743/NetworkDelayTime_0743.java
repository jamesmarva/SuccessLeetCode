package leet0601to0800.problem0743;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/network-delay-time/
 *
 * @author Brilliant James
 * @date 2020-04-07 04:03
 **/
public class NetworkDelayTime_0743 {

    /**
     * time {2 ,3, 1} mean:
     * startVertex 2 ;
     * endVertex: 3;
     * weight 1;
     * @param times
     * @param N
     * @param K
     * @return
     */
    public int networkDelayTime(int[][] times, int N, int K) {
        ArrayList<Edge>[] adj = getAdj(times, N + 1);
        ArrayList<Edge> startVerAdj = adj[K];
        if (startVerAdj == null) {
            return -1;
        }
        PriorityQueue<VerAndDis> minHeap = new PriorityQueue<>((o1, o2) -> o1.dis - o2.dis);
        int[] disArr = new int[N + 1];
        Arrays.fill(disArr, Integer.MAX_VALUE);
        minHeap.offer(new VerAndDis(K,0));
        Set<Integer> visited = new HashSet<>();
        disArr[K] = 0;
        while (minHeap.size() > 0) {
            VerAndDis temp = minHeap.poll();
            if (visited.contains(temp.v)) {
                continue;
            }
            visited.add(temp.v);
            ArrayList<Edge> edges = adj[temp.v];
            if (edges == null) {
                continue;
            }
            for (Edge e : edges) {
                int newDis = temp.dis + e.weight;
                disArr[e.to] = Math.min(newDis, disArr[e.to]);
                minHeap.offer(new VerAndDis(e.to, newDis));
            }
        }
        int ans = -1;
        if (visited.size() < N) {
            return ans;
        }
        for (int i = 1; i <= N;i++) {
            ans = Math.max(ans, disArr[i]);
        }
        return ans;
    }

    private ArrayList<Edge>[] getAdj(int[][] times, int n) {
        ArrayList<Edge>[] ans = new ArrayList[n];
        for (int[] i : times) {
            Edge e = new Edge(i[0], i[1],i[2]);
            if (ans[i[0]] == null) {
                ans[i[0]] = new ArrayList<>();
            }
            ans[i[0]].add(e);
        }
        return ans;
    }

    private class VerAndDis {
        Integer v;
        Integer dis;
        VerAndDis(int v, int dis) {
            this.v = v;
            this.dis = dis;
        }
    }

    private class Edge {
        Integer from;
        Integer to;
        Integer weight;

        Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
        public  Integer getOther(Integer v) {
            if (v.equals(from)) {
                return to;
            } else if (v.equals(to)) {
                return from;
            }
            return null;
        }
    }


    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
//        System.out.println(list.get(2));
        int[][] t = {{1,2,1},
                {2,1,3}};
        int N = 2;
        int K = 2;
        NetworkDelayTime_0743 n = new NetworkDelayTime_0743();
        System.out.println(n.networkDelayTime(t, N, K));
    }
}
