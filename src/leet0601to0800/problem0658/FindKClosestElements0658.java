package leet0601to0800.problem0658;

import java.util.*;

/**
 * @author James
 * https://leetcode-cn.com/problems/find-k-closest-elements/
 * @date 2019-10-20 08:04
 **/
public class FindKClosestElements0658 {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        ArrayList<Integer> ans = new ArrayList<>();
        for (int item : arr) {
            ArrayList<Integer> listTemp = map.getOrDefault(Math.abs(item - x), new ArrayList<>());
            listTemp.add(item);
            map.put(Math.abs(item - x), listTemp);
        }
        ArrayList<Map.Entry<Integer, ArrayList<Integer>>> entryArrayList = new ArrayList<>(map.entrySet());
        entryArrayList.sort( Comparator.comparing(Map.Entry::getKey));
        int index = 0, len = entryArrayList.size();
        while (k > 0 && index < len) {
            ArrayList<Integer> listTemp =  entryArrayList.get(index).getValue();
            if ( k > listTemp.size()) {
                ans.addAll(listTemp);
                k-=listTemp.size();
                index++;
                continue;
            }
            for (int i = 0, lenTemp = listTemp.size(); i < lenTemp && k > 0; ++i) {
                ans.add(listTemp.get(i));
                k--;
            }
            index++;
        }
        ans.sort((o1, o2) -> o1 - o2);
        return ans;
    }


    /**
     * 官方题解，算是很精简的回答了。
     */
    public List<Integer> findClosestElements2(int[] arr, int k, int x) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int item : arr) {
            list.add(item);
        }
        list.sort((a, b) -> a.equals(b) ? a.compareTo(b) : Math.abs(a-x) - Math.abs(b-x));
        List<Integer> ans = list.subList(0, k);
        Collections.sort(ans);
        return ans;
    }


    /**
     *
     */
    public List<Integer> findClosestElements3(int[] arr, int k, int x) {
        int len = arr.length;
        int left = 0;
        int right = len - 1;
        ArrayList<Integer> ans = new ArrayList<>();
        while (right - left >= k) {
            int leftMax = Math.abs(arr[left] - x);
            int rightMax = Math.abs(arr[right] - x);
            if (leftMax > rightMax) {
                left++;
            } else if (leftMax < rightMax){
                right--;
            } else {
                right--;
            }
        }
        for (int i = left; i <= right; i++) {
            ans.add(arr[i]);
        }
        return ans;
    }

    /**
     * 二分的查找
     * 这个思想很牛掰，这个找，找什么呢？找左边区间的起始点。
     *              x
     * 0 1 3 4 6 9 10 14 18 22
     *         m            m+k
     * 找m的最好点
     * x-arr[m] 和 arr[m+k]-x
     * 比较两个位置的区间，然后继续查找。
     */
    public List<Integer> findClosestElements4(int[] arr, int k, int x) {
        int len = arr.length;
        int low = 0;
        int high = len - k;
        ArrayList<Integer> ans = new ArrayList<>();
        while (low < high) {
            int mid = low + ((high - low) >> 1);
            if (x - arr[mid] > arr[mid + k] - x) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        for (int i = high; i < high + k; ++i) {
            ans.add(arr[i]);
        }
        return ans;
    }


    public static void main(String[] args) {
        int[] test = {1,2,3,4,5};
        int k = 4;
        int x = 3;
        FindKClosestElements0658 findKClosestElements0658 = new FindKClosestElements0658();
        findKClosestElements0658.findClosestElements(test, k, x);
    }




}
