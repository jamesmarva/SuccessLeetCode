package leet0801to1000.problem0868;

/**
 * @author James
 * @date 2019-12-05 15:07
 **/
public class BinaryGap_0868 {



    public int binaryGap(int N) {
        int lastIndex = 0;
        boolean isBegin = false;
        int max = 0;
        for (int i = 0; i < 32; i++) {
            if (((N >> i) & 1) == 1) {
                if (isBegin){
                    max = Math.max(i - lastIndex, max);
                }
                lastIndex = i;
                if (!isBegin) {
                    isBegin = true;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int test1 =5;

        BinaryGap_0868 bb = new BinaryGap_0868();
        int ans = bb.binaryGap(test1);
        System.out.println(ans);
    }
}
