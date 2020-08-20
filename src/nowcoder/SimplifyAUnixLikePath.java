package nowcoder;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author Brilliant James
 * @date 2020-05-07 20:01
 **/
public class SimplifyAUnixLikePath {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] str = in.nextLine().split("/");
//        while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
//            str = in.nextLine().split("/");
//            break;
//        }
//        for (String item : str) {
//            System.out.println(item);
//        }
        System.out.print(solution(str));
    }

//    public static void main(String[] args) {
//        String test = "/a/b/../c/./d//";
//        String[] str = test.split("/");
////        while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
////            str = in.nextLine().split("/");
////            break;
////        }
//        for (String s : str) {
//            System.out.println(s);
//        }
//        System.out.println(solution(str));
//    }

    public static String solution(String[] s) {
        LinkedList<String> stack = new LinkedList<>();
        for (String item : s) {
            if (item.equals("..")) {
                if (stack.size() > 0) {
                    stack.removeLast();
                }
            } else if (item.equals(".")) {
                continue;
            } else if (!item.equals("")){
                stack.addLast(item);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (stack.size() > 0) {
            sb.append("/").append(stack.removeFirst());
        }
        return sb.toString();
    }
}
