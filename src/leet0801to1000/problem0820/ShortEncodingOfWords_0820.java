package leet0801to1000.problem0820;

import java.util.Arrays;

/**
 * @author Brilliant James
 * @date 2020-03-28 02:15
 **/
public class ShortEncodingOfWords_0820 {

    private TrieNode root = new TrieNode('/');

    public int minimumLengthEncoding(String[] words) {
        int res = 0;
        if (words == null || words.length == 0) {
            return res;
        }
        Arrays.sort(words, (o1, o2) -> {
            return o2.length() - o1.length();
        });
        for (String s : words) {
            char[] chars = new StringBuilder(s).reverse().toString().toCharArray();
            if (insert(chars)) {
                res+=chars.length + 1;
            }
        }
        return res;
    }

    class TrieNode {
        char val;
        TrieNode[] children;
        boolean isWord;
        TrieNode(char v) {
            this.val = v;
            children = new TrieNode[26];
        }
    }

    private boolean insert(char[] chars) {
        boolean res = false;
        TrieNode index = root;
        for (char c : chars) {
            int pos = c - 'a';
            if (index.children[pos] == null) {
                index.children[pos] = new TrieNode(c);
                res = true;
            }
            index = index.children[pos];
        }
        index.isWord = true;
        return res;
    }
}
