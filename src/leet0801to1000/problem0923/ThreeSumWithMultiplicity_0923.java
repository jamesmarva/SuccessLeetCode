package leet0801to1000.problem0923;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * https://leetcode-cn.com/problems/3sum-with-multiplicity/
 *
 * @author James
 * @date 2020-02-06 12:21
 **/
public class ThreeSumWithMultiplicity_0923 {

    /**
     *
     * @param arr
     * @param target
     * @return
     */
    public int threeSumMulti(int[] arr, int target) {
        int len = arr.length;
        int ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int item : arr) {
            map.put(item, map.getOrDefault(item, 0) + 1);
        }
        for (int i = 0; i <= len - 3; ) {
            int left =  i + 1;
            int right = len - 1;
            int tempTarget = 0;
            while (left < right) {
                tempTarget = arr[i] + arr[left] + arr[right];
                if (tempTarget == target) {
                    if (arr[left] != arr[right]) {
                        ans = ans + map.get(arr[left]) * map.get(arr[right]);
                        while (arr[right] == arr[right - 1]) {
                            right--;
                        }
                        right--;
                        while (arr[left] == arr[left + 1]) {
                            left ++;
                        }
                        left++;
                    } else {
                        ans = ans + (right - left + 1) * (right - left) / 2;
                        break;
                    }
//                    if (arr[left] == arr[left + 1]) {
//                        left++;
//                    } else if (arr[right] == arr[right - 1]) {
//                        int temp = arr[right];
//                        while (temp == arr[right]) {
//                            right--;
//                        }
//                    } else if (arr[left] != arr[left - 1] && arr[right] != arr[right - 1]) {
//                        left++;
//                    }
                } else if (tempTarget > target) {
                    int temp = arr[right];
                    while (temp == arr[right]) {
                        right--;
                    }
                } else if (tempTarget < target) {
                    int temp = arr[left];
                    while (temp == arr[left]) {
                        left++;
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] test = {1,1,2,2,3,3,4,4,5,5};
        int[] test1 = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
                0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
                0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        System.out.println(test1.length);
        ThreeSumWithMultiplicity_0923 tt = new ThreeSumWithMultiplicity_0923();
        int ans = tt.threeSumMulti_01(test, 8);
        System.out.println(ans);
    }


    private final static int MOD = 1_000_000_007;
    public int threeSumMulti_01(int[] arr, int target) {
        Arrays.sort(arr);
        int len = arr.length;
        int ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            map.put(arr[i], i);
        }
        for (int i = 0; i <= len - 3; i++ ) {
            int left =  i + 1;
            int right = len - 1;
            int tempTarget = 0;
            while (left < right) {
                tempTarget = arr[i] + arr[left] + arr[right];
                if (tempTarget == target) {
                    System.out.println(arr[i] + "_" + arr[left] + "_" + arr[right]);
                    if (arr[left] != arr[right]) {
                        while (right - 1 >= 0 && arr[right] == arr[right - 1]) {
                            right--;
                        }
                        ans = (ans + (map.get(arr[left]) - left  + 1) * (map.get(arr[right]) - right + 1) % MOD) % MOD;
                        right--;
                        while (left + 1 < len && arr[left] == arr[left + 1]) {
                            left++;
                        }
                        left++;
                    } else {
                        ans = (ans + ((right - left + 1) * (right - left) / 2) % MOD) % MOD;
                        break;
                    }
                } else if (tempTarget > target) {
                    while (right - 1 >= 0 && arr[right] == arr[right - 1]) {
                        right--;
                    }
                    right--;
                } else if (tempTarget < target) {
                    while (left + 1 < len && arr[left] == arr[left + 1]) {
                        left++;
                    }
                    left++;
                }
            }
        }
        return ans;
    }
}
