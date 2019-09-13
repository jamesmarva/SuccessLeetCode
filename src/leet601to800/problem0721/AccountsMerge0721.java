package leet601to800.problem0721;

import java.util.*;

/**
 * @program: SuccessLeetCode
 * @description: https://leetcode-cn.com/problems/accounts-merge/
 * @author: James
 * @create: 2019-09-13 00:10
 **/
public class AccountsMerge0721 {

    private Map<String, String> fatherMap = new HashMap<>();
    private Map<String, Integer> rankMap = new HashMap<>();
    private Map<String, String> mailToClient = new HashMap<>();
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> res = new ArrayList<>();
        if (accounts == null || accounts.size() == 0) {
            return null;
        }

        for (List<String> item : accounts) {
            for (int i = 1, len = item.size(); i < len; ++i) {
                fatherMap.put(item.get(i), item.get(i));
                rankMap.put(item.get(i), 1);
                mailToClient.put(item.get(i), item.get(0));
            }
        }

        for (List<String> item : accounts) {
            for (int i = 1, len = item.size(); i < len; ++i) {
                union(item.get(1), item.get(i));
            }
        }
        Map<String, ArrayList<String>> mapList = new HashMap<>();

        for (String itemKey : fatherMap.keySet()) {
            String value = findHead(itemKey);
            ArrayList<String> tempList = mapList.getOrDefault(value, new ArrayList<>());
            if (tempList.size() > 0) {
                tempList.add(itemKey);
            } else {
                //tempList.add(mailToClient.get(value));
                tempList.add(itemKey);
                mapList.put(value, tempList);
            }
        }
        for (String itemKey : mapList.keySet()) {
            ArrayList<String> tempList = mapList.get(itemKey);
            Collections.sort(tempList);
            tempList.add(0, mailToClient.get(itemKey));
        }
        return new ArrayList<>(mapList.values());
    }

    private String findHead(String a) {
        Stack<String> path = new Stack<>();
        while(!a.equals(fatherMap.get(a))) {
            path.push(a);
            a = fatherMap.get(a);
        }
        while (!path.isEmpty()) {
            fatherMap.put(path.pop(), a);
        }
        return a;
    }

    private void union(String a, String b) {
        String aFather = findHead(a);
        String bFather = findHead(b);
        if (aFather.equals(bFather)) {
            return;
        }
        String big = aFather;
        String small = bFather;
        if (rankMap.get(aFather) < rankMap.get(bFather)) {
            big = bFather;
            small = aFather;
        }
        fatherMap.put(small, big);
        rankMap.put(big, rankMap.get(big) + rankMap.get(small));
        rankMap.remove(small);
        mailToClient.remove(small);
    }
}
