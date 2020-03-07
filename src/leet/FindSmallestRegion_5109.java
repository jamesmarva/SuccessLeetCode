package leet;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author James
 * @date 2019-11-16 22:46
 **/
public class FindSmallestRegion_5109 {

    public String findSmallestRegion(List<List<String>> regions, String region1, String region2) {

        if (regions  == null ||regions.isEmpty()) {
            return "";
        }
        HashMap<String,String> parentsMap = new HashMap<>();
        int len = regions.size();
        for (int i = 0; i < len; i++) {
            List<String> tempList = regions.get(i);
            int tempLen = tempList.size();
            String parent = tempList.get(0);
            for (int j = 1; j < tempLen; j++) {
                parentsMap.put(tempList.get(j), parent);
            }
        }
        Set<String> path = new HashSet<>();
        String tempIndex = region1;
        while (tempIndex != null) {
            String tempParent = parentsMap.get(tempIndex);
            if (tempParent != null) {
                path.add(tempParent);
            }
            tempIndex = tempParent;
        }

        tempIndex = region2;
        while (tempIndex != null) {
            String tempParent = parentsMap.get(tempIndex);
            if (path.contains(tempParent)) {
                return tempParent;
            }
            tempIndex = tempParent;
        }
        return "";
    }
}
