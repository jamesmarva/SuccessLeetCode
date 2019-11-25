package leet0001to0200.problem0015;

import java.util.*;

/**
 * @program: SuccessLeetCode
 * @description:
 * https://leetcode-cn.com/problems/3sum/
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * 满足要求的三元组集合为：
 * @author: james
 * @create: 2019-09-09 21:09
 **/
public class ThreeSum15 {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new LinkedList<>();
        int length = nums.length;
        for (int i = 0; i < length - 2; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                int lowIndex = i + 1;
                int highIndex = length-1;
                while (lowIndex < highIndex) {
                    int targetC = 0 - nums[i] - nums[lowIndex];
                    if (targetC == nums[highIndex]) {
                        List<Integer> tempList = new ArrayList<>();

                        tempList.add(nums[i]);
                        tempList.add(nums[lowIndex]);
                        tempList.add(nums[highIndex]);
                        result.add(tempList);
                        while (lowIndex < highIndex && nums[lowIndex] == nums[lowIndex + 1]) {
                            lowIndex++;
                        }
                        while (lowIndex < highIndex && nums[highIndex] == nums[highIndex - 1]) {
                            highIndex--;
                        }
                        highIndex--;
                        lowIndex++;

                    } else if (targetC > nums[highIndex]) {
                        lowIndex++;
                    } else {
                        highIndex--;
                    }
                }
            }
        }
        return result;
    }

    class ThreeComparator implements Comparable {

        @Override
        public int compareTo(Object o) {
            return 0;
        }
    }

    public List<List<Integer>> threeSumRight(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new LinkedList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                int low = i + 1;
                int high = nums.length - 1;
                int sum = 0 - nums[i];
                while (low < high) {
                    if (nums[low] + nums[high] == sum) {
                        result.add(Arrays.asList(nums[i], nums[low], nums[high]));
                        while (low < high && nums[low] == nums[low + 1]) {
                            low++;
                        }
                        while (low < high && nums[high] == nums[high - 1]) {
                            high--;
                        }
                        low++;
                        high--;
                    } else if (nums[low] + nums[high] < sum) {
                        low++;
                    } else {
                        high--;
                    }

                }
            }
        }
        return result;
    }

    public List<List<Integer>> threeSumTest(int[] nums) {
        Comparator<Integer> threeComparable = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        };
        Arrays.sort(nums);
        List<List<Integer>> result = new LinkedList<>();
        int length = nums.length;
        for (int i = 0; i < length - 2; i++) {
            int targetBAndC = 0 - nums[i];
            for (int j = i+1; j < length - 1; j++) {
                int targetC = targetBAndC - nums[j];
                int highIndex = length-1;
                while (j < highIndex) {
                    if (targetC < nums[highIndex]) {
                        highIndex--;
                    } else if (targetC > nums[highIndex]) {
                        break;
                    } else {
                        List<Integer> tempList = new ArrayList<>();
                        tempList.add(nums[i]);
                        tempList.add(nums[j]);
                        tempList.add(targetC);
                        tempList.sort(threeComparable);
                        if (!result.contains(tempList)) {
                            result.add(tempList);
                        }
                        break;
                    }
                }
            }
        }
        return result;
    }

    public List<List<Integer>> threeSumTest2(int[] nums)  {
        Comparator<Integer> threeComparable = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        };
        Arrays.sort(nums);
        List<List<Integer>> result = new LinkedList<>();
        int length = nums.length;
        for (int i = 0; i < length - 2; i++) {
            int lowIndex = i + 1;
            int highIndex = length-1;
            int targetC = 0 - nums[i] - nums[lowIndex];
            while (lowIndex < highIndex) {
                if (targetC < nums[highIndex]) {
                    highIndex--;
                } else if (targetC > nums[highIndex]) {
                    lowIndex++;
                } else {
                    List<Integer> tempList = new ArrayList<>();
                    tempList.add(nums[i]);
                    tempList.add(nums[lowIndex]);
                    tempList.add(targetC);
                    tempList.sort(threeComparable);
                    if (!result.contains(tempList)) {
                        result.add(tempList);
                    }
                    break;
                }
            }

        }
        return result;
    }

    /**
     * 双指针的思想
     *
     */
    public List<List<Integer>> threeSum4(int[] nums) {
        HashSet<String> set = new HashSet();
        int len = nums.length;
        Arrays.sort(nums);
        ArrayList<List<Integer>> ans = new ArrayList();
        for (int i = 0; i < len - 2; i++) {
            int start = i + 1;
            int end = len - 1;
            while (start < end) {
                int tempSum = nums[i] + nums[start] + nums[end];
                if (tempSum == 0) {
                    if (set.add(nums[i] + "_" + nums[start] + "_" +nums[end])) {
                        List<Integer> tempList = new ArrayList();
                        tempList.add(nums[i]);
                        tempList.add(nums[start]);
                        tempList.add(nums[end]);
                        ans.add(tempList);
                    }
                    start++;
                    end--;
                } else if (tempSum > 0) {
                    end--;
                } else if (tempSum < 0) {
                    start++;
                }
            }
            while ( i + 1 < len && nums[i] == nums[i + 1]) {
                i++;
            }
        }
        return ans;
    }

    public List<List<Integer>> threeSum_5(int[] nums) {
        HashSet<String> set = new HashSet();
        int len = nums.length;
        Arrays.sort(nums);
        ArrayList<List<Integer>> ans = new ArrayList();
        for (int i = 0; i < len - 2; i++) {
            int start = i + 1;
            int end = len - 1;
            while (start < end) {
                if (nums[i] + nums[start] + nums[end] == 0) {
                    set.add(nums[i] + "_" + nums[start] + "_" +nums[end]);
                    start++;
                } else if (nums[i] + nums[start] + nums[end] > 0) {
                    end--;
                } else if (nums[i] + nums[start] + nums[end] < 0) {
                    start++;
                }
            }
            while ( i + 1 < len && nums[i] == nums[i + 1]) {
                i++;
            }
        }

        for (String item : set) {
            String[] arr = item.split("_");
            ArrayList tempList = new ArrayList() {{
                add(Integer.valueOf(arr[0]));
                add(Integer.valueOf(arr[1]));
                add(Integer.valueOf(arr[2]));
            }};
            ans.add(tempList);
        }
        return ans;
    }

    public List<List<Integer>> threeSum_6(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return result;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                break;
            }

            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum < 0) {
                    left++;
                } else if (sum > 0) {
                    right--;
                } else {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    result.add(list);
                    // 为了防止重复
                        while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                }
            }
        }
        return result;
    }
    /**
     * 执行用时 : 33 ms, 在所有 java 提交中击败了96.29%的用户
     * 内存消耗 :46.9 MB, 在所有 java 提交中击败了95.44%的用户
     */
    public List<List<Integer>> threeSum_7(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return result;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                break;
            }

            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum < 0) {
                    left++;
                } else if (sum > 0) {
                    right--;
                } else {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    result.add(list);
                    // 为了防止重复
                    left++;
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    right--;
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                }
            }
        }
        return result;
    }
}
