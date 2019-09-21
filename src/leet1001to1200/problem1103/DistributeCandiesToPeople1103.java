package leet1001to1200.problem1103;

/**
 *  https://leetcode-cn.com/problems/distribute-candies-to-people/
 * 提示：
 * 1 <= candies <= 10^9
 * 1 <= num_people <= 1000
 * @author James
 * @date 2019-09-21 17:52
 **/
public class DistributeCandiesToPeople1103 {
    public int[] distributeCandies(int candies, int num_people) {
        int[] res = new int[num_people];
        int count = 1;
        while (candies  > 0) {
            for (int i = 0; i < num_people; ++i) {
                int temp = count * num_people + (i + 1);
                if (temp < candies) {
                    res[i] += temp;
                    candies -= temp;
                } else if (candies > 0) {
                    res[i] += candies;
                    candies=0;
                } else if (candies == 0) {
                    break;
                }
            }
        }
        return res;
    }
}
