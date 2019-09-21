package leet0401to0600.problem0504;

/**
 * @program: SuccessLeetCode
 * @description:
 * @author: James
 * @create: 2019-09-08 09:10
 **/
public class Base70504 {

    public String convertToBase7(int num) {
        if (num == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        boolean isNegative = false;
        if (num < 0) {
            isNegative = true;
        }
        while (num != 0) {
            sb.append(Math.abs(num % 7));
            num = num / 7;
        }
        if (isNegative) {
            sb.append("-");
        }
        return sb.reverse().toString();
    }

    public String convertToBase7Better(int num) {
            int temp = Math.abs(num);
            StringBuilder ans = new StringBuilder();
            while(temp>=7){
                ans.append(temp%7);
                temp/=7;
            }
            ans.append(temp);
            if(num<0) {
                ans.append("-");
            }
            return ans.reverse().toString();

    }


    public static void main(String[] args) {
        System.out.println(-10 % 7);
    }


}
