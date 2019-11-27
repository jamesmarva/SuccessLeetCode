package leet0601to0800.problem0648;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author James
 * @date 2019-11-27 22:35
 **/
public class ReplaceWords_0648 {

    public String replaceWords(List<String> dict, String sentence) {
        String[] arr = sentence.split(" ");
        StringBuilder ans = new StringBuilder();
        for (String item : dict) {
            insertWord(item);
        }

        for (String item : arr) {
            String temp = getPrefix(item);
            if (temp.equals("")) {
                ans.append(item);
            } else {
                ans.append(temp);
            }
            ans.append(" ");
        }
        return ans.toString().trim();
    }

    class Node {
        boolean isWord;
        Map<Character, Node> next;
        Node(boolean isWord) {
            this.isWord = isWord;
        }
        Node() {
            next = new HashMap<Character, Node>();
        }
    }

    private  Node root = new Node();

    private void insertWord(String word) {
        char[] arr = word.toCharArray();
        Node current = root;
        for (char item : arr) {
            if (current.next.get(item) == null) {
                current.next.put(item, new Node());
            }
            current = current.next.get(item);
        }
        current.isWord = true;
    }

    private String getPrefix(String s) {
        char[] arr = s.toCharArray();
        Node cur = root;
        StringBuilder ans = new StringBuilder();
        for (char item : arr) {
            if (cur.next.get(item) != null) {
                ans.append(item+"");
                if (cur.next.get(item).isWord){
                    return ans.toString();
                }
                cur = cur.next.get(item);
            } else {
                return "";
            }
        }
        return "";
    }

    public static void main(String[] args) {
        char test = 'a';
        System.out.println(test + "");


        String[] arr = {"cat", "bat", "rat"};
        ArrayList<String> list =new ArrayList<>(){{
            for (String item : arr) {
                add(item);
            }
        }};

        String se = "the cattle was rattled by the battery";
        ReplaceWords_0648 replaceWords_0648 = new ReplaceWords_0648();
        replaceWords_0648.replaceWords(list, se);
    }



}
