package leet0401to0600.problem0405;

/**
 * @author Brilliant James
 * @date 2020-03-11 07:27
 **/
public class ConvertNumToHexadecimal_0405 {

    public String toHex(int num) {
        if (num == 0){
            return "0";
        }
        String[] chars = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};
        StringBuilder res = new StringBuilder();
        while (num != 0) {
            int index = num & 15;
            res.append(chars[index]);
            // 无符号右移
            num >>>= 4;
        }
        return res.reverse().toString();
    }

    /**
     * 八进制
     * @return
     */
    public String toOctal(int num) {
        if (num == 0) {
            return "0";
        }
        String[] chars = {"0", "1", "2", "3", "4", "5", "6", "7"};
        StringBuilder res = new StringBuilder();
        while (num != 0) {
            res.append(chars[num & 7]);
            num >>>= 3;
        }
        return res.reverse().toString();
    }

    public static void main(String[] args) {
//        System.out.println( -3 >> 1);
//        System.out.println( -3 >>> 1);

        ConvertNumToHexadecimal_0405 p = new ConvertNumToHexadecimal_0405();
        System.out.println(p.toOctal(-3));
        System.out.println(p.toOctal(10));

        System.out.println(p.toOctal(30));
    }
}

