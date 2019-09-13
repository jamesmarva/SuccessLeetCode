package utils;

/**
 * @program: SuccessLeetCode
 * @description:
 * @author: James
 * @create: 2019-09-08 09:16
 **/
public class BitMap {
    private char[] bytes;

    private int nBits;

    public BitMap(int nBits) {
        this.nBits = nBits;
        // 初始化大小
        this.bytes = new char[nBits/16+1];
    }

    public void set(int k) {
        if (k > nBits) {
            return;
        }
        int byteIndex = k /16;
        int bitIndex = k % 16;
        bytes[byteIndex] |= (1 << bitIndex);
    }

    public boolean get(int k) {
        if (k > nBits) {
            return false;
        }
        int byteIndex = k / 16;
        int bitIndex = k % 16;
        return (bytes[byteIndex] & (1 << bitIndex)) != 0;
    }
}
