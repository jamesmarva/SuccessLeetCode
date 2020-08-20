package nowcoder;

import java.util.*;

/**
 * @author Brilliant James
 * @date 2020-05-07 20:38
 **/
public class TheMostDependedUponPackage {

    private static Map<String, String> father = new HashMap<>();
    private static Map<String, Integer> rank = new HashMap<>();
    private static Set<String> set = new HashSet<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ans = 0, x;
        ArrayList<String[]> inputList = new ArrayList<>();
        for(int i = 0; i < n; i++){
            String[] str = sc.nextLine().split(" ");
            inputList.add(str);
            if (set.add(str[0])) {
                father.put(str[0], str[0]);
                rank.put(str[0], 1);
            }
            if (set.add(str[1])) {
                father.put(str[1], str[1]);
                rank.put(str[1], 1);
            }
        }
        for (String[] item : inputList) {

            unionNode(item[0], item[1]);
        }
        int max = 0;
        String res = "";
        for (String key : rank.keySet()) {
            if (max < rank.get(key)) {
                res = key;
            }
        }
        System.out.println(res);
    }

    private static String findFather(String element) {
        Stack<String> path = new Stack<>();
//		找父节点
        while (element != father.get(element)) {
            path.push(element);
            element = father.get(element);
        }
//		路径压缩
        while (!path.isEmpty()) {
            father.put(path.pop(), element);
        }
        return element;
    }


    private static void unionNode(String a, String b) {
        if (set.contains(a) && set.contains(b)) {
            String aF = findFather(a);
            String bF = findFather(b);
//			若相同就表示已经在一个集合中了
            if (!aF.equals(bF)) {
                String small = aF;
                String big = bF;
                father.put(small, big);
                rank.put(big, rank.get(aF) + rank.get(bF));
                rank.remove(small);
            }
        }
    }

//    public static String solution(String[] args) {
//
//    }
}
