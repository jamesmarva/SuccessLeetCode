package leet0601to0800.problem0719;

import java.sql.Array;
import java.util.*;

/**
 * @author James
 * @program SuccessLeetCode
 * @description
 * https://leetcode-cn.com/problems/find-k-th-smallest-pair-distance/
 * @date 2019-10-19 11:52
 **/

public class FindKthSmallestPairDistance0719 {

    /**
     * 超出内存限制
     * @param nums
     * @param k
     * @return
     */
    public int smallestDistancePair(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i = 0, len = nums.length; i <= len - 2; ++i) {
            for (int j = i + 1; j <= len - 1; ++j) {
                priorityQueue.add(Math.abs(nums[i] - nums[j]));
            }
        }
        int ans = 0;
        while (k > 0 && priorityQueue.size() > 0) {
            ans = priorityQueue.poll();
            k--;
        }
        return ans;
    }
    public int smallestDistancePairNew(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i = 1, len = nums.length; i <= len - 1; ++i) {
            priorityQueue.add(nums[i] - nums[i - 1]);
        }
        int ans = 0;
        while (k > 0 && priorityQueue.size() > 0) {
            ans = priorityQueue.poll();
            k--;
        }
        return ans;
    }


    /**
     * 超出时间限制
     * @param nums
     * @param k
     * @return
     */
    public int smallestDistancePair2(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0, len = nums.length; i <= len - 2; ++i) {
            for (int j = i + 1; j <= len - 1; ++j) {
                int distance = Math.abs(nums[i] - nums[j]);
                map.put(distance, map.getOrDefault(distance, 0) + 1);
            }
        }
        ArrayList<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, (o1, o2) -> o1.getKey() - o2.getKey());
        int cursor = 0;
        for (int i = 0, len = list.size(); i < len; ++i) {
            if (cursor < k && k <= cursor + list.get(i).getValue()) {
                return list.get(i).getKey();
            }
            cursor += list.get(i).getValue();
        }
        return 0;
    }

    public static class TempNode{
        int value;
        int count;
        TempNode(int tempValue) {
            value = tempValue;
        }
        public void addCount() {
            count++;
        }
        public int getValue() {
            return value;
        }


        public int getCount() {
            return count;
        }
    }


    public int smallestDistancePair3(int[] nums, int k) {
        Arrays.sort(nums);
//        PriorityQueue<Node> heap = new PriorityQueue<Node>(nums.length,
//                Comparator.<Node> comparingInt(node -> nums[node.nei] - nums[node.root]));
        PriorityQueue<Node> heap = new PriorityQueue<Node>(nums.length, (o1, o2) -> {
            int o1Dis = nums[o1.after] - nums[o1.root];
            int o2Dis = nums[o2.after] - nums[o2.root];

            if (o1Dis < o2Dis) {
                return -1;
            } else if (o1Dis == o2Dis) {
                return 0;
            } else {
                return 1;
            }
        });
        for (int i = 0; i + 1 < nums.length; ++i) {
            heap.offer(new Node(i, i+1));
        }

        Node node = null;
        for (; k > 0; --k) {
            node = heap.poll();
            if (node.after + 1 < nums.length) {
                heap.offer(new Node(node.root, node.after + 1));
            }
        }
        return nums[node.after] - nums[node.root];
    }

    class Node {
        int root;
        int after;
        Node(int r, int n) {
            root = r;
            after = n;
        }
    }

    /**
     *
     */
    public int smallestDistancePair4(int[] nums, int k) {
        Arrays.sort(nums);
        int WIDTH = 2 * nums[nums.length - 1];

        //multiplicity[i] = number of nums[j] == nums[i] (j < i)
        int[] multiplicity = new int[nums.length];
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] == nums[i-1]) {
                multiplicity[i] = 1 + multiplicity[i - 1];
            }
        }

        //prefix[v] = number of values <= v
        int[] prefix = new int[WIDTH];
        int left = 0;
        for (int i = 0; i < WIDTH; ++i) {
            while (left < nums.length && nums[left] == i) {
                left++;
            }
            prefix[i] = left;
        }

        int low = 0;
        int high = nums[nums.length - 1] - nums[0];
        while (low < high) {
            int mid = low +  ((high - low) >> 2);
            int count = 0;
            for (int i = 0; i < nums.length; ++i) {
                count += prefix[nums[i] + mid] - prefix[nums[i]] + multiplicity[i];
            }
            //count = number of pairs with distance <= mi
            if (count >= k) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }


    public int smallestDistancePair5(int[] nums, int k) {
        Arrays.sort(nums);
        int len = nums.length;
        int lo = 0, hi = nums[len - 1] - nums[0];
        // O(nlogn)
        while (lo < hi) { // O(1)
            int mid = lo + ((hi - lo) >> 1);
            int count = 0;
            // O(nlogn)
            for (int i = 1; i < len; ++i) { // O(n)
                count += search(nums, i, mid) - (len - i); // O(logn)
            }
            if (k <= count) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    // 标准 upperbound 模板。查找第一个 > target 的元素的位置。
    // 也就是 <= target 的元素的个数。
    int search(int[] nums, int row, int target) {
        int len = nums.length;
        int lo = len - row, hi = len;
        while (lo < hi) {
            int mid = lo + (hi - lo >> 1);
            // matrix[row][mid]
            if (nums[row] - nums[len - 1 - mid] > target) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    public int smallestDistancePair6(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int len = nums.length;
        int low = 0, high = nums[len - 1] - nums[0];
        while (low < high) {
            int mid = low + ((high - low) >> 1);
            int count = findLessTargetDistanceCount(nums, mid);
            if (count >= k) {
                high = mid;
            } else if (count < k) {
                low = mid + 1;
            }
        }
        return high;
    }

    /**
     *   6 5 4 3 2
     * 2         0
     * 3       0 1
     * 4     0 1 2
     * 5   0 1 2 3
     * 6 0 1 2 3 4
     *
     */
    private int findLessTargetDistanceCount(int[] nums, int target) {
        int length = nums.length;
        int rowIndex = length - 1, rowIndexBeyond = length - 2, columnIndex = 1, ans = 0;
//        while (columnIndex < length && rowIndex > 1) {
//            if (nums[rowIndex] - nums[length - columnIndex] < target) {
//                ans += rowIndex - (length - columnIndex);
//                columnIndex++;
//            } else {
//                rowIndex--;
//            }
//        }
       while (rowIndexBeyond >= 0){
            if (rowIndex > rowIndexBeyond && nums[rowIndex] - nums[rowIndexBeyond] <= target) {
                ans += rowIndex - rowIndexBeyond;
                rowIndexBeyond--;
            } else if (rowIndex > rowIndexBeyond){
                rowIndex--;
            } else {
                rowIndexBeyond--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {

        int[] test = {9,10,7,10,6,1,5,4,9,8};
        FindKthSmallestPairDistance0719 findKthSmallestPairDistance0719 = new FindKthSmallestPairDistance0719();
        findKthSmallestPairDistance0719.smallestDistancePair4(test, 18);

//        18
//        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
//        List<Integer> list =Arrays.asList(1);
//        priorityQueue.addAll(Arrays.asList(1, 9, 7, 8, 5, 3, 2));
//        while (priorityQueue.size() > 0) {
//            System.out.println(priorityQueue.poll());
//    }
        TempNode node = new TempNode(0);
//        PriorityQueue<TempNode> priorityQueue = new PriorityQueue<>(o1, (o1, o2) -> {
//
//        });

//        Map<Integer, TempNode> map = new HashMap<>();
//        map.put(0, node);
//        priorityQueue.add(node);
//        TempNode nodeTemp = map.get(0);
//        nodeTemp.addCount();
//        System.out.println(priorityQueue.poll().getCount());

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>((o1, o2) -> {
            if (o1 < o2) {
                return -1;
            } else if (o1.equals(o2)) {
                return 0;
            } else {
                return 1;
            }
        });

        priorityQueue.addAll(Arrays.asList(1, 9, 7, 8, 5, 3, 2));
        while (priorityQueue.size() > 0) {
            System.out.println(priorityQueue.poll());
        }
    }
}
