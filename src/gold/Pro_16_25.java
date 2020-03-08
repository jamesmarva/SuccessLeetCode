package gold;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Brilliant James
 * @date 2020-03-08 14:31
 **/
public class Pro_16_25 {


    LinkedHashMap<Integer, Integer> map;

    public Pro_16_25(int capacity) {
        map = new LinkedHashMap<>(capacity,0.75f, true){
            @Override
            public boolean removeEldestEntry(Map.Entry<Integer, Integer> entry) {
                return size() > capacity;
            }
        };
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            return map.get(key);
        }
        return -1;
    }

    public void put(int key, int value) {
        map.put(key, value);
    }
}
