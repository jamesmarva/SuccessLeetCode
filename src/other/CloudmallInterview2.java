package other;

import java.util.*;

/**
 * @author Brilliant James
 * @date 2020-04-23 19:42
 **/
public class CloudmallInterview2 {
//        Letter root = new Letter(' ', false);
//        Letter index = root;
//        for (String item : RevList.values()) {
//            char[] chars = item.toCharArray();
//            index = root;
//            for (int i = 0, len = chars.length; i < len; i++) {
//                if (chars[i] == '.') {
//                    index.child[26] = new Letter(chars[i], false);
//                    index = index.child[27];
//                    continue;
//                }
//                if (i == len - 1) {
//                    index.child[chars[i] - 'a'] = new Letter(chars[i], true);
//                } else {
//                    index.child[chars[i] - 'a'] = new Letter(chars[i], false);
//                }
//                index = index.child[chars[i] - 'a'];
//            }
//        }
    /**
     * { "foo": "1"
     *
     * }
     *
     * @param RevList
     * @return
     */
    public static String CloudmallInterview2(Map<String, String> RevList) {
//        Map<String, Set<Word>> map = new HashMap<>();
//        Word root = new Word(" ", false, "");
//        Word index = root;
//        for (String item : RevList.keySet()) {
//            String[] arr = RevList.get(item).split("\\.");
//            index = root;
//            for (int i = 0, len = arr.length; i < len; i++) {
//                Word newChild = null;
//                if (i == len - 1) {
//                    newChild = new Word(arr[i], true, item);
//                } else {
//                    newChild = new Word(arr[i], false, "");
//                }
//                if (index.map.keySet().contains(arr[i])) {
//                    index.map.get(arr[i]).add(newChild);
//                }
//                index = newChild;
//            }
//        }
//
//        StringBuilder ans = new StringBuilder("{");
//        for ( item : root.map.keySet()) {
////            ans.append(dfs(String val, item, "")).append(",");
//        }
//        ans.append("}");
//        return ans.toString();
        return null;
    }

//    public static String CloudmallInterview2_New(Map<String, String> RevList) {
//        Map<String, Set<Word>> map = new HashMap<>();
//        for (String item : RevList.keySet()) {
//            String[] arr = RevList.get(item).split("\\.");
//
//            for (int i = 0, len = arr.length; i < len; i++) {
//
//            }
//
//    }

//    private static String dfs(Word root, String s) {
//           s += ": \"" + root.pos + "\"";
//        }
//        s += "\"" + root.val + "\"" +": "  + "{";
//        for (String item : root.map.keySet()) {
//            dfs(item, , s);
//            s += ", ";
//        }
//        s += "}";
//        return s;
//    }


//    private static String dfs(Word root, Set<Word> set, boolean isEnd, String pos, String s) {
//        if (root.isEnd) {
//            s += ": \"" + root.pos + "\"";
//        }
//        s += "\"" + root.val + "\"" +": "  + "{";
//        for (Word item : set) {
//            dfs(root., s);
//            s += ", ";
//        }
//        s += "}";
//        return s;
//    }

    private static class Word {
        String val;
        boolean isEnd;
        Map<String, Set<Word>> map;
        String pos;

        public Word(String word, boolean isEnd, String pos) {
            this.val = word;
            this.isEnd = isEnd;
            this.pos = pos;
            map = new HashMap<>();
        }
    }

//    private static class Letter {
//        char val;
//        boolean isEnd;
//        Letter[] child;
//
//        public Letter(char val, boolean isEnd) {
//            this.val = val;
//            this.isEnd = isEnd;
//            child = new Letter[27];
//        }
//    }

    public static void main(String[] args) {
        Map<String, String> m = new HashMap<String, String>();
        m.put("1", "bar");
        m.put("2", "foo.bar");
        m.put("3", "foo.foo");
        m.put("4", "baz.cloudmall.com");
        m.put("5", "baz.cloudmall.ai");
        System.out.println("CloudmallInterview2 input:");
        System.out.println(m);
        System.out.println(Arrays.toString("foo.bar".split("\\.")));
        String res = CloudmallInterview2(m);
        System.out.println("CloudmallInterview2 output:");
        System.out.println(res);
    }
}
