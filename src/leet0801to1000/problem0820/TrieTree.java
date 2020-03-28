package leet0801to1000.problem0820;

import java.util.TreeMap;

/**
 * @author Brilliant James
 * @date 2020-03-28 02:28
 **/
public class TrieTree {

    class TrieNode {
        char val;
        TrieNode[] children;
        boolean isWord;
        TrieNode(char v) {
            this.val = v;
            children = new TrieNode[26];
        }
    }

    private TrieNode root = new TrieNode('/');

    public void insert(char[] word) {
        TrieNode index = root;
        for (int i = 0, len = word.length; i < len; i++) {
            int pos = word[i] - 'a';
            if (index.children[pos] == null) {
                index.children[pos] = new TrieNode(word[i]);
            }
            index = index.children[pos];
        }
        index.isWord = true;
    }

    public boolean find(char[] word) {
        TrieNode index = root;
        for (int i = 0, len = word.length; i < len; i++) {
            int pos = word[i] - 'a';
            if (index.children[pos] == null) {
                return false;
            }
            index = index.children[pos];
        }
        return index.isWord;
    }
}
