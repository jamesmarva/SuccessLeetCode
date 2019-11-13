package leet0001to0200.problem0190;

import javax.sound.midi.Soundbank;
import java.math.BigInteger;

/**
 * @author James
 * @date 2019-11-12 18:02
 **/
public class ReverseBits_0190 {

    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 32; i++) {
            int temp = 1 << i;
            if (i == 31) {
                if ((n & temp) == Integer.MIN_VALUE) {
                    sb.append(1);
                } else {
                    sb.append(0);
                }
            } else {
                if ((n & temp) > 0) {
                    sb.append(1);
                } else {
                    sb.append(0);
                }
            }
        }
        BigInteger bigInteger = new BigInteger(sb.toString(), 2);
        return bigInteger.intValue();
    }


    /**
     *
     * 00000010100101000001111010011100
     *
     * @param args
     */
    public static void main(String[] args) {
        int test = 43261596;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 32; i++) {
            int temp = 1 << i;
            if (i == 31) {
                if ((test & temp) == Integer.MIN_VALUE) {
                    sb.append(1);
                } else {
                    sb.append(0);
                }
            } else {
                if ((test & temp) > 0) {
                    sb.append(1);
                } else {
                    sb.append(0);
                }
            }
        }
        BigInteger bigInteger = new BigInteger(sb.toString(), 2);

    }


}
