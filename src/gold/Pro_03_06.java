package gold;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author Brilliant James
 * @date 2020-03-28 01:21
 **/
public class Pro_03_06 {

    private final static int[] NULL = {-1, -1};

    private LinkedList<int[]> list;
    public Pro_03_06() {
        list = new LinkedList<>();
    }

    public void enqueue(int[] animal) {
        list.add(animal);

    }

    public int[] dequeueAny() {
        if (list.isEmpty()) {
            return NULL;
        }
        return list.removeFirst();
    }

    // 1
    public int[] dequeueDog() {
        return getAnimal(1);
    }
    // 0
    public int[] dequeueCat() {

        return getAnimal(0);
    }

    private int[] getAnimal(int flag) {
        Iterator iterator = list.iterator();
        int[] res = NULL;
        while (iterator.hasNext()) {
            int[] temp = (int[]) iterator.next();
            if (temp[1] == flag) {
                res = temp;
                iterator.remove();
                break;
            }
        }
        return res;
    }
}
