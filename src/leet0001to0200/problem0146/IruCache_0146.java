package leet0001to0200.problem0146;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * @author James
 * @date 2019-11-25 16:13
 **/
public class IruCache_0146 {
    int capacity = 0;
    LinkedList<Integer> list = null;
    HashMap<Integer, Integer> map = null;

    public IruCache_0146(int capacity) {
        this.capacity = capacity;
        list = new LinkedList<>();
        map = new HashMap<>();
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            list.remove(new Integer(key));
            list.addLast(key);
            return map.get(key);
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            list.remove(key);
            list.addLast(key);
            map.put(key, value);
        } else {
            list.addLast(key);
            map.put(key, value);
            if (list.size() > this.capacity) {
                int keyTemp = list.removeFirst();
                map.remove(keyTemp);
            }
        }
    }
}
