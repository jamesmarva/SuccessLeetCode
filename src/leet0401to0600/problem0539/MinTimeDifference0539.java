package leet0401to0600.problem0539;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @program: SuccessLeetCode
 * @description: https://leetcode-cn.com/problems/minimum-time-difference/
 * 全部转换成分钟的思想
 * @author: James
 * @create: 2019-09-13 12:43
 **/
public class MinTimeDifference0539 {

    public int findMinDifference(List<String> timePoints) {
        if (timePoints == null || timePoints.isEmpty() || timePoints.size() == 1) {
            return 0;
        }
        ArrayList<Integer> list = new ArrayList<>(timePoints.size());
        for (int i = 0, len = timePoints.size(); i < len; ++i) {
            String[] splitArr = timePoints.get(i).split(":");
            int prefixNum = Integer.parseInt(splitArr[0]);
            int suffixNum = Integer.parseInt(splitArr[1]);
            if (prefixNum == 0) {
            }
            list.add(prefixNum * 60 + suffixNum);
        }
        Collections.sort(list);
        int res = Integer.MAX_VALUE;
        for (int i = 1, len = list.size(); i <= len; ++i) {
            res = Math.min(res, list.get(i) - list.get(i - 1));
        }
        res = Math.min(res, list.get(0) + 1440 - list.get(list.size() - 1));
        return res;
    }
}
