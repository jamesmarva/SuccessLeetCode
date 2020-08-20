package other;

import java.util.*;

/**
 * @author Brilliant James
 * @date 2020-04-23 23:30
 **/
public class CloudmallInterview2_00 {

public static String CloudmallInterview2_New(Map<String, String> RevList) {
    Map<String, Word> rootMap = new HashMap<>();
    Map<String, Word> indexMap = rootMap;
    for (String item : RevList.keySet()) {
        String[] arr = RevList.get(item).split("\\.");
        for (int i = 0, len = arr.length; i < len; i++) {
            Word newWord = null;
            if (i == len - 1) {
                newWord = new Word(arr[i], true, item);
            } else {
                newWord = new Word(arr[i], false, "");
            }
            Word oldWord = indexMap.get(arr[i]);
            if (oldWord != null) {
                if (newWord.isEnd) {
                    oldWord.isEnd = true;
                    oldWord.pos = newWord.pos;
                }
                indexMap.put(arr[i], oldWord);
                indexMap = oldWord.childMap;
            } else {
                indexMap.put(arr[i], newWord);
                indexMap = newWord.childMap;
            }
        }
        indexMap = rootMap;
    }
    StringBuilder ans = new StringBuilder("{");
    Iterator iterator = rootMap.keySet().iterator();
    while (iterator.hasNext()) {
        String item = iterator.next() + "";
        ans.append(dfs(rootMap.get(item)));
        if (iterator.hasNext()) {
            ans.append(",");
        }
    }
    ans.append("}");
    return ans.toString();
}

private static String dfs(Word root) {
    if (root.isEnd) {
        return "\"" + root.val + "\": \"" + root.pos + "\"";
    }
    StringBuilder ans = new StringBuilder("\"" + root.val + "\"" +": "  + "{");
    Iterator iterator = root.childMap.keySet().iterator();
    while (iterator.hasNext()) {
        String item = iterator.next() + "";
        ans.append(dfs(root.childMap.get(item)));
        if (iterator.hasNext()) {
            ans.append(",");
        }
    }
    ans.append("}");
    return ans.toString();
}

private static class Word {
    String val;
    boolean isEnd;
    Map<String, Word> childMap;
    String pos;

    public Word(String word, boolean isEnd, String pos) {
        this.val = word;
        this.isEnd = isEnd;
        this.pos = pos;
        childMap = new HashMap<>();
    }
}

    /**
     *  Map<String, String> m = new HashMap<String, String>();
     *         m.put("1", "bar");
     *         m.put("2", "foo.bar");
     *         m.put("3", "foo.foo");
     *         m.put("4", "baz.cloudmall.com");
     *         m.put("5", "baz.cloudmall.ai");
     *         System.out.println("CloudmallInterview2 input:");
     *         System.out.println(m);
     *         System.out.println(Arrays.toString("foo.bar".split("\\.")));
     *         String res = CloudmallInterview2(m);
     *         System.out.println("CloudmallInterview2 output:");
     *         System.out.println(res);
     */


//    @Override
//    public int hashCode() {
//        return val.hashCode();
//    }
//    @Override
//    public boolean equals(Object obj) {
//        if (obj == null) {
//            return false;
//        }
//        if (obj instanceof Word) {
//            Word o = (Word) obj;
//            if (val.equals(o.val)) {
//                return true;
//            }
//        }
//        return false;
//    }

    public static void main(String[] args) {
        Map<String, String> m = new HashMap<String, String>();
        m.put("5", "baz.cloudmall.ai");
        m.put("1", "bar");
        m.put("2", "foo.bar");
        m.put("3", "foo.foo");
        m.put("4", "baz.cloudmall.com");

        System.out.println("CloudmallInterview2 input:");
        System.out.println(m);
        System.out.println(Arrays.toString("foo.bar".split("\\.")));
        String res = CloudmallInterview2_New(m);
        System.out.println("CloudmallInterview2 output:");
        System.out.println(res);
    }
}
