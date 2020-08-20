package other;

import java.util.ArrayList;

/**
 * @author Brilliant James
 * @date 2020-05-12 19:15
 **/
public class YueSeFu {

    /**
     *
     * @return
     */
    public int getSolution(int n) {
        if (n < 1) {
            throw new IllegalArgumentException("n is under zero.");
        }
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            arr.add(i);
        }
        int count = 0;
        int index = 0;
        for(int i = 0; i < n - 1; i++) {
            count = 1;
            while (count != 3) {
                index++;
                count++;
            }
            index = index % arr.size();
            arr.remove(index);
            index = index % arr.size();
        }
        return arr.get(0);
    }

    public static void main(String[] args) {
        YueSeFu yueSeFu = new YueSeFu();
        System.out.println("1: " + yueSeFu.getSolution(1));
        System.out.println("2: " + yueSeFu.getSolution(2));
        System.out.println("3: " + yueSeFu.getSolution(3));
        System.out.println("4: " + yueSeFu.getSolution(4));
        System.out.println("5: " + yueSeFu.getSolution(5));
        System.out.println("6: " + yueSeFu.getSolution(6));
        System.out.println("7: " + yueSeFu.getSolution(7));
        System.out.println("8: " + yueSeFu.getSolution(8));
        System.out.println("100: " + yueSeFu.getSolution(100));
    }
}
