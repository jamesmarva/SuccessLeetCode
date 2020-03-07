package leet;

import java.util.*;

/**
 * @author James
 * @date 2019-11-16 22:56
 **/
public class GenerateSentences_5110 {


    HashMap<String, String> parentMap  =new HashMap<>();
    List<String> ans = new ArrayList<>();
    public List<String> generateSentences(List<List<String>> synonyms, String text) {
        if (synonyms == null || synonyms.isEmpty()) {
            ans.add(text);
            return ans;
        }
        int len = synonyms.size();
        for (int i = 0; i < len; i++) {
            List<String> tempList = synonyms.get(i);
            String father = tempList.get(0);
            if (findFather(father) != null) {
                father = findFather(father);
            }
            for (int j = 0, tempLen = tempList.size(); j < tempLen; j++) {
                if (parentMap.containsKey(tempList.get(j))) {
                    continue;
                }
                parentMap.put(tempList.get(j), father);
            }
        }

        String[] textString = text.split(" ");
        HashMap<String, HashSet<String>> fatherChild = new HashMap<>();
        for (Map.Entry<String, String> item : parentMap.entrySet()) {
            String father = item.getValue();
            HashSet<String> tempSet = fatherChild.getOrDefault(father, new HashSet<>());
            tempSet.add(item.getKey());
            fatherChild.put(father, tempSet);
        }
        dfs(textString, 0, "", fatherChild);
        Collections.sort(ans);
        return ans;
    }


    private void dfs(String[] arr, int index, String tempString, HashMap<String, HashSet<String>> fatherChild) {
        if (index == arr.length) {
            ans.add(tempString.trim());
            return;
        }
        String father = findFather(arr[index]);
        if (father != null) {
            HashSet<String> tempSet = fatherChild.get(father);
            for (String item : tempSet) {
                dfs(arr, index + 1, tempString + " " + item, fatherChild);
            }
        } else {
            dfs( arr, index + 1, tempString + " " + arr[index], fatherChild);
        }
    }

    private String findFather(String child) {
        Stack<String> path = new Stack<>();
        if (parentMap.get(child) == null) {
            return null;
        }
//		找父节点
        while (child != parentMap.get(child)) {
            path.push(child);
            child = parentMap.get(child);
        }
//		路径压缩
        while (!path.isEmpty()) {
            parentMap.put(path.pop(), child);
        }
        return child;
    }


    /**
     * [["happy","joy"],["sad","sorrow"],["joy","cheerful"]]
     * "I am happy today but was sad yesterday"
     * @param args
     */
    public static void main(String[] args) {
        String text = "I am happy today but was sad yesterday";
        List<List<String>> test = new ArrayList<>();
        List<String> temp1 = new ArrayList<>(){{
            add("happy");
            add("joy");
        }};

        List<String> temp2 = new ArrayList<>(){{
            add("sad");
            add("sorrow");
        }};

        List<String> temp3 = new ArrayList<>(){{
            add("joy");
            add("cheerful");
        }};
        test.add(temp1);
        test.add(temp2);
        test.add(temp3);

        GenerateSentences_5110 generateSentences_5110 = new GenerateSentences_5110();
        generateSentences_5110.generateSentences(test, text);
    }

}
