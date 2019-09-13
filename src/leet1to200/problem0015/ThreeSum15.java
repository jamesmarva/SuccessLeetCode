package leet1to200.problem0015;

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
}
