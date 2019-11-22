package leet0201to0400.problem0212;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author James
 * @date 2019-11-15 22:58
 **/
public class WordSearchII_0212 {

    private int[][] move = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    private HashSet<String> ans = new HashSet<>();

    private char[][] globalBoard;

    private int rowSize = 0;

    private int columnSize = 0;

    private boolean[][] visited;

    private TrieNode root = new TrieNode(' ');

    public List<String> findWords(char[][] board, String[] words) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return new ArrayList<>(ans);
        }
        rowSize = board.length;
        columnSize = board[0].length;
        visited = new boolean[rowSize][columnSize];
        globalBoard = board;
        for (String item : words) {
            insert(item.toCharArray());
        }
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < columnSize; j++) {
                dfs(i, j, root, new String());

            }
        }
        return new ArrayList<>(ans);
    }

    private void dfs(int rowIndex, int columnIndex, TrieNode current, String tempString) {
        if (rowIndex < 0 || rowIndex >= rowSize || columnIndex < 0 || columnIndex >= columnSize ||
            visited[rowIndex][columnIndex]) {
            return;
        }
        char tempChar = globalBoard[rowIndex][columnIndex];
        if (current.children[tempChar - 'a'] == null) {
            return;
        }
        TrieNode tempTrieNode = current.children[tempChar - 'a'];
        if (tempTrieNode.isWord) {
            ans.add(tempString + "" + tempChar);
        }
        visited[rowIndex][columnIndex] = true;
        for (int i = 0; i < 4; i++) {
            dfs(rowIndex + move[i][0], columnIndex + move[i][1], tempTrieNode, tempString + "" + tempChar);
        }
        visited[rowIndex][columnIndex] = false;
    }

    private void insert(char[] word) {
        TrieNode index = root;
        for (int i = 0, len = word.length; i < len; i++) {
            int tempIndex = word[i] - 'a';
            if (index.children[tempIndex] == null) {
                index.children[tempIndex] = new TrieNode(word[i]);
            }
            index = index.children[tempIndex];
        }
        index.isWord = true;
    }

    public static void main(String[] args) {

    }
    class TrieNode {
        public char data;
        public TrieNode[] children = new TrieNode[26];
        public boolean isWord = false;
        public TrieNode(char data) {
            this.data = data;
        }
    }

}
