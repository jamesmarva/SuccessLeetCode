package leet0401to0600.problem0433;

import java.util.*;

/**
 *
 * @author Brilliant James
 * @date 2020-05-24 17:11
 **/
public class MinGeneticMutation_0433 {

    public int minMutation(String start, String end, String[] bank) {
        HashSet<String> set = new HashSet<>(Arrays.asList(bank));
        if (!set.contains(end)) {
            return -1;
        }
        char[] four = {'A', 'C', 'G', 'T'};
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        set.remove(start);
        int step = 0;
        while (queue.size() > 0) {
            step++;
            for (int count = queue.size(); count > 0; count--) {
                char[] temStringChars = queue.poll().toCharArray();
                for (int i = 0, len = temStringChars.length; i < len; ++i) {
                    char oldChar = temStringChars[i];
                    for (int j = 0; j < 4; ++j) {
                        temStringChars[i] = four[j];
                        String newGenetic = new String(temStringChars);
                        if (end.equals(newGenetic)) {
                            return step;
                        } else if (set.contains(newGenetic)) {
                            set.remove(newGenetic);
                            queue.offer(newGenetic);
                        }
                    }
                    temStringChars[i] = oldChar;
                }
            }
        }
        return -1;
    }

    public int minMutation1(String start, String end, String[] bank) {
        Set<String> set = new HashSet<>(Arrays.asList(bank));
        Queue<String> queue = new LinkedList<>();
        if (!set.contains(end)) {
            return -1;
        }
        queue.add(start);
        set.remove(start);
        char[] four = {'A', 'G', 'C', 'T'};
        int step = 0;
        while (!queue.isEmpty()) {
            step++;
            for (int i = 0, len = queue.size(); i < len; ++i) {
                char[] temStringChars = queue.poll().toCharArray();
                for (int j = 0; j < temStringChars.length; j++) {
                    char oldChar = temStringChars[j];
                    for (int k = 0; k < 4; k++) {
                        temStringChars[j] = four[k];
                        String newStr = new String(temStringChars);
                        if (newStr.equals(end)) {
                            return step;
                        } else if (set.contains(newStr)) {
                            set.remove(newStr);
                            queue.offer(newStr);
                        }
                    }
                    temStringChars[j] = oldChar;
                }
            }
        }
        return -1;
    }
}
