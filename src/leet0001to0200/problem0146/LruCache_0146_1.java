package leet0001to0200.problem0146;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author James
 * @date 2019-11-25 16:18
 **/
public class LruCache_0146_1 {


    private LinkedHashMap<Integer, Integer> map;

    public LruCache_0146_1(int capacity) {
        map = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer,Integer> eldest){
                return size() > capacity;
            }
        };
    }

    public int get(int key) {
        return map.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        map.put(key, value);

    }

    public static void main(String[] args) {
        LinkedHashMap<String, String> linkedHashMap  = new LinkedHashMap<String, String>();
    }

//    @Override
//    protected boolean removeEldestEntry(Map.Entry<Integer,Integer> eldest){
//        return size()>capacity;
//    }
}
