package gold;

/**
 * @author Brilliant James
 * @date 2020-03-13 16:25
 **/
public class Pro_05_02 {

    public String printBin(double num) {
        if (num >= 1 || num <= 0) {
            return "ERROR";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("0.");
        while (num != 0) {
            if (sb.length() > 32) {
                return "ERROR";
            }
            num = num * 2;
            if (num >= 1) {
                sb.append("1");
                num = num - 1;
            } else {
                sb.append("0");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Pro_05_02 p = new Pro_05_02();
        System.out.println(p.printBin(0.625));
    }
}
