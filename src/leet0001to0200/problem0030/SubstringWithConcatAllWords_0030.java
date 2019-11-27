package leet0001to0200.problem0030;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author James
 * @date 2019-11-26 18:01
 **/
public class SubstringWithConcatAllWords_0030 {

    /**
     *
     */
    public List<Integer> findSubstring(String s, String[] words) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (words== null || words.length == 0) {
            return ans;
        }
        int wordLen = words[0].length();
        int len = words.length;
        int sLen = s.length();
        HashMap<String, Integer> map = new HashMap<>();
        for (String item : words) {
            map.put(item, map.getOrDefault(item, 0) + 1);
        }
        for (int i = 0; i <= sLen - wordLen * len; i++) {
            String tempString = s.substring(i, i+wordLen * len);
            int tempLen = tempString.length();
            HashMap<String, Integer> tempMap = (HashMap) map.clone();
            for (int j = 0; j < tempLen; j+=wordLen) {
                String tempWord = tempString.substring(j, j+wordLen);
                if (tempMap.getOrDefault(tempWord, 0) > 0) {
                    tempMap.put(tempWord, tempMap.get(tempWord) - 1);
                } else {
                    break;
                }
            }
            boolean all = true;
            for (String wordItem : tempMap.keySet()) {
                if (tempMap.get(wordItem) != 0) {
                    all = false;
                    break;
                }
            }
            if (all) {
                ans.add(i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String test = "abcdefg";


        String s = "wordgoodgoodgoodbestword";
        String[] words = {"word","good","best","good"};
        SubstringWithConcatAllWords_0030 substringWithConcatAllWords_0030  = new SubstringWithConcatAllWords_0030();
        List<Integer> list = substringWithConcatAllWords_0030.findSubstring(s, words);
        System.out.println(list);

//        System.out.println("barfoo".substring(3, 3+3));
//        System.out.println(test.substring(0, 3));

    }
}
