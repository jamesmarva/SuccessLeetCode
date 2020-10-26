
package leet1001to1200.problem1013;

/**
 *
 */
public class PartitionArrIntoThreePartsWithEqualSum_1013 {
    
    public boolean canThreePartsEqualSum(int[] arr) {
        if (arr == null || arr.length < 3) {
            return false;
        }
        int allSum = 0;
        for (int i : arr) {
            allSum += i;
        }
        int len = arr.length;
        int first = 0;
        int second = 0;
        for (int i = 0; i <= len - 3; i++) {
            first += arr[i];
            int tempSum = allSum - first;
            for (int j = len - 1; j > i + 1; j--) {
                second += arr[j];
                tempSum -= arr[j];
                if (first == tempSum && first == second) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 1ms
     *
     * @param arr
     * @return
     */
    public boolean canThreePartsEqualSum_01(int[] arr) {
        if (arr == null || arr.length < 3) {
            return false;
        }
        int allSum = 0;
        for (int i : arr) {
            allSum += i;
        }
        if (allSum % 3 != 0) {
            return false;
        }
        int first = 0;
        int partSum = allSum / 3;
        for (int i = 0, len = arr.length; i <= len - 3; i ++) {
            first += arr[i];
            if (first == partSum) {
                int second = 0;
                for (int j = len - 1; j >= i + 2; j--) {
                    second += arr[j];
                    if (second == partSum) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}