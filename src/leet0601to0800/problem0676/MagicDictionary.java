package leet0601to0800.problem0676;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author James
 * @date 2019-11-27 23:38
 **/
public class MagicDictionary {

    Map<Integer, ArrayList<String>> buckets;
    public MagicDictionary() {
        buckets = new HashMap();
    }

    public void buildDict(String[] words) {
//        for (String word: words) {
//            int len = word.length();
//            if (buckets.get(len) == null) {
//                buckets.put(len, new ArrayList<>());
//                buckets.get(len).add(word);
//            } else {
//                buckets.get(len).add(word);
//            }
//        }
//        buckets.computeIfAbsent(words, )
        for (String word: words) {
            buckets.computeIfAbsent(word.length(), x -> new ArrayList()).add(word);
        }
    }

    public boolean search(String word) {
        int len = word.length();
        if (!buckets.containsKey(len)) {
            return false;
        }
        int count = 0;
        ArrayList<String> list = buckets.get(len);
        for (String item : list) {
            for (int i = 0; i < len; i++) {
                if (word.charAt(i) != item.charAt(i)) {
                    count++;
                    if (count > 1) {
                        break;
                    }
                }
            }
            if (count == 1) {
                return true;
            }
        }
        return false;
    }

}
