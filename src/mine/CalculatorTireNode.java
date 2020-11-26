package mine;

import java.util.HashMap;
import java.util.Map;

/**
 * 〈功能概述〉<br>
 *
 * @author 王涵威
 * @date 20.11.4 20:24
 */
public class CalculatorTireNode {

    private char val;

    private String word;

    private boolean isWord;

    private Map<Character, CalculatorTireNode> children;

    public CalculatorTireNode(char v) {
        this(v, null, false);
    }

    public CalculatorTireNode(char v, String w, boolean isWord) {
        this.val = v;
        this.word = w;
        this.isWord = isWord;
        this.children = new HashMap<>();
    }

    public CalculatorTireNode insert(String word) {
        char[] chars = word.toCharArray();
        CalculatorTireNode idx = this;
        for (int i = 0, l = chars.length; i < l; i++) {
            if (i == l - 1) {
                idx  = idx.insert(chars[i], word, true);
            } else {
                idx  = idx.insert(chars[i], null, false);
            }
        }
        return idx;
    }

    public CalculatorTireNode insert(char v, String word, boolean isWord) {
        CalculatorTireNode node = new CalculatorTireNode(v, word, isWord);
        this.children.put(v, node);
        return node;
    }

    public CalculatorTireNode find(char v) {
        return this.children.get(v);
    }

    public char getVal() {
        return val;
    }

    public void setVal(char val) {
        this.val = val;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public boolean isWord() {
        return isWord;
    }

    public void setWord(boolean word) {
        isWord = word;
    }
}
